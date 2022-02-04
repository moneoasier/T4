package com.example.beltzarun;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Platform extends Character
{

    Bitmap resource;
    private Rect hitbox;
    private int w,h;
    public Platform(int id, int x, int y, int w, int h, Resources res)
    {
        super(id,x,y,w,h);


        this.x = x;
        this.y = y;

        this.w = w;
        this.h=h;

        hitbox = new Rect(x,y,x+w,y+h);

        resource= BitmapFactory.decodeResource(res,R.drawable.png_match_fino);
        resource = Bitmap.createScaledBitmap(resource,w,h,false);

    }

    public int show()
    {
        return id;
    }

    public String toString()
    {
        return x + " " + y;
    }

    public Rect getHitbox(){
        return this.hitbox;
    }

    public void setHitbox(Rect hitbox) {
        this.hitbox = hitbox;
    }

    public void updateHitbox(){
        hitbox = new Rect(x,y,x+w,y+h);
    }

    public boolean inScene()
    {
        boolean scene = true;
        if(getX() > 600)
            scene = false;
        return scene;
    }



}
