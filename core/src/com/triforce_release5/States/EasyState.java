package com.triforce_release5.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.triforce_release5.HUD;
import com.triforce_release5.TbMenu;
import com.triforce_release5.TbText;
import com.triforce_release5.TriForceRelease5;

/**
 * Created by Matthew on 12/9/2015.
 */
public class EasyState implements Screen, InputProcessor{
    TriForceRelease5 triForceRelease5;

    private TextureAtlas textureAtlas; //This is for the animation of the character.
    private Animation animation;
    private float fElapsedTime = 0f;

    SpriteBatch sbBatch;
    Stage stage;

    TbMenu tbMenu;
    TextButton TbBack;

    public EasyState(TriForceRelease5 triForceRelease5){ //References the main class.
        this.triForceRelease5=triForceRelease5;
        triForceRelease5.hud = new HUD(triForceRelease5.sbBatch);
    }

    public void create(){
        sbBatch = new SpriteBatch();
        stage = new Stage();
        tbMenu= new TbMenu();
        Skin skin = tbMenu.getSkin();//calls skin
        TbBack = new TbText("Back", skin);
        TbBack.setPosition(0, 0);
        textureAtlas = new TextureAtlas(Gdx.files.internal("Megaman.pack"));
        animation = new Animation(1f/6f, textureAtlas.getRegions());
        stage.addActor(TbBack);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        create();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 0, 1); //Yellow background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        triForceRelease5.hud.stage.draw(); //Draw the hud.
        fElapsedTime += Gdx.graphics.getDeltaTime();
        sbBatch.begin();
        sbBatch.draw(animation.getKeyFrame(fElapsedTime,true),150,180);
        sbBatch.end();
        triForceRelease5.hud.update();
        if(TbBack.isPressed()){
            triForceRelease5.currentState = TriForceRelease5.GameState.PLAY;
            triForceRelease5.updateState();
            triForceRelease5.hud.reset();

        }
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
        sbBatch.dispose();
        textureAtlas.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
