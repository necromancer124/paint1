package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class MyLine extends Shape {
    private Pointe start;
    private Pointe end;
    MyLine(Pointe start)
    {
        this.start=start;
    }
    MyLine() {
        name="Line";
    }

    public MyLine(Pointe pointeStart, Pointe pointeEnd, Paint paint) {
        super();
        start = pointeStart;
        end = pointeEnd;
        this.paint = paint;
    }


    public Pointe getStart() {
        return start;
    }

    @Override
    public void setStart(Pointe start) {
        this.start = start;
    }

    public Pointe getEnd() {
        return end;
    }

    @Override
    public void setEnd(Pointe end) {
        this.end = end;
    }


    @Override
    protected void draw(Canvas canvas) {
        Log.d("line","Drawing line: "+toString());
        if (canvas!=null) {
            canvas.drawLine(start.getX(), start.getY(), end.getX(), end.getY(), paint);
            Log.d("line", "Drawn line");
        }
        else {
            Log.e("line", "Canvas is null");
        }
    }
    @Override
    public String toString() {
        return "MyLine{" +
                "start=" + start.toString() +
                ", end=" + end.toString() +
                '}';
    }
}

