package com.example.piotr.oss.Testy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.piotr.oss.Testy.DbHelper.DbHelper;
import com.example.piotr.oss.R;


public class Done extends AppCompatActivity {

    Button btnTryAgain;
    TextView txtResultScore, txtResultQuestion;
    ProgressBar progressBarResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        DbHelper db = new DbHelper(this, "MyDB.db");


        txtResultScore = (TextView) findViewById(R.id.txtTotalScore);
        txtResultQuestion = (TextView) findViewById(R.id.txtTotalQuestion);
        progressBarResult = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);
                finish();
            }
        });


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int score = extra.getInt("SCORE");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            //Update 2.0
            int playCount = 0;
            if(totalQuestion == 5) // EASY MODE
            {
                playCount = db.getPlayCount(0);
                playCount++;
                db.updatePlayCount(0,playCount); // Set PlayCount ++
            }
            else if(totalQuestion == 15) // MEDIUM MODE
            {
                playCount = db.getPlayCount(1);
                playCount++;
                db.updatePlayCount(1,playCount); // Set PlayCount ++
            }
            else if(totalQuestion == 25) // HARD MODE
            {
                playCount = db.getPlayCount(2);
                playCount++;
                db.updatePlayCount(2,playCount); // Set PlayCount ++
            }


            double subtract = (playCount-1); //-1 because we playCount++ before we calculate result
            double finalScore = score - subtract;

            txtResultScore.setText(String.format("Wynik : %.1f (-%d)", finalScore,(playCount-1)));
            txtResultQuestion.setText(String.format("Prawidłowych : %d/%d", correctAnswer, totalQuestion));

            progressBarResult.setMax(totalQuestion);
            progressBarResult.setProgress(correctAnswer);

            //save score
            db.insertScore(finalScore);
        }
    }
}
