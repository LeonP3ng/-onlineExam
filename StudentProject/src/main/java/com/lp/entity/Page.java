package com.lp.entity;

import java.util.List;

public class Page<T> {
    private int pageNum;
    private int pageSize;
    private int totalRecord;
    List<T> list;
    private int totalPage;
    private int start;
    private int end;
    private int startIndex;
    public Page(int pageNum, int pageSize, int totalRecord){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalRecord=totalRecord;
        //计算totalPage
        if(totalRecord%pageSize==0){
            this.totalPage=totalRecord/pageSize;
        }else {
            this.totalPage=totalRecord/pageSize+1;
        }
        //计算startIndex
        this.startIndex=pageNum*pageSize-pageSize;
        //计算start、end默认是5
        if(totalPage<=5){
            this.start=1;
            this.end=totalPage;
        }else{
            this.start=pageNum-2;
            this.end=pageNum+2;
            if(this.start<=0){
                this.start=1;
                this.end=5;
            }
            if(this.end>totalPage){
                this.end=totalPage;
                this.start=this.end-4;
            }
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}