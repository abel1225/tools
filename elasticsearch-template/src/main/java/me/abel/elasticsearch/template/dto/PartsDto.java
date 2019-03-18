package me.abel.elasticsearch.template.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 15:19
 */
public class PartsDto implements Serializable {

    private String code;
    private Long approvalstatus;
    private String brandnamelist;
    private String baseunit;
    private Date createdts;
    private String categorylist;
    private String statuscode;
    private Date modifiedts;
    private String brandcodelist;
    private String name;
    private String manucode;
    private Long pk;
    private String pricequantity;

    public final String getCode() {
        return code;
    }

    public final void setCode(String code) {
        this.code = code;
    }

    public final Long getApprovalstatus() {
        return approvalstatus;
    }

    public final void setApprovalstatus(Long approvalstatus) {
        this.approvalstatus = approvalstatus;
    }

    public final String getBrandnamelist() {
        return brandnamelist;
    }

    public final void setBrandnamelist(String brandnamelist) {
        this.brandnamelist = brandnamelist;
    }

    public final String getBaseunit() {
        return baseunit;
    }

    public final void setBaseunit(String baseunit) {
        this.baseunit = baseunit;
    }

    public final Date getCreatedts() {
        return createdts;
    }

    public final void setCreatedts(Date createdts) {
        this.createdts = createdts;
    }

    public final String getCategorylist() {
        return categorylist;
    }

    public final void setCategorylist(String categorylist) {
        this.categorylist = categorylist;
    }

    public final String getStatuscode() {
        return statuscode;
    }

    public final void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public final Date getModifiedts() {
        return modifiedts;
    }

    public final void setModifiedts(Date modifiedts) {
        this.modifiedts = modifiedts;
    }

    public final String getBrandcodelist() {
        return brandcodelist;
    }

    public final void setBrandcodelist(String brandcodelist) {
        this.brandcodelist = brandcodelist;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getManucode() {
        return manucode;
    }

    public final void setManucode(String manucode) {
        this.manucode = manucode;
    }

    public final Long getPk() {
        return pk;
    }

    public final void setPk(Long pk) {
        this.pk = pk;
    }

    public final String getPricequantity() {
        return pricequantity;
    }

    public final void setPricequantity(String pricequantity) {
        this.pricequantity = pricequantity;
    }
}
