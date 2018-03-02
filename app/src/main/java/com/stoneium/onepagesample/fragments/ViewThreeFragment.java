package com.stoneium.onepagesample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.stoneium.onepagesample.R;
import com.stoneium.onepagesample.navigation.INavigationController;
import com.stoneium.onepagesample.navigation.TransitionType;
import com.stoneium.onepagesample.utilities.ILogger;

/**
 * The third view.
 * Created by Michael Leighton on 3/2/18.
 */

public class ViewThreeFragment extends Fragment {

    /**
     * Hold the navigation controller.
     */
    private INavigationController _navigationController;

    /***
     * Hold the application logger.
     */
    private ILogger _logger;

    /***
     * Create the new view.
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewthree, container, false);

        // Get the next button.
        Button next = (Button) view.findViewById(R.id.backButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _navigationController.transitionToView("viewOne", null, TransitionType.Right);
            }
        });

        return view;
    }

    /***
     * Called when the fragment is resumed.
     */
    @Override
    public void onResume() {
        super.onResume();
        _logger.debug("ViewThreeFragment->onResume");
    }

    /***
     * Called when the fragment is paused.
     */
    @Override
    public void onPause() {
        super.onPause();
        _logger.debug("ViewThreeFragment->onPause");
    }

    /***
     * Initialize the fragment.
     *
     * @param navigationController The navigation controller.
     * @param logger               The application logger.
     */
    public void Init(INavigationController navigationController, ILogger logger) {
        _navigationController = navigationController;
        _logger = logger;
    }
}
