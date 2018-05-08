package com.piotrek.piotr.oss.Testy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.piotrek.piotr.oss.CommonKt;
import com.piotrek.piotr.oss.R;
import com.piotrek.piotr.oss.Testy.Common.CustomAdapter;
import com.piotrek.piotr.oss.Testy.DbHelper.DbHelper;
import com.piotrek.piotr.oss.Testy.Model.Ranking;

import java.util.List;

public class Score extends AppCompatActivity {

    private static final String EXTRA_FIELD = "FIELD";

    ListView lstView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        CommonKt.setUpActionBar(this);

        final String field = getIntent().getStringExtra(EXTRA_FIELD);



        lstView = (ListView) findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this, field);
        List<Ranking> lstRanking = db.getRanking();
        if (lstRanking.size() > 0) {
            CustomAdapter adapter = new CustomAdapter(this, lstRanking);
            lstView.setAdapter(adapter);
        }

        final Context context = this;

    }

    static void start(Context context, String field) {
        Intent intent = new Intent(context, Score.class);
        intent.putExtra(EXTRA_FIELD, field);
        context.startActivity(intent);
    }
}
