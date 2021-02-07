package com.gencaydil.raid;
//Position
//Health
//Texture
//Size

import com.badlogic.gdx.graphics.Texture;

public class Spaceship {
    private int x;
    private int y;
    private int health;
    private Texture texture;
    private int speed;

    public Spaceship(){
        x = 270;
        y = 30;
        health = 60;
        this.texture = new Texture("spaceshipimage.jpg");
        this.speed = 5;
    }


//    public Spaceship(String textureUrl){
//
//        x = 0;
//        y = 100;
//        health = 60;
//        this.texture = new Texture(textureUrl);
//        width = 80;
//        height = 120;
//
//    }

    public void goLeft(){
        x = x - speed;

    }


    public void goRight(){
        x = x + speed;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return texture.getWidth();
    }

    public int getHeight(){
        return texture.getHeight();
    }

    public Texture getTexture(){
        return texture;
    }

    public int getHealth(){
        return health;
    }









}
