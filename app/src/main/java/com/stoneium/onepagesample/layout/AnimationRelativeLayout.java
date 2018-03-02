package com.stoneium.onepagesample.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Michael Leighton on 11/18/15.
 * Relative layout that will support transitions on/off the screen.
 */
public class AnimationRelativeLayout extends RelativeLayout {


    /***
     * Constructors for the layout.
     */
    public AnimationRelativeLayout(Context context) {
        super(context);
    }

    public AnimationRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimationRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /***
     * Get the x location as a fraction of the width of the layout.
     *
     * @return The x location as a fraction.
     */
    public float getXFraction() {

        // Calculate and return the x fraction.
        float x = getX();
        if (x == 0) {
            return 0;
        }
        float width = getWidth();
        return x / width;
    }

    /***
     * Set the x location as a fraction of the width.
     *
     * @param xFraction The x fraction.
     */
    public void setXFraction(float xFraction) {
        final int width = getWidth();
        setX((width > 0) ? (xFraction * width) : -9999);
    }

    /***
     * Get the y location as a fraction of the height of the layout.
     *
     * @return The y location as a fraction.
     */
    public float getYFraction() {

        // Calculate and return the y fraction.
        float y = getY();
        if (y == 0) {
            return 0;
        }
        float height = getHeight();
        return y / height;
    }

    /***
     * Set the y location as a fraction of the height.
     *
     * @param yFraction The y fraction.
     */
    public void setYFraction(float yFraction) {
        final int height = getHeight();
        setY((height > 0) ? (yFraction * height) : -9999);
    }
}
