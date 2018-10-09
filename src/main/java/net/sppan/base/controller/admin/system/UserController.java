package net.sppan.base.controller.admin.system;

import java.util.*;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.User;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.entity.system.TbUser;
import net.sppan.base.entity.system.UserRole;
import net.sppan.base.mapper.system.TbRoleMapper;
import net.sppan.base.service.IRoleService;
import net.sppan.base.service.IUserService;
import net.sppan.base.service.RoleService;
import net.sppan.base.service.UserService;
import net.sppan.base.service.specification.SimpleSpecificationBuilder;
import net.sppan.base.service.specification.SpecificationOperator.Operator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	@Autowired
	private UserService userService2;

	@Autowired
	private TbRoleMapper tbRoleMapper;

	@Autowired
	private RoleService roleService2;

	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "admin/user/index";
	}

	@RequestMapping(value = { "/list" })
	@ResponseBody
	public Page<TbUser> list() {
		/*SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("nickName", Operator.likeAll.name(), searchText);
		}
		Page<User> page = userService.findAll(builder.generateSpecification(), getPageRequest());*/

		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");
		Map<String, Object> params = new HashMap<>();
		params.put("name", request.getParameter("searchText"));
		params.put("description", request.getParameter("searchText"));
		params.put("sortName", sortName);
		params.put("sortOrder", sortOrder);
		Page<TbUser> page = userService2.findAll(params, getPageRequest());
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		return "admin/user/form";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		TbUser user = userService2.find(id);
		map.put("user", user);
		return "admin/user/form";
	}
	
	@RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(TbUser user,ModelMap map){
		try {
			userService2.saveOrUpdate(user);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			userService2.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.GET)
	public String grant(@PathVariable Integer id, ModelMap map) {
		TbUser user = userService2.find(id);
		map.put("user", user);
		
		List<Integer> roleIds = tbRoleMapper.getUserRolesByUserId(id);
		map.put("roleIds", roleIds);
		
		List<TbRole> roles = roleService2.findAll();
		map.put("roles", roles);
		return "admin/user/grant";
	}
	
	@ResponseBody
	@RequestMapping(value = "/grant/{id}", method = RequestMethod.POST)
	public JsonResult grant(@PathVariable Integer id,String[] roleIds, ModelMap map) {
		try {
			userService2.grant(id,roleIds);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
