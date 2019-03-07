package me.abel.elasticsearch.template;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 15:22
 */
public class NormalCustomerDto implements Serializable {

    private Date modifiedts;
    private String code;
    private String mobilenumber;
    private String gender;
    private String name;
    private Long pk;
    private String storelist;
    private Date createdts;
    private String paperid;

    public final Date getModifiedts() {
        return modifiedts;
    }

    public final void setModifiedts(Date modifiedts) {
        this.modifiedts = modifiedts;
    }

    public final String getCode() {
        return code;
    }

    public final void setCode(String code) {
        this.code = code;
    }

    public final String getMobilenumber() {
        return mobilenumber;
    }

    public final void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public final String getGender() {
        return gender;
    }

    public final void setGender(String gender) {
        this.gender = gender;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final Long getPk() {
        return pk;
    }

    public final void setPk(Long pk) {
        this.pk = pk;
    }

    public final String getStorelist() {
        return storelist;
    }

    public final void setStorelist(String storelist) {
        this.storelist = storelist;
    }

    public final Date getCreatedts() {
        return createdts;
    }

    public final void setCreatedts(Date createdts) {
        this.createdts = createdts;
    }

    public final String getPaperid() {
        return paperid;
    }

    public final void setPaperid(String paperid) {
        this.paperid = paperid;
    }
}
