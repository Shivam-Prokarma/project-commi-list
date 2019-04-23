package com.shivam.gitcommits.data;

import com.shivam.gitcommits.data.models.CommitData;
import com.shivam.gitcommits.data.network.CommitDataService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager {

    private final CommitDataService commitDataService;

    @Inject
    public AppDataManager(CommitDataService commitDataService) {
        this.commitDataService = commitDataService;
    }

    public Single<List<CommitData>> getCommitDataList() {
        return commitDataService.getCommitData();
    }
}
