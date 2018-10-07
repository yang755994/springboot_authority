package net.sppan.base.service;

import net.sppan.base.entity.system.TbResource;
import net.sppan.base.vo.ZtreeView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface ResourceService {

	/**
	 * 获取角色的权限树
	 * @param roleId
	 * @return
	 */
	List<ZtreeView> tree(int roleId);

	/**
	 * 修改或者新增资源
	 * @param resource
	 */
	void saveOrUpdate(TbResource resource);

	void delete(Integer id);

    Page<TbResource> findAll(Map<String, Object> params, PageRequest pageRequest);

	List<TbResource> findAll();

	TbResource find(Integer id);
}
