package com.stoneium.onepagesample.navigation;

/**
 * Interface that controls navigation throughout the application.
 * Created by Michael Leighton on 8/16/15.
 */
public interface INavigationController {

    /***
     * Add a view to the controller.
     *
     * @param name The name of the view.
     * @param view The view to add.
     */
    void addView(String name, Object view);

    /***
     * Set the master view of the navigation controller.
     *
     * @param view The master view.
     */
    void setMasterView(IMasterView view);

    /***
     * Transition to a given view.
     *
     * @param name           The name of the view to transition to.
     * @param state          A state object that can be passed to the view.
     * @param transitionType The type of transition to use.
     */
    void transitionToView(String name, Object state, TransitionType transitionType);
}
