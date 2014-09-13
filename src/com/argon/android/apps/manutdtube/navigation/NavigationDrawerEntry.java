package com.argon.android.apps.manutdtube.navigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * The base class of a navigation drawer entry. A drawer entry has a thumbnail
 * and a title
 * 
 * @author Luxi Liu (luxi.liu@gmail.com)
 * 
 */
abstract class NavigationDrawerEntry {
	private Context mContext;
	private String mTitle;
	private Drawable mThumbnail;

	public NavigationDrawerEntry(Context context, String title,
			Drawable thumbnail) {
		mContext = context;
		mTitle = title;
		mThumbnail = thumbnail;
	}

	protected final Context getContext() {
		return mContext;
	}

	protected final String getTitle() {
		return mTitle;
	}

	protected final Drawable getThumbnail() {
		return mThumbnail;
	}

	public abstract View getView(View convertView, ViewGroup parent);
}
