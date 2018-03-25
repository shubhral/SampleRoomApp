package com.shubhral.myfirstmvvp.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Shubhral on 3/26/2018.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    public Cache providesCache(Context context) {
        return new Cache(context.getCacheDir(), 10 * 1024 * 1024);
    }

    @Provides
    public HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }
}
