package com.crash.buttoncrush;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main_Game extends ApplicationAdapter implements InputProcessor{
	Texture img;
	private OrthographicCamera camera;
	private SpriteBatch batch;
//	private Stage stage; //** stage holds the Button **//
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	private int screenWidth, screenHeight;
	private float glyph_Width, glyph_Height;
	private String message = "Button Crush!!!";

	int touchCounter = 0;



	@Override
	public void create () {
//		stage = new Stage();        //** window is stage **//
//		stage.clear();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();


		batch = new SpriteBatch();

		font = new BitmapFont(Gdx.files.internal("font.fnt"));

		GlyphLayout layout = new GlyphLayout(); //dont do this every frame! Store it as member
		layout.setText(font, message);

		glyph_Width = layout.width;// contains the width of the current set text
		glyph_Height = layout.height; // contains the height of the current set text


		Gdx.input.setInputProcessor(this); //** stage is responsive **//

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();


		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.draw(batch, message, screenWidth/2 - glyph_Width/2, screenHeight - screenHeight/6);

		batch.end();

	}


	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();

	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		touchCounter++;
		message = "Touch: "+ touchCounter;

		System.out.println("Touch: " + touchCounter + " !!");

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}