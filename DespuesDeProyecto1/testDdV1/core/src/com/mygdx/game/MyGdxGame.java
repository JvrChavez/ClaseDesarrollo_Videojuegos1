package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private TextureRegion region;
	private Sprite miSprite;
	private float posX=0;
	private boolean cambio=false,sDerecha=false,sIzquierda=false;
	private int width,height,velocidad=100,aceleracion;
	
	@Override
	public void create () {
		width=Gdx.graphics.getWidth();
		height=Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture("mario1.png");
		region=new TextureRegion(img,0,0,32,20);
		miSprite=new Sprite(img,0,0,42,40);
		miSprite.setPosition(0,350);	
	}
	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
			batch.draw(img, 10, 50,100,75);
			batch.draw(region,10,170,50,50);
			miSprite.draw(batch);
			//miSprite.rotate(15);
			/*if (miSprite.getX()==(width-50)) {
				cambio=false;
			}else if(miSprite.getX()==0){
				cambio=true;
			}
			if (cambio) {
				posX++;
			} else {
				posX--;
			}*/
			//miSprite.setPosition(posX,miSprite.getY());
			
			boolean derecha=Gdx.input.isKeyPressed(Input.Keys.RIGHT);			
			boolean izquierda=Gdx.input.isKeyPressed(Input.Keys.LEFT);
			float tiempo=Gdx.graphics.getDeltaTime();
			if (derecha) {
				posX+=velocidad*tiempo;				
				if (aceleracion<20) {									
					aceleracion+=1;
					velocidad+=aceleracion;
				}
				sDerecha=true;
			} else if(sDerecha){				
				if (aceleracion>0) {
					posX+=velocidad*tiempo;	
					System.out.println("Decremento");								
					aceleracion-=2;
					velocidad-=aceleracion;
				}else{
					System.out.println("no hay");	
					velocidad=100;
					aceleracion=0;
					sDerecha=false;
				}
				
			}
			if (izquierda) {
				posX-=velocidad*tiempo;				
				if (aceleracion<20) {									
					aceleracion+=1;
					velocidad+=aceleracion;
				}
				sIzquierda=true;
			} else if(sIzquierda){				
				if (aceleracion>0) {
					posX-=velocidad*tiempo;	
					System.out.println("Decremento");								
					aceleracion-=2;
					velocidad-=aceleracion;
				}else{
					System.out.println("no hay");	
					velocidad=100;
					aceleracion=0;
					sIzquierda=false;
				}
				
			}
			miSprite.setPosition(posX,miSprite.getY());
		batch.end();
	}	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
