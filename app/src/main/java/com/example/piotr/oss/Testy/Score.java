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

    private static final String EXTRA_FIELD = "FIELD";

    ListView lstView;
    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final String field = getIntent().getStringExtra(EXTRA_FIELD);

        Back = (ImageView) findViewById(R.id.Back);

        lstView = (ListView) findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this, field);
        List<Ranking> lstRanking = db.getRanking();
        if (lstRanking.size() > 0) {
            CustomAdapter adapter = new CustomAdapter(this, lstRanking);
            lstView.setAdapter(adapter);
        }

        final Context context = this;
        Back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test.start(context, field);
            }
        });
    }

    static void start(Context context, String field) {
        Intent intent = new Intent(context, Score.class);
        intent.putExtra(EXTRA_FIELD, field);
        context.startActivity(intent);
    }
}
