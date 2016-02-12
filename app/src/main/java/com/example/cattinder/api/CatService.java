package com.example.cattinder.api;

import com.google.gson.Gson;

import com.example.cattinder.data.CatServiceResponse;
import com.example.cattinder.rx.SchedulerFactory;

import java.util.HashMap;
import java.util.Map;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Uses Google Custom Search API to search
 * for images of cats.
 *
 * Key: AIzaSyAZmvW6DecHAvtLCiqYQzmhKCNnsOYxtgo
 * Search Engine ID: 005351716643766109453:uusxxukdams
 *
 * URL:
 * https://www.googleapis.com/customsearch/v1?key=AIzaSyAZmvW6DecHAvtLCiqYQzmhKCNnsOYxtgo&cx=005351716643766109453:uusxxukdams&q=cat&searchType=image
 */
public interface CatService {

  String BASE_URL = "https://www.googleapis.com";

  class RestClient {

    private final CatService service;

    public static RestClient createService() {

      return new RestClient();
    }

    private RestClient() {
      super();

      RestAdapter.Builder builder = new RestAdapter.Builder()
              .setEndpoint(BASE_URL);

      RestAdapter restAdapter = builder.build();
      this.service = restAdapter.create(CatService.class);
    }

    public CatService getService() {
      return this.service;
    }
  }



  @GET("/customsearch/v1?key=AIzaSyAZmvW6DecHAvtLCiqYQzmhKCNnsOYxtgo&cx=005351716643766109453" +
    ":uusxxukdams&searchType=image&q=cat")
  CatServiceResponse getCats(@Query("start") int startIndex);

  /**
   * Optional version of {@link #getCats(int)} that returns the response via
   * an RxJava {@link Observable}.
   *
   * Also see: {@link SchedulerFactory}
   */
//  @GET("/customsearch/v1?key=AIzaSyAZmvW6DecHAvtLCiqYQzmhKCNnsOYxtgo&cx=005351716643766109453" +
//      ":uusxxukdams&searchType=image&q=cat")
//  Observable<CatServiceResponse> getCats(@Query("start") int startIndex);
}
