package net.sppan.base.vo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by yangzg on 2018/10/7.
 */
public class BatchDelPriceRedis implements Serializable {

    @NotEmpty(message = "skus不能为空")
    private String skus;

    @NotEmpty(message = "warehuoseCode不能为空")
    private String warehouseCode;

    @NotEmpty(message = "pipelineCode不能为空")
    private String pipelineCode;

    public String getSkus() {
        return skus;
    }

    public void setSkus(String skus) {
        this.skus = skus;
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
