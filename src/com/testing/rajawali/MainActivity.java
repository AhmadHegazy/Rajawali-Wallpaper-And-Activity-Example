package com.testing.rajawali;

import rajawali.RajawaliFragmentActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends RajawaliFragmentActivity implements
		OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final MyRenderer renderer = new MyRenderer(this);
		renderer.setSurfaceView(mSurfaceView);
		setRenderer(renderer);

		final LinearLayout mLinearLayout = new LinearLayout(
				getApplicationContext());
		mLinearLayout.setGravity(Gravity.BOTTOM);

		Button mButton = new Button(this);
		mButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		mButton.setText("Change Settings");
		mButton.setOnClickListener(this);
		mLinearLayout.addView(mButton);

		addContentView(mLinearLayout, new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	@Override
	public void onClick(View v) {
		final Intent intent = new Intent(this,
				WallpaperPreferencesActivity.class);
		startActivity(intent);
	}

}