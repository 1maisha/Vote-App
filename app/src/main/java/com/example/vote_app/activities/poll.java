package com.example.vote_app.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vote_app.R;

public class poll extends AppCompatActivity {
    SeekBar seekBar1,seekbar2,seekBar3,seekBar4;
    TextView candidate1,candidate2,candidate3,candidate4;
    TextView Cper1,Cper2,Cper3,Cper4;
    double count1 = 1, count2=1, count3=1, count4=1;
    boolean flag1= true, flag2 = true, flag3 = true, flag4=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_poll);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            seekBar1 = findViewById(R.id.seek_bar1);
            seekbar2 = findViewById(R.id.seek_bar2);
            seekBar3 = findViewById(R.id.seek_bar3);
            seekBar4 = findViewById(R.id.seek_bar4);

            candidate1 = findViewById(R.id.candidate1);
            candidate2 = findViewById(R.id.candidate2);
            candidate3 = findViewById(R.id.candidate3);
            candidate4 = findViewById(R.id.candidate4);

            Cper1 = findViewById(R.id.candidate_percent1);
            Cper2 = findViewById(R.id.candidate_percent2);
            Cper3 = findViewById(R.id.candidate_percent3);
            Cper4 = findViewById(R.id.candidate_percent4);

            seekBar1.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });

            candidate4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag1) {
                      count1=1;
                      count2 = 1;
                        count3 = 1;
                        count4++;
                        flag1 = true;
                        flag2=true;
                        flag3=true;
                        flag4=false;

                        calculatePercent();

                    }
                }

                private void calculatePercent() {
                    double total = count1 + count2 + count3 + count4;
                    double percent1 = (count1/total)*100;
                    double percent2 = (count2/total)*100;
                    double percent3 = (count3/total)*100;
                    double percent4 = (count4/total)*100;

                    Cper1.setText(String.format("%0.f%%",percent1));
                    seekBar1.setProgress((int) percent1);
                    Cper2.setText(String.format("%0.f%%",percent2));
                    seekbar2.setProgress((int) percent2);
                    Cper3.setText(String.format("%0.f%%",percent3));
                    seekBar3.setProgress((int) percent3);
                    Cper4.setText(String.format("%0.f%%",percent4));
                    seekBar4.setProgress((int) percent4);



                }


            });



        });
    }
}