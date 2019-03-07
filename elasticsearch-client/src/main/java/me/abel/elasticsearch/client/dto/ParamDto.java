package me.abel.elasticsearch.client.dto;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/11 11:24
 */
public class ParamDto {

    private String index;
    private String key;
    private String value;

    public ParamDto() {
    }

    public ParamDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ParamDto(String index, String key, String value) {
        this.index = index;
        this.key = key;
        this.value = value;
    }

    public final String getIndex() {
        return index;
    }

    public final void setIndex(String index) {
        this.index = index;
    }

    public final String getKey() {
        return key;
    }

    public final void setKey(String key) {
        this.key = key;
    }

    public final String getValue() {
        return value;
    }

    public final void setValue(String value) {
        this.value = value;
    }
}
