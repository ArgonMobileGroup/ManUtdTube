package com.argon.android.apps.manutdtube.contextual;

import com.argon.android.apps.manutube.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * An extended ArrayAdapter that is backed by an array of String.
 * 
 * @author Luxi Liu(luxi.liu@gmail.com)
 *
 */
public class ContextualMenuAdapter extends ArrayAdapter<String> {
	private ViewHolder mViewHolder;

	public ContextualMenuAdapter(Context context, String[] titles) {
		super(context, 0, titles);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			// Inflate the view
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(
					R.layout.compact_video_card_contextual_menu_item_layout,
					new LinearLayout(getContext()));

			// Always cache the view into ViewHolder for performance
			mViewHolder = new ViewHolder();
			mViewHolder.mTitleTv = (TextView) convertView
					.findViewById(R.id.title);

			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		// Set the title
		String title = getItem(position);
		mViewHolder.mTitleTv.setText(title);

		return convertView;
	}

	private static class ViewHolder {
		TextView mTitleTv;
	}
}
