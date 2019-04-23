package com.shivam.gitcommits.di.module;

import com.shivam.gitcommits.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModulesProvider {

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity getMainActivity();
}
