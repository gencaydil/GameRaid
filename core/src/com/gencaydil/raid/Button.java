package com.gencaydil.raid;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

//int called x,y
//texture called button
//rectangle called collision
public class Button {

/*
    int is a java primitive type
    texture and rectangle are lib types imported from another class downloaded (think of it as a mod)
    */

    private int x ;
    private int y ;
    private Texture texture;
    private Rectangle collision;


    //adds constructors for the object button

    public Button(int x, int y, String textureurl){

        this.texture = new Texture(textureurl);
        this.x = (x - (texture.getWidth() /2));
        this.y = (y - (texture.getHeight() /2));
        collision = new Rectangle(this.x,this.y, getWidth(), getHeight());
    }




    public Texture getTexture() {
        return texture;
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

    public Rectangle getCollision(){
        return collision;
    }
}
