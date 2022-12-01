package com.mygdx.game;

public class Castigo implements Ruleta{

	


	@Override
    public void modVida() 
    {
		Tarro.createTarro().setVidas(-1);
    }

	@Override
    public void modVelocidad() 
    {
		Tarro.createTarro().setVelx(-250);
    }

}