package com.cbcnews.adp.cbcnewstest.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by asharshoaib on 2016-10-24.
 */

public class News extends RealmObject {


    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("sourceId")
    @Expose
    private String sourceId;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    @SerializedName("readablePublishedAt")
    @Expose
    private String readablePublishedAt;

    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    @SerializedName("readableUpdatedAt")
    @Expose
    private String readableUpdatedAt;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("imageLarge")
    @Expose
    private String imageLarge;

    @SerializedName("imageSmall")
    @Expose
    private String imageSmall;

    @SerializedName("url")
    @Expose
    private String url;

    public News(Integer id, String title, String description, String source, String sourceId, String publishedAt, String readablePublishedAt, String updatedAt, String readableUpdatedAt, String type, String imageLarge, String imageSmall, String url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.source = source;
        this.sourceId = sourceId;
        this.publishedAt = publishedAt;
        this.readablePublishedAt = readablePublishedAt;
        this.updatedAt = updatedAt;
        this.readableUpdatedAt = readableUpdatedAt;
        this.type = type;
        this.imageLarge = imageLarge;
        this.imageSmall = imageSmall;
        this.url = url;
    }

    public News() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getReadablePublishedAt() {
        return readablePublishedAt;
    }

    public void setReadablePublishedAt(String readablePublishedAt) {
        this.readablePublishedAt = readablePublishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReadableUpdatedAt() {
        return readableUpdatedAt;
    }

    public void setReadableUpdatedAt(String readableUpdatedAt) {
        this.readableUpdatedAt = readableUpdatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
