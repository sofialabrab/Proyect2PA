package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public abstract class  Gota {
	
	
	//public abstract void crearGota();
	
	public abstract boolean actualizarMovimiento();
	
	public abstract void actualizarDibujoGota(Rectangle raindrop, SpriteBatch batch);
	
	
	
}