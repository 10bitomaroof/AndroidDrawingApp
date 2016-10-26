package com.example.omer.androiddrawingapplication;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Omer on 10/3/2016.
 */

public class CustomImageView extends View {

    float dX, dY;

    public CustomImageView(Context context){
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)  {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                dX = this.getX() - event.getRawX();
                dY = this.getY() - event.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:

                this.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            default:
                return false;
        }
        return true;
    }
}
