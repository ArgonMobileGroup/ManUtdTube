package com.argon.android.apps.manutdtube.navigation;

import java.util.ArrayList;

import com.argon.android.apps.manutube.R;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * This fragment is a simple navigation fragment for activity
 * 
 * @author Luxi Liu (luxi.liu@gmail.com)
 * 
 */
public class NavigationDrawerFragment extends Fragment {
	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	private DrawerLayout mDrawerLayout;
	private View mFragmentContainerView;
	private ListView mDrawerListView;
	private ActionBarDrawerToggle mDrawerToggle;

	private NavigationDrawerCallbacks mCallbacks;

	private int mCurrentSelectedPosition = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Enable option menu as to enable drawer toggle
		setHasOptionsMenu(true);

		// Get last selected item
		if (savedInstanceState != null) {
			mCurrentSelectedPosition = savedInstanceState
					.getInt(STATE_SELECTED_POSITION);
		}

		// Select either the default item (0) or the last selected item.
		selectItem(mCurrentSelectedPosition);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Context context = inflater.getContext();

		// Inflate drawer list view
		mDrawerListView = (ListView) inflater.inflate(
				R.layout.navigation_drawer_fragment, container, false);

		// Set on click listener
		mDrawerListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						selectItem(position);
					}
				});

		// Create drawer entry list
		ArrayList<NavigationDrawerEntry> entryList = new ArrayList<NavigationDrawerEntry>();

		// Add primary entries
		entryList.add(new NavigationDrawerPrimaryEntry(context,
				getString(R.string.what_to_watch_title), getResources()
						.getDrawable(R.drawable.ic_drawer_what_to_watch)));
		entryList.add(new NavigationDrawerPrimaryEntry(context,
				getString(R.string.my_subscriptions_title), getResources()
						.getDrawable(R.drawable.ic_drawer_subscriptions)));
		entryList.add(new NavigationDrawerPrimaryEntry(context,
				getString(R.string.uploads_title), getResources().getDrawable(
						R.drawable.ic_drawer_uploads)));
		entryList.add(new NavigationDrawerPrimaryEntry(context,
				getString(R.string.history_title), getResources().getDrawable(
						R.drawable.ic_drawer_watch_history)));
		entryList.add(new NavigationDrawerPrimaryEntry(context,
				getString(R.string.watch_later_title), getResources()
						.getDrawable(R.drawable.ic_drawer_watch_later)));

		// Create & set adapter
		NavigationDrawerArrayAdapter adapter = new NavigationDrawerArrayAdapter(
				inflater.getContext(), 0, entryList);
		mDrawerListView.setAdapter(adapter);

		// Set default checked item
		mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);

		return mDrawerListView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			// Set callback activity
			mCallbacks = (NavigationDrawerCallbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(
					"Activity must implement NavigationDrawerCallbacks.");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();

		// Remove callback activity
		mCallbacks = null;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Drawer toggle will handle "Home" option
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// Keep current selected position
		outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * Activity needs to call this function to initiate the navigation fragment
	 * to interact with activity
	 * 
	 * @param fragmentId
	 * @param drawerLayout
	 */
	public void setup(int fragmentId, DrawerLayout drawerLayout) {
		mFragmentContainerView = getActivity().findViewById(fragmentId);
		mDrawerLayout = drawerLayout;

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the navigation drawer and the action bar app icon.
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_action_bar_drawer, /*
										 * nav drawer image to replace 'Up'
										 * caret
										 */
		R.string.navigation_drawer_open, /*
										 * "open drawer" description for
										 * accessibility
										 */
		R.string.navigation_drawer_close /*
										 * "close drawer" description for
										 * accessibility
										 */
		) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);

				if (!isAdded()) {
					return;
				}

				// Notify activity the drawer has closed
				mCallbacks.onNavigationDrawerClosed();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!isAdded()) {
					return;
				}

				// Notify activity the drawer has opened;
				mCallbacks.onNavigationDrawerOpened();
			}
		};

		// Defer code dependent on restoration of previous instance state.
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});

		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	public boolean isDrawerVisible() {
		return mDrawerLayout != null
				&& mDrawerLayout.isDrawerVisible(mFragmentContainerView);
	}

	public void openDrawer() {
		if (mDrawerLayout != null) {
			mDrawerLayout.openDrawer(mFragmentContainerView);
		}
	}

	public void closeDrawer() {
		if (mDrawerLayout != null) {
			// Close drawer
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
	}

	private void selectItem(final int position) {
		if (mDrawerListView != null) {
			if (mDrawerListView.getAdapter().getItem(position) instanceof NavigationDrawerPrimaryEntry) {
				// A primary drawer entry is selected
				mCurrentSelectedPosition = position;
			} else {
				// A secondary drawer entry is selected, still remember last
				// selected primary drawer entry
			}
			mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
		}

		if (mDrawerLayout != null) {
			// Close drawer if a item is selected
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}

		if (mCallbacks != null) {
			mCallbacks.onNavigationDrawerItemSelected(position);
		}
	}

	/**
	 * Callbacks interface that all activities using this fragment must
	 * implement.
	 */
	public static interface NavigationDrawerCallbacks {
		/**
		 * Called when an item in the navigation drawer is selected.
		 */
		void onNavigationDrawerItemSelected(int position);

		/**
		 * Called when the drawer is opened.
		 */
		void onNavigationDrawerOpened();

		/**
		 * Called when the drawer is closed.
		 */
		void onNavigationDrawerClosed();
	}
}
