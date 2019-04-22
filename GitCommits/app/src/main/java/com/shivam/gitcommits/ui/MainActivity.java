package com.shivam.gitcommits.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.shivam.gitcommits.R;

import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.loader);
        setUpLiveData();
    }

    private void setUpLiveData() {
        mainActivityViewModel.getLiveDataResults().observe(this, (Observer<MainActivityViewModel.ResultType>) (resultType) -> {
            switch (resultType) {
                case IN_PROGRESS:
                    progressBar.setVisibility(View.VISIBLE);
                    break;
                case SUCCESS:
                    progressBar.setVisibility(View.GONE);
                    break;
                case FAILURE:
                    progressBar.setVisibility(View.GONE);
                default:
                    break;
            }
        });
    }

}
