package com.argon.android.apps.manutdtube.card;

import it.gmariotti.cardslib.library.internal.Card;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.argon.android.apps.manutube.R;

public class CompactVideoCard extends Card {

	public CompactVideoCard(Context context) {
		super(context, R.layout.compact_video_card_inner_content);
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		TextView durationTv = (TextView) parent.findViewById(R.id.duration);
		durationTv.setText("8:57");

		TextView titleTv = (TextView) parent.findViewById(R.id.title);
		titleTv.setText("TEENS REACT TO NINTENDO (NES)");

		TextView authorTv = (TextView) parent.findViewById(R.id.author);
		authorTv.setText("TheFineBros");

		TextView detailsTv = (TextView) parent.findViewById(R.id.details);
		detailsTv.setText("1 day ago ¡¤ 3,600,951 views");

		ImageView contextIv = (ImageView) parent
				.findViewById(R.id.contextual_menu_anchor);
		contextIv.setVisibility(View.VISIBLE);
		contextIv.setOnClickListener(new OnClickListener() {

			@SuppressLint("InflateParams")
			@Override
			public void onClick(View v) {

			}

		});

	}
}
