package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private long lastDropTime;
//    private Texture gotaBuena;
//    private Texture gotaMala;
//    private Sound dropSound;
    private Music rainMusic;
	private Array<Rectangle> rainDropsPos;
	private Array<Gota> gotas = new Array<Gota>();
	public Lluvia(Music mm) {
		rainMusic = mm;
	}
	
	public void crear() {
		
		//crearGotaDeLluvia();
	      // start the playback of the background music immediately
		  rainDropsPos = new Array<Rectangle>();
	      rainMusic.setLooping(true);
	      rainMusic.play();
	}
	
	private void crearGotaDeLluvia() {
		  Gota gota;
	      Rectangle raindrop = new Rectangle();
	      raindrop.x = MathUtils.random(0, 800-64);
	      raindrop.y = 480;
	      raindrop.width = 64;
	      raindrop.height = 64;
	      rainDropsPos.add(raindrop);
	      // ver el tipo de gota
	      if (MathUtils.random(1,10) < 5)
	      {
	    	  gota = new GotaMala();
	    	  //gota.crearGota();
	    	
	      }
	      else
	      {
	    	  gota = new GotaBuena();
	    	  //gota.crearGota();
	      }
	     gotas.add(gota);
	
	    lastDropTime = TimeUtils.nanoTime();
	   }
	
   public boolean actualizarMovimiento(Tarro tarro) { 
	   // generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia();
	 
	   for (int i=0; i < rainDropsPos.size; i++ ) {
		  
		   	 Rectangle raindrop = rainDropsPos.get(i);
		      raindrop.y -= 300 * Gdx.graphics.getDeltaTime();
		      //cae al suelo y se elimina
		      if(raindrop.y + 64 < 0){
		    	  rainDropsPos.removeIndex(i); 
		    	  gotas.removeIndex(i);
		      }
		      if(raindrop.overlaps(tarro.getArea())) { 
		    	  Gota gt = gotas.get(i);
		    	  gt.activarSonido();
		    	  //la gota choca con el tarro
			    		boolean estado = gt.actualizarMovimiento();
			    		if(estado == false) 	
		    			{	gt.destruirSonido();
			    			return false;
		    			}
		    		
			    		// gota dañina
			    		//llamar a actualizar gota mala
			    	  rainDropsPos.removeIndex(i);
			          gotas.removeIndex(i);
			      }
			   } 
			  return true; 
		   }
   
   public void actualizarDibujoLluvia(SpriteBatch batch) { 
		  for (int i=0; i < rainDropsPos.size; i++ ) {
			  Rectangle raindrop = rainDropsPos.get(i);
			  Gota gt = gotas.get(i);
				  gt.actualizarDibujoGota(raindrop, batch);
				  // gota dañina	 
		   }
	   }
   public void destruir() {
      rainMusic.dispose();
   }
   public void pausar() {
	  rainMusic.stop();
   }
   public void continuar() {
	  rainMusic.play();
   }
   
}

