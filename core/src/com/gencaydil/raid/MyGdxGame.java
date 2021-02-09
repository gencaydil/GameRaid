package com.gencaydil.raid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private Music music;
	private Soundmanager soundmanager;
//	private FreeTypeFontGenerator fontGenerator;
//	private FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;
//	private BitmapFont font;

	@Override
	public void create() {

		Soundmanager.create();


		batch = new SpriteBatch();
		this.setScreen(new MainMenu(batch, this));
		Gdx.gl.glClearColor(0, 0, 0, 1);

		Music music = Gdx.audio.newMusic(Gdx.files.internal("yeah.mp3"));
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("nice.mp3"));

		music.setVolume(0.2f);
		music.setLooping(true);
		music.play();

	}

	public void dispose(){

		music.dispose();
		soundmanager.dispose();
//		font.dispose();
	}


	}
