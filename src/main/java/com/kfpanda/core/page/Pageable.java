package com.kfpanda.core.page;

/**
 * 分页查询参数包装类。
 * @author kfpanda
 * @Date 2016/7/6
 */
public class Pageable {
    private int offset;
    private int pageSize;
    private String sort;

    public Pageable(){

    }

    public Pageable(int offset, int pageSize, String sort){
        this.offset = offset;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }
}
