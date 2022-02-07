package com.example.beltzarun;

public abstract class Character
{
    protected int x, y, id;
    protected int width, height;

    public Character()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        id=0;
    }

    public Character(int id1, int x1, int y1, int w, int h)
    {
        id = id1;
        x = x1;
        y = y1;
        width = w;
        height = h;
    }

    public abstract int show();


    public int getId()
    {
        return id;
    }

    public void setId(int i)
    {
        id = i;
    }

    // accessor methods
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }

    public void setX(int x1)
    {
        x = x1;
    }
    public void setY(int y1)
    {
        y = y1;
    }
    public void changeX(int k)
    {
        x += k;
    }
    public void changeY(int k)
    {
        y += k;
    }

    public boolean inScene()
    {
        return true;
    }

}