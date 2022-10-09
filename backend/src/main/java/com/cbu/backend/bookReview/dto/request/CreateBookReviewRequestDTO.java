package com.cbu.backend.bookReview.dto.request;

public class CreateBookReviewRequestDTO {

    private String id;
    private String detailReview;
    private String simpleReview;
    private star starPoint;
    private star starLevel;
    private enum star {
        oneStar, twoStar, threeStar, fourStar, fiveStar
    }

    public CreateBookReviewRequestDTO(String name, String id, String detailReview,
                                      String simpleReview, star starPoint, star starLevel) {
        this.id = id;
        this.detailReview = detailReview;
        this.simpleReview = simpleReview;
        this.starPoint = starPoint;
        this.starLevel = starLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetailReview() {
        return detailReview;
    }

    public void setDetailReview(String detailReview) {
        this.detailReview = detailReview;
    }

    public String getSimpleReview() {
        return simpleReview;
    }

    public void setSimpleReview(String simpleReview) {
        this.simpleReview = simpleReview;
    }

    public star getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(star starPoint) {
        this.starPoint = starPoint;
    }

    public star getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(star starLevel) {
        this.starLevel = starLevel;
    }
}
