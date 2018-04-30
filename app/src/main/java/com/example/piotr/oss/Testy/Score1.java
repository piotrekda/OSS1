package com.example.piotr.oss.Testy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.piotr.oss.Testy.Common.CustomAdapter;

import com.example.piotr.oss.Testy.DbHelper.DbHelper;
import com.example.piotr.oss.Testy.Model.Ranking;
import com.example.piotr.oss.R;

import java.util.List;

public class Score1 extends AppCompatActivity {

    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        lstView = (ListView)findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this, "MyDB1.db");
        List<Ranking> lstRanking = db.getRanking();
        if(lstRanking.size() > 0)
        {
            CustomAdapter adapter = new CustomAdapter(this,lstRanking);
            lstView.setAdapter(adapter);
        }
    }
}
