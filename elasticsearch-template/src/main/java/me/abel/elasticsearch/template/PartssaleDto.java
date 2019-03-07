package me.abel.elasticsearch.template;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 11:12
 */
public class PartssaleDto implements Serializable {

    private String pricecondition;
    private String pricestartdate;
    private String productcode;
    private String pricecode;
    private Long productpk;
    private Date createdts;
    private Long ydstorepk;
    private Date modifiedts;
    private String storeuid;
    private String price;
    private String priceunit;
    private String priceenddate;
    private String productname;
    private Long pk;

    public final String getPricecondition() {
        return pricecondition;
    }

    public final void setPricecondition(String pricecondition) {
        this.pricecondition = pricecondition;
    }

    public final String getPricestartdate() {
        return pricestartdate;
    }

    public final void setPricestartdate(String pricestartdate) {
        this.pricestartdate = pricestartdate;
    }

    public final String getProductcode() {
        return productcode;
    }

    public final void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public final String getPricecode() {
        return pricecode;
    }

    public final void setPricecode(String pricecode) {
        this.pricecode = pricecode;
    }

    public final Long getProductpk() {
        return productpk;
    }

    public final void setProductpk(Long productpk) {
        this.productpk = productpk;
    }

    public final Date getCreatedts() {
        return createdts;
    }

    public final void setCreatedts(Date createdts) {
        this.createdts = createdts;
    }

    public final Long getYdstorepk() {
        return ydstorepk;
    }

    public final void setYdstorepk(Long ydstorepk) {
        this.ydstorepk = ydstorepk;
    }

    public final Date getModifiedts() {
        return modifiedts;
    }

    public final void setModifiedts(Date modifiedts) {
        this.modifiedts = modifiedts;
    }

    public final String getStoreuid() {
        return storeuid;
    }

    public final void setStoreuid(String storeuid) {
        this.storeuid = storeuid;
    }

    public final String getPrice() {
        return price;
    }

    public final void setPrice(String price) {
        this.price = price;
    }

    public final String getPriceunit() {
        return priceunit;
    }

    public final void setPriceunit(String priceunit) {
        this.priceunit = priceunit;
    }

    public final String getPriceenddate() {
        return priceenddate;
    }

    public final void setPriceenddate(String priceenddate) {
        this.priceenddate = priceenddate;
    }

    public final String getProductname() {
        return productname;
    }

    public final void setProductname(String productname) {
        this.productname = productname;
    }

    public final Long getPk() {
        return pk;
    }

    public final void setPk(Long pk) {
        this.pk = pk;
    }
}
