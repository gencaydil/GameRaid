package com.gencaydil.raid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;



public class Soundmanager {

    public static Sound click;

    public static void create(){
        click = Gdx.audio.newSound(Gdx.files.internal("nice.mp3"));
        long id = (long) 0.1;
        Soundmanager.click.setVolume(id,0.1f);

    }



    public void dispose(){

        click.dispose();
    }

}
