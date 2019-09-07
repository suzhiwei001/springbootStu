package com.szw.springbootdemosu.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaasPurchaseBillInfo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 上级单据编号
     */
    private String parentBillNo;

    /**
     * 单据编号
     */
    private String billNo;

    /**
     * 开票日期
     */
    private Date billTime;

    /**
     * 商品种类
     */
    private Integer productKind;

    /**
     * 收货时间
     */
    private Date receivedTime;

    /**
     * 单据类型: 01-采购订单 02-收货复核 03-入库验收 04-采购入库单
     */
    private String billType;

    /**
     * 供应商编号
     */
    private String supplierNo;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 审核人
     */
    private String reviewUser;

    /**
     * 处理单据人员
     */
    private String billingUser;

    /**
     * 采购单含税总金额
     */
    private BigDecimal taxAmountSum;

    /**
     * 整单折扣
     */
    private BigDecimal discount;

    /**
     * 折后金额
     */
    private BigDecimal priceAfterDiscount;

    /**
     * 折扣金额
     */
    private BigDecimal priceDiscounted;

    /**
     * 到货温度
     */
    private BigDecimal arrivalTemperature;

    /**
     * 承运单位
     */
    private String carrierUnit;

    /**
     * 启运地址
     */
    private String shipment;

    /**
     * 启运时间
     */
    private Date departureTime;

    /**
     * 承运方式
     */
    private String transportMode;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 单据状态: 01-录入；02-正式
     */
    private String status;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除 1 有效 0 删除
     */
    private Byte yn;

    /**
     * 上报系统，1：上报成功；0：上报失败或未上报
     */
    private Byte upload;

    /**
     * 收货状态，1：已收货或者已入库
     */
    private Byte receivingState;

    /**
     * 采购订单标号
     */
    private String purchaseBillNo;

    /**
     * 操作版本号
     */
    private String baseVersion;

    /**
     * 药店唯一标识
     */
    private String organsign;

    /**
     * guid
     */
    private String guid;

    /**
     * saas_purchase_bill_info
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentBillNo() {
        return parentBillNo;
    }

    public void setParentBillNo(String parentBillNo) {
        this.parentBillNo = parentBillNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Integer getProductKind() {
        return productKind;
    }

    public void setProductKind(Integer productKind) {
        this.productKind = productKind;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(String reviewUser) {
        this.reviewUser = reviewUser;
    }

    public String getBillingUser() {
        return billingUser;
    }

    public void setBillingUser(String billingUser) {
        this.billingUser = billingUser;
    }

    public BigDecimal getTaxAmountSum() {
        return taxAmountSum;
    }

    public void setTaxAmountSum(BigDecimal taxAmountSum) {
        this.taxAmountSum = taxAmountSum;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(BigDecimal priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public BigDecimal getPriceDiscounted() {
        return priceDiscounted;
    }

    public void setPriceDiscounted(BigDecimal priceDiscounted) {
        this.priceDiscounted = priceDiscounted;
    }

    public BigDecimal getArrivalTemperature() {
        return arrivalTemperature;
    }

    public void setArrivalTemperature(BigDecimal arrivalTemperature) {
        this.arrivalTemperature = arrivalTemperature;
    }

    public String getCarrierUnit() {
        return carrierUnit;
    }

    public void setCarrierUnit(String carrierUnit) {
        this.carrierUnit = carrierUnit;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getYn() {
        return yn;
    }

    public void setYn(Byte yn) {
        this.yn = yn;
    }

    public Byte getUpload() {
        return upload;
    }

    public void setUpload(Byte upload) {
        this.upload = upload;
    }

    public Byte getReceivingState() {
        return receivingState;
    }

    public void setReceivingState(Byte receivingState) {
        this.receivingState = receivingState;
    }

    public String getPurchaseBillNo() {
        return purchaseBillNo;
    }

    public void setPurchaseBillNo(String purchaseBillNo) {
        this.purchaseBillNo = purchaseBillNo;
    }

    public String getBaseVersion() {
        return baseVersion;
    }

    public void setBaseVersion(String baseVersion) {
        this.baseVersion = baseVersion;
    }

    public String getOrgansign() {
        return organsign;
    }

    public void setOrgansign(String organsign) {
        this.organsign = organsign;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}