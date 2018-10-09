package net.sppan.base.vo;

import java.io.Serializable;

/**
 * @author: yangzhigang
 * @Date: 2018/10/9 14:06
 * @Description:
 */
public class SqlGenerateDto implements Serializable {

//    @NotEmpty(message = "skus不能为空")
    private String skus;

    private String priceName;

    private Integer templateId;

    private String warehouseCode;

    private String pipelineCode;

    private String sysLabelId;

    public String getSkus() {
        return skus;
    }

    public void setSkus(String skus) {
        this.skus = skus;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getPipelineCode() {
        return pipelineCode;
    }

    public void setPipelineCode(String pipelineCode) {
        this.pipelineCode = pipelineCode;
    }

    public String getSysLabelId() {
        return sysLabelId;
    }

    public void setSysLabelId(String sysLabelId) {
        this.sysLabelId = sysLabelId;
    }
}
