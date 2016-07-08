package com.example.y.mvp.mvp.Bean;

/**
 * by 12406 on 2016/5/14.
 */
@SuppressWarnings("ALL")
public class TabNewsInfo {

    private Long id;
    private Integer mId;
    private String name;

    public TabNewsInfo() {
    }

    public TabNewsInfo(Long id) {
        this.id = id;
    }

    public TabNewsInfo(Long id, Integer mId, String name) {
        this.id = id;
        this.mId = mId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
