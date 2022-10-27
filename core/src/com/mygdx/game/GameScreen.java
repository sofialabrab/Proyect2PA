package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
	final GameLluviaMenu game;
    private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	private Tarro tarro;
	private Lluvia lluvia;
	private Sound droupSound;
	private Gota gota;

	   
	//boolean activo = true;

	public GameScreen(final GameLluviaMenu game) {
		this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
		  // load the images for the droplet and the bucket, 64x64 pixels each 	    
         tarro = Tarro.createTarro();
         gota = new GotaBuena();
         //gota.crearGota();
         gota = new GotaMala();
         //gota.crearGota();
	      // load the drop sound effect and the rain background "music" 
         
	     Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("justinbaby.mp3"));
         lluvia = new Lluvia(rainMusic);
	      
	      // camera
	      camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 480);
	      batch = new SpriteBatch();
	      // creacion del tarro
	      tarro.crear();
	      
	      // creacion de la lluvia
	      lluvia.crear();
	}

	@Override
	public void render(float delta) {
		tarro = Tarro.createTarro();
		//limpia la pantalla con color azul obscuro.
		//ScreenUtils.clear(0, 0, 0.2f, 1);
		Gdx.gl.glClearColor( 167/255f , 217/255f , 219/255f, 1 );
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		//actualizar matrices de la cámara
		camera.update();
		//actualizar 
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//dibujar textos
		font.draw(batch, "Gotas totales: " + tarro.getPuntos(), 5, 475);
		font.draw(batch, "Vidas : " + tarro.getVidas(), 670, 475);
		font.draw(batch, "HighScore : " + game.getHigherScore(), camera.viewportWidth/2-50, 475);
		
		if (!tarro.estaHerido()) {
			// movimiento del tarro desde teclado
	        tarro.actualizarMovimiento();        
			// caida de la lluvia 
	        boolean estado = lluvia.actualizarMovimiento(tarro);
	       if (estado == false) {
	    	   
	    	  //actualizar HigherScore
	    	  if (game.getHigherScore() < tarro.getPuntos())
	    	  {
	    		  game.setHigherScore(tarro.getPuntos());  
	    		  
	    		 
	    	  }
	    		 
	    	  //ir a la ventana de finde juego y destruir la actual
	    	  game.setScreen(new GameOverScreen(game));
	    	  
	    	  dispose();
	       }
		}
		
		tarro.dibujar(batch);
		lluvia.actualizarDibujoLluvia(batch);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	  // continuar con sonido de lluvia
	  lluvia.continuar();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		lluvia.pausar();
		game.setScreen(new PausaScreen(game, this)); 
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
	
	  Tarro.createTarro().destruir();
      lluvia.destruir();

	}

}

