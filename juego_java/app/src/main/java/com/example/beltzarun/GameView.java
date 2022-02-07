package com.example.beltzarun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Iterator;

import Movement.Acelerometer;
import Movement.Gyroscope;
import Movement.Magnetometer;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying;
    private Background background;
    private Floor floor;
    private int screenX,screenY;
    private Paint paint;
    private float screenRatioX,screenRatioY;
    private Doodle main_char;
    private Boolean gameStart;
    private Context context;
    private Boolean facing = false;
    private int positionY = 0;

    private Acelerometer acelerometer;
    private Gyroscope gyroscope;
    private Magnetometer magnetometer;

    private ArrayList<Platform> platformsArrayList = new ArrayList<>();

    private Canvas canvas;

    public GameView(Context context,int screenX,int screenY) {
        super(context);

        this.context = context;
        acelerometer = new Acelerometer(context);
        gyroscope = new Gyroscope(context);
        magnetometer = new Magnetometer(context);

        magnetometer.setListener(new Magnetometer.Listener() {
            @Override
            public void onTilt(float tiltx, float tilty, float tiltz) {
                /*if(tiltx > 0.5f){
                    facing = true;
                }else if(tiltx < -0.5f){
                    facing = false;
                }*/
            }
        });

        acelerometer.setListener(new Acelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {

            }
        });

        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(ry > 0.0f){
                    facing = true;
                    positionY += ry;
                }else if(ry < 0.0f){
                    facing = false;
                    positionY += ry;
                }
            }
        });

        MainActivity.Highscore = 0;

        this.screenX = screenX;
        this.screenY = screenY;
        this.screenRatioX = 1920f / screenX;
        this.screenRatioY = 1080f / screenY;
        gameStart = false;

        background = new Background(screenX,screenY,getResources());
        floor = new Floor(screenX,screenY,screenX,screenY-screenY/10,getResources());

        randomPlatform();

        main_char = new Doodle(1,0,0,screenX/6,screenY/10,getResources());
        main_char.setX((int)((screenX/2)-(main_char.width/2)));
        main_char.setY((int)(screenY/1.25)-main_char.height);



    }

    @Override
    public void run() {
        while(isPlaying){
            update();
            draw();
            sleep();
        }
        context.startActivity(new Intent(context,MainActivity.class));
    }

    public void randomPlatform(){
        int last_yp = screenY;
        int range = 8;

        for(int i = 0;i<8;i++){
            int yp = screenY/10*range;
            System.out.println(screenY-(screenY/10));

            Platform plat1 = new Platform(1, randomXPos((int) (screenX/3.5)), yp, (int) (screenX/3.5), screenY/45,getResources());
            platformsArrayList.add(plat1);
            range--;
        }

    }

    private void update() {
        if(positionY > 0 && main_char.x < screenX-main_char.width){
            main_char.x += 30;
        }else if(positionY < 0 && main_char.x > 0){
            main_char.x -= 30;
        }
        if(main_char.y > screenY){
            isPlaying = false;
        }
        tileGen();
        main_char.move(screenY);
        colliderDetections();
        background_controller();
    }
    public void colliderDetections(){
        Iterator<Platform> platformIterator = platformsArrayList.iterator();
        if(main_char.getVelocity() > 0){
            while(platformIterator.hasNext()){
                if(isColliding(platformIterator.next(),main_char)){
                    platformIterator.remove();
                    main_char.jump();
                    MainActivity.Highscore += 1;
                }
            }
        }
    }

    public boolean isColliding(Platform platform,Doodle main_character){
        return Rect.intersects(platform.getHitbox(),main_character.getHitbox());
    }

    public void background_controller(){
        if(main_char.getY() < screenY/2){
            if(main_char.getVelocity()<0){
//                background.y += main_char.getVelocity();
//                background2.y += main_char.getVelocity();

                if(floor.posY < screenY){
                    floor.posY -= main_char.getVelocity();
                }

                for(Platform plat : this.platformsArrayList){
                    plat.y -= main_char.getVelocity();
                }
            }
        }

//        if(background.y + background.background.getHeight() > 0) {
//            background.y = screenY;
//        }
//
//        if(background2.y + background2.background.getHeight() > 0) {
//            background2.y = screenY;
//        }
    }

//    @SuppressLint("UseCompatLoadingForDrawables")
//    @Override
//    public void setBackground(Drawable background) {
//        super.setBackground(getResources().getDrawable(R.drawable.background_big));
//    }

    public void jump(){
        main_char.setVelocity(-75);
    }

    /*@SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x;
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN: {
            }
            break;

            case MotionEvent.ACTION_MOVE:
            {
                main_char.x=(int)event.getX();
                invalidate();
            }

            break;
            case MotionEvent.ACTION_UP:
                System.out.println(event.getX());
                System.out.println(event.getY());
                main_char.x=(int)event.getX();
                invalidate();
                break;
        }
        return true;
    }*/



    @SuppressLint("ResourceAsColor")
    private void draw(){
        if(getHolder().getSurface().isValid()){
            canvas = getHolder().lockCanvas();
            paint = new Paint();

            paint.setColor(Color.rgb(135, 206, 235));
            canvas.drawRect((float)(0),(float)(0),screenX,screenY,paint);

            //canvas.drawBitmap(background.background,0,0,paint);


            canvas.drawBitmap(floor.background,0,floor.posY,paint);






            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLACK);
            paint.setTextSize(45);
            canvas.drawText(String.valueOf(MainActivity.Highscore), 50, 55, paint);
            canvas.drawBitmap(main_char.resource,main_char.x,main_char.y,paint);
            main_char.updateHitbox();
            //canvas.drawRect(main_char.getHitbox(),paint);
            for(Platform plat : this.platformsArrayList){
                canvas.drawBitmap(plat.resource,plat.x,plat.y,paint);
                plat.updateHitbox();
                //canvas.drawRect(plat.getHitbox(),paint);
            }
            getHolder().unlockCanvasAndPost(canvas);

        }
    }
    private void sleep() {
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Pause(){
        try {
            System.out.println("game paused");
            magnetometer.unregister();
            acelerometer.unregistered();
            gyroscope.unregister();
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Resume(){
        magnetometer.register();
        acelerometer.register();
        gyroscope.register();
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public int randomXPos(float width){
        int number = (int)(Math.random()* screenX);
        if((number+width) > screenX){
            number -= screenX-width;
        }
        return number;
    }

    public void tileGen(){
        if(platformsArrayList.get(platformsArrayList.size()-1).y > screenY*0.25){
            Platform plat1 = new Platform(1, randomXPos((int) (background.background.getWidth()/3.5)), 0, (int) (background.background.getWidth()/3.5), background.background.getHeight()/45,getResources());
            platformsArrayList.add(plat1);
        }
    }
}
