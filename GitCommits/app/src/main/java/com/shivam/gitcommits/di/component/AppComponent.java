package com.shivam.gitcommits.di.component;

import com.shivam.gitcommits.GitCommitApp;
import com.shivam.gitcommits.di.module.ActivityModulesProvider;
import com.shivam.gitcommits.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityModulesProvider.class})
public interface AppComponent {

    void inject(GitCommitApp gitCommitApp);

}
