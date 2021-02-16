package com.accp.vo;

public class Page<T> extends com.baomidou.mybatisplus.extension.plugins.pagination.Page<T> {

    public Long getPrev(){
        return ((this.getCurrent()-1>0)?this.getCurrent()-1:1);
    }

    public Long getNext(){
        return this.getCurrent()+1>this.getPages()?this.getPages():this.getCurrent()+1;
    }

}
