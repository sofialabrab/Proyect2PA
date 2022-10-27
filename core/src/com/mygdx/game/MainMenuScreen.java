package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuScreen implements Screen {

	final GameLluviaMenu game;
	private SpriteBatch batch;
	private BitmapFont font;
	private OrthographicCamera camera;

	public MainMenuScreen(final GameLluviaMenu game) {
		this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

	@Override
	public void render(float delta) {
		//ScreenUtils.clear(0, 250, 1, 1);
		Gdx.gl.glClearColor( 167/255f , 217/255f , 219/255f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		font.getData().setScale(2,2);
		font.draw(batch, "Bienvenido a Atrapa a Justin!!! ", 150, camera.viewportHeight/2+50);
		font.draw(batch, "Toca en cualquier lugar para comenzar!", 100, camera.viewportHeight/2-50);

		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
