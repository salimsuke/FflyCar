package com.flycar.asmagannouni.compfeflycar.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.flycar.asmagannouni.compfeflycar.Fragments.LoginFragment;
import com.flycar.asmagannouni.compfeflycar.R;


/**
 * Created by Salim on 4/12/2018.
 */

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showFragment(R.id.sign_in_main_container, new LoginFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signin;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //goto back stack from current screen
                backStackFragment(R.id.sign_in_main_container);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //On back press if there is no more fragment on back stack exit from app
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }
}
