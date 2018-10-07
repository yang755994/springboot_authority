package net.sppan.base.controller.admin.system;

import net.sppan.base.common.JsonResult;
import net.sppan.base.controller.BaseController;
import net.sppan.base.entity.system.TbResource;
import net.sppan.base.service.ResourceService;
import net.sppan.base.vo.ZtreeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
//	@Autowired
//	private IResourceService resourceService;

	@Autowired
	private ResourceService resourceService2;

	
	@RequestMapping("/tree/{resourceId}")
	@ResponseBody
	public List<ZtreeView> tree(@PathVariable Integer resourceId){
		List<ZtreeView> list = resourceService2.tree(resourceId);
		return list;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "admin/resource/index";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<TbResource> list() {
		/*SimpleSpecificationBuilder<Resource> builder = new SimpleSpecificationBuilder<Resource>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("name", Operator.likeAll.name(), searchText);
		}
		Page<Resource> page = resourceService.findAll(builder.generateSpecification(),getPageRequest());*/
		String sortName = request.getParameter("sortName");
		String sortOrder = request.getParameter("sortOrder");
		int page = Integer.parseInt(request.getParameter("pageNumber"));
		int size = Integer.parseInt(request.getParameter("pageSize"));
		Map<String, Object> params = new HashMap<>();
		params.put("name", request.getParameter("searchText"));
		params.put("sortName", sortName);
		params.put("sortOrder", sortOrder);
		Page<TbResource> page2 = resourceService2.findAll(params, getPageRequest());
		return page2;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<TbResource> list = resourceService2.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		TbResource resource = resourceService2.find(id);
		map.put("resource", resource);
		
		List<TbResource> list = resourceService2.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}
	
	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(TbResource resource, ModelMap map){
		try {
			resourceService2.saveOrUpdate(resource);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			resourceService2.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
