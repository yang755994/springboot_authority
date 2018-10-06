package net.sppan.base.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * fastJson序列化反序列化工具
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 18:20
 */
public class FastJSONHelper {

	/**
	 * 将java类型的对象转换为JSON格式的字符串
	 * 
	 * @param object
	 *            java类型的对象
	 * @return JSON格式的字符串
	 */
	public static <T> String serialize(T object) {
		return JSON.toJSONString(object);
	}

	/**
	 * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
	 * 
	 * @param json
	 *            JSON格式的字符串
	 * @param clz
	 *            java类型或者java数组类型，不包括java集合类型
	 * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
	 */
	public static <T> T deserialize(String json, Class<T> clz) {
		return JSON.parseObject(json, clz);
	}

	/**
	 * 将JSON格式的字符串转换为List<T>类型的对象
	 * 
	 * @param json
	 *            JSON格式的字符串
	 * @param clz
	 *            指定泛型集合里面的T类型
	 * @return List<T>类型的对象
	 */
	public static <T> List<T> deserializeList(String json, Class<T> clz) {
		String jsonStr = "";
		if (!(null == json || json.trim().equals(""))) {
			if (!json.startsWith("[")) {
				jsonStr = "[" + json + "]";
			} else {
				jsonStr = json;
			}
			return JSON.parseArray(jsonStr, clz);
		} else {
			return new ArrayList<T>();
		}
	}
	
	/**
	 * 将JSON格式的字符串转换成任意Java类型的对象
	 * 
	 * @param json
	 *            JSON格式的字符串
	 * @param type
	 *            任意Java类型
	 * @return 任意Java类型的对象
	 */
	public static <T> T deserializeAny(String json, TypeReference<T> type) {
		return JSON.parseObject(json, type);
	}

	public static String getJsonValue(String json, String key) {
		HashMap<?, ?> map = FastJSONHelper.deserialize(json, HashMap.class);
		return (String) map.get(key);
	}

	public static byte[] serializeBytes(Object obj) throws IOException {
		if(obj==null){
			return new byte[]{};
		}
		return JSON.toJSONBytes(obj,SerializerFeature.WriteEnumUsingToString,SerializerFeature.DisableCircularReferenceDetect);
	}

	/**
	 * 将二进制转换为Object
	 * @param bytes 
	 * @param clazz
	 * @return 
	 * @return
	 * @throws IOException
	 * @datetime 2016年7月18日下午4:24:45
	 */
	public static <T> T deSerializeObject(byte[] bytes,Class<T> clazz) throws IOException {
		if(bytes!=null && bytes.length>0){
			return JSONObject.parseObject(bytes, clazz, Feature.SupportArrayToBean, Feature.DisableCircularReferenceDetect);
		}
		return null;
	}
	/**
	 * 将二进制转换为List
	 * @param bytes 
	 * @param clazz
	 * @return
	 * @throws IOException
	 * @datetime 2016年7月18日下午4:24:45
	 */
	public static List<?> deSerializeList(byte[] bytes,Class<?> clazz) throws IOException {
		ArrayList<Object> listClazz = new ArrayList<Object>();
		if(bytes!=null && bytes.length>0){
			List<Object> listObj = JSONObject.parseObject(bytes,List.class, Feature.SupportArrayToBean, Feature.DisableCircularReferenceDetect);
			if(listObj!=null){
				for (Object object : listObj) {
					listClazz.add(JSON.toJavaObject((JSON)object, clazz));
				}
			}
		}
		return listClazz;
	}
	
	public static void main(String[] args) {
		HashMap<?, ?> map = FastJSONHelper.deserialize("{id:'11',name:'rian',age:23}", HashMap.class);

		System.out.println("============================" + map.get("id"));
		System.out.println(FastJSONHelper.serialize(map));
	}
}