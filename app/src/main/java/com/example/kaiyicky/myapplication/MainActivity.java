package com.example.kaiyicky.myapplication;

import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PathView pathView = (PathView) findViewById(R.id.pathView);
//        final Path path = makeConvexArrow(50, 100);
//        pathView.setPath(path);
        //执行动画后不再回到开始
        pathView.setFillAfter(true);
        //使用svg内部本身的颜色
        pathView.useNaturalColors();
        //点击事件
        pathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拿到本身svg里面的动画
                pathView.getPathAnimator().
                        //延迟时间
                        delay(100).
                        //执行时间
                        duration(1500).
                        //动画插入器
                        interpolator(new AccelerateDecelerateInterpolator()).
                        //开始执行
                        start();
            }
        });
    }

    private Path makeConvexArrow(float length, float height) {
        final Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(length / 4f, 0.0f);
        path.lineTo(length, height / 2.0f);
        path.lineTo(length / 4f, height);
        path.lineTo(0.0f, height);
        path.lineTo(length * 3f / 4f, height / 2f);
        path.lineTo(0.0f, 0.0f);
        path.close();
        return path;
    }

}
