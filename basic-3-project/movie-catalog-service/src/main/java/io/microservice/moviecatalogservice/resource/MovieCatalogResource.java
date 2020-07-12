package io.microservice.moviecatalogservice.resource;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * MovieCatalogResource Controller Class
 */

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

  private static final String RATING_URI = "http://user-rating-service/ratings/users/";
  private static final String MOVIEINFO_URI = "http://movie-info-service/movieInfo/";

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(value = "/{userId}", method = {RequestMethod.GET})
  public Catalog getCatalog(@PathVariable("userId") String userId) {
    Catalog catalog = new Catalog();
    UserRating userRating = restTemplate.getForObject(RATING_URI + userId, UserRating.class);

    catalog.setCatalogItemList(userRating.getRatingDataList().stream().map(ratingData -> {
      MovieInfo movieInfo = restTemplate.getForObject(MOVIEINFO_URI + ratingData.getMovieId(), MovieInfo.class);
       return new CatalogItem(movieInfo.getMovieName(), "No description provided" ,ratingData.getRating());
    }).collect(Collectors.toList()));

    return catalog;
  }

  @RequestMapping(value = "rating/{ratingId}", method = {RequestMethod.GET})
  public UserRating singleRating(@PathVariable("ratingId") String ratingId) {
    Catalog catalog = new Catalog();
    UserRating userRating = restTemplate.getForObject("http://user-rating-service/ratings/" + ratingId, UserRating.class);
    return userRating;
  }
}
