package com.example.paint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Path extends Shape {


    Path() {
        list=new ArrayList<>();
        name = "path";
    }
    Path(List<Pointe> list, Paint paint) {
       this.paint = paint;
        this.list=list;
        name = "path";
    }

    @Override
    public String toString() {
        return "Path{" + "list=" + list.toString() + '}';
    }

    @Override
    protected void draw(Canvas canvas) {
        if (start != null && end != null && start.distence(end) > 0.2f) {
            Log.d("path", "starting path: " + start.toString() + " ending path: " + end.toString());
            list.add(end);
            start = end;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            canvas.drawLine(list.get(i).getX(), list.get(i).getY(), list.get(i + 1).getX(), list.get(i + 1).getY(), paint);
        }

    }


}
