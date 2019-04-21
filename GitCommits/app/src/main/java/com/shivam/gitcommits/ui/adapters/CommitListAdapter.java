package com.shivam.gitcommits.ui.adapters;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shivam.gitcommits.R;
import com.shivam.gitcommits.data.models.CommitData;
import com.shivam.gitcommits.databinding.CommitDetailsLayoutBinding;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class CommitListAdapter extends RecyclerView.Adapter<CommitListAdapter.CommitListViewHolder> {

    private List<CommitData> commitDataList = Collections.emptyList();

    //Set the @CommitData after fetching from Git web API.
    public void setData(List<CommitData> commitDataList) {
        this.commitDataList = commitDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommitDetailsLayoutBinding commitDetailsLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.commit_details_layout, parent, false);
        return new CommitListViewHolder(commitDetailsLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommitListViewHolder commitListViewHolder, int position) {
        commitListViewHolder.bindData(commitDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return commitDataList.size();
    }

    static class CommitListViewHolder extends RecyclerView.ViewHolder {

        private final CommitDetailsLayoutBinding commitDetailsLayoutBinding;

        public CommitListViewHolder(CommitDetailsLayoutBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.commitDetailsLayoutBinding = viewDataBinding;
        }

        public void bindData(CommitData commitData) {
            commitDetailsLayoutBinding.setCommitData(commitData);
        }
    }
}
