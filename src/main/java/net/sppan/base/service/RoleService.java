package net.sppan.base.service;

import net.sppan.base.entity.system.TbRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;


public interface RoleService {

	/**
	 * 添加或者修改角色
	 * @param role
	 */
	void saveOrUpdate(TbRole role);

	public void delete(Integer id);

	/**
	 * 给角色分配资源
	 * @param id 角色ID
	 * @param resourceIds 资源ids
	 */
	void grant(Integer id, String[] resourceIds);

	Page<TbRole> findAll(Map<String, Object> params, PageRequest pageRequest);

	TbRole find(Integer id);

	List<TbRole> findAll();
}
