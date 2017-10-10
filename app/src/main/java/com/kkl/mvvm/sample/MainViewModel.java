package com.kkl.mvvm.sample;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

import java.util.Observable;

/**
 * Created by Kuo Liang on 09-Oct-17.
 */

public class MainViewModel {
    Point mVideoSizePoint;
    int mTextCounter = 0;
    Toggle mToggle;
    MainNavigator mNavigator;

    public User user;
    public final ObservableField<String> videoSize =
            new ObservableField<>();

    public MainViewModel(Context context) {
        user = new User();
        mVideoSizePoint = new Point();
        mToggle = new Toggle(Color.RED, Color.BLUE);
        setListener(new MainNavigator() {
            @Override
            public void onToggled(int color) {
                //Do nothing now.
            }
        });
    }

    public void setListener(MainNavigator navigator) {
        mNavigator = navigator;
    }

    public void setVideoSize(int width, int height) {
        mVideoSizePoint.set(width, height);
    }

    public void onClickText(View v) {
        user.firstName.set("kkl " + mTextCounter++);
    }

    public void onClickButton(View v, int width, int height) {
        setVideoSize(width, height);
        mNavigator.onToggled((int)mToggle.toggle());
        videoSize.set(mVideoSizePoint.x + "x" + mVideoSizePoint.y);
    }
}
