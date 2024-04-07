package com.metaphore.basisutest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crashinvaders.basisu.gdx.Ktx2TextureData;
import com.crashinvaders.basisu.gdx.BasisuTextureData;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture imagePng;
    private Texture imageKtx2;
    private Texture imageBasis;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imagePng = new Texture("libgdx.png"); // Plain PNG
        imageKtx2 = new Texture(new Ktx2TextureData(Gdx.files.internal("libgdx.ktx2"))); // UASTC
        imageBasis = new Texture(new BasisuTextureData(Gdx.files.internal("libgdx.basis"))); // ETC1S
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(imagePng, 140, 70);
        batch.draw(imageKtx2, 140, 210);
        batch.draw(imageBasis, 140, 350);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imagePng.dispose();
        imageKtx2.dispose();
        imageBasis.dispose();
    }
}
