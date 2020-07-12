package com.example.movieinforepo.resource;

/**
 * Class MovieInfo
 */

public class MovieInfo {

  private String movieId;
  private String movieName;

  /**
   * Constructor
   * @param movieId
   * @param movieName
   */
  public MovieInfo(String movieId, String movieName) {
    this.movieId = movieId;
    this.movieName = movieName;
  }

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public String getMovieName() {
    return movieName;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }
}
