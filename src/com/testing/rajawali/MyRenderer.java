package com.testing.rajawali;

import javax.microedition.khronos.opengles.GL10;

import rajawali.materials.SimpleMaterial;
import rajawali.materials.TextureManager.TextureType;
import rajawali.primitives.Plane;
import rajawali.renderer.RajawaliRenderer;
import android.content.Context;

public final class MyRenderer extends RajawaliRenderer {

	private static final int SIMPLE_VERTEX_MATERIAL = com.monyetmabuk.livewallpapers.photosdof.R.raw.simple_material_vertex;

	private UserPrefs mUserPrefs;
	private Plane box;

	public MyRenderer(Context context) {
		super(context);

		// Application context so that we do not keep a reference to a service
		// that might not be needed any longer such as the preview.
		mUserPrefs = UserPrefs.getInstance(context.getApplicationContext());
	}

	@Override
	protected void initScene() {
		final MySimpleMaterial material = new MySimpleMaterial();
		material.setUseColor(true);

		box = new Plane(1, 1, 1, 1);
		box.setMaterial(material);
		box.setTransparent(true);
		box.setColor(0xffffff);
		box.setX(-0.25f);
		addChild(box);

		final Plane mPlane2 = new Plane(1, 1, 1, 1);
		mPlane2.setMaterial(material);
		mPlane2.setManageMaterial(false);
		mPlane2.setTransparent(true);
		mPlane2.setColor(0xaaff1111);
		mPlane2.setZ(0.1f);
		mPlane2.setX(0.25f);
		addChild(mPlane2);

		final MyTextureMaterial material2 = new MyTextureMaterial();
		material2.addTexture(mTextureManager.addTexture(R.drawable.texture_normal));

		final Plane mPlane3 = new Plane(1, 1, 1, 1);
		mPlane3.setMaterial(material2);
		mPlane3.setColor(0xaaffffff);
		mPlane3.setTransparent(true);
		mPlane3.setY(0.5f);
		mPlane3.setRotZ(-90);
		addChild(mPlane3);

		final SimpleMaterial material3 = new SimpleMaterial();
		material3.addTexture(mTextureManager.addEtc1Texture(
				new int[] { R.raw.texture_normal_mip_0,
						R.raw.texture_normal_mip_1, R.raw.texture_normal_mip_2,
						R.raw.texture_normal_mip_3, R.raw.texture_normal_mip_4,
						R.raw.texture_normal_mip_5, R.raw.texture_normal_mip_6,
						R.raw.texture_normal_mip_7 }, TextureType.DIFFUSE));

		final Plane mPlane4 = new Plane(1, 1, 1, 1);
		mPlane4.setMaterial(material3);
		mPlane4.setY(-0.5f);
		mPlane4.setRotZ(-90);
		addChild(mPlane4);
	}

	@Override
	public void onDrawFrame(GL10 glUnused) {
		box.setColor(mUserPrefs.getBoxColor());

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
