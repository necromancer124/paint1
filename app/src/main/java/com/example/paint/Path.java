package com.example.paint;

import android.graphics.Canvas;

public class Path extends Shape {

    Path() {
        type = "path";
    }

    @Override
    protected void draw(Canvas canvas) {
        float[] f = new float[points.size()];
        for (Pointe point : points) {
            f[points.indexOf(point)] = point.getX();
            f[points.indexOf(point) + 1] = point.getY();
        }

        canvas.drawLines(f, paint);
    }
}
