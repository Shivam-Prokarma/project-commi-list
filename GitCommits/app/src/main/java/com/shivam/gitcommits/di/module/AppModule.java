package com.shivam.gitcommits.di.module;

import com.shivam.gitcommits.data.network.CommitDataService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    public CommitDataService getCommitDataService() {

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(false);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.client(builder.build());
        retrofitBuilder.baseUrl("https://api.github.com");
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync());
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder.build().create(CommitDataService.class);
    }
}
