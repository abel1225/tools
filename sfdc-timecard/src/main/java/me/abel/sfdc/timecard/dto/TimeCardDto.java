package me.abel.sfdc.timecard.dto;

import java.util.List;

/**
 * @description:
 * @author: able.li
 * @create: 2018/12/29 14:02
 */
public class TimeCardDto {

    private String message;

    private List<TimeCardDetailDto> details;

    public final String getMessage() {
        return message;
    }

    public final void setMessage(String message) {
        this.message = message;
    }

    public final List<TimeCardDetailDto> getDetails() {
        return details;
    }

    public final void setDetails(List<TimeCardDetailDto> details) {
        this.details = details;
    }
}
