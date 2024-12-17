package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class MyRect extends Shape{
    private Pointe one;
    private Pointe two;
    private Pointe three;
    private Pointe fowr;

    MyRect()
    {name="Rectangle";}

    public MyRect(Pointe one, Pointe fowr, Paint paint) {
        this.one = one;
        this.fowr = fowr;
        name = "Rectangle";
       this.paint = paint;
    }

    @Override
    protected void setStart(Pointe start) {
        this.one = start;
    }

    @Override
    protected void setEnd(Pointe end) {
        this.fowr = end;
    }

    @Override
    public String toString() {
        return "";
    }

    private void calculate() {
        two = new Pointe(fowr.getX(), one.getY());
        three = new Pointe(one.getX(), fowr.getY());
    }

    @Override
    protected void draw(Canvas canvas) {
    Paint paint = new Paint(this.paint);
        paint.setStyle(Paint.Style.STROKE); // Set the paint style to STROKE
        calculate();
        canvas.drawLine(one.getX(), one.getY(), two.getX(), two.getY(), paint);
        canvas.drawLine(one.getX(), one.getY(), three.getX(), three.getY(), paint);
        canvas.drawLine(fowr.getX(), fowr.getY(), two.getX(), two.getY(), paint);
        canvas.drawLine(fowr.getX(), fowr.getY(), three.getX(), three.getY(), paint);
    }
}