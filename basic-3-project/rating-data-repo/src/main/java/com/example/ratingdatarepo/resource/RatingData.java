package com.example.ratingdatarepo.resource;

/**
 * RatingData Class
 */

public class RatingData {

  private String movieId;
  private double rating;

  /**
   * Constructor
   * @param movieId
   * @param rating
   */
  public RatingData(String movieId, double rating) {
    this.movieId = movieId;
    this.rating = rating;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
