package com.example.beltzarun;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Floor {
    public float posY,posX;
    int x = 0,y = 0;
    Bitmap background;

    Floor(int screenX, int screenY,int posX,int posY, Resources res){
        this.posX = posX;
        this.posY = posY;
        background = BitmapFactory.decodeResource(res,R.drawable.doodle_floor_recortado);
        background = Bitmap.createScaledBitmap(background,screenX,screenY/10,false);
    }
}
