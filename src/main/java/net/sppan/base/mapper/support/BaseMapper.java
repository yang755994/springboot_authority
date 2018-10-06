package net.sppan.base.mapper.support;

import net.sppan.base.framework.SimplePage;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseMapper<T extends Serializable> {

	int save(T entity);

	int update(T entity);

	int delete(Number id);

	int count(@Param("params") Map<String, Object> params);

	T get(Number id);

	List<T> list(@Param("params") Map<String, Object> params);

	List<T> query(@Param("page") SimplePage page, @Param("params") Map<String, Object> params);
}