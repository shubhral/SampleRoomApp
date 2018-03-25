package com.shubhral.myfirstmvvp.di;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Shubhral on 3/26/2018.
 */
@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    public OkHttp3Downloader providesOkHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    public Picasso providesPicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }
}
