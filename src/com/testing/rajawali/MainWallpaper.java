package com.testing.rajawali;

import android.preference.PreferenceManager;
import rajawali.wallpaper.Wallpaper;

public class MainWallpaper extends Wallpaper {

	@Override
	public Engine onCreateEngine() {
		return new WallpaperEngine(
				PreferenceManager
						.getDefaultSharedPreferences(getApplicationContext()),
				getApplicationContext(),
				new MyRenderer(getApplicationContext()));
	}

}
