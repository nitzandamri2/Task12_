package com.example.task12_;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    LinearLayout gameLayout, resultsLayout;
    Button btnBlue, btnRed, btnResults, btnBack;
    TextView tvBlueScore, tvRedScore, tvWinner;
    int blueScore = 0;
    int redScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameLayout = findViewById(R.id.gameLayout);
        resultsLayout = findViewById(R.id.resultsLayout);
        btnBlue = findViewById(R.id.btnBlue);
        btnRed = findViewById(R.id.btnRed);
        btnResults = findViewById(R.id.btnResults);
        btnBack = findViewById(R.id.btnBack);
        tvBlueScore = findViewById(R.id.tvBlueScore);
        tvRedScore = findViewById(R.id.tvRedScore);
        tvWinner = findViewById(R.id.tvWinner);

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueScore = blueScore + 1;
            }
        });

        btnRed.setOnLongClickListener(this);

        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBlueScore.setText("ניקוד כחול: " + blueScore);
                tvRedScore.setText("ניקוד אדום: " + redScore);

                if (blueScore > redScore) {
                    tvWinner.setText("המנצח הוא הכחול!");
                } else if (redScore > blueScore) {
                    tvWinner.setText("המנצח הוא האדום!");
                } else {
                    tvWinner.setText("תיקו!");
                }

                gameLayout.setVisibility(View.GONE);
                resultsLayout.setVisibility(View.VISIBLE);
            }
        });


}