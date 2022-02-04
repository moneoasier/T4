package com.example.beltzarun;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Doodle extends Character
{
    private int velocity,w,h;
    private int count;
    Bitmap resource;
    private Rect hitbox;

    public Doodle(int id, int x, int y, int w, int h, Resources res)
    {
        super(id,x,y,w,h);

        velocity=-65;
        count=0;

        this.w = w;
        this.h=h;

        hitbox = new Rect(x,y,x+w/2,y+h);

        resource= BitmapFactory.decodeResource(res,R.drawable.doodle_png);
        resource = Bitmap.createScaledBitmap(resource,w,h,false);
    }

    public int getVelocity()
    {
        return velocity;
    }

    public void setVelocity(int v)
    {
        velocity = v;
    }

    public Rect getHitbox(){
        return this.hitbox;
    }

    public void setHitbox(Rect hitbox) {
        this.hitbox = hitbox;
    }

    public void updateHitbox(){
        hitbox = new Rect((int)(x+w*0.1),(int)(y+h*0.85),(int)((x+w*0.65)),y+h);
    }

    public int show()
    {
        return id;
    }

    public String toString()
    {
        return "Doodle x: "+x+"|y: "+y;
    }


    public void move(int screenY)
    {
        int acceleration = 1;
        if(velocity!=0){
            if(velocity<=-1)
                acceleration=10;
            if(velocity>=1)
                acceleration=30;
            if(count>2){
                if(velocity<10){
                    if(velocity+acceleration==0){
                        velocity=0;
                    }
                    velocity=velocity+acceleration;
                }
                count=0;
            }
            count++;
            if(this.getY() >= screenY/2 || velocity > 0){
                changeY(velocity);
            }

        }

        //	System.out.println("Doodle x: "+super.getX()+" | y: "+super.getY()+ " | v: "+velocity + " | a: "+acceleration);
    }

    public void jump(){
        this.velocity = -111;
    }

    public boolean checkHitPlatform(Object obj)
    {
        Platform other = (Platform) obj;

        if(getX()+getWidth()>=other.getX()&&
                getX()<=other.getX()+other.getWidth() &&
                getY()+getHeight() >=other.getY() &&
                getY()+getHeight() <= other.getY()+other.getHeight())
            return true;
        return false;
    }

    public void getCollider(Object obj){

    }
}
