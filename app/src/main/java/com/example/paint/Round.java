package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Round extends Shape{

    Round(){
        name="Round";
    }
    Round(Pointe start, Pointe end, Paint paint){
        this.start=start;
        this.end=end;
        this.paint=paint;
        name="Round";
    }
    @Override
    protected void setStart(Pointe start) {
        this.start=start;
    }

    @Override
    protected void setEnd(Pointe end) {
        this.end=end;
    }

    @Override
    public String toString() {
        return "Round{" +
                "paint=" + paint.toString() +
                ", start=" + start.toString() +
                ", end=" + end.toString() +
                ", name='" + name +
                '}';
    }

    @Override
    protected void draw(Canvas canvas) {
        Paint paint1 = new Paint(paint);
        paint1.setStyle(Paint.Style.STROKE); // Set the paint style to STROKE
        paint1.setStrokeWidth(20f); // Set the stroke width to 20 pixels

        canvas.drawCircle(start.getX(),start.getY(),start.distence(end),paint1);


    }




}
