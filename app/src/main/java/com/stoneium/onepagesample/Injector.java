package com.stoneium.onepagesample;

import android.util.Log;

import com.stoneium.onepagesample.fragments.ViewOneFragment;
import com.stoneium.onepagesample.fragments.ViewThreeFragment;
import com.stoneium.onepagesample.fragments.ViewTwoFragment;
import com.stoneium.onepagesample.navigation.IMasterView;
import com.stoneium.onepagesample.navigation.INavigationController;
import com.stoneium.onepagesample.navigation.NavigationController;
import com.stoneium.onepagesample.utilities.ILogger;

/**
 * Created by Michael Leighton on 1/24/18.
 * Class that is used to inject the application.
 */

public class Injector {

    /***
     * Hold the logger.
     */
    private ILogger _logger;

    /***
     * Hold the navigation controller.
     */
    private INavigationController _navigation;

    /***
     * Create the new injector.
     */
    public Injector() {
        initialize();
        initializeViews();
    }

    /***
     * Get the navigation controller.
     *
     * @return The navigation controller.
     */
    public INavigationController getNavigation() {
        return _navigation;
    }

    /***
     * Get the current logger.
     *
     * @return The logger.
     */
    public ILogger getLogger() {
        return _logger;
    }

    /***
     * Set the master view.
     *
     * @param masterView The master view.
     */
    public void setMasterView(IMasterView masterView) {
        _navigation.setMasterView(masterView);
    }


    /***
     * Initialize the injector.
     */
    private void initialize() {

        // Create the logger.
        _logger = new ILogger() {
            @Override
            public void debug(String format, Object... params) {
                final String TAG = "PixelBeam";
                Log.d(TAG, String.format(format, params));
            }

            @Override
            public void error(String format, Object... params) {
                final String TAG = "PixelBeam";
                Log.e(TAG, String.format(format, params));
            }
        };

        // Create the navigation controller.
        _navigation = new NavigationController(_logger);
    }

    /***
     * Initialize application views.
     */
    private void initializeViews() {

        ViewOneFragment viewOne = new ViewOneFragment();
        viewOne.Init(_navigation, _logger);

        ViewTwoFragment viewTwo = new ViewTwoFragment();
        viewTwo.Init(_navigation, _logger);

        ViewThreeFragment viewThree = new ViewThreeFragment();
        viewThree.Init(_navigation, _logger);

        _navigation.addView("viewOne", viewOne);
        _navigation.addView("viewTwo", viewTwo);
        _navigation.addView("viewThree", viewThree);
    }
}
