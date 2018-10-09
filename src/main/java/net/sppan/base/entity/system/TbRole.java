package net.sppan.base.entity.system;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.Resource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 
 *
 * @author yangzhigang
 * @since 2018-10-6
 *
 */
public class TbRole implements Serializable {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /**  */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**  */
    private String description;

    /**  */
    private String name;

    /**  */
    private String roleKey;

    /**  */
    private Integer status;

    /**  */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private java.util.List<TbResource> resources;

    public List<TbResource> getResources() {
        return resources;
    }

    public void setResources(List<TbResource> resources) {
        this.resources = resources;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}