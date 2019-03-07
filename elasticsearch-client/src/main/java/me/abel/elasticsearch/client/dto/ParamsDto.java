package me.abel.elasticsearch.client.dto;

import java.util.List;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/11 11:24
 */
public class ParamsDto {

    private String index;
    private List<ParamDto> params;

    public ParamsDto() {
    }

    public ParamsDto(String index, List<ParamDto> params) {
        this.index = index;
        this.params = params;
    }

    public final String getIndex() {
        return index;
    }

    public final void setIndex(String index) {
        this.index = index;
    }

    public final List<ParamDto> getParams() {
        return params;
    }

    public final void setParams(List<ParamDto> params) {
        this.params = params;
    }
}
