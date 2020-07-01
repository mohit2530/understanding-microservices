package io.microservice.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * MovieCatalogResource Controller Class
 */

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {

  @RequestMapping(value = "/{userId}", method = {RequestMethod.GET})
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    // if the userId is "mohit" then load titanic else load transformers

    if (userId.equalsIgnoreCase("mohit")) {
      List<CatalogItem> catalogItems = new ArrayList<>();
      CatalogItem catalogItem = new CatalogItem("Titanic", "Romantic Movie", 4.5);
      catalogItems.add(catalogItem);
      return catalogItems; // we can also use Collections.singletonList(new CatalogItem(name, description, rating);
    }
    return Collections.singletonList(new CatalogItem("Transformers", "Bumblebee Adventures", 4.7));
  }


}
