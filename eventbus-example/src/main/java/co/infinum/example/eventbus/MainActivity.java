package co.infinum.example.eventbus;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.infinum.example.eventbus.fragments.BlueFragment;
import co.infinum.example.eventbus.fragments.GreenFragment;
import co.infinum.example.eventbus.fragments.RedFragment;

public class MainActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, new RedFragment());
            ft.commit();
        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        if (mNavigationDrawerFragment != null && mNavigationDrawerFragment.getAdapter() != null) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            int titleResId = (int) mNavigationDrawerFragment.getAdapter().getItem(position);

            switch (titleResId) {
                case R.string.red_fragment:
                    ft.replace(R.id.container, new RedFragment());
                    break;
                case R.string.green_fragment:
                    ft.replace(R.id.container, new GreenFragment());
                    break;
                case R.string.blue_fragment:
                    ft.replace(R.id.container, new BlueFragment());
                    break;
            }

            ft.commit();
        }
    }

    public void onSectionAttached(int number) {
        if (mNavigationDrawerFragment != null && mNavigationDrawerFragment.getAdapter() != null) {
            mTitle = getString((Integer) mNavigationDrawerFragment.getAdapter().getItem(number));
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
//            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

}
