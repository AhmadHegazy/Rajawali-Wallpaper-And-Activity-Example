precision mediump float;

varying vec2 vTextureCoord;
uniform sampler2D uDiffuseTexture;
varying vec4 vColor;
				
vec4 modifiedColor;

void main() {
	modifiedColor = vColor;
	modifiedColor.a = max(modifiedColor.a, 0.5);
	gl_FragColor = modifiedColor;
}