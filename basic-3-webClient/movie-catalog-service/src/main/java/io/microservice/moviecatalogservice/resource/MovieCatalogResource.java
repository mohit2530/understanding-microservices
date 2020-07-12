package io.microservice.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * MovieCatalogResource Controller Class
 */

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

  private static final String uri = "http://localhost:9001/movieInfo/";

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @RequestMapping(value = "/{userId}", method = {RequestMethod.GET})
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

    List<RatingData> ratings = Arrays.asList(
        new RatingData("01", 4.5),
        new RatingData("02", 4.6)
    );

    return ratings.stream().map(ratingData -> {
      MovieInfo movieInfo = restTemplate.getForObject(uri + ratingData.getMovieId(), MovieInfo.class);
//      bodyToMono means whatever body you get back convert it into the instance of the class, mono is a reactive way of saying its a promise
//      and block means to block execution until the execution is complete.
//      MovieInfo movieInfo = webClientBuilder.build().get().uri(uri + ratingData.getMovieId()).retrieve().bodyToMono(MovieInfo.class).block();
      return new CatalogItem(movieInfo.getMovieName(), "No description provided" ,ratingData.getRating());
    }).collect(Collectors.toList());
  }
}
