package com.argon.android.apps.manutdtube.navigation;

import com.argon.android.apps.manutube.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * An extension to RelativeLayout that implements Checkable interface to change
 * appearance when checked or unchecked
 * 
 * @author Luxi Liu (luxi.liu@gmail.com)
 * 
 */
class NavigationDrawerCheckableRelativeLayout extends RelativeLayout implements
		Checkable {

	private boolean mChecked = false;

	public NavigationDrawerCheckableRelativeLayout(Context context) {
		super(context);
	}

	public NavigationDrawerCheckableRelativeLayout(Context context,
			AttributeSet attrs) {
		super(context, attrs);
	}

	public NavigationDrawerCheckableRelativeLayout(Context context,
			AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void setChecked(boolean checked) {
		mChecked = checked;

		if (checked) {
			setBackgroundResource(R.color.navigation_drawer_primary_entry_selected);
		} else {
			setBackgroundResource(android.R.color.transparent);
		}
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public void toggle() {
		mChecked = !mChecked;

		setChecked(mChecked);
	}
}
