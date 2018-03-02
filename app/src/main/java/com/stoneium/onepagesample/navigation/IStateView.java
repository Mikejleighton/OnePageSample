package com.stoneium.onepagesample.navigation;

/**
 * Used to pass state information to views.
 * Created by Michael Leighton on 9/29/16.
 */
public interface IStateView {

    /***
     * Set the state of the given view.
     *
     * @param state The new state.
     */
    void setState(Object state);
}
