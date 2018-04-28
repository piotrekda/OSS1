package com.example.piotr.oss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.piotr.oss.Common.CustomAdapter;
import com.example.piotr.oss.DbHelper.DbHelper;
import com.example.piotr.oss.Model.Ranking;

import java.util.List;

public class Score extends AppCompatActivity {

    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        lstView = (ListView)findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this);
        List<Ranking> lstRanking = db.getRanking();
        if(lstRanking.size() > 0)
        {
            CustomAdapter adapter = new CustomAdapter(this,lstRanking);
            lstView.setAdapter(adapter);
        }
    }
}
