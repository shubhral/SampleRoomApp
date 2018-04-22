package com.shubhral.myfirstmvvp.model;

import android.arch.paging.ItemKeyedDataSource;
import android.support.annotation.NonNull;

import com.shubhral.myfirstmvvp.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepositoryDataSource extends ItemKeyedDataSource<Long, Repository> {

    private long pageCount = 1;
    private final GithubService githubService;

    public GithubRepositoryDataSource(GithubService githubService) {
        this.githubService = githubService;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Repository> callback) {
        githubService.getRepositoriesByTopic("topic:android", pageCount).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull final LoadCallback<Repository> callback) {
        githubService.getRepositoriesByTopic("topic:android", pageCount).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Repository> callback) {

    }

    @NonNull
    @Override
    public Long getKey(@NonNull Repository item) {
        return ++pageCount;
    }
}
