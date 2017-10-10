package com.kkl.mvvm.sample.views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.kkl.mvvm.sample.R;
import com.kkl.mvvm.sample.databinding.HintTextViewBinding;

import java.util.Observable;

/**
 * Created by Kuo Liang on 10-Oct-17.
 */

public class HintTextView extends FrameLayout {
    public HintTextView(@NonNull Context context) {
        this(context, null);
    }

    public HintTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HintTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final HintTextViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.hint_text_view, this, true);
        ViewModel viewModel = new ViewModel();
        binding.setModel(viewModel);
        binding.etName.addTextChangedListener(viewModel.textWatcher());
    }

    public static class ViewModel extends Observable {
        public ObservableInt hintTextVisibility = new ObservableInt();

        public ViewModel() {
            hintTextVisibility.set(View.INVISIBLE);
        }

        public TextWatcher textWatcher() {
            return new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    hintTextVisibility.set(count > 0 ? View.VISIBLE : View.INVISIBLE);
                }

                @Override
                public void afterTextChanged(Editable s) {}
            };
        }
    }
}
