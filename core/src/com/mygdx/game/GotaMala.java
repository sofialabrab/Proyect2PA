package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class GotaMala extends Gota{

	 Texture gotaMala;
	 Sound hurtSound ;

	public GotaMala() {
		
		  super(Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")));
		  gotaMala = new Texture(Gdx.files.internal("SelenaSi.jpg"));
		  //hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
	      
	} 
		// TODO Auto-generated method stub
		
	public boolean actualizarMovimiento() {
	
		Tarro.createTarro().dañar();
		//hurtSound.play();
  	  	if (Tarro.createTarro().getVidas()<=0)
  	  	{	System.out.println("Se quedo sin vidas:" + Tarro.createTarro().getVidas() );
  	  		return false;
  	  	}
  	  		 
  	  	else return true;// si se queda sin vidas retorna falso /game over
  	  	
        
	}

	@Override
	public void actualizarDibujoGota(Rectangle raindrop,SpriteBatch batch) {
		batch.draw(gotaMala, raindrop.x, raindrop.y); 
		// TODO Auto-generated method stub
		
	}



}
