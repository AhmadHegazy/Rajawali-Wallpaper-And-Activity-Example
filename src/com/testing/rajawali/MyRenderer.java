package com.testing.rajawali;

import rajawali.materials.SimpleMaterial;
import rajawali.primitives.Plane;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;
import android.graphics.BitmapFactory;

public final class MyRenderer extends RajawaliRenderer {

	public MyRenderer(Context context) {
		super(context);
	}

	@Override
	protected void initScene() {
		final SimpleMaterial material = new SimpleMaterial();
		material.setUseColor(true);

		final Plane mPlane = new Plane(1, 1, 1, 1, 1);
		mPlane.setMaterial(material);
		mPlane.setTransparent(true);
		mPlane.setColor(0xaaffffff);
		mPlane.setX(-0.25f);
		addChild(mPlane);

		final Plane mPlane2 = new Plane(1, 1, 1, 1, 1);
		mPlane2.setMaterial(material);
		mPlane2.setManageMaterial(false);
		mPlane2.setTransparent(true);
		mPlane2.setColor(0xaaff1111);
		mPlane2.setZ(0.1f);
		mPlane2.setX(0.25f);
		addChild(mPlane2);

		final MyMaterial material2 = new MyMaterial();
		material2.addTexture(mTextureManager.addTexture(BitmapFactory
				.decodeResource(mContext.getResources(), R.drawable.ic_launcher)));

		final Plane mPlane3 = new Plane(1, 1, 1, 1, 1);
		mPlane3.setMaterial(material2);
		mPlane3.setColor(0xaaffffff);
		mPlane3.setTransparent(true);
		mPlane3.setY(0.25f);
		mPlane3.setRotZ(-90);
		addChild(mPlane3);
	}
	
	public static final class MyMaterial extends SimpleMaterial {		
		protected static final String mFShader = 
			"precision mediump float;\n" +

			"varying vec2 vTextureCoord;\n" +
			"uniform sampler2D uDiffuseTexture;\n" +
			"varying vec4 vColor;\n" +

			"void main() {\n" +
			"	gl_FragColor = texture2D(uDiffuseTexture, vTextureCoord) * vColor;\n" +
			"}\n";
		
		public MyMaterial() {
			super(mVShader, mFShader);
		}
	}
} 
