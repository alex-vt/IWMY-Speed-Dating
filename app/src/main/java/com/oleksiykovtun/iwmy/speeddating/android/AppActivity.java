package com.oleksiykovtun.iwmy.speeddating.android;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.oleksiykovtun.android.cooltools.CoolFragmentManager;
import com.oleksiykovtun.iwmy.speeddating.R;
import com.oleksiykovtun.iwmy.speeddating.android.fragments.StartFragment;
import io.fabric.sdk.android.Fabric;

/**
 * The only activity in the app
 */
public class AppActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity);

        CoolFragmentManager.setup(this, R.id.fragment_holder);

        CoolFragmentManager.switchToFragment(new StartFragment()); // show the first fragment
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // pop the top fragment from the stack
        if (! CoolFragmentManager.areAnyOlderFragments()) {
            // If there are no fragments in the stack to show, go back from the activity itself
            super.onBackPressed();
        }
    }

}
