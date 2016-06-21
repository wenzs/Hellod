package com.wenzs.jokeintefacetest;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/19.
 */
public class Joke_showapi_res_body {
    private int allPages;
    private int ret_code;
    private Joke_contentlist[] contentlist;
    private int currentPage;
    private long allNum;
    private int maxResult;

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public Joke_contentlist[] getContentlist() {
        return contentlist;
    }

    public void setContentlist(Joke_contentlist[] contentlist) {
        this.contentlist = contentlist;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getAllNum() {
        return allNum;
    }

    public void setAllNum(long allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    @Override
    public String toString() {
        return "Joke_showapi_res_body{" +
                "allPages=" + allPages +
                ", ret_code=" + ret_code +
                ", contentlist=" + Arrays.toString(contentlist) +
                ", currentPage=" + currentPage +
                ", allNum=" + allNum +
                ", maxResult=" + maxResult +
                '}';
    }
}
