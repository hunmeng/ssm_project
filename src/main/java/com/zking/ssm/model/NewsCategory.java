package com.zking.ssm.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NewsCategory implements Serializable {
    private Integer id;

    private Integer nid;

    private Integer cid;

    private News news;

    private Category category;

    public NewsCategory(Integer id, Integer nid, Integer cid) {
        this.id = id;
        this.nid = nid;
        this.cid = cid;
    }

    public NewsCategory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "NewsCategory{" +
                "id=" + id +
                ", nid=" + nid +
                ", cid=" + cid +
                '}';
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}