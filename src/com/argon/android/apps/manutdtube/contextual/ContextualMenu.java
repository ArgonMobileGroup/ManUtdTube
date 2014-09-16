package com.argon.android.apps.manutdtube.contextual;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.argon.android.apps.manutube.R;

/**
 * A ContextualMenu displays a Menu in a modal popup window. It's always used
 * with CompactVideoCard
 * 
 * @author Luxi Liu(luxi.liu@gmail.com)
 *
 */
public class ContextualMenu extends ListPopupWindow {
	private Context mContext;
	private OnItemClickListener mListener;

	public ContextualMenu(Context context) {
		super(context);

		mContext = context;

		initView();
	}

	@Override
	public void show() {
		// Show it first in order to create a ListView
		super.show();

		// Then customize the ListView
		ListView listView = getListView();
		listView.setBackgroundResource(R.color.compact_video_card_contextual_menu_background);
		listView.setVerticalScrollBarEnabled(false);
		listView.setHorizontalScrollBarEnabled(false);
		listView.setCacheColorHint(mContext.getResources().getColor(
				R.color.compact_video_card_contextual_menu_background));
	}

	@Override
	public void setOnItemClickListener(OnItemClickListener clickListener) {
		mListener = clickListener;
	}

	private void initView() {
		setWidth(mContext.getResources().getDimensionPixelSize(
				R.dimen.compact_video_card_contextual_menu_width));
		setHeight(ListPopupWindow.WRAP_CONTENT);

		setBackgroundDrawable(mContext.getResources().getDrawable(
				R.drawable.compact_video_card_contextual_menu_background));

		setHorizontalOffset(mContext.getResources().getDimensionPixelSize(
				R.dimen.compact_video_card_contextual_menu_horizontal_offset));
		setVerticalOffset(mContext.getResources().getDimensionPixelSize(
				R.dimen.compact_video_card_contextual_menu_vertical_offset));

		setModal(true);

		super.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				dismiss();

				if (mListener != null) {
					mListener.onItemClick(parent, view, position, id);
				}
			}

		});
	}
}
