package com.example.piotr.oss.Testy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.piotr.oss.R;
import com.example.piotr.oss.Testy.Common.Common;
import com.example.piotr.oss.Testy.DbHelper.DbHelper;

import java.io.IOException;

public class Test1 extends AppCompatActivity {

    private static final String EXTRA_DB_NAME = "DB_NAME";

    SeekBar seekBar;
    TextView txtMode;
    Button btnPlay, btnScore;
    DbHelper db;
    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final String dbName = getIntent().getStringExtra(EXTRA_DB_NAME);

        ImageView background = findViewById(R.id.lungs);
        Drawable image = getResources().getDrawable(R.drawable.heart);
        background.setImageDrawable(image);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        txtMode = (TextView) findViewById(R.id.txtMode);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnScore = (Button) findViewById(R.id.btnScore);
        Back = (ImageView) findViewById(R.id.Back);


        db = new DbHelper(this, dbName);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Event
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0)
                    txtMode.setText("5 pytań".toString());
                else if (progress == 1)
                    txtMode.setText("15 pytań".toString());
                else if (progress == 2)
                    txtMode.setText("25 pytań".toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final Context context = this;
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Playing1.start(context, getPlayMode(), dbName);
                finish();
            }
        });
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Score.start(context, dbName);
                finish();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StrefaTestu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getPlayMode() {
        if (seekBar.getProgress() == 0)
            return Common.MODE.EASY.toString();
        else if (seekBar.getProgress() == 1)
            return Common.MODE.MEDIUM.toString();
        else if (seekBar.getProgress() == 2)
            return Common.MODE.HARD.toString();

        return null;
    }

    static void start(Context context, String dbName) {
        Intent intent = new Intent(context, Test1.class);
        intent.putExtra(EXTRA_DB_NAME, dbName);
        context.startActivity(intent);
    }
}
