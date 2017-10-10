package com.kkl.mvvm.sample;

/**
 * Created by Kuo Liang on 10-Oct-17.
 */

public class Toggle {

    Object mToggle1;
    Object mToggle2;
    Object mSelectedToggle;

    public Toggle(Object toggle1, Object toggle2) {
        mToggle1 = toggle1;
        mToggle2 = toggle2;
        mSelectedToggle = toggle1;
    }

    public Object toggle() {
        if (mToggle1 == mSelectedToggle) {
            mSelectedToggle = mToggle2;
        } else {
            mSelectedToggle = mToggle1;
        }
        return mSelectedToggle;
    }

    public Object current() {
        return mSelectedToggle;
    }
}
