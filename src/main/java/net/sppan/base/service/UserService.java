package net.sppan.base.service;

import net.sppan.base.entity.User;
import net.sppan.base.entity.system.TbUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * 用户服务类
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 16:33
 */
public interface UserService  {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	TbUser findByUserName(String username);

	public void delete(Integer id);

	/**
	 * 增加或者修改用户
	 * @param user
	 */
	void saveOrUpdate(TbUser user);

	/**
	 * 给用户分配角色
	 * @param id 用户ID
	 * @param roleIds 角色Ids
	 */
	void grant(Integer id, String[] roleIds);

	Page<TbUser> findAll(Map<String, Object> params, PageRequest pageRequest);

	TbUser find(Integer id);
}
