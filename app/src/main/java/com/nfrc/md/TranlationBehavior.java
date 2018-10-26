package com.nfrc.md;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangl on 2018/10/26.
 */

public class TranlationBehavior extends FloatingActionButton.Behavior{

    public TranlationBehavior(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);

    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {

        return ViewCompat.SCROLL_AXIS_VERTICAL == axes;

    }



    private boolean isOut = false;

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);

            if (dyConsumed > 0){

                if (!isOut){

                    //向上滑动  隐藏
                    int translationY = ((CoordinatorLayout.LayoutParams)child.getLayoutParams()).bottomMargin + child.getMeasuredHeight();
                    child.animate().translationY(translationY).setDuration(300).start();
                    isOut = true;
                }



            }else {
                //向下滑动


                if (isOut){

                    child.animate().translationY(0).setDuration(300).start();
                    isOut = false;
                }
            }


    }




}
