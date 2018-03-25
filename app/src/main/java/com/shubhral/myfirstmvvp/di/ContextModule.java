package com.shubhral.myfirstmvvp.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shubhral on 3/26/2018.
 */
@Module
public class ContextModule {

    private Application application;

    public ContextModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context providesContext() {
        return application;
    }
}
