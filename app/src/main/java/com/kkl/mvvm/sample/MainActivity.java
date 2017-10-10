package com.kkl.mvvm.sample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kkl.mvvm.sample.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final MainViewModel mainViewModel = new MainViewModel(this);
        mBinding.setMainViewModel(mainViewModel);
        mainViewModel.addObserver(this);

        // In case some libraries do not support certain event listeners,
        // use example below for complying MVVM architecture
        mBinding.btnPressMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.onClickButton(view,
                        mBinding.btnPressMe.getWidth(), mBinding.btnPressMe.getHeight());
            }
        });
    }

    @Override
    public void update(Observable observable, Object data) {
        Toggle colorToggle = (Toggle) data;
        mBinding.btnPressMe.setBackgroundColor((int)colorToggle.current());
    }
}
