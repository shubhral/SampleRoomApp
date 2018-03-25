package com.shubhral.myfirstmvvp.di;

import com.shubhral.myfirstmvvp.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Shubhral on 3/26/2018.
 */
@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    GithubService getGithubService();

    Picasso getPicasso();

}
