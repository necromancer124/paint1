package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape {
    Shape(){}
    protected Paint paint;
    protected Pointe start;
    protected Pointe end;
    protected int engels;

    protected String name;
      protected void setPaint(Paint paint)
      {
          this.paint=paint;
      }
    protected  void setStart(Pointe start)
    {
        this.start=start;
    }
    protected  void setEnd(Pointe end)
    {this.end=end;}
    protected void setEngels(int x)
    {this.engels=x;}
protected String getName(){return name;}

    public Paint getPaint() {
        return paint;
    }

    public abstract String toString();
    protected abstract void draw(Canvas canvas);



}
