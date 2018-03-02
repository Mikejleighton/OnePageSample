package com.stoneium.onepagesample.navigation;

/**
 * The different types of transitions supported by the navigation system.
 * Created by Michael Leighton on 11/18/15.
 */
public enum TransitionType {

    /***
     * No transitions.
     */
    None,

    /***
     * Move the current fragment off the top of the screen and the new
     * fragment will transition in from the bottom.
     */
    Up,

    /***
     * Move the current fragment off the bottom of the screen and the
     * new fragment will transition in from the top.
     */
    Down,

    /***
     * Move the current fragment off the left of the screen and the
     * new fragment will transition in from the right.
     */
    Left,

    /***
     * Move the current fragment off the right of the screen and the
     * new fragment will transition in from the left.
     */
    Right
}
