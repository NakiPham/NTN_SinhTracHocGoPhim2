package com.example.keystrokedynamics;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Random;

/**
 * Created by hp on 23/11/2017.
 */

import java.util.Random;

public class trainingActivity {
    Context con;
    double input_layer[];
    int global_hopphap_count, global_bathopphap_count ;
    public trainingActivity(Context con){
        this.con = con;
        global_hopphap_count = 0;
        global_bathopphap_count = 0;
    }
    public void performTraining(){
        Log.e("Training : ",  "Training started");

        DBHelper mydbhelper = new DBHelper(con, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        Cursor cur_hopphap=mydatabase.rawQuery("SELECT * from " + Database.TABLE_NAME, null);
        int count_hopphap = cur_hopphap.getCount();

        Cursor cur_bathopphap=mydatabase.rawQuery("SELECT * from " + Database.BAT_HOP_PHAP_TABLE_NAME, null);
        int count_bathopphap = cur_bathopphap.getCount();
        count_bathopphap=0;
        while(count_hopphap != 0 || count_bathopphap != 0){
            Random r = new Random();
            int r_hopphap = r.nextInt(6);
            int r_bathopphap = r.nextInt(4);
            if(count_hopphap < r_hopphap)
                r_hopphap = count_hopphap;
            if(count_bathopphap < r_bathopphap)
                r_bathopphap = count_bathopphap;
            int random = r.nextInt(2);
            startLegitimateTraining();
            global_hopphap_count++;
            /*if(random == 1) {
                for (int i = 0; i < r_hopphap; i++) {
                    starthopphapTraining();
                    global_hopphap_count++;
                }
                for (int i = 0; i < r_bathopphap; i++) {
                    startbathopphapTraining();
                    global_bathopphap_count++;
                }
            }else{
                for (int i = 0; i < r_bathopphap; i++) {
                    startbathopphapTraining();
                    global_bathopphap_count++;
                }
                for (int i = 0; i < r_hopphap; i++) {
                    starthopphapTraining();
                    global_hopphap_count++;
                }
            }
            */
            count_hopphap = count_hopphap - r_hopphap;
            //count_bathopphap = count_bathopphap - r_bathopphap;
        }
    }

    private void startbathopphapTraining() {
        Log.e("Training : ",  "bathopphap Training started");

        errorbackPropagation e=new errorbackPropagation(con);
        e.initialiseHiddenLayer();
        e.initialiseInputLayer();
        e.initialiseOutputLayer();
        e.initialiseTargetOutput();
        e.setIllegitimatetargetOutput();
        e.initialiseWeightsAndBias();
        e.initialiseChangeInWeightsAndBias();
        e.initialiseError();
        e.initialiseInputForHiddenLayer();
        e.initialiseInputForOutputLayer();
        DBHelper mydbhelper=new DBHelper(con,Database.KEYSTROKE_DYNAMICS,null,Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        Cursor cur=mydatabase.rawQuery("SELECT * from " + DatabaseNetwork.NETWORK_TABLE_NAME, null);
        int count = cur.getCount();
        if(count!=0){
            e.getFinalWeightsFromInputToHidden(con);
            e.getFinalWeightsFromHiddenToOutput();
            //e.getFinalBiasHidden();
            //e.getFinalBiasOutput();
        }else{
            e.randomizeWeights();
        }
        input_layer=new double[45];
        setbathopphapInputLayer();
        e.getInputLayer(input_layer);
        e.functionHiddenLayer();
        e.functionOutputLayer();
        e.functionErrorOutputLayer();
        e.functionChangeInWeightsHiddenToOutput();
        e.functionErrorHiddenLayer();
        e.functionChangeInWeightsInputToHidden();
        e.updateWeights();
        e.setFinalWeightsFromInputToHidden(con);
        e.setFinalWeightsFromHiddenToOutput();
        //e.setFinalBiasHidden();
        //e.setFinalBiasOutput();
        e.setError();
        e.getTotalmeanSquareError();
    }

    private void setbathopphapInputLayer() {
        DBHelper mydbhelper=new DBHelper(con,Database.KEYSTROKE_DYNAMICS,null,Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        String []col=new String[]{
                Database.b1_x,Database.b1_y,
                Database.b2_x,Database.b2_y,
                Database.b3_x,Database.b3_y,
                Database.b4_x,Database.b4_y,
                Database.b5_x,Database.b5_y,
                Database.b6_x,Database.b6_y,
                Database.b1_size, Database.b2_size,
                Database.b3_size, Database.b4_size,
                Database.b5_size, Database.b6_size,
                Database.b1_apluc,Database.b2_apluc,
                Database.b3_apluc,Database.b4_apluc,
                Database.b5_apluc,Database.b6_apluc,
                Database.p1_GIU,Database.p2_GIU,
                Database.p3_GIU,Database.p4_GIU,
                Database.p5_GIU,Database.p6_GIU,
                Database.p1_p2_BAY,
                Database.p2_p3_BAY,
                Database.p3_p4_BAY,
                Database.p4_p5_BAY,
                Database.p5_p6_BAY,
                Database.p1_p2_tgBA,
                Database.p2_p3_tgBA,
                Database.p3_p4_tgBA,
                Database.p4_p5_tgBA,
                Database.p1_p2_tgDOI,
                Database.p2_p3_tgDOI,
                Database.p3_p4_tgDOI,
                Database.p4_p5_tgDOI,
                Database.p5_p6_tgDOI,
                Database.tong_THOIGIAN
        };
        Cursor c=mydatabase.query(Database.BAT_HOP_PHAP_TABLE_NAME,col,null,null,null,null,null);
        c.moveToPosition(global_bathopphap_count);
        for(int i=0,q=0;i<45;i++) {
            input_layer[i] = Double.parseDouble(c.getString(q++));
        }
        String print="";
        for(int i=0;i<45;i++)
            print+=input_layer[i]+",";

        Log.e("Bất hợp pháp : ", print);
    }

    private void startLegitimateTraining() {
        Log.e("Training : ",  "Đào tạo hợp pháp bắt đầu");

        errorbackPropagation e=new errorbackPropagation(con);
        Log.e("Training : ",  "Đào tạo started 1 ");

        e.initialiseHiddenLayer();
        e.initialiseInputLayer();
        e.initialiseOutputLayer();
        e.initialiseTargetOutput();
        e.setHopphaptargetOutput();
        e.initialiseWeightsAndBias();
        e.initialiseChangeInWeightsAndBias();
        e.initialiseError();
        e.initialiseInputForHiddenLayer();
        e.initialiseInputForOutputLayer();

        Log.e("Training : ", "Đào tạo started 2");

        DBHelper mydbhelper=new DBHelper(con,Database.KEYSTROKE_DYNAMICS,null,Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        Cursor cur=mydatabase.rawQuery("SELECT * from " + DatabaseNetwork.NETWORK_TABLE_NAME, null);
        int count = cur.getCount();
        if(count!=0){
            e.getFinalWeightsFromInputToHidden(con);
            e.getFinalWeightsFromHiddenToOutput();
            //e.getFinalBiasHidden();
            //e.getFinalBiasOutput();
        }else{
            e.randomizeWeights();
            Log.e("Training : ", "Đào tạo started 3");

        }
        input_layer=new double[45];
        setLegitimateInputLayer();
        e.getInputLayer(input_layer);
        e.functionHiddenLayer();
        e.functionOutputLayer();
        e.functionErrorOutputLayer();
        e.functionChangeInWeightsHiddenToOutput();
        e.functionErrorHiddenLayer();
        e.functionChangeInWeightsInputToHidden();
        e.updateWeights();
        e.setFinalWeightsFromInputToHidden(con);
        e.setFinalWeightsFromHiddenToOutput();
        //e.setFinalBiasHidden();
        //e.setFinalBiasOutput();
        //e.setError();
        //e.getTotalmeanSquareError();
        Log.e("Training : ",  "Đào tạo started 4");

    }

    private void setLegitimateInputLayer() {
        DBHelper mydbhelper=new DBHelper(con,Database.KEYSTROKE_DYNAMICS,null,Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        String []col=new String[]{
                Database.b1_x,Database.b1_y,
                Database.b2_x,Database.b2_y,
                Database.b3_x,Database.b3_y,
                Database.b4_x,Database.b4_y,
                Database.b5_x,Database.b5_y,
                Database.b6_x,Database.b6_y,
                Database.b1_size, Database.b2_size,
                Database.b3_size, Database.b4_size,
                Database.b5_size, Database.b6_size,
                Database.b1_apluc,Database.b2_apluc,
                Database.b3_apluc,Database.b4_apluc,
                Database.b5_apluc,Database.b6_apluc,
                Database.p1_GIU,Database.p2_GIU,
                Database.p3_GIU,Database.p4_GIU,
                Database.p5_GIU,Database.p6_GIU,
                Database.p1_p2_BAY,
                Database.p2_p3_BAY,
                Database.p3_p4_BAY,
                Database.p4_p5_BAY,
                Database.p5_p6_BAY,
                Database.p1_p2_tgBA,
                Database.p2_p3_tgBA,
                Database.p3_p4_tgBA,
                Database.p4_p5_tgBA,
                Database.p1_p2_tgDOI,
                Database.p2_p3_tgDOI,
                Database.p3_p4_tgDOI,
                Database.p4_p5_tgDOI,
                Database.p5_p6_tgDOI,
                Database.tong_THOIGIAN
        };
        Cursor c=mydatabase.query(Database.TABLE_NAME,col,null,null,null,null,null);
        c.moveToPosition(global_hopphap_count);
        for(int i=0,q=0;i<45;i++){
            input_layer[i]=Double.parseDouble(c.getString(q++));
        }
        String print="";
        for(int i=0;i<45;i++)
            print+=input_layer[i]+",";

        Log.e("Hợp pháp : ", print);

    }
}


