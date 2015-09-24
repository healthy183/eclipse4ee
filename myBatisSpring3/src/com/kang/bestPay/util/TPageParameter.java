package com.kang.bestPay.util;

import java.io.Serializable;

/**
 *
 * user:pengzz
 * Time: 2014/5/27 17:18.
 * 分页参数类
 * 
 */
public class TPageParameter implements Serializable{
    private static final long serialVersionUID = -2050903899112211502L;

    public static final int DEFAULT_PAGE_SIZE = 2;

    private int pageSize;
    private int currentPage;
    private int totalPage;
    private int totalCount;

    public TPageParameter() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * 
     * @param currentPage
     * @param pageSize
     */
    public TPageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage <= 0 ?1 : currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize <= 0 ?10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
