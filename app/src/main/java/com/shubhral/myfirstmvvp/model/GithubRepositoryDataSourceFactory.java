package com.shubhral.myfirstmvvp.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import com.shubhral.myfirstmvvp.GithubService;

public class GithubRepositoryDataSourceFactory extends DataSource.Factory<Long, Repository> {

    private final GithubService githubService;
    private final MutableLiveData<GithubRepositoryDataSource> githubRepositoryDataSourceLiveData = new MutableLiveData<>();

    public GithubRepositoryDataSourceFactory(GithubService githubService) {
        this.githubService = githubService;
    }

    @Override
    public DataSource<Long, Repository> create() {
        GithubRepositoryDataSource dataSource = new GithubRepositoryDataSource(githubService);
        githubRepositoryDataSourceLiveData.postValue(dataSource);
        return dataSource;
    }
}
