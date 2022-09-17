package com.irfaan.movies.entities;

import javax.persistence.*;

@Entity
@Table(name = "movies_detail")
public class MoviesDetail extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob()
    @Column(name = "detail_description")
    private String detailDescription;

    private Double rating;

    @Column(name = "is_shareable")
    private boolean isShareAble;

    @Column(name = "is_downloadable")
    private boolean isDownloadable;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean isShareAble() {
        return isShareAble;
    }

    public void setShareAble(boolean shareAble) {
        isShareAble = shareAble;
    }

    public boolean isDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        isDownloadable = downloadable;
    }

    @Override
    public String toString() {
        return "MoviesDetail{" +
                "id=" + id +
                ", detailDescription='" + detailDescription + '\'' +
                ", rating='" + rating + '\'' +
                ", isShareAble=" + isShareAble +
                ", isDownloadable=" + isDownloadable +
                '}';
    }
}
