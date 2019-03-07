package me.abel.utils;

import java.util.List;

/**
 * @author Aaron.xun
 * @Title:
 * @Package
 * @Description:
 * @email aaron.xun@ibreakingpoint.com
 * @date 2018/8/2 10:49
 */
public class PageUtil<T> {
    private int pageSize =10; //每页显示条数
    private int pageNo;//当前页
    private int totalCount; //总条数
    private int start; //开始条数
    private int totalPages; //总页数
    private List<T> pageList;//数据

    public final int getPageSize() {
        return pageSize;
    }

    public final void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public final int getPageNo() {
        return pageNo;
    }

    public final void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public final int getTotalCount() {
        return totalCount;
    }

    public final void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public final int getStart() {
        this.start = ((pageNo < 1 ? 1 : pageNo)-1)* pageSize;
        return start;
    }

    public final void setStart(int start) {
        this.start = start;
    }

    public final int getTotalPages() {
        this.totalPages = totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize+1;
        return totalPages;
    }

    public final void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public final List<T> getPageList() {
        return pageList;
    }

    public final void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
