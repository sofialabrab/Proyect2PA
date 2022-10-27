package com.mygdx.game;

public class Castigo implements Ruleta{




    public void modVida() 
    {
        Tarro.createTarro().setVidas(-1);
    }


    public void modVelocidad() 
    {
        Tarro.createTarro().setVelx(-100);
    }

}