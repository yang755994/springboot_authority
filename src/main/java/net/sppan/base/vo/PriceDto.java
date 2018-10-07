package net.sppan.base.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 价格dto
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/7 18:53
 */
public class PriceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 主键ID
     */
    private Long id;

    /**
     * 价格ID
     */
    private String priceId;

    /**
     * 价格条件ID
     */
    private String conditionId;

    /**
     * 组名称
     */
    private String priceName;

    /**
     * 商品SKU
     */
    private String goodSn;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 用户自定义标签ID,逗号隔开
     */
    private String userLabelId;

    /**
     * 系统标签ID
     */
    private String sysLabelId;
    
    /**
     * 模板ID
     */
    private Integer templateId;

    /**
     * 仓库编码
     */
    private String warehouseCode;

    /**
     * 利润率
     */
    private BigDecimal rates;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 价格因子
     */
    private String priceMd5;

    /**
     * 价格标识：0-普通 1-限价 2-最低利润率
     */
    private Integer priceMark;

    /**
     * 价格尾数
     */
    private BigDecimal mantissa;

    /**
     * 开始时间
     */
    private Integer startTime;

    /**
     * 结束时间
     */
    private Integer endTime;

    /**
     * 网站code
     */
    private String siteCode;

    /**
     * 是否锁定,0-否 1-是
     */
    private Integer isLock;

    /**
     * 申请库存占用状态：0-不能申请库存占用 1-可以申请库存占用  2-已经申请库存占用 3-库存占用已审核
     */
    private Integer applyStatus;

    /**
     * 状态 0-不可用 1-可用 2-删除
     */
    private Integer status;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 建档人ID
     */
    private Integer creatorId;

    /**
     * 建档人名称
     */
    private String creatorName;

    /**
     * 建档时间
     */
    private Integer createTime;

    /**
     * 修改操作人ID
     */
    private Integer updatorId;

    /**
     * 修改操作人名称
     */
    private String updatorName;

    /**
     * 更新时间
     */
    private Integer updateTime;
    

    /**
     * 模板名称
     */
	private String templateName;

	private String goodThumbUrl;

	private BigDecimal shopPrice;

	private String categoryName;

	private String warehouseName;

	private String goodName;

	/**
	 * 模板分类
	 */
	private Integer classId;

	/**
	 * 积分比率
	 */
	private BigDecimal integralRate;

	/**
	 * 系统标签名称
	 */
	private String label;

	/**
	 * 定时价格增长
	 */
	private String timerRiseInPrice;

	/**
	 * 定时订单增长
	 */
	private String timerRiseInOrder;

	/**
	 * 订单量价格异动
	 */
	private String orderChange;

	/**
	 * 虚拟售出数量
	 */
	private Integer virtualSaleQty;

	/**
	 * 可销售数量
	 */
	private Integer saleQty;

	/**
	 * 用户购买数量限制
	 */
	private Integer buyLimit;

	/**
	 * 绑定会员
	 */
	private String users;

	/**
	 * 用户等级
	 */
	private String userLevel;

	/**
	 * 平台
	 */
	private String platforms;

	/**
	 * 绑定国家
	 */
	private String country;

	/**
	 * 用户邮箱
	 */
	private String emails;

	/**
	 * 密文
	 */
	private String ciphertext;

	/**
	 * 是否同款生效
	 */
	private Integer isSameStyle;

	/**
	 * 说明
	 */
	private String declare;

	/**
	 * 阶梯价
	 */
	private String stepPrice;

	/**
	 * 生效标识：1-已生效  0-未生效
	 */
	private Integer isEffect;

	/**
	 * 强制类型：强制包邮、强制促销
	 */
	private String forceType;

	/**
	 * 渠道编码
	 */
	private String pipelineCode;
	
	/**
	 * 店铺编码
	 */
	private String shopCode;
	
	/**
	 * 平台主体or店铺主体
	 */
	private String sponsor;
	
	/**
	 * 结果说明(priceLog要存储该信息)
	 */
	private String resultDesc;
	
	/**
	 * 排除系统标签
	 */
	private String excludeSysLabelId;
	
	/**
	 * 已卖出的数量
	 */
	private Integer usedCount;
	
	/**
	 * 老gb修改之前的使用次数
	 */
	private Integer usedCountOld = 0;
	
	/** 是否共享:1-是 0-否 */
	private Integer shareStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getConditionId() {
		return conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public String getPriceName() {
		return priceName;
	}

	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}

	public String getGoodSn() {
		return goodSn;
	}

	public void setGoodSn(String goodSn) {
		this.goodSn = goodSn;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getUserLabelId() {
		return userLabelId;
	}

	public void setUserLabelId(String userLabelId) {
		this.userLabelId = userLabelId;
	}

	public String getSysLabelId() {
		return sysLabelId;
	}

	public void setSysLabelId(String sysLabelId) {
		this.sysLabelId = sysLabelId;
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

	public BigDecimal getRates() {
		return rates;
	}

	public void setRates(BigDecimal rates) {
		this.rates = rates;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPriceMd5() {
		return priceMd5;
	}

	public void setPriceMd5(String priceMd5) {
		this.priceMd5 = priceMd5;
	}

	public Integer getPriceMark() {
		return priceMark;
	}

	public void setPriceMark(Integer priceMark) {
		this.priceMark = priceMark;
	}

	public BigDecimal getMantissa() {
		return mantissa;
	}

	public void setMantissa(BigDecimal mantissa) {
		this.mantissa = mantissa;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdatorId() {
		return updatorId;
	}

	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}

	public String getUpdatorName() {
		return updatorName;
	}

	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getGoodThumbUrl() {
		return goodThumbUrl;
	}

	public void setGoodThumbUrl(String goodThumbUrl) {
		this.goodThumbUrl = goodThumbUrl;
	}

	public BigDecimal getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(BigDecimal shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public BigDecimal getIntegralRate() {
		return integralRate;
	}

	public void setIntegralRate(BigDecimal integralRate) {
		this.integralRate = integralRate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTimerRiseInPrice() {
		return timerRiseInPrice;
	}

	public void setTimerRiseInPrice(String timerRiseInPrice) {
		this.timerRiseInPrice = timerRiseInPrice;
	}

	public String getTimerRiseInOrder() {
		return timerRiseInOrder;
	}

	public void setTimerRiseInOrder(String timerRiseInOrder) {
		this.timerRiseInOrder = timerRiseInOrder;
	}

	public String getOrderChange() {
		return orderChange;
	}

	public void setOrderChange(String orderChange) {
		this.orderChange = orderChange;
	}

	public Integer getVirtualSaleQty() {
		return virtualSaleQty;
	}

	public void setVirtualSaleQty(Integer virtualSaleQty) {
		this.virtualSaleQty = virtualSaleQty;
	}

	public Integer getSaleQty() {
		return saleQty;
	}

	public void setSaleQty(Integer saleQty) {
		this.saleQty = saleQty;
	}

	public Integer getBuyLimit() {
		return buyLimit;
	}

	public void setBuyLimit(Integer buyLimit) {
		this.buyLimit = buyLimit;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getCiphertext() {
		return ciphertext;
	}

	public void setCiphertext(String ciphertext) {
		this.ciphertext = ciphertext;
	}

	public Integer getIsSameStyle() {
		return isSameStyle;
	}

	public void setIsSameStyle(Integer isSameStyle) {
		this.isSameStyle = isSameStyle;
	}

	public String getDeclare() {
		return declare;
	}

	public void setDeclare(String declare) {
		this.declare = declare;
	}

	public String getStepPrice() {
		return stepPrice;
	}

	public void setStepPrice(String stepPrice) {
		this.stepPrice = stepPrice;
	}

	public Integer getIsEffect() {
		return isEffect;
	}

	public void setIsEffect(Integer isEffect) {
		this.isEffect = isEffect;
	}

	public String getForceType() {
		return forceType;
	}

	public void setForceType(String forceType) {
		this.forceType = forceType;
	}

	public String getPipelineCode() {
		return pipelineCode;
	}

	public void setPipelineCode(String pipelineCode) {
		this.pipelineCode = pipelineCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getExcludeSysLabelId() {
		return excludeSysLabelId;
	}

	public void setExcludeSysLabelId(String excludeSysLabelId) {
		this.excludeSysLabelId = excludeSysLabelId;
	}

	public Integer getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public Integer getUsedCountOld() {
		return usedCountOld;
	}

	public void setUsedCountOld(Integer usedCountOld) {
		this.usedCountOld = usedCountOld;
	}

	public Integer getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(Integer shareStatus) {
		this.shareStatus = shareStatus;
	}
}