package com.bean;

import java.util.List;

/**
 * 分页
 *
 * @author l666888999
 * @version 1.0
 * @date 2022/11/20 14:15
 **/
public class Page<T> {
    //上一页
    private int prePage;
    //下一页
    private int nextPage;
    //首页
    private int firstPage=1;
    //尾页
    private int lastPage;
    //当前页
    private int currentPage=1;
    //总页数
    private int totalPage;
    //每页显示的条数
    private int pageSize;
    //总条数
    private int totalDate;
    //传过来的数据
    private List<T> pageDate;
    public Page(){

    }
    public Page(int currentPage,int pageSize,int totalDate){
        this.currentPage=currentPage;
        this.pageSize=pageSize;
        this.totalDate=totalDate;
        //计算获得总页数(尾页)
        //this.totalPage=this.lastPage=(totalDate+pageSize-1)/pageSize;
        this.totalPage=this.lastPage=(int)Math.ceil((double)totalDate/pageSize);
        //防止当前页小于1
        this.currentPage=Math.max(this.currentPage,1);
        //防止当前页大于总的页数
        this.currentPage=Math.min(this.totalPage,this.currentPage);
        //设置上一页，上一页不能小于1
        this.prePage=Math.max(this.currentPage - 1,1);
        //设置下一页，下一页不能大于总的页数
        this.nextPage=Math.min(this.currentPage +1,this.totalPage);




    }

    public Page(int prePage, int nextPage, int firstPage, int lastPage, int currentPage, int totalPage, int pageSize, int totalDate, List<T> pageDate) {
        this.prePage = prePage;
        this.nextPage = nextPage;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.totalDate = totalDate;
        this.pageDate = pageDate;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        int count= totalDate/pageSize;
        return (totalDate/pageSize==0)? count:count+1;
    }

   /* public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }*/

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(int totalDate) {
        this.totalDate = totalDate;
    }

    public List<T> getPageDate() {
        return pageDate;
    }

    public void setPageDate(List<T> pageDate) {
        this.pageDate = pageDate;
    }
}