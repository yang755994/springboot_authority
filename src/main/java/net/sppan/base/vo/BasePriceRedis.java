package net.sppan.base.vo;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author: yangzhigang
 * @Date: 2018/10/7 11:26
 * @Description:
 */
public class BasePriceRedis implements Serializable {

    @NotEmpty(message = "goodSn不能为空")
    private String goodSn;
    @NotEmpty(message = "warehouseCode不能为空")
    private String warehouseCode;
    @NotEmpty(message = "pipelineCode不能为空")
    private String pipelineCode;

    public String getGoodSn() {
        return goodSn;
    }

    public void setGoodSn(String goodSn) {
        this.goodSn = goodSn;
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
}
