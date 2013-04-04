package com.testing.rajawali;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class UserPrefs {

	private static final String PREF_BOX_COLOR = "prefBoxColor";

	private static UserPrefs mUserPrefs;

	private SharedPreferences mSharedPrefs;

	private UserPrefs(final Context context) {
		mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		init();
	}

	public static final UserPrefs getInstance(final Context context) {
		if (mUserPrefs == null)
			mUserPrefs = new UserPrefs(context);

		return mUserPrefs;
	}

	public int getBoxColor() {
		return Integer.parseInt(mSharedPrefs.getString(PREF_BOX_COLOR,
				"16777215"));
	}

	public void setBoxColor(int color) {
		mSharedPrefs.edit().putString(PREF_BOX_COLOR, String.valueOf(color))
				.commit();
	}

	/**
	 * Good time to verify any data. In this instance I just want to see the
	 * default value for the box color. This is not really necessary I just
	 * wanted to have an example.
	 */
	private final void init() {
		final Editor editor = mSharedPrefs.edit();

		// This could easily be done in the preferences XML
		if (!mSharedPrefs.contains(PREF_BOX_COLOR)) {
			// White is default (aaffffff)
			editor.putString(PREF_BOX_COLOR, "16777215");
		}

		editor.commit();
	}

}