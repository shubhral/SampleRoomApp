package com.shubhral.myfirstmvvp;

import com.shubhral.myfirstmvvp.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Shubhral on 3/26/2018.
 */
public interface GithubService {

    @GET("/search/repositories")
    Call<List<Repository>> getRepositoriesByTopic(@Query("q") String topic,
                                           @Query("page") long pageNumber);
}
