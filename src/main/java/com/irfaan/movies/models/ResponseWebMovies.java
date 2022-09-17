package com.irfaan.movies.models;

public class ResponseWebMovies {

    private String title;

    private String description;

    private String rating;

    private String category;

    private boolean isShareable;

    private boolean isDownloadable;

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isShareable() {
        return isShareable;
    }

    public void setShareable(boolean shareable) {
        isShareable = shareable;
    }

    public boolean isDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        isDownloadable = downloadable;
    }

    @Override
    public String toString() {
        return "ResponseWebMovies{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", category='" + category + '\'' +
                ", isShareable=" + isShareable +
                ", isDownloadable=" + isDownloadable +
                '}';
    }
}
