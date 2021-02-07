package com.gencaydil.raid;
//Position
//Health
//Texture
//Size

import com.badlogic.gdx.graphics.Texture;

public class Alien {

    private int x;
    private int y;
    private int health;
    private Texture texture;
    private int speed;

    public Alien(int x, int y, String texture){

        this.x = x;
        this.y = y;
        health = 10;
        this.texture = new Texture("alienimage.jpg");
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Texture getTexture(){
        return texture;
    }

    public int getHealth(){
        return health;
    }


}
