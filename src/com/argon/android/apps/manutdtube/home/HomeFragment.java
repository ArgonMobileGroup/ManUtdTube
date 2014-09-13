package com.argon.android.apps.manutdtube.home;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

import com.argon.android.apps.manutdtube.card.CompactVideoCard;
import com.argon.android.apps.manutube.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Context context = inflater.getContext();

		// Inflate main view
		View view = inflater.inflate(R.layout.home_fragment, null);

		// Get card list view
		CardListView cardListView = (CardListView) view
				.findViewById(R.id.compact_video_card_list);

		// Create card array adapter & set to card list view
		List<Card> cardList = new ArrayList<Card>();
		for (int i = 0; i < 20; i++) {
			CompactVideoCard card = new CompactVideoCard(context);
			card.setOnClickListener(new OnCardClickListener() {

				@Override
				public void onClick(Card arg0, View arg1) {

				}

			});
			cardList.add(card);
		}
		CardArrayAdapter adapter = new CardArrayAdapter(context, cardList);
		cardListView.setAdapter(adapter);

		return view;
	}
}
