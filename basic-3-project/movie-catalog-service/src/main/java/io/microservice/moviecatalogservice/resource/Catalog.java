package io.microservice.moviecatalogservice.resource;

import java.util.List;

public class Catalog {

  private List<CatalogItem> catalogItemList;

  public List<CatalogItem> getCatalogItemList() {
    return catalogItemList;
  }

  public void setCatalogItemList(
      List<CatalogItem> catalogItemList) {
    this.catalogItemList = catalogItemList;
  }
}
