package com.shubhral.myfirstmvvp;

import android.app.Activity;
import android.app.Application;

import com.shubhral.myfirstmvvp.di.ApplicationComponent;
import com.shubhral.myfirstmvvp.di.ContextModule;
import com.shubhral.myfirstmvvp.di.DaggerApplicationComponent;

import timber.log.Timber;

/**
 * Created by Shubhral on 3/25/2018.
 */

public class MyApp extends Application {

    private ApplicationComponent applicationComponent;

    public static MyApp get(Activity activity) {
        return (MyApp) activity.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
