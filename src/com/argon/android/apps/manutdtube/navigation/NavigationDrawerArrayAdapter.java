package com.argon.android.apps.manutdtube.navigation;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * A concrete ArrayAdapter that is backed by an list of navigation drawer entry
 * 
 * @author Luxi Liu (luxi.liu@gmail.com)
 * 
 */
class NavigationDrawerArrayAdapter extends ArrayAdapter<NavigationDrawerEntry> {

	public NavigationDrawerArrayAdapter(Context context, int resource,
			List<NavigationDrawerEntry> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getItem(position).getView(convertView, parent);
	}
}
