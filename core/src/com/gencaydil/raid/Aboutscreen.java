package com.gencaydil.raid;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Aboutscreen implements Screen {

    private Button gobackButton = new Button(Gdx.graphics.getWidth() /2,(Gdx.graphics.getHeight() /2) - 180, "gobackbutton.jpg");
    private SpriteBatch spriteBatch;
    private Vector3 touchPoint;
    private OrthographicCamera cam;
    private ShapeRenderer sr = new ShapeRenderer();
    private Game game;
    private Settingsscreen settingsscreen;

    public Aboutscreen(SpriteBatch batch, Game game, Settingsscreen settingsscreen) {
        cam = new OrthographicCamera();

        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        this.spriteBatch = batch;
        this.game = game;
        this.settingsscreen = settingsscreen;
    }


    @Override
    public void show() {

        ScreenUtils.clear(1, 0, 0, 1);
    }
    public void handleInput()
    {
        touchPoint = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPoint);
        if(Gdx.input.justTouched()){
            if (gobackButton.getCollision().contains(touchPoint.x, touchPoint.y)){
                game.setScreen(settingsscreen);
            }
        }
    }


    @Override
    public void render(float delta) {
        handleInput();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(gobackButton.getTexture(),gobackButton.getX(), gobackButton.getY(), gobackButton.getWidth(), gobackButton.getHeight());
        spriteBatch.end();

        sr.setProjectionMatrix(cam.combined);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.WHITE);
        sr.rect(gobackButton.getCollision().x, gobackButton.getCollision().y, gobackButton.getCollision().width, gobackButton.getCollision().height);
        sr.end();
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