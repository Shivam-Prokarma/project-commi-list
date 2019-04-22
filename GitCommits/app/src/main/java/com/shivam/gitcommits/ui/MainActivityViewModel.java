package com.shivam.gitcommits.ui;

import com.shivam.gitcommits.data.AppDataManager;
import com.shivam.gitcommits.data.models.CommitData;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ResultType> liveDataResults = new MutableLiveData<>();

    private List<CommitData> commitDataList = null;

    public void fetchCommitData() {

        AppDataManager.getInstance().getCommitDataList().subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribeWith(new DisposableSingleObserver<List<CommitData>>() {

                    @Override
                    protected void onStart() {
                        liveDataResults.postValue(ResultType.IN_PROGRESS);
                    }

                    @Override
                    public void onSuccess(List<CommitData> listCommitData) {
                        commitDataList = listCommitData;
                        liveDataResults.postValue(ResultType.SUCCESS);
                    }

                    @Override
                    public void onError(Throwable e) {
                        liveDataResults.postValue(ResultType.FAILURE);
                    }
                });

    }

    public LiveData<ResultType> getLiveDataResults() {
        return liveDataResults;
    }

    public List<CommitData> getCommitDataList() {
        return commitDataList;
    }

    enum ResultType {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }
}
