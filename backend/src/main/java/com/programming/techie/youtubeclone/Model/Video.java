package com.programming.techie.youtubeclone.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;


@Document(value="video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    private String id;
    private String videoUrl;
    private String thumbnailUrl;
    private String description;
    private String title;
    private String userId;
    private Integer likes;
    private Integer dislikes;
    private Set<String> tags;
    private VideoStatus videoStatus;
    private Integer views;
    private List<Comment> commentsList;

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public Set<String> getTags() {
        return tags;
    }

    public VideoStatus getVideoStatus() {
        return videoStatus;
    }

    public Integer getViews() {
        return views;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setVideoStatus(VideoStatus videoStatus) {
        this.videoStatus = videoStatus;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }




}
