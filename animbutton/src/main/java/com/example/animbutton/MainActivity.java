package com.example.animbutton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 孙晨昊 2016/4/11
 */
public class MainActivity extends AppCompatActivity {
    private int[] mRes = {R.id.imgbtn1, R.id.imgbtn2, R.id.imgbtn3};
    private List<ImageView> mImageButton = new ArrayList<ImageView>();
    private boolean mFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < mRes.length; i++) {
            ImageView imageView = (ImageView) findViewById(mRes[i]);
            mImageButton.add(imageView);
        }
    }

    public void Open(View view) {
        if (mFlag) {
            closeAnim();
        } else {
            startAnim();
        }
    }

    private void closeAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageButton.get(0), "translationY", 200F);;
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageButton.get(1), "translationY", 400F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageButton.get(2), "translationY", 600F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2);
        set.start();
        mFlag = false;
    }


    private void startAnim() {
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageButton.get(0), "translationY", -200F);;
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageButton.get(1), "translationY", -400F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageButton.get(2), "translationY", -600F);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(animator0, animator1, animator2);
        set.start();
        mFlag = true;
    }
}
