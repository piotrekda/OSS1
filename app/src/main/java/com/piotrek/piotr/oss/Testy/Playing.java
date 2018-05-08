package com.piotrek.piotr.oss.Testy;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.piotrek.piotr.oss.Testy.DbHelper.DbHelper;
import com.piotrek.piotr.oss.Testy.Model.Question;
import com.piotrek.piotr.oss.R;

import java.util.ArrayList;
import java.util.List;

import static android.app.ProgressDialog.show;

public class Playing extends AppCompatActivity implements View.OnClickListener {

    private static final String EXTRA_MODE = "MODE";
    private static final String EXTRA_FIELD = "FIELD";

    int progressValue = 0;

    CountDownTimer mCountDown; // for progressbar
    List<Question> questionPlay = new ArrayList<>(); //total Question
    DbHelper db;
    int index = 0, score = 0, thisQuestion = 0, totalQuestion, correctAnswer;
    String mode = "";

    //Control
    ProgressBar progressBar;
    ImageView imageView;
    Button btnA, btnB, btnC, btnD;
    TextView txtScore, txtQuestion;
    TextView questiona;
    MediaPlayer mySound;
    String field;
    ImageView button_play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        makeInitialization();




    }

    private void makeInitialization() {
        initFields();
        initViews();
        setUpButtons();

        mCountDown = new CountDownTimer(40000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(progressValue);
                progressValue++;
            }

            @Override
            public void onFinish() {
                mCountDown.cancel();
                showQuestion(++index);
            }
        };
        showQuestion(index);
    }

    private void initFields() {
        mode = getIntent().getStringExtra(EXTRA_MODE);
        field = getIntent().getStringExtra(EXTRA_FIELD);
        db = new DbHelper(this, field);
        questionPlay = db.getQuestionMode(mode);
        totalQuestion = questionPlay.size();
    }

    private void initViews() {
        questiona = findViewById(R.id.question);
        txtScore = findViewById(R.id.txtScore);
        txtQuestion = findViewById(R.id.txtQuestion);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.button_play);
        btnA = findViewById(R.id.btnAnswerA);
        btnB = findViewById(R.id.btnAnswerB);
        btnC = findViewById(R.id.btnAnswerC);
        btnD = findViewById(R.id.btnAnswerD);
        button_play = findViewById(R.id.button_play);
    }

    private void setUpButtons() {
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tryToSetUpAudio(index);
        button_play.setImageResource(R.drawable.e10);
    }

    @Override
    protected void onPause() {
        super.onPause();
        tryToReleaseAudio();
        button_play.setImageResource(R.drawable.e10);
    }

    private void showQuestion(int index) {
        if (index < totalQuestion) {
            thisQuestion++;
            txtQuestion.setText(String.format("%d/%d", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue = 0;

            tryToSetUpAudio(index);

            String ImageId = questionPlay.get(index).getImage();

            if (ImageId.equals("b")) {
                imageView.setVisibility(View.GONE);
            } else {
                imageView.setVisibility(View.VISIBLE);
            }

            questiona.setText(questionPlay.get(index).getQuestiona());
            btnA.setText(questionPlay.get(index).getAnswerA());
            btnB.setText(questionPlay.get(index).getAnswerB());
            btnC.setText(questionPlay.get(index).getAnswerC());
            btnD.setText(questionPlay.get(index).getAnswerD());

            mCountDown.start();
        } else {
            Done.start(this, field, score, totalQuestion, correctAnswer);
            finish();
        }
    }

    private void tryToSetUpAudio(int index) {
        int soundId = getResourceId(questionPlay.get(index).getSound(), "raw", getPackageName());
        if (soundId != 0) {
            mySound = MediaPlayer.create(this, soundId);
        }

    }



    public int getResourceId(String pVariableName, String pResourcename, String pPackageName) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void playMusic(View view) {
        if (mySound.isPlaying()) {
            mySound.pause();
            button_play.setImageResource(R.drawable.e10);
        } else {
            mySound.start();
            button_play.setImageResource(R.drawable.e101);
        }



        }




    @Override
    public void onClick(View v) {
        tryToReleaseAudio();
        mCountDown.cancel();
        button_play.setImageResource(R.drawable.e10);
        if (index < totalQuestion) {
            Button clickedButton = (Button) v;
            if (clickedButton.getText().equals(questionPlay.get(index).getCorrectAnswer())) {
                score += 10; // increase score
                correctAnswer++; //increase correct answer
                showQuestion(++index);
            } else
                showQuestion(++index); // If choose right , just go to next question

            txtScore.setText(String.format("%d", score));
        }

    }

    private void tryToReleaseAudio() {
        if (mySound != null) {
            mySound.release();
            button_play.setImageResource(R.drawable.e10);
        }
    }

    static void start(Context context, String mode, String field) {
        Intent intent = new Intent(context, Playing.class);
        intent.putExtra(EXTRA_MODE, mode);
        intent.putExtra(EXTRA_FIELD, field);
        context.startActivity(intent);
    }



}

