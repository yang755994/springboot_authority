package net.sppan.base.service;

import net.sppan.base.entity.Resource;
import net.sppan.base.entity.system.RoleResource;
import net.sppan.base.entity.system.TbResource;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.framework.SimplePage;
import net.sppan.base.mapper.system.TbResourceMapper;
import net.sppan.base.mapper.system.TbRoleMapper;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

/**
 * 角色表  服务实现类
 *
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 16:35
 */
@Service("roleService2")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TbRoleMapper tbRoleMapper;

	@Autowired
	private TbResourceMapper tbResourceMapper;

	@Override
	public void saveOrUpdate(TbRole role) {
		if (role.getId() != null) {
			TbRole dbRole = tbRoleMapper.get(role.getId());
			dbRole.setUpdateTime(new Date());
			dbRole.setName(role.getName());
			dbRole.setDescription(role.getDescription());
			dbRole.setUpdateTime(new Date());
			dbRole.setStatus(role.getStatus());
			tbRoleMapper.update(dbRole);
		} else {
			role.setCreateTime(new Date());
			role.setUpdateTime(new Date());
			tbRoleMapper.save(role);
		}
	}


	@Override
	public void delete(Integer id) {
		TbRole role = tbRoleMapper.get(id);
		Assert.state(!"administrator".equals(role.getRoleKey()), "超级管理员角色不能删除");
		tbRoleMapper.deleteResourcesByRoleId(id);
		tbRoleMapper.delete(id);
	}

	@Override
	public void grant(Integer id, String[] resourceIds) {
		TbRole role = tbRoleMapper.get(id);
		Assert.notNull(role, "角色不存在");

		Assert.state(!"administrator".equals(role.getRoleKey()), "超级管理员角色不能进行资源分配");

		tbRoleMapper.deleteResourcesByRoleId(role.getId());

		List<RoleResource> resources = new ArrayList<>();
		if (resourceIds != null) {
			for (int i = 0; i < resourceIds.length; i++) {
				if (StringUtils.isBlank(resourceIds[i]) || "0".equals(resourceIds[i])) {
					continue;
				}
				RoleResource roleResource = new RoleResource();
				Integer rid = Integer.parseInt(resourceIds[i]);
				roleResource.setResourceId(rid);
				roleResource.setRoleId(id);
				resources.add(roleResource);
			}
		}
		tbRoleMapper.batchInsertRoleResources(resources);
	}

	@Override
	public Page<TbRole> findAll(Map<String, Object> params, PageRequest pageRequest) {
		SimplePage page = new SimplePage();
		page.setPageNo(pageRequest.getPageNumber());
		page.setPageSize(pageRequest.getPageSize());
		int count = 0;
		List<TbRole> tbRoles = tbRoleMapper.query(page, params);
		if (CollectionUtils.isNotEmpty(tbRoles)) {
			count = tbRoleMapper.count(params);
		}


		Page<TbRole> results = new PageImpl<TbRole>(tbRoles, pageRequest, count);
		return results;
	}

	@Override
	public TbRole find(Integer id) {
		TbRole tbRole = tbRoleMapper.get(id);
		List<TbResource> resources = tbResourceMapper.list(null);
		tbRole.setResources(resources);
		return tbRole;
	}

	@Override
	public List<TbRole> findAll() {
		return tbRoleMapper.list(null);
	}
}
