package com.shivam.gitcommits.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.shivam.gitcommits.R;
import com.shivam.gitcommits.ui.adapters.CommitListAdapter;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    CommitListAdapter commitListAdapter;

    private MainActivityViewModel mainActivityViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
        setUpLiveData();
        setUpRecyclerView(savedInstanceState);
    }

    //@param savedInsatnceStated is to differentiate between whether Activity is recreated on orientation change
    // or created first time on launch.
    private void setUpRecyclerView(Bundle savedInstanceState) {
        final RecyclerView recyclerView = findViewById(R.id.listCommits);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(commitListAdapter);
        if (savedInstanceState != null && mainActivityViewModel.hasData()) {
            commitListAdapter.setData(mainActivityViewModel.getCommitDataList());
        } else {
            mainActivityViewModel.fetchCommitData();
        }
    }

    private void setUpLiveData() {
        mainActivityViewModel.getLiveDataResults().observe(this, (resultType) -> {
            switch (resultType) {
                case IN_PROGRESS:
                    progressBar.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    progressBar.setVisibility(View.GONE);
                    commitListAdapter.setData(mainActivityViewModel.getCommitDataList());
                    break;
                case FAILURE:
                    progressBar.setVisibility(View.GONE);
                default:
                    break;
            }
        });
    }

}
