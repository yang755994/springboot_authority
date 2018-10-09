package net.sppan.base.service;

import net.sppan.base.common.utils.MD5Utils;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.system.TbResource;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.entity.system.TbUser;
import net.sppan.base.entity.system.UserRole;
import net.sppan.base.framework.SimplePage;
import net.sppan.base.mapper.system.TbRoleMapper;
import net.sppan.base.mapper.system.TbUserMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service("userService2")
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private TbRoleMapper tbRoleMapper;
	
	@Override
	public TbUser findByUserName(String username) {
		Map<String, Object> params = new HashMap<>(1);
		params.put("userName", username);
		List<TbUser> users = tbUserMapper.list(params);
		if (CollectionUtils.isNotEmpty(users)) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public void saveOrUpdate(TbUser user) {
		if(user.getId() != null){
			TbUser dbUser = tbUserMapper.get(user.getId());
			dbUser.setNickName(user.getNickName());
			dbUser.setSex(user.getSex());
			dbUser.setBirthday(user.getBirthday());
			dbUser.setTelephone(user.getTelephone());
			dbUser.setEmail(user.getEmail());
			dbUser.setAddress(user.getAddress());
			dbUser.setLocked(user.getLocked());
			dbUser.setDescription(user.getDescription());
			dbUser.setUpdateTime(new Date());
			tbUserMapper.update(dbUser);
		}else{
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setDeleteStatus(0);
			user.setPassword(MD5Utils.md5("111111"));
			tbUserMapper.save(user);
		}
	}
	
	

	@Override
	public void delete(Integer id) {
		TbUser user = tbUserMapper.get(id);
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能删除");
		tbUserMapper.delete(id);
	}

	@Override
	public void grant(Integer id, String[] roleIds) {
		TbUser user = tbUserMapper.get(id);
		Assert.notNull(user, "用户不存在");
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能修改管理角色");

		tbRoleMapper.deleteUserRolesByUserId(id);


		List<UserRole> userRoles = new ArrayList<>();
		if(roleIds != null){
			for (int i = 0; i < roleIds.length; i++) {
				Integer rid = Integer.parseInt(roleIds[i]);
				UserRole ur = new UserRole();
				ur.setRoleId(rid);
				ur.setUserId(id);
				userRoles.add(ur);
			}
		}
		tbRoleMapper.batchInsertUserRoles(userRoles);
	}

	@Override
	public Page<TbUser> findAll(Map<String, Object> params, PageRequest pageRequest) {
		SimplePage page = new SimplePage();
		page.setPageNo(pageRequest.getPageNumber());
		page.setPageSize(pageRequest.getPageSize());
		int count = 0;
		List<TbUser> tbUsers = tbUserMapper.query(page, params);
		if (CollectionUtils.isNotEmpty(tbUsers)) {
			count = tbUserMapper.count(params);
		}


		Page<TbUser> results = new PageImpl<TbUser>(tbUsers, pageRequest, count);
		return results;
	}

	@Override
	public TbUser find(Integer id) {
		TbUser tbUser = tbUserMapper.get(id);
		//java.util.List<TbRole> roles = tbRoleMapper.list(null);
		return tbUser;
	}

}
