package com.piotrek.piotr.oss.Testy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.piotrek.piotr.oss.R;
import com.piotrek.piotr.oss.Testy.DbHelper.DbHelper;


public class Done extends AppCompatActivity {

    private static final String EXTRA_FIELD = "FIELD";
    private static final String EXTRA_SCORE = "SCORE";
    private static final String EXTRA_TOTAL = "TOTAL";
    private static final String EXTRA_CORRECT = "CORRECT";

    Button btnTryAgain;
    TextView txtResultScore, txtResultQuestion;
    ProgressBar progressBarResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);


        final String field = getIntent().getStringExtra(EXTRA_FIELD);
        DbHelper db = new DbHelper(this, field);


        txtResultScore = (TextView) findViewById(R.id.txtTotalScore);
        txtResultQuestion = (TextView) findViewById(R.id.txtTotalQuestion);
        progressBarResult = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        final Context context = this;
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test.start(context, field);
                finish();
            }
        });


        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            int score = extra.getInt(EXTRA_SCORE);
            int totalQuestion = extra.getInt(EXTRA_TOTAL);
            int correctAnswer = extra.getInt(EXTRA_CORRECT);

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
            double finalScore = score + subtract;

            txtResultScore.setText(String.format("Wynik : %.1f (+%d)", finalScore,(playCount-1)));
            txtResultQuestion.setText(String.format("Prawidłowych : %d/%d", correctAnswer, totalQuestion));

            progressBarResult.setMax(totalQuestion);
            progressBarResult.setProgress(correctAnswer);

            //save score
            db.insertScore(finalScore);
        }
    }

    static void start(Context context, String field, int score, int total, int correct) {
        Intent intent = new Intent(context, Done.class);
        intent.putExtra(EXTRA_FIELD, field);
        intent.putExtra(EXTRA_SCORE, score);
        intent.putExtra(EXTRA_TOTAL, total);
        intent.putExtra(EXTRA_CORRECT, correct);
        context.startActivity(intent);
    }
}
