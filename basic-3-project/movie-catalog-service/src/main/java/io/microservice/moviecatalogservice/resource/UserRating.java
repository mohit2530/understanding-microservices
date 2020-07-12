package io.microservice.moviecatalogservice.resource;

import java.util.List;

public class UserRating {

  private List<RatingData> ratingDataList;

  public List<RatingData> getRatingDataList() {
    return ratingDataList;
  }

  public void setRatingDataList(
      List<RatingData> ratingDataList) {
    this.ratingDataList = ratingDataList;
  }
}
