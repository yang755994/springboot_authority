package net.sppan.base.mapper.system;

import net.sppan.base.entity.system.RoleResource;
import net.sppan.base.entity.system.TbRole;
import net.sppan.base.entity.system.UserRole;
import net.sppan.base.mapper.support.BaseMapper;

import java.util.List;

/**
 * Mapper/**
 *
 *
 * @author yangzhigang
 * @since 2018-10-6
 *
 */
public interface TbRoleMapper extends BaseMapper<TbRole> {
    /**
     * 获取对应的资源ID
     * @param roleId
     * @return
     */
    List<Integer> getRoleResources(Integer roleId);

    /**
     * 级联删除
     * @param id
     * @return
     */
    int deleteResourcesByResourceId(Integer id);

    /**
     * 级联删除
     * @param id
     * @return
     */
    int deleteResourcesByRoleId(Integer id);

    /**
     * 批量插入roleResources
     * @param resources
     * @return
     */
    int batchInsertRoleResources(List<RoleResource> resources);

    /**
     * 级联删除UserRole
     * @param id
     * @return
     */
    int deleteUserRolesByUserId(Integer id);

    /**
     * 批量插入UserRole
     * @param userRoles
     * @return
     */
    int batchInsertUserRoles(List<UserRole> userRoles);
}