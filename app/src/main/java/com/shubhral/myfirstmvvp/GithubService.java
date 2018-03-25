package com.shubhral.myfirstmvvp;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Shubhral on 3/26/2018.
 */
public interface GithubService {

    @GET("/users/{userId}/repos")
    Call<Response> getRepositories(@Path("userId") String userId);
}
