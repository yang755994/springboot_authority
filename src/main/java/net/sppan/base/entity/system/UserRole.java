package net.sppan.base.entity.system;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**  */
    private Integer userId;

    /**  */
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}