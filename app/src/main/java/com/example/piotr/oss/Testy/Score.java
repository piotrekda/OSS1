package com.example.piotr.oss.Testy;


import android.widget.ImageView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.content.Intent;
import com.example.piotr.oss.Testy.Common.CustomAdapter;
import com.example.piotr.oss.Testy.DbHelper.DbHelper;
import com.example.piotr.oss.Testy.Model.Ranking;
import com.example.piotr.oss.R;

import java.util.List;

public class Score extends AppCompatActivity {



    ListView lstView;
    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Back = (ImageView)findViewById(R.id.Back);

        lstView = (ListView)findViewById(R.id.lstRanking);
        DbHelper db = new DbHelper(this);
        List<Ranking> lstRanking = db.getRanking();
        if(lstRanking.size() > 0)
        {
            CustomAdapter adapter = new CustomAdapter(this,lstRanking);
            lstView.setAdapter(adapter);
        }

          Back.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Test.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
