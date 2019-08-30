package com.szw.springbootdemosu.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SaasPurchaseBillDetialPo implements Serializable {
    private Long id;

    private String guid;//分库分表后，弃用自增id,使用guid作为唯一标识

    /**
     * 解决jqgrid的id绑定问题
     */
    private Long idTemp;

    private Long purchaseBillId;
    /**
     * 单据编号
     */
    private String billNo;

    private String productCode;

    private String productCodeText; 	//仅前端显示使用

    private String productName;

    private String productBatchNo;

    private Date productDate;

    private Date productExpiryDate;

    private String specifications;

    private String packingUnit;

    private String manufacturer;

    private BigDecimal productAmount;

    private BigDecimal stockNum;

    private BigDecimal productTaxPrice;

    private BigDecimal productTaxPriceSum;

    private BigDecimal discount;

    private BigDecimal productDiscountTaxPrice;

    private BigDecimal productDiscountTaxPriceSum;

    private BigDecimal productRetailPrice;

    private BigDecimal productMemberPrice;

    private BigDecimal productRejectionAmount;

    private BigDecimal productSampleAmount;

    private BigDecimal productQualifiedAmount;

    private BigDecimal productUnqualifiedAmount;

    private String productUnqualifiedRemark;

    private String productReturnReason;

    private String remark;

    private Boolean reviewConclusion;

    /**
     * 解决jqgrid不能传递select的value问题
     */
    private String reviewConclusionText;

    private String approvalNumber;

    private String productOriginAddress;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private Boolean yn;

    private Byte upload;

    /**
     * 采购退出单使用，原单数量
     */
    private BigDecimal oldAmount;

    /**
     * 采购退出单使用，已退出量
     */
    private BigDecimal oldRejectAmount;

    /**
     * 采购退出单使用, 库存状态
     */
    private String stockStatusTest;
    /**
     * 库存数量，退出开票单使用
     */
    private BigDecimal stockAmount;

    /**
     * 1：不可以被下游流程提取；当bill_type类型为04的时候，表示是否可以被采购退出开票提取
     */
    private Byte cannotFind;

    /**
     * 最后三次采购入库价格
     */
    private String lastThreeTaxPrice;

    private String commonName;

    private String supplier_name;

    /**
     * 进货价
     */
    private BigDecimal buyingPrice;

    private Byte status;

    private String baseVersion;
    private String organSign;
    private Integer page;//页码
    private Integer rows;//每页条数
    private String pharmacyPref;// 药店商品标识

    private Integer businessScope;// 经营范围
    /**
     * 最后一次供应商名称
     */
    private String lastSupplierName;
    /**
     * 最后一次供应商编码
     */
    private String lastSupplierNo;
    /**
     * 最近入库价
     */
    private BigDecimal lastPrice;

    /**
     * 处理措施
     */
    private String productTreatment;

    /**
     * 货位
     **/
    private String positionNo;

    /**
     * 货位名称
     **/
    private String positionName;

    /**
     * 货位禁用状态
     **/
    private Integer positionUsed;

    /**
     * 收货数量
     **/
    private BigDecimal receivingAmount;

    /**
     *  采购数量
     **/
    private BigDecimal productOrderAmount;

    /**
     *  标准库id
     **/
    private Long standardLibraryId;

    /**
     *   商品新分类
     **/
    private Integer systemType;
    /**
     *   是否是中药饮片  1：是 0：否
     **/
    private Integer specialType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(Long idTemp) {
        this.idTemp = idTemp;
    }

    public Long getPurchaseBillId() {
        return purchaseBillId;
    }

    public void setPurchaseBillId(Long purchaseBillId) {
        this.purchaseBillId = purchaseBillId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCodeText() {
        return productCodeText;
    }

    public void setProductCodeText(String productCodeText) {
        this.productCodeText = productCodeText;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBatchNo() {
        return productBatchNo;
    }

    public void setProductBatchNo(String productBatchNo) {
        this.productBatchNo = productBatchNo;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(Date productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

    public BigDecimal getProductTaxPrice() {
        return productTaxPrice;
    }

    public void setProductTaxPrice(BigDecimal productTaxPrice) {
        this.productTaxPrice = productTaxPrice;
    }

    public BigDecimal getProductTaxPriceSum() {
        return productTaxPriceSum;
    }

    public void setProductTaxPriceSum(BigDecimal productTaxPriceSum) {
        this.productTaxPriceSum = productTaxPriceSum;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getProductDiscountTaxPrice() {
        return productDiscountTaxPrice;
    }

    public void setProductDiscountTaxPrice(BigDecimal productDiscountTaxPrice) {
        this.productDiscountTaxPrice = productDiscountTaxPrice;
    }

    public BigDecimal getProductDiscountTaxPriceSum() {
        return productDiscountTaxPriceSum;
    }

    public void setProductDiscountTaxPriceSum(BigDecimal productDiscountTaxPriceSum) {
        this.productDiscountTaxPriceSum = productDiscountTaxPriceSum;
    }

    public BigDecimal getProductRetailPrice() {
        return productRetailPrice;
    }

    public void setProductRetailPrice(BigDecimal productRetailPrice) {
        this.productRetailPrice = productRetailPrice;
    }

    public BigDecimal getProductMemberPrice() {
        return productMemberPrice;
    }

    public void setProductMemberPrice(BigDecimal productMemberPrice) {
        this.productMemberPrice = productMemberPrice;
    }

    public BigDecimal getProductRejectionAmount() {
        return productRejectionAmount;
    }

    public void setProductRejectionAmount(BigDecimal productRejectionAmount) {
        this.productRejectionAmount = productRejectionAmount;
    }

    public BigDecimal getProductSampleAmount() {
        return productSampleAmount;
    }

    public void setProductSampleAmount(BigDecimal productSampleAmount) {
        this.productSampleAmount = productSampleAmount;
    }

    public BigDecimal getProductQualifiedAmount() {
        return productQualifiedAmount;
    }

    public void setProductQualifiedAmount(BigDecimal productQualifiedAmount) {
        this.productQualifiedAmount = productQualifiedAmount;
    }

    public BigDecimal getProductUnqualifiedAmount() {
        return productUnqualifiedAmount;
    }

    public void setProductUnqualifiedAmount(BigDecimal productUnqualifiedAmount) {
        this.productUnqualifiedAmount = productUnqualifiedAmount;
    }

    public String getProductUnqualifiedRemark() {
        return productUnqualifiedRemark;
    }

    public void setProductUnqualifiedRemark(String productUnqualifiedRemark) {
        this.productUnqualifiedRemark = productUnqualifiedRemark;
    }

    public String getProductReturnReason() {
        return productReturnReason;
    }

    public void setProductReturnReason(String productReturnReason) {
        this.productReturnReason = productReturnReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getReviewConclusion() {
        return reviewConclusion;
    }

    public void setReviewConclusion(Boolean reviewConclusion) {
        this.reviewConclusion = reviewConclusion;
    }

    public String getReviewConclusionText() {
        return reviewConclusionText;
    }

    public void setReviewConclusionText(String reviewConclusionText) {
        this.reviewConclusionText = reviewConclusionText;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getProductOriginAddress() {
        return productOriginAddress;
    }

    public void setProductOriginAddress(String productOriginAddress) {
        this.productOriginAddress = productOriginAddress;
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

    public Boolean getYn() {
        return yn;
    }

    public void setYn(Boolean yn) {
        this.yn = yn;
    }

    public Byte getUpload() {
        return upload;
    }

    public void setUpload(Byte upload) {
        this.upload = upload;
    }

    public BigDecimal getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(BigDecimal oldAmount) {
        this.oldAmount = oldAmount;
    }

    public BigDecimal getOldRejectAmount() {
        return oldRejectAmount;
    }

    public void setOldRejectAmount(BigDecimal oldRejectAmount) {
        this.oldRejectAmount = oldRejectAmount;
    }

    public String getStockStatusTest() {
        return stockStatusTest;
    }

    public void setStockStatusTest(String stockStatusTest) {
        this.stockStatusTest = stockStatusTest;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Byte getCannotFind() {
        return cannotFind;
    }

    public void setCannotFind(Byte cannotFind) {
        this.cannotFind = cannotFind;
    }

    public String getLastThreeTaxPrice() {
        return lastThreeTaxPrice;
    }

    public void setLastThreeTaxPrice(String lastThreeTaxPrice) {
        this.lastThreeTaxPrice = lastThreeTaxPrice;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getBaseVersion() {
        return baseVersion;
    }

    public void setBaseVersion(String baseVersion) {
        this.baseVersion = baseVersion;
    }

    public String getOrganSign() {
        return organSign;
    }

    public void setOrganSign(String organSign) {
        this.organSign = organSign;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getPharmacyPref() {
        return pharmacyPref;
    }

    public void setPharmacyPref(String pharmacyPref) {
        this.pharmacyPref = pharmacyPref;
    }

    public Integer getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(Integer businessScope) {
        this.businessScope = businessScope;
    }

    public String getLastSupplierName() {
        return lastSupplierName;
    }

    public void setLastSupplierName(String lastSupplierName) {
        this.lastSupplierName = lastSupplierName;
    }

    public String getLastSupplierNo() {
        return lastSupplierNo;
    }

    public void setLastSupplierNo(String lastSupplierNo) {
        this.lastSupplierNo = lastSupplierNo;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getProductTreatment() {
        return productTreatment;
    }

    public void setProductTreatment(String productTreatment) {
        this.productTreatment = productTreatment;
    }

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionUsed() {
        return positionUsed;
    }

    public void setPositionUsed(Integer positionUsed) {
        this.positionUsed = positionUsed;
    }

    public BigDecimal getReceivingAmount() {
        return receivingAmount;
    }

    public void setReceivingAmount(BigDecimal receivingAmount) {
        this.receivingAmount = receivingAmount;
    }

    public BigDecimal getProductOrderAmount() {
        return productOrderAmount;
    }

    public void setProductOrderAmount(BigDecimal productOrderAmount) {
        this.productOrderAmount = productOrderAmount;
    }

    public Long getStandardLibraryId() {
        return standardLibraryId;
    }

    public void setStandardLibraryId(Long standardLibraryId) {
        this.standardLibraryId = standardLibraryId;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public Integer getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
    }

    @Override
    public String toString() {
        return "SaasPurchaseBillDetialPo{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", idTemp=" + idTemp +
                ", purchaseBillId=" + purchaseBillId +
                ", billNo='" + billNo + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productCodeText='" + productCodeText + '\'' +
                ", productName='" + productName + '\'' +
                ", productBatchNo='" + productBatchNo + '\'' +
                ", productDate=" + productDate +
                ", productExpiryDate=" + productExpiryDate +
                ", specifications='" + specifications + '\'' +
                ", packingUnit='" + packingUnit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productAmount=" + productAmount +
                ", stockNum=" + stockNum +
                ", productTaxPrice=" + productTaxPrice +
                ", productTaxPriceSum=" + productTaxPriceSum +
                ", discount=" + discount +
                ", productDiscountTaxPrice=" + productDiscountTaxPrice +
                ", productDiscountTaxPriceSum=" + productDiscountTaxPriceSum +
                ", productRetailPrice=" + productRetailPrice +
                ", productMemberPrice=" + productMemberPrice +
                ", productRejectionAmount=" + productRejectionAmount +
                ", productSampleAmount=" + productSampleAmount +
                ", productQualifiedAmount=" + productQualifiedAmount +
                ", productUnqualifiedAmount=" + productUnqualifiedAmount +
                ", productUnqualifiedRemark='" + productUnqualifiedRemark + '\'' +
                ", productReturnReason='" + productReturnReason + '\'' +
                ", remark='" + remark + '\'' +
                ", reviewConclusion=" + reviewConclusion +
                ", reviewConclusionText='" + reviewConclusionText + '\'' +
                ", approvalNumber='" + approvalNumber + '\'' +
                ", productOriginAddress='" + productOriginAddress + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", yn=" + yn +
                ", upload=" + upload +
                ", oldAmount=" + oldAmount +
                ", oldRejectAmount=" + oldRejectAmount +
                ", stockStatusTest='" + stockStatusTest + '\'' +
                ", stockAmount=" + stockAmount +
                ", cannotFind=" + cannotFind +
                ", lastThreeTaxPrice='" + lastThreeTaxPrice + '\'' +
                ", commonName='" + commonName + '\'' +
                ", supplier_name='" + supplier_name + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", status=" + status +
                ", baseVersion='" + baseVersion + '\'' +
                ", organSign='" + organSign + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                ", pharmacyPref='" + pharmacyPref + '\'' +
                ", businessScope=" + businessScope +
                ", lastSupplierName='" + lastSupplierName + '\'' +
                ", lastSupplierNo='" + lastSupplierNo + '\'' +
                ", lastPrice=" + lastPrice +
                ", productTreatment='" + productTreatment + '\'' +
                ", positionNo='" + positionNo + '\'' +
                ", positionName='" + positionName + '\'' +
                ", positionUsed=" + positionUsed +
                ", receivingAmount=" + receivingAmount +
                ", productOrderAmount=" + productOrderAmount +
                ", standardLibraryId=" + standardLibraryId +
                ", systemType=" + systemType +
                ", specialType=" + specialType +
                '}';
    }
}
