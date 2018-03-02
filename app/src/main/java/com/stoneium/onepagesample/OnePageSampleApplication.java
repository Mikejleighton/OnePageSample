package com.stoneium.onepagesample;

import android.app.Application;

import com.stoneium.onepagesample.navigation.TransitionType;

/**
 * Entry point for the the application.
 * Created by Michael Leighton on 3/2/18.
 */

public class OnePageSampleApplication extends Application {

    /***
     * Hold the injector.
     */
    private static Injector _injector;

    /***
     * Get the injector.
     *
     * @return The injector.
     */
    public static Injector getInjector() {
        return _injector;
    }

    /***
     * Called when the application is first created.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        _injector = new Injector();

        // Set the initial view.
        _injector.getNavigation().transitionToView("viewOne", null, TransitionType.Down);
    }
}
