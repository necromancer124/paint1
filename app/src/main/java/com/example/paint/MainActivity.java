package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private MyView myView;
        private Button shapeButton;
        private Button colourButton;
        private Dialog shapedialog;
        private Paint paint=new Paint();
    private PickColorDialog d;
        private int engles=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView=findViewById(R.id.myView);
        myView.setFocusable(true);
        myView.setClickable(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        myView.setShape(new MyLine(), paint);
        Log.d("viewSetup","line insert");
        shapeButton=findViewById(R.id.buttonShapes);
        shapedialog=new Dialog(this);
        shapedialog.setContentView(R.layout.shape_choice);
        shapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = findViewById(R.id.buttonColors);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.show();
                    }
                });
            Button buttonLine=shapedialog.findViewById(R.id.buttonLine);
            Button buttonPath=shapedialog.findViewById(R.id.buttonPath);
            Button buttonRec=shapedialog.findViewById(R.id.buttonRec);
            Button buttonRound=shapedialog.findViewById(R.id.buttonRound);
            Button buttonPoliglov=shapedialog.findViewById(R.id.buttonPoliglob);
                TextView textView=shapedialog.findViewById(R.id.NumOfEngles);
                SeekBar seekBar=shapedialog.findViewById(R.id.seekBar);
                seekBar.setMin(3);
                seekBar.setMax(8);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    engles=progress;
                    textView.setText(engles+"");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        buttonPoliglov.callOnClick();
                    }
                });
            buttonLine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myView.setShape(new MyLine(),paint);
                }
            });
            buttonPoliglov.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myView.setShape(new Poligob(engles),paint);
                }
            });
            buttonRec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myView.setShape(new MyRect(),paint);
                }
            });
            buttonRound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myView.setShape(new Round(),paint);
                }
            });
            buttonPath.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set up the path here
                }
            });

            shapedialog.show();
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();

        d = new PickColorDialog(this);
        d.init();
        d.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
               paint.setColor(d.getSavedColor());
            }
        });
    }

}