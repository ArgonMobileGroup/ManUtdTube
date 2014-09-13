package com.argon.android.apps.manutdtube.widget;

import com.argon.android.apps.manutube.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MUTubeTextView extends TextView {
	private static final String REGULAR_TYPEFACE_FILE = "fonts/Roboto-Regular.ttf";
	private static final String LIGHT_TYPEFACE_FILE = "fonts/Roboto-Light.ttf";

	public MUTubeTextView(Context context) {
		super(context);

		initView(context, null, 0);
	}

	public MUTubeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		initView(context, attrs, 0);
	}

	public MUTubeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		initView(context, attrs, defStyle);
	}

	private void initView(Context context, AttributeSet attrs, int defStyle) {
		if (attrs != null) {
			// Get robotoFont attribute value
			TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
					R.styleable.MUTubeTextView, 0, 0);
			int typefaceId = array.getInteger(
					R.styleable.MUTubeTextView_robotoFont, -1);

			// Set corresponding typeface
			Typeface typeface;
			switch (typefaceId) {
			case -1:
				break;

			case 0:
				typeface = Typeface.createFromAsset(getContext().getAssets(),
						LIGHT_TYPEFACE_FILE);
				setTypeface(typeface, defStyle);
				break;

			case 1:
				typeface = Typeface.createFromAsset(getContext().getAssets(),
						REGULAR_TYPEFACE_FILE);
				setTypeface(typeface, defStyle);
				break;
			}
		}
	}

}
