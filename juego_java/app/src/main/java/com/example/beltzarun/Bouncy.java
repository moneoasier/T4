package com.example.beltzarun;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Bouncy {
    int x = 0,y = 0;
    Bitmap background;

    Bouncy(int screenX, int screenY, Resources res){
        background = BitmapFactory.decodeResource(res,R.drawable.spring_coil);
        background = Bitmap.createScaledBitmap(background,screenX,screenY,false);
    }
}
