package com.stoneium.onepagesample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.stoneium.onepagesample.navigation.IMasterView;
import com.stoneium.onepagesample.navigation.IStateView;
import com.stoneium.onepagesample.navigation.TransitionType;
import com.stoneium.onepagesample.utilities.ILogger;

/***
 * The main activity of the application.
 * Created by Michael Leighton on 3/2/2018.
 */
public class MainActivity extends AppCompatActivity implements IMasterView {

    /***
     * The system logger.
     */
    protected ILogger _logger;

    /***
     * The current fragment being displayed on the screen.
     */
    private Fragment _currentFragment;

    /***
     * Create the main activity.
     *
     * @param savedInstanceState Not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

        // Inject members.
        Injector injector = OnePageSampleApplication.getInjector();
        _logger = injector.getLogger();

        injector.setMasterView(this);
    }

    /***
     * Transition to a given view.
     *
     * @param tag            The tag that represents the fragment.
     * @param view           The view to transition to.
     * @param transitionType The type of transition to use.
     * @param state          A state object that can be passed to the view.
     */
    @Override
    public void transitionToView(String tag, Object view, TransitionType transitionType,
                                 Object state) {

        // We wont transition if the view is not active.
        _logger.debug("MainActivity: transitionToView - %s", tag);

        // If the view is already set then lets do nothing.
        if (_currentFragment == view) {
            return;
        }

        // Get the fragment manager and transaction object.
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (transitionType != null) {
            setTransitionType(fragmentTransaction, transitionType);
        }

        // Remove the current fragment if needed.
        if (_currentFragment != null) {
            fragmentTransaction.remove(_currentFragment);
        } else {
            Fragment fragment = fragmentManager.findFragmentByTag(tag);
            if (fragment != null) {
                fragmentTransaction.remove(fragment);
            }
        }

        // Add the new fragment.
        fragmentTransaction.add(R.id.fragmentContainer, (Fragment) view, tag);
        fragmentTransaction.commit();
        _currentFragment = (Fragment) view;

        if (_currentFragment instanceof IStateView) {
            ((IStateView) _currentFragment).setState(state);
        }
    }

    /***
     * Set the transition type.
     *
     * @param transaction    The fragment transition.
     * @param transitionType The transition type.
     */
    private void setTransitionType(FragmentTransaction transaction,
                                   TransitionType transitionType) {
        switch (transitionType) {
            case None:
                break;
            case Left:
                transaction.setCustomAnimations(R.animator.slide_in_right,
                        R.animator.slide_out_left);
                break;
            case Right:
                transaction.setCustomAnimations(R.animator.slide_in_left,
                        R.animator.slide_out_right);
                break;
            case Up:
                transaction.setCustomAnimations(R.animator.slide_in_bottom,
                        R.animator.slide_out_top);
                break;
            case Down:
                transaction.setCustomAnimations(R.animator.slide_out_bottom,
                        R.animator.slide_in_top);
                break;
            default:
                break;
        }
    }
}
