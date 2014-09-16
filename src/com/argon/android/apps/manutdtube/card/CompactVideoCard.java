package com.argon.android.apps.manutdtube.card;

import it.gmariotti.cardslib.library.internal.Card;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.argon.android.apps.manutdtube.contextual.ContextualMenu;
import com.argon.android.apps.manutube.R;

public class CompactVideoCard extends Card {
	private ContextualMenu mContextualMenu;
	private ImageView mAnchor;

	public CompactVideoCard(Context context) {
		super(context, R.layout.compact_video_card_inner_content);
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		// Get view elements
		TextView durationTv = (TextView) parent.findViewById(R.id.duration);

		TextView titleTv = (TextView) parent.findViewById(R.id.title);

		TextView authorTv = (TextView) parent.findViewById(R.id.author);

		TextView detailsTv = (TextView) parent.findViewById(R.id.details);

		mAnchor = (ImageView) parent.findViewById(R.id.contextual_menu_anchor);

		// Add ContextualMenu if available
		addContextualMenu(mContextualMenu, mAnchor);

		/**
		 * TEST CODE BELOW
		 */
		durationTv.setText("8:57");
		titleTv.setText("TEENS REACT TO NINTENDO (NES)");
		authorTv.setText("TheFineBros");
		detailsTv.setText("1 day ago · 3,600,951 views");
	}

	public void setContextualMenu(ContextualMenu contextualMenu) {
		mContextualMenu = contextualMenu;

		addContextualMenu(mContextualMenu, mAnchor);
	}

	private void addContextualMenu(final ContextualMenu contextualMenu,
			View anchor) {
		if (contextualMenu != null && anchor != null) {
			contextualMenu.setAnchorView(anchor);

			anchor.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					contextualMenu.show();
				}
			});

			anchor.setVisibility(View.VISIBLE);
		}
	}
}
