package com.example.movieinforepo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MovieInfoResource Controller Class
 */

@RestController
@RequestMapping(value = "/movieInfo")
public class MovieInfoResource {

  @RequestMapping(value = "/{movieId}", method = {RequestMethod.GET})
  public MovieInfo getMovieInfo(@PathVariable ("movieId") String movieId) {
    return new MovieInfo(movieId, "Test Name");
  }

}
