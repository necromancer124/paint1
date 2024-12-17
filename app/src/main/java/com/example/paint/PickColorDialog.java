package com.example.paint;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PickColorDialog extends Dialog {
private int[] colors;

    public int getSavedColor() {
        return savedColor;
    }

    private int savedColor;
    public PickColorDialog(@NonNull Context context) {
        super(context);
    }
    public void init()
    {
        this.setContentView(R.layout.dialog_layout);
        colors = new int[]{0xFF7F50,0xFFD700,0xFF0000,0x00FFFF,0xB266FF,0x994C00
        ,0x00FF00,0x800000,0x4B0082,0x708090,0xD2B48C,0x8B4513};
        savedColor = 0xFF000000;
        SeekBar red = findViewById(R.id.red);
        SeekBar green = findViewById(R.id.green);
        SeekBar blue = findViewById(R.id.blue);
        Button save=  findViewById(R.id.save);
        Button cancel =  findViewById(R.id.cancel);
        TextView circle = findViewById(R.id.circle);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedColor = circle.getBackgroundTintList().getDefaultColor();
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColor(progress,green.getProgress(),blue.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColor(red.getProgress(),progress,blue.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setColor(red.getProgress(),green.getProgress(),progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        for (int i = 0; i <12 ; i++) {
            int id = this.getContext().getResources().getIdentifier("button" + (i+1), "id", getContext().getPackageName());
            final Button b = findViewById(id);
            b.setBackgroundTintList(ColorStateList.valueOf(colors[i]));
            final int index = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int c = colors[index];
                    setColor(Color.red(c),Color.green(c),Color.blue(c));
                    red.setProgress(Color.red(c));
                    green.setProgress(Color.green(c));
                    blue.setProgress(Color.blue(c));
                }
            });
        }
    }
    public void setColor(int r,int g, int b)
    {
        TextView circle = findViewById(R.id.circle);
        ColorStateList csl = ColorStateList.valueOf(Color.rgb(r,g,b));
        circle.setBackgroundTintList(csl);
    }




}

