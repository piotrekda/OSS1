package com.example.piotr.oss.Testy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.piotr.oss.R;
import com.example.piotr.oss.Testy.Common.CustomAdapter;
import com.example.piotr.oss.Testy.DbHelper.DbHelper;
import com.example.piotr.oss.Testy.Model.Ranking;

import java.util.List;

public class Score extends AppCompatActivity {

    private static final String EXTRA_DB_NAME = "DB_NAME";

    ListView lstView;
    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String dbName = getIntent().getStringExtra(EXTRA_DB_NAME);

        Back = (ImageView) findViewById(R.id.Back);

        lstView = (ListView) findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this, dbName);
        List<Ranking> lstRanking = db.getRanking();
        if (lstRanking.size() > 0) {
            CustomAdapter adapter = new CustomAdapter(this, lstRanking);
            lstView.setAdapter(adapter);
        }

        Back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);
                finish();
            }
        });
    }

    static void start(Context context, String dbName) {
        Intent intent = new Intent(context, Score.class);
        intent.putExtra(EXTRA_DB_NAME, dbName);
        context.startActivity(intent);
    }
}
