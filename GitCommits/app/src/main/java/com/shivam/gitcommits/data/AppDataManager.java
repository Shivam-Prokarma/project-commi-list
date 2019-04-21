package com.shivam.gitcommits.data;

import com.shivam.gitcommits.data.models.CommitData;
import com.shivam.gitcommits.data.network.CommitDataService;

import java.util.List;

import io.reactivex.Single;

public class AppDataManager {

    public CommitDataService commitDataService;

    public Single<List<CommitData>> getCommitDataList() {
        return commitDataService.getCommitData();
    }
}
