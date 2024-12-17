package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

public class Poligob extends Shape{
        Poligob(int engels)
        {name="Poliglob";
            this.engels=engels;}
    Poligob(int engels, Paint paint, Pointe start, Pointe end)
    {this.engels=engels;
        this.paint=paint;
        this.start=start;
        this.end=end;
        name="Poligob";
    }


    @Override
    public String toString() {
        return "";
    }

    @Override
    protected void draw(Canvas canvas) {
        List<Pointe> list=findpoint();
for (Pointe p:list)
{
    int size = list.size();
    Paint paint1 = new Paint(paint);
    paint1.setStyle(Paint.Style.STROKE); // Set the paint style to STROKE
    for (int i = 0; i < size; i++) {
        Pointe pa = list.get(i);
        Pointe prev = list.get((i + size - 1) % size);
        canvas.drawLine(pa.getX(), pa.getY(), prev.getX(), prev.getY(), paint1);
    }
    canvas.drawLine(list.get(size - 1).getX(), list.get(size - 1).getY(), list.get(0).getX(), list.get(0).getY(), paint1);
}
    }



    private List<Pointe> findpoint()
    {
        List<Pointe> list=new ArrayList<>();
        float R=start.distence(end);
        float a=(float)Math.toRadians(360/engels);

        float x;
        float y;


        for(int i=0;i<engels;i++)
        {
            float theta = i * a; // Current angle in radians


             x = start.getX() + R * (float) Math.cos(theta);  // X-coordinate
             y = start.getY() + R * (float) Math.sin(theta);  // Y-coordinate

            list.add(new Pointe(x,y));
        }

        return list;
    }


}
