package net.sppan.base.service;

import net.sppan.base.common.utils.BeanConvertUtils;
import net.sppan.base.entity.Resource;
import net.sppan.base.entity.system.TbResource;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.framework.SimplePage;
import net.sppan.base.mapper.system.TbResourceMapper;
import net.sppan.base.mapper.system.TbRoleMapper;
import net.sppan.base.vo.ZtreeView;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 资源表 服务实现类
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/6 16:34
 */
@Service("resourceService2")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private TbRoleMapper tbRoleMapper;

	@Autowired
	private TbResourceMapper tbResourceMapper;

	@Override
	@Cacheable(value = "resourceCache", key = "'tree' + #roleId")
	public List<ZtreeView> tree(int roleId) {
		List<ZtreeView> resulTreeNodes = new ArrayList<ZtreeView>();
		TbRole role = tbRoleMapper.get(roleId);
		List<Integer> roleResources = tbRoleMapper.getRoleResources(role.getId());
		resulTreeNodes.add(new ZtreeView(0L, null, "系统菜单", true));
		ZtreeView node;
		Sort sort = new Sort(Direction.ASC, "parent", "id", "sort");
		List<TbResource> all = tbResourceMapper.list(null);
		for (TbResource resource : all) {
			node = new ZtreeView();
			node.setId(Long.valueOf(resource.getId()));
			if (resource.getParentId() == null) {
				node.setpId(0L);
			} else {
				TbResource parent = tbResourceMapper.get(resource.getParentId());
				node.setpId(Long.valueOf(parent.getId()));
			}
			node.setName(resource.getName());
			if (roleResources != null && roleResources.contains(resource.getId())) {
				node.setChecked(true);
			}
			resulTreeNodes.add(node);
		}
		return resulTreeNodes;
	}

	@Override
	@CacheEvict(value = "resourceCache")
	public void saveOrUpdate(TbResource resource) {
		try {
			if(resource.getId() != null){
				TbResource dbResource = tbResourceMapper.get(resource.getId());
				dbResource.setUpdateTime(new Date());
				dbResource.setName(resource.getName());
				dbResource.setSourceKey(resource.getSourceKey());
				dbResource.setType(resource.getType());
				dbResource.setSourceUrl(resource.getSourceUrl());
				dbResource.setLevel(resource.getLevel());
				dbResource.setSort(resource.getSort());
				dbResource.setIsHide(resource.getIsHide());
				dbResource.setIcon(resource.getIcon());
				dbResource.setDescription(resource.getDescription());
				dbResource.setUpdateTime(new Date());
				if (Objects.nonNull(resource.getParentId())) {
					dbResource.setParentId(resource.getId());
				}
				tbResourceMapper.update(dbResource);
			}else{
				resource.setCreateTime(new Date());
				resource.setUpdateTime(new Date());
				tbResourceMapper.save(resource);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@CacheEvict(value = "resourceCache")
	public void delete(Integer id) {
		// 级联删除role-resource
		tbRoleMapper.deleteResourcesByResourceId(id);
		tbResourceMapper.delete(id);
	}

	@Override
	public Page<TbResource> findAll(Map<String, Object> params, PageRequest pageRequest) {
		SimplePage page = new SimplePage();
		page.setPageNo(pageRequest.getPageNumber());
		page.setPageSize(pageRequest.getPageSize());
		int count = 0;
		List<Resource> resources = null;
		List<TbResource> tbResources = tbResourceMapper.query(page, params);
		if (CollectionUtils.isNotEmpty(tbResources)) {
			count = tbResourceMapper.count(params);
		}

		                                        
		Page<TbResource> results = new PageImpl<TbResource>(tbResources, pageRequest, count);
		return results;
	}

	@Override
	public List<TbResource> findAll() {
		List<TbResource> tbResources = tbResourceMapper.list(null);
		//return BeanConvertUtils.convertBeanList(tbResources, Resource.class);
		return tbResources;
	}

	@Override
	public TbResource find(Integer id) {
		//return BeanConvertUtils.convertBean(tbResourceMapper.get(id), Resource.class);
		return tbResourceMapper.get(id);
	}
}
