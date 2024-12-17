package com.example.paint;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MyView extends View {
    private Shape shape;
    private Pointe pointeStart=null;
    private Pointe pointeEnd=null;
    private ShapeHistory shapeHistory;
    private boolean move;
    public MyView(Context context) {
        super(context);
        shapeHistory = new ShapeHistory();
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape , Paint paint) {
        this.shape = shape;
        shape.setPaint(paint);
        Log.d("SetShape","Got it");
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        shapeHistory = new ShapeHistory();
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        shapeHistory = new ShapeHistory();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("ACTION", "onTouchEvent called with action: " + event.getAction());

        switch (event.getAction())
        {

            case MotionEvent.ACTION_DOWN:
                Log.d("ACTION","startdown");
                pointeStart= new Pointe(event.getX(),event.getY());
                Log.d("ACTION","startdown pointe:"+pointeStart.toString());
                if (shape != null) {
                    shape.setStart(pointeStart);
                    move=true;
                }


                break;

            case MotionEvent.ACTION_UP:
                Log.d("ACTION", "startup");
                move=false;
                pointeEnd = new Pointe(event.getX(), event.getY());
                if (pointeStart == null) {
                    pointeStart = new Pointe(event.getX(), event.getY());
                }
                if (shape != null) {
                    shape.setEnd(pointeEnd);
                }
                Shape newShape = null;
                Paint paint = new Paint(shape.paint);
                if(shape.getName().equals("Line")) {

                    newShape = new MyLine(pointeStart, pointeEnd,paint);
                }
                if (shape.getName().equals("Rectangle")) {
                    newShape = new MyRect(pointeStart, pointeEnd,paint);
                }
                if (shape.getName().equals("Round")) {
                    newShape = new Round(pointeStart, pointeEnd,paint);
                }
                if (shape.getName().equals("Poliglob")) {
                    newShape=new Poligob(shape.engels,paint,pointeStart,pointeEnd);
                }
                // add path

                shapeHistory.addShape(newShape);

                Log.d("ACTION", "Added shape to history:"+shapeHistory.toString());
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d("ACTION", "startmove");
                float currentX = event.getX();
                float currentY = event.getY();
                if (pointeEnd == null)
            {
                pointeEnd = new Pointe(currentX, currentY);
                Log.d("ACTION", "startmove pointe:"+pointeEnd.toString());
            }
                if (pointeStart == null) {
                    pointeStart = new Pointe(currentX, currentY);
                }
                if (calculateDistance(currentX, currentY, pointeEnd.getX(), pointeEnd.getY()) > 0.2) {
                    pointeEnd = new Pointe(currentX, currentY);
                    Log.d("ACTION", "startMoveCalculateDistance pointe:"+pointeEnd.toString());
                    shape.setEnd(pointeEnd);
                    invalidate();
                }
                break;
        };


        return super.onTouchEvent(event);
    }


    public static float calculateDistance(float x1, float y1, float x2, float y2) {
        // Applying the Euclidean distance formula
        float distance = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public void undo() {
        // Remove the last shape from the history
        shapeHistory.removeLastShape();
        // Redraw the view to show the remaining shapes
        invalidate();
    }
    @SuppressLint({"ResourceAsColor", "SuspiciousIndentation"})
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(R.color.blue);
        if(shapeHistory!=null&&!move){
            List<Shape> list=shapeHistory.getShapes();
        for (Shape shape : list) {
            if (shape != null) {

                Log.d("Drawing", "Drawing shape: " + shape.toString());
                shape.draw(canvas);
            }
        }}
        else if (shape != null&&move) {

            Log.d("Drawing", "Drawing shape: " + shape.toString());
            shape.draw(canvas);
        }

    }

}

