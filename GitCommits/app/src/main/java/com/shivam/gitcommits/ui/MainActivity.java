package com.shivam.gitcommits.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shivam.gitcommits.R;

//https://api.github.com/repos/Shivam-Prokarma/project-commit-list/commits
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
