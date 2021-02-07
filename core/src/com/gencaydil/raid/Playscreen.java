package com.gencaydil.raid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Playscreen implements Screen {

    private OrthographicCamera cam;
    private Spaceship spaceship = new Spaceship();
    private SpriteBatch spriteBatch;
    private Game game;
    private Vector3 touchPoint;


    public Playscreen(SpriteBatch batch, Game game){
        cam = new OrthographicCamera();

        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        this.spriteBatch = batch;
        this.game = game;

    }

    public void handleInput (){
        touchPoint = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPoint);
            if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed (Input.Keys.RIGHT)) {
                spaceship.goRight();
            }else if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                spaceship.goLeft();

            }




    }


    @Override
    public void show() {
        ScreenUtils.clear(0, 0, 0, 1);

    }

    @Override
    public void render(float delta) {
        handleInput();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(spaceship.getTexture(),spaceship.getX(), spaceship.getY());
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
