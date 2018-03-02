package com.stoneium.onepagesample.navigation;

import com.stoneium.onepagesample.utilities.ILogger;

import java.util.HashMap;

/**
 * Class that controls navigation in the application.
 * Created by Michael Leighton on 11/17/15.
 */
public class NavigationController implements INavigationController {

    /***
     * Hold all registered views.
     */
    private HashMap<String, Object> _views;

    /***
     * Create the master view.
     */
    private IMasterView _masterView;

    /***
     * Class that is used for logging throughout the application.
     */
    private ILogger _logger;

    /***
     * Get the current view.
     */
    private String _currentView;

    /***
     * The type of transition to use.
     */
    private TransitionType _transitionType;

    /***
     * Create the navigation controller.
     *
     * @param logger The logger that is used for logging messages.
     */
    public NavigationController(ILogger logger) {
        _logger = logger;
        _views = new HashMap<>();
        _currentView = null;
    }

    /***
     * Set the master view of the navigation controller.
     *
     * @param view The master view.
     */
    public void setMasterView(IMasterView view) {
        _masterView = view;
        if (_masterView == null) {
            _logger.debug("Master view has been set to null");
            return;
        }

        // Check to see if the view has already been set.
        if (_currentView != null) {
            _masterView.transitionToView(_currentView, _views.get(_currentView),
                    _transitionType, null);
        }
    }

    /***
     * Add a view to the controller.
     *
     * @param name The name of the view.
     * @param view The view to add.
     */
    public void addView(String name, Object view) {
        if (_views.containsKey(name)) {
            _views.remove(name);
        }
        _views.put(name, view);
    }

    /***
     * Transition to a given view.
     *
     * @param name           The name of the view to transition to.
     * @param state          A state object that can be passed to the view.
     * @param transitionType The type of transition to use.
     */
    public void transitionToView(String name, Object state, TransitionType transitionType) {
        _currentView = name;
        if (!_views.containsKey(name)) {
            _logger.debug("NavigationController:" +
                    " Could not change to view. Name was not found.");
            return;
        }

        if (_masterView == null) {
            _logger.debug("NavigationController: " +
                    "Could not change to view. Master view not found.");
            return;
        }

        _transitionType = transitionType;
        _logger.debug(String.format("Transition to: %s", name));
        _masterView.transitionToView(name, _views.get(name), transitionType, state);
    }

}