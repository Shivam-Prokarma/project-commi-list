package com.shivam.gitcommits.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory {

    private T viewModel;

    public ViewModelFactory(T viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (!modelClass.isInstance(viewModel)) {
            throw new IllegalArgumentException("Can not create View Model!!");
        }
        return (T) viewModel;
    }
}
