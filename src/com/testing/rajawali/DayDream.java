package com.testing.rajawali;

import rajawali.RajawaliDaydream;
import rajawali.renderer.RajawaliRenderer;
import android.annotation.TargetApi;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class DayDream extends RajawaliDaydream {

	@Override
	protected RajawaliRenderer createRenderer() {
		return new MyRenderer(this);
	}


}
