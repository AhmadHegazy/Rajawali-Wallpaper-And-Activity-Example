package com.testing.rajawali;

import rajawali.RajawaliFragmentActivity;
import android.os.Bundle;

public class MainActivity extends RajawaliFragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final MyRenderer renderer = new MyRenderer(this);
		renderer.setSurfaceView(mSurfaceView);
		setRenderer(renderer);
	}
	
}
