package com.piotrek.piotr.oss.Testy.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.piotrek.piotr.oss.Testy.Common.Common;
import com.piotrek.piotr.oss.Testy.Model.Question;
import com.piotrek.piotr.oss.Testy.Model.Ranking;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private SQLiteDatabase mDataBase;
    private Context mContext = null;

    public DbHelper(Context context, String field) {
        super(context, field + ".db", null, 1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        File file = new File(DB_PATH + getDatabaseName());
        if (file.exists())
            openDataBase(); // Add this line to fix db.insert can't insert values
        this.mContext = context;
    }

    public void openDataBase() {
        String myPath = DB_PATH + getDatabaseName();
        mDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void copyDataBase() throws IOException {
        try {
            InputStream myInput = mContext.getAssets().open(getDatabaseName());
            String outputFileName = DB_PATH + getDatabaseName();
            OutputStream myOutput = new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0)
                myOutput.write(buffer, 0, length);

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase tempDB = null;
        try {
            String myPath = DB_PATH + getDatabaseName();
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (tempDB != null)
            tempDB.close();
        return tempDB != null ? true : false;
    }

    public void createDataBase() throws IOException {
        boolean isDBExists = checkDataBase();
        if (isDBExists) {

        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //CRUD For Table
    public List<Question> getAllQuestion() {
        List<Question> listQuestion = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Question ORDER BY Random()", null);
            if (c == null) return null;
            c.moveToFirst();
            do {
                int Id = c.getInt(c.getColumnIndex("ID"));
                String Image = c.getString(c.getColumnIndex("Image"));
                String Questiona = c.getString(c.getColumnIndex("Questiona"));
                String AnswerA = c.getString(c.getColumnIndex("AnswerA"));
                String AnswerB = c.getString(c.getColumnIndex("AnswerB"));
                String AnswerC = c.getString(c.getColumnIndex("AnswerC"));
                String AnswerD = c.getString(c.getColumnIndex("AnswerD"));
                String CorrectAnswer = c.getString(c.getColumnIndex("CorrectAnswer"));
                String Sound = c.getString(c.getColumnIndex("Sound"));

                Question question = new Question(Id, Image, Questiona, AnswerA, AnswerB, AnswerC, AnswerD, CorrectAnswer, Sound);
                listQuestion.add(question);
            }
            while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return listQuestion;
    }

    //We need improve this function to optimize process from Playing
    public List<Question> getQuestionMode(String mode) {
        List<Question> listQuestion = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        int limit = 0;
        if (mode.equals(Common.MODE.EASY.toString()))
            limit = 5;
        else if (mode.equals(Common.MODE.MEDIUM.toString()))
            limit = 15;
        else if (mode.equals(Common.MODE.HARD.toString()))
            limit = 25;
        try {
            c = db.rawQuery(String.format("SELECT * FROM Question ORDER BY Random() LIMIT %d", limit), null);
            if (c == null) return null;
            c.moveToFirst();
            do {
                int Id = c.getInt(c.getColumnIndex("ID"));
                String Image = c.getString(c.getColumnIndex("Image"));
                String Questiona = c.getString(c.getColumnIndex("Questiona"));
                String AnswerA = c.getString(c.getColumnIndex("AnswerA"));
                String AnswerB = c.getString(c.getColumnIndex("AnswerB"));
                String AnswerC = c.getString(c.getColumnIndex("AnswerC"));
                String AnswerD = c.getString(c.getColumnIndex("AnswerD"));
                String CorrectAnswer = c.getString(c.getColumnIndex("CorrectAnswer"));
                String Sound = c.getString(c.getColumnIndex("Sound"));

                Question question = new Question(Id, Image, Questiona, AnswerA, AnswerB, AnswerC, AnswerD, CorrectAnswer, Sound);
                listQuestion.add(question);
            }
            while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return listQuestion;
    }

    //Insert Score to Ranking table
    public void insertScore(double score) {
        String query = "INSERT INTO Ranking(Score) VALUES(" + score + ")";
        mDataBase.execSQL(query);
    }

    //Get Score and sort ranking
    public List<Ranking> getRanking() {
        List<Ranking> listRanking = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM Ranking Order By Score DESC;", null);
            if (c == null) return null;
            c.moveToNext();
            do {
                int Id = c.getInt(c.getColumnIndex("Id"));
                double Score = c.getDouble(c.getColumnIndex("Score"));

                Ranking ranking = new Ranking(Id, Score);
                listRanking.add(ranking);
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return listRanking;

    }


    //Update version 2.0
    public int getPlayCount(int level) {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT PlayCount FROM UserPlayCount WHERE Level=" + level + ";", null);
            if (c == null) return 0;
            c.moveToNext();
            do {
                result = c.getInt(c.getColumnIndex("PlayCount"));
            } while (c.moveToNext());
            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void updatePlayCount(int level, int playCount) {
        String query = String.format("UPDATE UserPlayCount Set PlayCount = %d WHERE Level = %d", playCount, level);
        mDataBase.execSQL(query);
    }
}
