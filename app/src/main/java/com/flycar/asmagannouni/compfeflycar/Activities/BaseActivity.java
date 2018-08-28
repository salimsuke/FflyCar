package com.flycar.asmagannouni.compfeflycar.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.flycar.asmagannouni.compfeflycar.R;
import com.flycar.asmagannouni.compfeflycar.Utilities.LogUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Salim Fg on 11/04/2018.
 * {@link BaseActivity}
 */

/*
* Base activity for all other activities created in application
* This activity contents most common feature used by every activity.
* Like common toolbar, loading indicator, back button handling, bind views
* */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setupToolbar();
        bindViews();
        initView();
        progressDialog = new ProgressDialog(this);
    }


    /**
     * Use this method to initialize view components. This method is called after {@link
     * BaseActivity#bindViews()}
     */
    public void initView() {
    }

    /**
     * Its common use a toolbar within activity, if it exists in the
     * layout this will be configured
     */
    public void setupToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * Every object annotated with {@link butterknife} its gonna injected trough butterknife
     */
    private void bindViews() {
        ButterKnife.bind(this);
    }

    @Nullable
    public Toolbar getToolbar() {
        return mToolbar;
    }

    /**
     * @return The layout id that's gonna be the activity view.
     */
    protected abstract int getLayoutId();

    /*
    * Show loading indicator on screen
    * */
    public void showLoading(String message) {
        hideLoading();
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    /*
    * Hide loading indicator from screen
    * */
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    /*
    * Open new fragment
    * */
    public void showFragment(int containerId, Fragment fragment) {
        String TAG = fragment.getClass().getSimpleName();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_right, R.anim.slide_left, R.anim.pop_right, R.anim.pop_left);
        fragmentTransaction.replace(containerId, fragment, TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    /*
    * Pop back stack when back button click or back navigation click from toolbar or any user event
    * */
    public void backStackFragment(int containerId) {
        LogUtils.d("**** Stack count", getSupportFragmentManager().getBackStackEntryCount() + "");
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
        getSupportFragmentManager().popBackStack();
        removeCurrentFragment(containerId);
    }

    /*
    * Remove current fragment from back stack once its closed by user
    * */
    private void removeCurrentFragment(int containerId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFrag = getSupportFragmentManager()
                .findFragmentById(containerId);
        if (currentFrag != null) {
            transaction.remove(currentFrag);
        }
        transaction.commitAllowingStateLoss();
    }

    /*
    * Enable back button on toolbar
    * */
    public void enableNavigationIcon() {
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /*
    * Disable back button from toolbar
    * */
    public void disableNavigationIcon() {
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    /*
    * Set toolbar title
    * */
    public void setToolbarTitle(int resID) {
        assert getToolbar() != null;
        getToolbar().setTitle(resID);
    }

    /*
    * Check if active screen has any open dialogs
    * */
    public static boolean hasOpenedDialogs(FragmentActivity activity) {
        List<Fragment> fragments = activity.getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof DialogFragment) {
                    ((DialogFragment) fragment).dismiss();
                    return true;
                }
            }
        }
        return false;
    }
}


