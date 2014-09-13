package com.argon.android.apps.manutdtube.home;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;

import com.argon.android.apps.manutdtube.navigation.NavigationDrawerFragment;
import com.argon.android.apps.manutube.R;

public class HomeActivity extends FragmentActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {
	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private int mNavigationEntryIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);

		// Set action bar
		getActionBar().setDisplayOptions(
				ActionBar.DISPLAY_USE_LOGO | ActionBar.DISPLAY_SHOW_HOME
						| ActionBar.DISPLAY_HOME_AS_UP
						| ActionBar.DISPLAY_SHOW_TITLE);

		// Get navigation drawer fragment
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setup(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

		// If the user hasn't 'learned' about the drawer, open it to introduce
		// them to the drawer,
		// per the navigation drawer design guidelines.
		boolean userLearnedDrawer = false;
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		userLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

		if (!userLearnedDrawer) {
			sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).commit();
			mNavigationDrawerFragment.openDrawer();
		}
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		mNavigationEntryIndex = position;

		FragmentManager fragmentManager = getSupportFragmentManager();
		HomeFragment homeFragment = (HomeFragment) fragmentManager
				.findFragmentById(R.id.container);

		if (homeFragment == null) {
			fragmentManager.beginTransaction()
					.add(R.id.container, new HomeFragment()).commit();
		} else if (!homeFragment.isAdded()) {
			fragmentManager.beginTransaction()
					.add(R.id.container, homeFragment).commit();
		}
	}

	@Override
	public void onNavigationDrawerOpened() {
		invalidateOptionsMenu();
	}

	@Override
	public void onNavigationDrawerClosed() {
		invalidateOptionsMenu();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (mNavigationDrawerFragment.isDrawerOpen()) {
			/**
			 * The drawer is open, set application's title
			 */
			getActionBar().setTitle(R.string.app_name);
		} else {
			ActionBar actionBar = getActionBar();

			switch (mNavigationEntryIndex) {
			case 0:
				actionBar.setTitle(R.string.what_to_watch_title);
				break;

			case 1:
				actionBar.setTitle(R.string.my_subscriptions_title);
				break;

			case 2:
				actionBar.setTitle(R.string.uploads_title);
				break;

			case 3:
				actionBar.setTitle(R.string.history_title);
				break;

			case 4:
				actionBar.setTitle(R.string.watch_later_title);
				break;
			}
		}

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onBackPressed() {
		if (mNavigationDrawerFragment.isDrawerOpen()) {
			// Close drawer when back button is clicked
			// PS: The drawer should close itself when back is clicked, but it's
			// not like this here
			// This is a workaround
			mNavigationDrawerFragment.closeDrawer();
		} else {
			super.onBackPressed();
		}
	}

}
