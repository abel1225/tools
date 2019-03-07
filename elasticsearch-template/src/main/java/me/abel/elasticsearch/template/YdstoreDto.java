package me.abel.elasticsearch.template;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: able.li
 * @create: 2019/3/1 15:21
 */
public class YdstoreDto implements Serializable {

    private String uid;
    private Date modifiedts;
    private String oacoding;
    private String name;
    private Long pk;
    private String fullname;
    private Date createdts;

    public final String getUid() {
        return uid;
    }

    public final void setUid(String uid) {
        this.uid = uid;
    }

    public final Date getModifiedts() {
        return modifiedts;
    }

    public final void setModifiedts(Date modifiedts) {
        this.modifiedts = modifiedts;
    }

    public final String getOacoding() {
        return oacoding;
    }

    public final void setOacoding(String oacoding) {
        this.oacoding = oacoding;
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

    public final String getFullname() {
        return fullname;
    }

    public final void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public final Date getCreatedts() {
        return createdts;
    }

    public final void setCreatedts(Date createdts) {
        this.createdts = createdts;
    }
}
