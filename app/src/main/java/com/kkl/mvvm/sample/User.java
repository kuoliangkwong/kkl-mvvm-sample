package com.kkl.mvvm.sample;

import android.databinding.ObservableField;
import android.view.View;

/**
 * Created by Kuo Liang on 09-Oct-17.
 */

public class User {
    int counter = 0;

    public final ObservableField<String> firstName =
            new ObservableField<>();

    public User() {
        //Initialize everything here
    }

    public void onClick(View v) {
        firstName.set("kkl " + counter++);
    }
}
