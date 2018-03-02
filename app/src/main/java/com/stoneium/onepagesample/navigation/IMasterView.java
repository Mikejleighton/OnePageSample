package com.stoneium.onepagesample.navigation;

/**
 * View that can display other views.
 * Create by Michael Leighton on 8/16/15.
 */
public interface IMasterView {

    /***
     * Transition to a given view.
     *
     * @param tag            The view tag.
     * @param view           The view to transition to.
     * @param transitionType The type of transition to use.
     * @param state          A state object that can be passed to the view.
     */
    void transitionToView(String tag, Object view, TransitionType transitionType,
                          Object state);
}
