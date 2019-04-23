package com.shivam.gitcommits.di.module;

import com.shivam.gitcommits.ui.MainActivityViewModel;
import com.shivam.gitcommits.ui.ViewModelFactory;

import javax.inject.Singleton;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    public ViewModelProvider.Factory provideViewModelProvider(MainActivityViewModel mainActivityViewModel){
        return new ViewModelFactory<>(mainActivityViewModel);
    }
}
