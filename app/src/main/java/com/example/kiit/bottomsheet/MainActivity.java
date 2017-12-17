package com.example.kiit.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button expand,collapse,hide,show;
    BottomSheetBehavior mbottomSheetBehavior;
    TextView t1;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expand= (Button) findViewById(R.id.button);
        collapse= (Button) findViewById(R.id.button2);
        hide= (Button) findViewById(R.id.button3);
        show=(Button)findViewById(R.id.button4);
        t1= (TextView) findViewById(R.id.text);
        expand.setOnClickListener(this);
        collapse.setOnClickListener(this);
        hide.setOnClickListener(this);
        show.setOnClickListener(this);
        View bsm=findViewById(R.id.bsml);
        mbottomSheetBehavior=BottomSheetBehavior.from(bsm);
        mbottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState==mbottomSheetBehavior.STATE_EXPANDED)
                {
                 t1.setText("COLLAPSE");
                    flag=1;
                }
                else
                    if (newState==mbottomSheetBehavior.STATE_COLLAPSED)
                    {
                        t1.setText("EXPAND");
                        flag=0;
                    }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.text:
                if (flag==0)
                {
                    mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else if (flag==1)
                {
                    mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                break;
            case R.id.button2:
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.button3:
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            default:
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
        }

    }
}
