package com.gencaydil.raid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private Music music;
	private Sound sound;

	@Override
	public void create() {
		batch = new SpriteBatch();
		this.setScreen(new MainMenu(batch, this));
		Gdx.gl.glClearColor(0, 0, 0, 1);

		Music music = Gdx.audio.newMusic(Gdx.files.internal("yeah.wav"));
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("nice.mp3"));

		music.setVolume(0.4f);
		music.setLooping(true);
		music.play();

		long id = sound.play(1.0f);
		sound.setPitch(id,1);
		sound.setLooping(id,false);

	}

	public void dispose(){

		music.dispose();
	}


	}



