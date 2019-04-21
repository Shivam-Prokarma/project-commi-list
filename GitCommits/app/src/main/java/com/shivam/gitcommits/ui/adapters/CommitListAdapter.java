package com.shivam.gitcommits.ui.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class CommitListAdapter extends RecyclerView.Adapter<CommitListAdapter.CommitListViewHolder> {

    @NonNull
    @Override
    public CommitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CommitListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class CommitListViewHolder extends RecyclerView.ViewHolder {

        public CommitListViewHolder(View view) {
            super(view);
        }
    }
}
