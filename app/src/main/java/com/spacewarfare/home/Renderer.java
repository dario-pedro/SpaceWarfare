package com.spacewarfare.home;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.spacewarfare.R;

import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;
import org.rajawali3d.renderer.RajawaliRenderer;


public class Renderer extends RajawaliRenderer implements View.OnTouchListener {


    private boolean LIGHT = true;

    public Context context;

    private DirectionalLight directionalLight;
    private Sphere earthSphere;

    public Renderer(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
    }

    int counter=0;

    public void initScene(){

        directionalLight = new DirectionalLight(1f, .2f, -1.0f);
        directionalLight.setColor(0.1f, 0.1f, 0.1f);
        directionalLight.setPower(3);
        getCurrentScene().addLight(directionalLight);

        Material material = new Material();
        material.enableLighting(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        material.setColor(0);




        Texture earthTexture = new Texture("Earth", R.drawable.planet_10);
        try{
            material.addTexture(earthTexture);

        } catch (ATexture.TextureException error){
            Log.d("DEBUG", "TEXTURE ERROR");
        }



        earthSphere = new Sphere(1, 24, 24);
        earthSphere.setMaterial(material);
        getCurrentScene().addChild(earthSphere);
        getCurrentCamera().setZ(4.2f);
        getCurrentScene().addLight(directionalLight);


    }




    @Override
     public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
        earthSphere.rotate(Vector3.Axis.Y, 1.0);

    }



    public void onTouchEvent(MotionEvent event){

    }




    public void onOffsetsChanged(float x, float y, float z, float w, int i, int j){

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){

            Material material = new Material();
            material.enableLighting(true);
            material.setDiffuseMethod(new DiffuseMethod.Lambert());
            material.setColor(0);


            int draw = R.drawable.planet1;

            switch (counter)
            {
               // case 0:draw = R.drawable.bac;break;
                case 1:draw = R.drawable.planet1;break;
                case 2:draw = R.drawable.planet2;break;
               // case 3:draw = R.drawable.a12;break;
                case 4:draw = R.drawable.planet3;break;
               // case 5:draw = R.drawable.a2;break;
                case 6:draw = R.drawable.planet4;break;
                case 7:draw = R.drawable.planet5;break;
                case 8:draw = R.drawable.planet7;break;
               // case 9:draw = R.drawable.a3;break;
                case 10:draw = R.drawable.planet6;break;
               // case 11:draw = R.drawable.a40;break;
              //  case 12:draw = R.drawable.a5;break;
              //  case 13:draw = R.drawable.a6;break;
                case 14:draw = R.drawable.planet8;break;
                case 15:draw = R.drawable.planet9;break;
                case 16:draw = R.drawable.planet_10;break;
               // case 17:draw = R.drawable.ground;break;
              //  case 18:draw = R.drawable.groundor;break;
                case 19:draw = R.drawable.planet_11;break;
                case 20:counter=0;break;

            }



            Texture earthTexture = new Texture("Earth", draw);
            try{
                material.addTexture(earthTexture);

            } catch (ATexture.TextureException error){
                Log.d("DEBUG", "TEXTURE ERROR");
            }
            earthSphere.setMaterial(material);

            earthSphere.setBackSided(false);

            counter++;

            //if(LIGHT) getCurrentScene().addLight(directionalLight);
            return true;

        }
        return false;
    }
}

