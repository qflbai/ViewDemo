package com.qflbai.view.line;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @author: qflbai
 * @CreateDate: 2019/3/12 11:46
 * @Version: 1.0
 * @description:
 */
public class LineView extends View {
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = getPaint();
        Path path = new Path();
        path.moveTo(100, 600);
        path.lineTo(400, 100);
        path.lineTo(700, 900);

        canvas.drawPath(path, paint);
        paint.setColor(Color.RED);


        //使用DashPathEffect画线段
        paint.setPathEffect(new DashPathEffect(new float[]{20, 10, 100, 100}, 0));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);


        paint.setPathEffect(new DashPathEffect(new float[]{20, 10, 50, 100}, pahas));
        paint.setColor(Color.GREEN);
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

    }


    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;

    }

    int pahas = 0;

    public void start() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 180);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                pahas = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(460);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
       // valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }
}
