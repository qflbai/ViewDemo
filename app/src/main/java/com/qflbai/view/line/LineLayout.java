package com.qflbai.view.line;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.qflbai.view.R;
import com.qflbai.view.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;


public class LineLayout extends RelativeLayout {
    LineView view;
    Button animateBt;

    public LineLayout(Context context) {
        super(context);
    }

    public LineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();


        view = (LineView) findViewById(R.id.objectAnimatorView);

        animateBt = (Button) findViewById(R.id.animateBt);
        OnClickListener listener = new OnClickListener() {


            @Override
            public void onClick(View v) {
                view.start();
            }
        };
        view.start();
        animateBt.setOnClickListener(listener);
        view.setOnClickListener(listener);
    }


}
