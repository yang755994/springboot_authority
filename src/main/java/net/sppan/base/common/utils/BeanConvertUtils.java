package net.sppan.base.common.utils;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * bean转换工具类
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 18:20
 */
public class BeanConvertUtils {

	/**
	 * 将一个对象属性复制到另一个对象中
	 * 
	 * @param source
	 * @param targetClass
	 * @return
	 */
	public static <T> T convertBean(Object source, Class<T> targetClass) {
		T target = BeanUtils.instantiate(targetClass);
		BeanUtils.copyProperties(source, target);
		return target;
	}

	/**
	 * 将一个列表的对象复制一份到新列表中
	 * 
	 * @param sourceList
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> convertBeanList(List<?> sourceList, Class<T> targetClass) {
		List<T> list = new ArrayList<>();
		if (sourceList == null || sourceList.size() == 0) {
			return list;
		}
		for (Object source : sourceList) {
			T target = BeanUtils.instantiate(targetClass);
			BeanUtils.copyProperties(source, target);
			list.add(target);
		}
		return list;
	}

	/**
	 * 对象转Map
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(Object object) {
		try {
			// return org.apache.commons.beanutils.BeanUtils.describe(object);
			return FastJSONHelper.deserialize(FastJSONHelper.serialize(object), Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MapUtils.EMPTY_MAP;
	}
	
	/**
	 * map转对象
	 * 注意：该方法有bug，需要完善  
	 * 		当类型为包装类型的时候，值为null，反射后的得到的值为包装类型对应的基本类型的默认值
	 * @param map
	 * @param targetClass
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToObject(Map<String, Object> map, Class<T> targetClass) {    
		
		/*if (map == null)  
            return null;  
        T target = BeanUtils.instantiate(targetClass);
		try {
			org.apache.commons.beanutils.BeanUtils.populate(target, map);
		} catch (Exception e) {
			e.printStackTrace();
		}      
		return target;*/
		
		
        return FastJSONHelper.deserialize(FastJSONHelper.serialize(map), targetClass);
    }    
}
