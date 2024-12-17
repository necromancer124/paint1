package com.example.paint;

import androidx.annotation.NonNull;

import com.example.paint.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeHistory {
    private List<Shape> history = new ArrayList<>();

    public void addShape(Shape shape) {
        history.add(shape);
    }

    public void removeLastShape() {
        if (history.size() > 0) {
            history.remove(history.size() - 1);
        }
    }

    public List<Shape> getShapes() {
        return history;
    }

    public void clearHistory() {
        history.clear();
    }



    public String toString() {
        return history.toString();
    }
}