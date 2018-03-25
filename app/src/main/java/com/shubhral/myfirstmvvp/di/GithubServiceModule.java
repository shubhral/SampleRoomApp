package com.shubhral.myfirstmvvp.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shubhral.myfirstmvvp.GithubService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shubhral on 3/26/2018.
 */
@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    public Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    public Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    public GithubService providesGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }
}
