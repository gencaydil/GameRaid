package com.gencaydil.raid;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
//Screen: everyone who uses this interface has to use the methods within the class of Screen. CMD + Screen to view.
public class MainMenu implements Screen {

    private Button newgameButton = new Button (Gdx.graphics.getWidth() /2,(Gdx.graphics.getHeight() /2) + 100 , "newgamebutton.jpg");
    private Button settingsButton = new Button (Gdx.graphics.getWidth() /2,(Gdx.graphics.getHeight() /2), "settingsbutton.jpg");
    private Button exitButton = new Button (Gdx.graphics.getWidth() /2,(Gdx.graphics.getHeight() /2) - 100, "exitgamebutton.jpg");
    private Backgroundimages mainmenuImage = new Backgroundimages("backgroundmoon.jpeg");
    private Backgroundimages gamelogoImage = new Backgroundimages("raidlogo.jpg");
    private SpriteBatch spriteBatch;
    private Vector3 touchPoint;
    private OrthographicCamera cam;
    private ShapeRenderer sr = new ShapeRenderer();
    private Game game;

    public MainMenu(SpriteBatch batch, Game game){
        cam = new OrthographicCamera();

        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        this.spriteBatch = batch;
        this.game = game;

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
            if (newgameButton.getCollision().contains(touchPoint.x, touchPoint.y)){
                game.setScreen(new Playscreen(spriteBatch, game));
            }
            else if (settingsButton.getCollision().contains(touchPoint.x, touchPoint.y)){
                System.out.println("I have touched the settings button!");
                game.setScreen(new Settingsscreen(spriteBatch, game, this));
            }
            else if (exitButton.getCollision().contains(touchPoint.x, touchPoint.y)){
                Gdx.app.exit();
                System.exit(0);
            }
        }
    }



    @Override
    public void render(float delta) {
        handleInput();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(mainmenuImage.getTexture(), 0,0);
        spriteBatch.draw(gamelogoImage.getTexture(), -20,0);
        spriteBatch.draw(newgameButton.getTexture(),newgameButton.getX(), newgameButton.getY(), newgameButton.getWidth(), newgameButton.getHeight());
        spriteBatch.draw(settingsButton.getTexture(),settingsButton.getX(), settingsButton.getY(), settingsButton.getWidth(), settingsButton.getHeight());
        spriteBatch.draw(exitButton.getTexture(),exitButton.getX(), exitButton.getY(), exitButton.getWidth(), exitButton.getHeight());
        spriteBatch.end();

//        sr.setProjectionMatrix(cam.combined);
//        sr.begin(ShapeRenderer.ShapeType.Line);
//        sr.setColor(Color.WHITE);
//        sr.rect(newgameButton.getCollision().x, newgameButton.getCollision().y, newgameButton.getCollision().width, newgameButton.getCollision().height);
//        sr.rect(settingsButton.getCollision().x, settingsButton.getCollision().y, settingsButton.getCollision().width, settingsButton.getCollision().height);
//        sr.rect(exitButton.getCollision().x, exitButton.getCollision().y, exitButton.getCollision().width, exitButton.getCollision().height);
//        sr.end();


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
