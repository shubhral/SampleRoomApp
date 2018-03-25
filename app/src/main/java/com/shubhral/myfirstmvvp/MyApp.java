package com.shubhral.myfirstmvvp;

import android.app.Activity;
import android.app.Application;

import com.shubhral.myfirstmvvp.di.ContextModule;
import com.shubhral.myfirstmvvp.di.DaggerGithubApplicationComponent;
import com.shubhral.myfirstmvvp.di.GithubApplicationComponent;

import timber.log.Timber;

/**
 * Created by Shubhral on 3/25/2018.
 */

public class MyApp extends Application {

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this)).build();
    }
}
