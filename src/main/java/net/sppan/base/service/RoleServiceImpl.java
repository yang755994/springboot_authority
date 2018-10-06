package net.sppan.base.service;

import net.sppan.base.entity.Resource;
import net.sppan.base.entity.system.RoleResource;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.mapper.system.TbResourceMapper;
import net.sppan.base.mapper.system.TbRoleMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * 角色表  服务实现类
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 16:35
 */
//@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TbRoleMapper tbRoleMapper;

	@Autowired
	private TbResourceMapper tbResourceMapper;
	
	@Override
	public void saveOrUpdate(TbRole role) {
		if(role.getId() != null){
			TbRole dbRole = tbRoleMapper.get(role.getId());
			dbRole.setUpdateTime(new Date());
			dbRole.setName(role.getName());
			dbRole.setDescription(role.getDescription());
			dbRole.setUpdateTime(new Date());
			dbRole.setStatus(role.getStatus());
			tbRoleMapper.update(dbRole);
		}else{
			role.setCreateTime(new Date());
			role.setUpdateTime(new Date());
			tbRoleMapper.save(role);
		}
	}

	
	
	@Override
	public void delete(Integer id) {
		TbRole role = tbRoleMapper.get(id);
		Assert.state(!"administrator".equals(role.getRoleKey()),"超级管理员角色不能删除");
		tbRoleMapper.delete(id);
	}

	@Override
	public void grant(Integer id, String[] resourceIds) {
		TbRole role = tbRoleMapper.get(id);
		Assert.notNull(role, "角色不存在");
		
		Assert.state(!"administrator".equals(role.getRoleKey()),"超级管理员角色不能进行资源分配");

		tbRoleMapper.deleteResourcesByRoleId(role.getId());

		List<RoleResource> resources = new ArrayList<>();
		if(resourceIds != null){
			for (int i = 0; i < resourceIds.length; i++) {
				if(StringUtils.isBlank(resourceIds[i]) || "0".equals(resourceIds[i])){
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
	
}
