package com.example.ratingdatarepo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RatingDataResource Controller Class
 */

@RestController
@RequestMapping(value = "ratings")
public class RatingDataResource {

  @RequestMapping(value = "/{movieId}", method = {RequestMethod.GET})
  public UserRating getRatingData(@PathVariable ("movieId") String movieId) {
    UserRating userRating = new UserRating();
    RatingData ratingData = new RatingData("01", 4.5);
    List<RatingData> ratingDataList = new ArrayList<>();
    ratingDataList.add(ratingData);
    userRating.setRatingDataList(ratingDataList);
    return userRating;
  }

  @RequestMapping(value = "users/{userId}", method = {RequestMethod.GET})
  public UserRating ratingData(@PathVariable("userId") String userId) {
    List<RatingData> ratings = Arrays.asList(
        new RatingData("01", 4.5),
        new RatingData("02", 4.6)
    );
    UserRating userRating = new UserRating();
    userRating.setRatingDataList(ratings);
    return userRating;
  }
}
