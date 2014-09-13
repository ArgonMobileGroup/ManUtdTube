package com.argon.android.apps.manutdtube.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.argon.android.apps.manutube.R;

/**
 * The NavigationDrawerPrimaryEntry is primarily associated with a content
 * fragment
 * 
 * @author Luxi Liu (luxi.liu@gmail.com)
 * 
 */
class NavigationDrawerPrimaryEntry extends NavigationDrawerEntry {

	public NavigationDrawerPrimaryEntry(Context context, String title,
			Drawable drawable) {
		super(context, title, drawable);
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(View convertView, ViewGroup parent) {
		View view = null;

		if (convertView != null) {
			// Use existing view
			view = convertView;
		} else {
			// Inflate a new view
			view = LayoutInflater.from(getContext()).inflate(
					R.layout.navigation_drawer_primary_entry, null);
		}

		// Set thumbnail
		ImageView thumbnailImageView = (ImageView) view
				.findViewById(R.id.thumbnail);
		thumbnailImageView.setImageDrawable(getThumbnail());

		// Set drawer entry text
		TextView titleTextView = (TextView) view.findViewById(R.id.title);
		titleTextView.setText(getTitle());

		return view;
	}
}
