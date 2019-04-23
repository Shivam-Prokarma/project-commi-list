package com.shivam.gitcommits.data.network;

import com.shivam.gitcommits.data.models.CommitData;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CommitDataService {

    @GET("repos/Shivam-Prokarma/project-commit-list/commits")
    Single<List<CommitData>> getCommitData();

}
