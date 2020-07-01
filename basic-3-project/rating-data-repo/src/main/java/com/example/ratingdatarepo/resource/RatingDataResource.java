package com.example.ratingdatarepo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RatingDataResource Controller Class
 */

@RestController
@RequestMapping(value = "/ratings")
public class RatingDataResource {

  @RequestMapping(value = "/{movieId}", method = {RequestMethod.GET})
  public RatingData getRatingData(@PathVariable ("movieId") String movieId) {
    return new RatingData(movieId, 4.5);
  }
}
