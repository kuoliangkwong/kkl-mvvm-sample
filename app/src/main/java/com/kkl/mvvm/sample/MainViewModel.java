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

public class MainViewModel extends Observable {
    Point mVideoSizePoint;
    int mTextCounter = 0;
    Toggle mToggle;

    public User user;
    public final ObservableField<String> videoSize =
            new ObservableField<>();

    public MainViewModel(Context context) {
        user = new User();
        mVideoSizePoint = new Point();
        mToggle = new Toggle(Color.RED, Color.BLUE);
    }

    public void setVideoSize(int width, int height) {
        mVideoSizePoint.set(width, height);
    }

    public void onClickText(View v) {
        user.firstName.set("kkl " + mTextCounter++);
    }

    public void onClickButton(View v, int width, int height) {
        mToggle.toggle();
        setVideoSize(width, height);
        setChanged();
        notifyObservers(mToggle);
        videoSize.set(mVideoSizePoint.x + "x" + mVideoSizePoint.y);
    }
}
