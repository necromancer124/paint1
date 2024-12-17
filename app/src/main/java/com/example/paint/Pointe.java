package com.example.paint;

import android.graphics.Point;

public class Pointe {
   private Float x;
   private Float y;

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Pointe(Float x, Float y){
        this.x=x;
        this.y=y;
    }
    public Point convert()
    {
        return new Point(Math.round(getX()),Math.round(getY()));
    }
    public Float distence(Pointe pointe)
    {
        Float f=(float)Math.sqrt(Math.pow(getX()-pointe.getX(),2)+Math.pow(getY()-pointe.getY(),2));
        return f;
    }

    @Override
    public String toString() {
        return "Pointe{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
