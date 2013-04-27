package com.testing.rajawali;

import javax.microedition.khronos.opengles.GL10;

import rajawali.animation.Animation3D;
import rajawali.animation.Animation3D.RepeatMode;
import rajawali.animation.ColorAnimation3D;
import rajawali.materials.SimpleMaterial;
import rajawali.materials.TextureManager.TextureType;
import rajawali.math.Number3D;
import rajawali.primitives.Plane;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;

public final class MyRenderer extends RajawaliRenderer {

	private static final int SIMPLE_VERTEX_MATERIAL = com.monyetmabuk.livewallpapers.photosdof.R.raw.simple_material_vertex;

	private UserPrefs mUserPrefs;
	private Plane mPlaneLeft;

	public MyRenderer(Context context) {
		super(context);

		// Application context so that we do not keep a reference to a service
		// that might not be needed any longer such as the preview.
		mUserPrefs = UserPrefs.getInstance(context.getApplicationContext());
	}

	@Override
	protected void initScene() {
		setFrameRate(60);

		final MySimpleMaterial material = new MySimpleMaterial();
		material.setUseColor(true);

		mPlaneLeft = new Plane(1, 1, 1, 1);
		mPlaneLeft.setMaterial(material);
		mPlaneLeft.setTransparent(true);
		mPlaneLeft.setColor(0xffffff);
		mPlaneLeft.setX(-0.25f);
		addChild(mPlaneLeft);

		final MySimpleMaterial material2 = new MySimpleMaterial();
		material2.setUseColor(true);

		final Plane mPlaneRight = new Plane(1, 1, 1, 1);
		mPlaneRight.setMaterial(material2);
		mPlaneRight.setTransparent(true);
		mPlaneRight.setColor(0xaaff1111);
		mPlaneRight.setZ(0.1f);
		mPlaneRight.setX(0.25f);
		addChild(mPlaneRight);

		final Number3D toPosition = new Number3D(mPlaneRight.getPosition());
		toPosition.x = 2f;
		
		final Animation3D mAnimRightPlane;
		mAnimRightPlane = new ColorAnimation3D(0xaaff1111, 0xaaffff11);
		mAnimRightPlane.setDelay(1000);
		mAnimRightPlane.setTransformable3D(mPlaneRight);
		mAnimRightPlane.setDuration(2000);
		mAnimRightPlane.setRepeatMode(RepeatMode.REVERSE_INFINITE);
		registerAnimation(mAnimRightPlane);
		mAnimRightPlane.play();

		final MyTextureMaterial material3 = new MyTextureMaterial();
		material3.setUseColor(true);

		final Plane mPlaneTopAndroid = new Plane(1, 1, 1, 1);
		mPlaneTopAndroid.setMaterial(material3);
		mPlaneTopAndroid.setColor(0xaa1111ff);
		mPlaneTopAndroid.addTexture(mTextureManager
				.addTexture(R.drawable.texture_normal));
		mPlaneTopAndroid.setTransparent(true);
		mPlaneTopAndroid.setY(0.5f);
		mPlaneTopAndroid.setZ(0.01f);
		addChild(mPlaneTopAndroid);

		final SimpleMaterial material4 = new SimpleMaterial();
		material4.addTexture(mTextureManager.addEtc1Texture(new int[] {
				R.raw.texture_normal_mip_0, R.raw.texture_normal_mip_1,
				R.raw.texture_normal_mip_2, R.raw.texture_normal_mip_3,
				R.raw.texture_normal_mip_4, R.raw.texture_normal_mip_5,
				R.raw.texture_normal_mip_6, R.raw.texture_normal_mip_7 },
				TextureType.DIFFUSE));

		final Plane mPlaneBottomAndroid = new Plane(1, 1, 1, 1);
		mPlaneBottomAndroid.setMaterial(material4);
		mPlaneBottomAndroid.setY(-0.5f);
		addChild(mPlaneBottomAndroid);
	}

	@Override
	public void onDrawFrame(GL10 glUnused) {
		mPlaneLeft.setColor(mUserPrefs.getBoxColor());
		super.onDrawFrame(glUnused);
	}

	public static final class MySimpleMaterial extends SimpleMaterial {

		public MySimpleMaterial() {
			super(SIMPLE_VERTEX_MATERIAL, R.raw.mat_simple);
		}
	}

	public static final class MyTextureMaterial extends SimpleMaterial {

		public MyTextureMaterial() {
			super(SIMPLE_VERTEX_MATERIAL, R.raw.mat_texture);
		}
	}
}
