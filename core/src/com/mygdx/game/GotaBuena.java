package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class GotaBuena extends Gota {

	Texture gotaBuena;
	public Sound dropSound;
	
	
	
	
	public GotaBuena() {
		
		 super(Gdx.audio.newSound(Gdx.files.internal("drop.wav")));
		 gotaBuena = new Texture(Gdx.files.internal("justin.png"));
		 //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean actualizarMovimiento() {
		Tarro.createTarro().sumarPuntos(10);
        //dropSound.play();
        return true;
   } 
// TODO Auto-generated method stub
		
	@Override
	public void actualizarDibujoGota(Rectangle raindrop, SpriteBatch batch) {
			 batch.draw(gotaBuena, raindrop.x, raindrop.y); 
		// TODO Auto-generated method stub
		
	}



}