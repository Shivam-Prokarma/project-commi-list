package com.shivam.gitcommits.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.shivam.gitcommits.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        setUpLiveData();
    }

    private void setUpLiveData() {
        mainActivityViewModel.getLiveDataResults().observe(this, (resultType) -> {
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
