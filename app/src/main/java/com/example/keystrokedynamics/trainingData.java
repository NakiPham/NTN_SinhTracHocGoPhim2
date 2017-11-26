package com.example.keystrokedynamics;


        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.Random;

/**
 * Created by hp on 23/11/2017.
 */

public class trainingData {

    Context con;
    double [] newinputset_add1,newinputset_add2,newinputset_sub1,newinputset_sub2;
    double [] bathopphapDataset_1,bathopphapDataset_2,bathopphapDataset_3,bathopphapDataset_4 ;
    public trainingData(Context con){
        this.con=con;
    }
    public void generateHopphapDataset(){
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
                Database.tong_THOIGIAN,


        };

        Cursor c=mydatabase.query(Database.TABLE_NAME,col,null,null,null,null,null);

        for(c.moveToLast();!c.isBeforeFirst();c.moveToPrevious()) {
            newinputset_add1 = new double[45];
            newinputset_sub1 = new double[45];
            newinputset_add2 = new double[45];
            newinputset_sub2 = new double[45];
            Random random = new Random();
            int add_sub;
            for(int j=0,i=0,q=0,k=0;j<45;j++,i++,k++,q++) {
                add_sub = random.nextInt(2);
                if(add_sub == 1)
                    newinputset_add1[i] = Double.parseDouble(c.getString(q)) + (0.01 * Double.parseDouble(c.getString(k)));
                else
                    newinputset_add1[i] = Double.parseDouble(c.getString(q)) - (0.01 * Double.parseDouble(c.getString(k)));

                add_sub = random.nextInt(2);
                if(add_sub == 1)
                    newinputset_sub1[i] = Double.parseDouble(c.getString(q)) - (0.02 * Double.parseDouble(c.getString(k)));
                else
                    newinputset_sub1[i] = Double.parseDouble(c.getString(q)) + (0.02 * Double.parseDouble(c.getString(k)));

                add_sub = random.nextInt(2);
                if(add_sub == 1)
                    newinputset_add2[i] = Double.parseDouble(c.getString(q)) + (0.03 * Double.parseDouble(c.getString(k)));
                else
                    newinputset_add2[i] = Double.parseDouble(c.getString(q)) - (0.03 * Double.parseDouble(c.getString(k)));

                add_sub = random.nextInt(2);
                if(add_sub == 1)
                    newinputset_sub2[i] = Double.parseDouble(c.getString(q)) - (0.04 * Double.parseDouble(c.getString(k)));
                else
                    newinputset_sub2[i] = Double.parseDouble(c.getString(q)) + (0.04 * Double.parseDouble(c.getString(k)));

            }
            putNewData();
        }
    }

    private void putNewData() {
        DBHelper mydbhelper = new DBHelper(con, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        int i=0;
        cv.put(Database.b1_x, newinputset_add1[i++]);
        cv.put(Database.b1_y, newinputset_add1[i++]);
        cv.put(Database.b2_x, newinputset_add1[i++]);
        cv.put(Database.b2_y, newinputset_add1[i++]);
        cv.put(Database.b3_x, newinputset_add1[i++]);
        cv.put(Database.b3_y, newinputset_add1[i++]);
        cv.put(Database.b4_x, newinputset_add1[i++]);
        cv.put(Database.b4_y, newinputset_add1[i++]);
        cv.put(Database.b5_x, newinputset_add1[i++]);
        cv.put(Database.b5_y, newinputset_add1[i++]);
        cv.put(Database.b6_x, newinputset_add1[i++]);
        cv.put(Database.b6_y, newinputset_add1[i++]);
        cv.put(Database.b1_size, newinputset_add1[i++]);
        cv.put(Database.b2_size, newinputset_add1[i++]);
        cv.put(Database.b3_size, newinputset_add1[i++]);
        cv.put(Database.b4_size, newinputset_add1[i++]);
        cv.put(Database.b5_size, newinputset_add1[i++]);
        cv.put(Database.b6_size, newinputset_add1[i++]);
        cv.put(Database.p1_GIU, newinputset_add1[i++]);
        cv.put(Database.p2_GIU, newinputset_add1[i++]);
        cv.put(Database.p3_GIU, newinputset_add1[i++]);
        cv.put(Database.p4_GIU, newinputset_add1[i++]);
        cv.put(Database.p5_GIU, newinputset_add1[i++]);
        cv.put(Database.p6_GIU, newinputset_add1[i++]);
        cv.put(Database.b1_apluc, newinputset_add1[i++]);
        cv.put(Database.b2_apluc, newinputset_add1[i++]);
        cv.put(Database.b3_apluc, newinputset_add1[i++]);
        cv.put(Database.b4_apluc, newinputset_add1[i++]);
        cv.put(Database.b5_apluc, newinputset_add1[i++]);
        cv.put(Database.b6_apluc, newinputset_add1[i++]);
        cv.put(Database.p1_p2_BAY, newinputset_add1[i++]);
        cv.put(Database.p2_p3_BAY, newinputset_add1[i++]);
        cv.put(Database.p3_p4_BAY, newinputset_add1[i++]);
        cv.put(Database.p4_p5_BAY, newinputset_add1[i++]);
        cv.put(Database.p5_p6_BAY, newinputset_add1[i++]);
        cv.put(Database.p1_p2_tgBA, newinputset_add1[i++]);
        cv.put(Database.p2_p3_tgBA, newinputset_add1[i++]);
        cv.put(Database.p3_p4_tgBA, newinputset_add1[i++]);
        cv.put(Database.p4_p5_tgBA, newinputset_add1[i++]);
        cv.put(Database.p1_p2_tgDOI, newinputset_add1[i++]);
        cv.put(Database.p2_p3_tgDOI, newinputset_add1[i++]);
        cv.put(Database.p3_p4_tgDOI, newinputset_add1[i++]);
        cv.put(Database.p4_p5_tgDOI, newinputset_add1[i++]);
        cv.put(Database.p5_p6_tgDOI, newinputset_add1[i++]);
        cv.put(Database.tong_THOIGIAN, newinputset_add1[i++]);

        long r = mydatabase.insertOrThrow(Database.TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, newinputset_sub1[i++]);
        cv.put(Database.b1_y, newinputset_sub1[i++]);
        cv.put(Database.b2_x, newinputset_sub1[i++]);
        cv.put(Database.b2_y, newinputset_sub1[i++]);
        cv.put(Database.b3_x, newinputset_sub1[i++]);
        cv.put(Database.b3_y, newinputset_sub1[i++]);
        cv.put(Database.b4_x, newinputset_sub1[i++]);
        cv.put(Database.b4_y, newinputset_sub1[i++]);
        cv.put(Database.b5_x, newinputset_sub1[i++]);
        cv.put(Database.b5_y, newinputset_sub1[i++]);
        cv.put(Database.b6_x, newinputset_sub1[i++]);
        cv.put(Database.b6_y, newinputset_sub1[i++]);
        cv.put(Database.b1_size, newinputset_sub1[i++]);
        cv.put(Database.b2_size, newinputset_sub1[i++]);
        cv.put(Database.b3_size, newinputset_sub1[i++]);
        cv.put(Database.b4_size, newinputset_sub1[i++]);
        cv.put(Database.b5_size, newinputset_sub1[i++]);
        cv.put(Database.b6_size, newinputset_sub1[i++]);
        cv.put(Database.p1_GIU, newinputset_sub1[i++]);
        cv.put(Database.p2_GIU, newinputset_sub1[i++]);
        cv.put(Database.p3_GIU, newinputset_sub1[i++]);
        cv.put(Database.p4_GIU, newinputset_sub1[i++]);
        cv.put(Database.p5_GIU, newinputset_sub1[i++]);
        cv.put(Database.p6_GIU, newinputset_sub1[i++]);
        cv.put(Database.b1_apluc, newinputset_sub1[i++]);
        cv.put(Database.b2_apluc, newinputset_sub1[i++]);
        cv.put(Database.b3_apluc, newinputset_sub1[i++]);
        cv.put(Database.b4_apluc, newinputset_sub1[i++]);
        cv.put(Database.b5_apluc, newinputset_sub1[i++]);
        cv.put(Database.b6_apluc, newinputset_sub1[i++]);
        cv.put(Database.p1_p2_BAY, newinputset_sub1[i++]);
        cv.put(Database.p2_p3_BAY, newinputset_sub1[i++]);
        cv.put(Database.p3_p4_BAY, newinputset_sub1[i++]);
        cv.put(Database.p4_p5_BAY, newinputset_sub1[i++]);
        cv.put(Database.p5_p6_BAY, newinputset_sub1[i++]);
        cv.put(Database.p1_p2_tgBA, newinputset_sub1[i++]);
        cv.put(Database.p2_p3_tgBA, newinputset_sub1[i++]);
        cv.put(Database.p3_p4_tgBA, newinputset_sub1[i++]);
        cv.put(Database.p4_p5_tgBA, newinputset_sub1[i++]);
        cv.put(Database.p1_p2_tgDOI, newinputset_sub1[i++]);
        cv.put(Database.p2_p3_tgDOI, newinputset_sub1[i++]);
        cv.put(Database.p3_p4_tgDOI, newinputset_sub1[i++]);
        cv.put(Database.p4_p5_tgDOI, newinputset_sub1[i++]);
        cv.put(Database.p5_p6_tgDOI, newinputset_sub1[i++]);
        cv.put(Database.tong_THOIGIAN, newinputset_sub1[i++]);

        r = mydatabase.insertOrThrow(Database.TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, newinputset_add2[i++]);
        cv.put(Database.b1_y, newinputset_add2[i++]);
        cv.put(Database.b2_x, newinputset_add2[i++]);
        cv.put(Database.b2_y, newinputset_add2[i++]);
        cv.put(Database.b3_x, newinputset_add2[i++]);
        cv.put(Database.b3_y, newinputset_add2[i++]);
        cv.put(Database.b4_x, newinputset_add2[i++]);
        cv.put(Database.b4_y, newinputset_add2[i++]);
        cv.put(Database.b5_x, newinputset_add2[i++]);
        cv.put(Database.b5_y, newinputset_add2[i++]);
        cv.put(Database.b6_x, newinputset_add2[i++]);
        cv.put(Database.b6_y, newinputset_add2[i++]);
        cv.put(Database.b1_size, newinputset_add2[i++]);
        cv.put(Database.b2_size, newinputset_add2[i++]);
        cv.put(Database.b3_size, newinputset_add2[i++]);
        cv.put(Database.b4_size, newinputset_add2[i++]);
        cv.put(Database.b5_size, newinputset_add2[i++]);
        cv.put(Database.b6_size, newinputset_add2[i++]);
        cv.put(Database.p1_GIU, newinputset_add2[i++]);
        cv.put(Database.p2_GIU, newinputset_add2[i++]);
        cv.put(Database.p3_GIU, newinputset_add2[i++]);
        cv.put(Database.p4_GIU, newinputset_add2[i++]);
        cv.put(Database.p5_GIU, newinputset_add2[i++]);
        cv.put(Database.p6_GIU, newinputset_add2[i++]);
        cv.put(Database.b1_apluc, newinputset_add2[i++]);
        cv.put(Database.b2_apluc, newinputset_add2[i++]);
        cv.put(Database.b3_apluc, newinputset_add2[i++]);
        cv.put(Database.b4_apluc, newinputset_add2[i++]);
        cv.put(Database.b5_apluc, newinputset_add2[i++]);
        cv.put(Database.b6_apluc, newinputset_add2[i++]);
        cv.put(Database.p1_p2_BAY, newinputset_add2[i++]);
        cv.put(Database.p2_p3_BAY, newinputset_add2[i++]);
        cv.put(Database.p3_p4_BAY, newinputset_add2[i++]);
        cv.put(Database.p4_p5_BAY, newinputset_add2[i++]);
        cv.put(Database.p5_p6_BAY, newinputset_add2[i++]);
        cv.put(Database.p1_p2_tgBA, newinputset_add2[i++]);
        cv.put(Database.p2_p3_tgBA, newinputset_add2[i++]);
        cv.put(Database.p3_p4_tgBA, newinputset_add2[i++]);
        cv.put(Database.p4_p5_tgBA, newinputset_add2[i++]);
        cv.put(Database.p1_p2_tgDOI, newinputset_add2[i++]);
        cv.put(Database.p2_p3_tgDOI, newinputset_add2[i++]);
        cv.put(Database.p3_p4_tgDOI, newinputset_add2[i++]);
        cv.put(Database.p4_p5_tgDOI, newinputset_add2[i++]);
        cv.put(Database.p5_p6_tgDOI, newinputset_add2[i++]);
        cv.put(Database.tong_THOIGIAN, newinputset_add2[i++]);

        r = mydatabase.insertOrThrow(Database.TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, newinputset_sub2[i++]);
        cv.put(Database.b1_y, newinputset_sub2[i++]);
        cv.put(Database.b2_x, newinputset_sub2[i++]);
        cv.put(Database.b2_y, newinputset_sub2[i++]);
        cv.put(Database.b3_x, newinputset_sub2[i++]);
        cv.put(Database.b3_y, newinputset_sub2[i++]);
        cv.put(Database.b4_x, newinputset_sub2[i++]);
        cv.put(Database.b4_y, newinputset_sub2[i++]);
        cv.put(Database.b5_x, newinputset_sub2[i++]);
        cv.put(Database.b5_y, newinputset_sub2[i++]);
        cv.put(Database.b6_x, newinputset_sub2[i++]);
        cv.put(Database.b6_y, newinputset_sub2[i++]);
        cv.put(Database.b1_size, newinputset_sub2[i++]);
        cv.put(Database.b2_size, newinputset_sub2[i++]);
        cv.put(Database.b3_size, newinputset_sub2[i++]);
        cv.put(Database.b4_size, newinputset_sub2[i++]);
        cv.put(Database.b5_size, newinputset_sub2[i++]);
        cv.put(Database.b6_size, newinputset_sub2[i++]);
        cv.put(Database.p1_GIU, newinputset_sub2[i++]);
        cv.put(Database.p2_GIU, newinputset_sub2[i++]);
        cv.put(Database.p3_GIU, newinputset_sub2[i++]);
        cv.put(Database.p4_GIU, newinputset_sub2[i++]);
        cv.put(Database.p5_GIU, newinputset_sub2[i++]);
        cv.put(Database.p6_GIU, newinputset_sub2[i++]);
        cv.put(Database.b1_apluc, newinputset_sub2[i++]);
        cv.put(Database.b2_apluc, newinputset_sub2[i++]);
        cv.put(Database.b3_apluc, newinputset_sub2[i++]);
        cv.put(Database.b4_apluc, newinputset_sub2[i++]);
        cv.put(Database.b5_apluc, newinputset_sub2[i++]);
        cv.put(Database.b6_apluc, newinputset_sub2[i++]);
        cv.put(Database.p1_p2_BAY, newinputset_sub2[i++]);
        cv.put(Database.p2_p3_BAY, newinputset_sub2[i++]);
        cv.put(Database.p3_p4_BAY, newinputset_sub2[i++]);
        cv.put(Database.p4_p5_BAY, newinputset_sub2[i++]);
        cv.put(Database.p5_p6_BAY, newinputset_sub2[i++]);
        cv.put(Database.p1_p2_tgBA, newinputset_sub2[i++]);
        cv.put(Database.p2_p3_tgBA, newinputset_sub2[i++]);
        cv.put(Database.p3_p4_tgBA, newinputset_sub2[i++]);
        cv.put(Database.p4_p5_tgBA, newinputset_sub2[i++]);
        cv.put(Database.p1_p2_tgDOI, newinputset_sub2[i++]);
        cv.put(Database.p2_p3_tgDOI, newinputset_sub2[i++]);
        cv.put(Database.p3_p4_tgDOI, newinputset_sub2[i++]);
        cv.put(Database.p4_p5_tgDOI, newinputset_sub2[i++]);
        cv.put(Database.p5_p6_tgDOI, newinputset_sub2[i++]);
        cv.put(Database.tong_THOIGIAN, newinputset_sub2[i++]);

        r = mydatabase.insertOrThrow(Database.TABLE_NAME, null, cv);
    }

    public void generateIllegitimateDataset(){
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
        int count = 0;
        c.moveToFirst();
        Random random = new Random();
        int add_sub;
        double percent;
        while (count <= 1) {
            bathopphapDataset_1= new double[45];
            bathopphapDataset_2= new double[45];
            bathopphapDataset_3= new double[45];
            bathopphapDataset_4= new double[45];

            for(int j=0,i=0,q=0,k=0; j<45;j++,i++,q++,k++){

                percent = random.nextInt(8);
                percent += 120;
                percent /= 100;
                if(j>23 && j<30 || j==44)
                    bathopphapDataset_1[i] = Double.parseDouble(c.getString(q)) + (percent * Double.parseDouble(c.getString(k)));
                else
                    bathopphapDataset_1[i] = Double.parseDouble(c.getString(q)) - (percent * Double.parseDouble(c.getString(k)));

                percent = 120 + random.nextInt(8);

                percent /= 100;
                if(j>23 && j<30 || j==44)
                    bathopphapDataset_2[i] = Double.parseDouble(c.getString(q)) + (percent * Double.parseDouble(c.getString(k)));
                else
                    bathopphapDataset_2[i] = Double.parseDouble(c.getString(q)) - (percent * Double.parseDouble(c.getString(k)));

                percent = 120 + random.nextInt(8);

                percent /= 100;
                if(j>23 && j<30 || j==44)
                    bathopphapDataset_3[i] = Double.parseDouble(c.getString(q)) + (percent * Double.parseDouble(c.getString(k)));
                else
                    bathopphapDataset_3[i] = Double.parseDouble(c.getString(q)) - (percent * Double.parseDouble(c.getString(k)));

                percent = 120 + random.nextInt(8);

                percent /= 100;
                if(j>23 && j<30 || j==44)
                    bathopphapDataset_4[i] = Double.parseDouble(c.getString(q)) + (percent * Double.parseDouble(c.getString(k)));
                else
                    bathopphapDataset_4[i] = Double.parseDouble(c.getString(q)) - (percent * Double.parseDouble(c.getString(k)));
            }
            count++;
            c.moveToNext();
            putIllegitimateData();
        }
    }

    private void putIllegitimateData() {
        DBHelper mydbhelper = new DBHelper(con, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        int i=0;
        cv.put(Database.b1_x, bathopphapDataset_1[i++]);
        cv.put(Database.b1_y, bathopphapDataset_1[i++]);
        cv.put(Database.b2_x, bathopphapDataset_1[i++]);
        cv.put(Database.b2_y, bathopphapDataset_1[i++]);
        cv.put(Database.b3_x, bathopphapDataset_1[i++]);
        cv.put(Database.b3_y, bathopphapDataset_1[i++]);
        cv.put(Database.b4_x, bathopphapDataset_1[i++]);
        cv.put(Database.b4_y, bathopphapDataset_1[i++]);
        cv.put(Database.b5_x, bathopphapDataset_1[i++]);
        cv.put(Database.b5_y, bathopphapDataset_1[i++]);
        cv.put(Database.b6_x, bathopphapDataset_1[i++]);
        cv.put(Database.b6_y, bathopphapDataset_1[i++]);
        cv.put(Database.b1_size, bathopphapDataset_1[i++]);
        cv.put(Database.b2_size, bathopphapDataset_1[i++]);
        cv.put(Database.b3_size, bathopphapDataset_1[i++]);
        cv.put(Database.b4_size, bathopphapDataset_1[i++]);
        cv.put(Database.b5_size, bathopphapDataset_1[i++]);
        cv.put(Database.b6_size, bathopphapDataset_1[i++]);
        cv.put(Database.p1_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.p2_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.p3_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.p4_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.p5_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.p6_GIU, bathopphapDataset_1[i++]);
        cv.put(Database.b1_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.b2_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.b3_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.b4_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.b5_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.b6_apluc, bathopphapDataset_1[i++]);
        cv.put(Database.p1_p2_BAY, bathopphapDataset_1[i++]);
        cv.put(Database.p2_p3_BAY, bathopphapDataset_1[i++]);
        cv.put(Database.p3_p4_BAY, bathopphapDataset_1[i++]);
        cv.put(Database.p4_p5_BAY, bathopphapDataset_1[i++]);
        cv.put(Database.p5_p6_BAY, bathopphapDataset_1[i++]);
        cv.put(Database.p1_p2_tgBA, bathopphapDataset_1[i++]);
        cv.put(Database.p2_p3_tgBA, bathopphapDataset_1[i++]);
        cv.put(Database.p3_p4_tgBA, bathopphapDataset_1[i++]);
        cv.put(Database.p4_p5_tgBA, bathopphapDataset_1[i++]);
        cv.put(Database.p1_p2_tgDOI, bathopphapDataset_1[i++]);
        cv.put(Database.p2_p3_tgDOI, bathopphapDataset_1[i++]);
        cv.put(Database.p3_p4_tgDOI, bathopphapDataset_1[i++]);
        cv.put(Database.p4_p5_tgDOI, bathopphapDataset_1[i++]);
        cv.put(Database.p5_p6_tgDOI, bathopphapDataset_1[i++]);
        cv.put(Database.tong_THOIGIAN, bathopphapDataset_1[i++]);

        mydatabase.insertOrThrow(Database.BAT_HOP_PHAP_TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, bathopphapDataset_2[i++]);
        cv.put(Database.b1_y, bathopphapDataset_2[i++]);
        cv.put(Database.b2_x, bathopphapDataset_2[i++]);
        cv.put(Database.b2_y, bathopphapDataset_2[i++]);
        cv.put(Database.b3_x, bathopphapDataset_2[i++]);
        cv.put(Database.b3_y, bathopphapDataset_2[i++]);
        cv.put(Database.b4_x, bathopphapDataset_2[i++]);
        cv.put(Database.b4_y, bathopphapDataset_2[i++]);
        cv.put(Database.b5_x, bathopphapDataset_2[i++]);
        cv.put(Database.b5_y, bathopphapDataset_2[i++]);
        cv.put(Database.b6_x, bathopphapDataset_2[i++]);
        cv.put(Database.b6_y, bathopphapDataset_2[i++]);
        cv.put(Database.b1_size, bathopphapDataset_2[i++]);
        cv.put(Database.b2_size, bathopphapDataset_2[i++]);
        cv.put(Database.b3_size, bathopphapDataset_2[i++]);
        cv.put(Database.b4_size, bathopphapDataset_2[i++]);
        cv.put(Database.b5_size, bathopphapDataset_2[i++]);
        cv.put(Database.b6_size, bathopphapDataset_2[i++]);
        cv.put(Database.p1_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.p2_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.p3_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.p4_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.p5_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.p6_GIU, bathopphapDataset_2[i++]);
        cv.put(Database.b1_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.b2_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.b3_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.b4_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.b5_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.b6_apluc, bathopphapDataset_2[i++]);
        cv.put(Database.p1_p2_BAY, bathopphapDataset_2[i++]);
        cv.put(Database.p2_p3_BAY, bathopphapDataset_2[i++]);
        cv.put(Database.p3_p4_BAY, bathopphapDataset_2[i++]);
        cv.put(Database.p4_p5_BAY, bathopphapDataset_2[i++]);
        cv.put(Database.p5_p6_BAY, bathopphapDataset_2[i++]);
        cv.put(Database.p1_p2_tgBA, bathopphapDataset_2[i++]);
        cv.put(Database.p2_p3_tgBA, bathopphapDataset_2[i++]);
        cv.put(Database.p3_p4_tgBA, bathopphapDataset_2[i++]);
        cv.put(Database.p4_p5_tgBA, bathopphapDataset_2[i++]);
        cv.put(Database.p1_p2_tgDOI, bathopphapDataset_2[i++]);
        cv.put(Database.p2_p3_tgDOI, bathopphapDataset_2[i++]);
        cv.put(Database.p3_p4_tgDOI, bathopphapDataset_2[i++]);
        cv.put(Database.p4_p5_tgDOI, bathopphapDataset_2[i++]);
        cv.put(Database.p5_p6_tgDOI, bathopphapDataset_2[i++]);
        cv.put(Database.tong_THOIGIAN, bathopphapDataset_2[i++]);

        mydatabase.insertOrThrow(Database.BAT_HOP_PHAP_TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, bathopphapDataset_3[i++]);
        cv.put(Database.b1_y, bathopphapDataset_3[i++]);
        cv.put(Database.b2_x, bathopphapDataset_3[i++]);
        cv.put(Database.b2_y, bathopphapDataset_3[i++]);
        cv.put(Database.b3_x, bathopphapDataset_3[i++]);
        cv.put(Database.b3_y, bathopphapDataset_3[i++]);
        cv.put(Database.b4_x, bathopphapDataset_3[i++]);
        cv.put(Database.b4_y, bathopphapDataset_3[i++]);
        cv.put(Database.b5_x, bathopphapDataset_3[i++]);
        cv.put(Database.b5_y, bathopphapDataset_3[i++]);
        cv.put(Database.b6_x, bathopphapDataset_3[i++]);
        cv.put(Database.b6_y, bathopphapDataset_3[i++]);
        cv.put(Database.b1_size, bathopphapDataset_3[i++]);
        cv.put(Database.b2_size, bathopphapDataset_3[i++]);
        cv.put(Database.b3_size, bathopphapDataset_3[i++]);
        cv.put(Database.b4_size, bathopphapDataset_3[i++]);
        cv.put(Database.b5_size, bathopphapDataset_3[i++]);
        cv.put(Database.b6_size, bathopphapDataset_3[i++]);
        cv.put(Database.p1_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.p2_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.p3_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.p4_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.p5_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.p6_GIU, bathopphapDataset_3[i++]);
        cv.put(Database.b1_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.b2_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.b3_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.b4_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.b5_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.b6_apluc, bathopphapDataset_3[i++]);
        cv.put(Database.p1_p2_BAY, bathopphapDataset_3[i++]);
        cv.put(Database.p2_p3_BAY, bathopphapDataset_3[i++]);
        cv.put(Database.p3_p4_BAY, bathopphapDataset_3[i++]);
        cv.put(Database.p4_p5_BAY, bathopphapDataset_3[i++]);
        cv.put(Database.p5_p6_BAY, bathopphapDataset_3[i++]);
        cv.put(Database.p1_p2_tgBA, bathopphapDataset_3[i++]);
        cv.put(Database.p2_p3_tgBA, bathopphapDataset_3[i++]);
        cv.put(Database.p3_p4_tgBA, bathopphapDataset_3[i++]);
        cv.put(Database.p4_p5_tgBA, bathopphapDataset_3[i++]);
        cv.put(Database.p1_p2_tgDOI, bathopphapDataset_3[i++]);
        cv.put(Database.p2_p3_tgDOI, bathopphapDataset_3[i++]);
        cv.put(Database.p3_p4_tgDOI, bathopphapDataset_3[i++]);
        cv.put(Database.p4_p5_tgDOI, bathopphapDataset_3[i++]);
        cv.put(Database.p5_p6_tgDOI, bathopphapDataset_3[i++]);
        cv.put(Database.tong_THOIGIAN, bathopphapDataset_3[i++]);

        mydatabase.insertOrThrow(Database.BAT_HOP_PHAP_TABLE_NAME, null, cv);

        cv = new ContentValues();
        i=0;
        cv.put(Database.b1_x, bathopphapDataset_4[i++]);
        cv.put(Database.b1_y, bathopphapDataset_4[i++]);
        cv.put(Database.b2_x, bathopphapDataset_4[i++]);
        cv.put(Database.b2_y, bathopphapDataset_4[i++]);
        cv.put(Database.b3_x, bathopphapDataset_4[i++]);
        cv.put(Database.b3_y, bathopphapDataset_4[i++]);
        cv.put(Database.b4_x, bathopphapDataset_4[i++]);
        cv.put(Database.b4_y, bathopphapDataset_4[i++]);
        cv.put(Database.b5_x, bathopphapDataset_4[i++]);
        cv.put(Database.b5_y, bathopphapDataset_4[i++]);
        cv.put(Database.b6_x, bathopphapDataset_4[i++]);
        cv.put(Database.b6_y, bathopphapDataset_4[i++]);
        cv.put(Database.b1_size, bathopphapDataset_4[i++]);
        cv.put(Database.b2_size, bathopphapDataset_4[i++]);
        cv.put(Database.b3_size, bathopphapDataset_4[i++]);
        cv.put(Database.b4_size, bathopphapDataset_4[i++]);
        cv.put(Database.b5_size, bathopphapDataset_4[i++]);
        cv.put(Database.b6_size, bathopphapDataset_4[i++]);
        cv.put(Database.p1_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.p2_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.p3_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.p4_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.p5_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.p6_GIU, bathopphapDataset_4[i++]);
        cv.put(Database.b1_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.b2_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.b3_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.b4_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.b5_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.b6_apluc, bathopphapDataset_4[i++]);
        cv.put(Database.p1_p2_BAY, bathopphapDataset_4[i++]);
        cv.put(Database.p2_p3_BAY, bathopphapDataset_4[i++]);
        cv.put(Database.p3_p4_BAY, bathopphapDataset_4[i++]);
        cv.put(Database.p4_p5_BAY, bathopphapDataset_4[i++]);
        cv.put(Database.p5_p6_BAY, bathopphapDataset_4[i++]);
        cv.put(Database.p1_p2_tgBA, bathopphapDataset_4[i++]);
        cv.put(Database.p2_p3_tgBA, bathopphapDataset_4[i++]);
        cv.put(Database.p3_p4_tgBA, bathopphapDataset_4[i++]);
        cv.put(Database.p4_p5_tgBA, bathopphapDataset_4[i++]);
        cv.put(Database.p1_p2_tgDOI, bathopphapDataset_4[i++]);
        cv.put(Database.p2_p3_tgDOI, bathopphapDataset_4[i++]);
        cv.put(Database.p3_p4_tgDOI, bathopphapDataset_4[i++]);
        cv.put(Database.p4_p5_tgDOI, bathopphapDataset_4[i++]);
        cv.put(Database.p5_p6_tgDOI, bathopphapDataset_4[i++]);
        cv.put(Database.tong_THOIGIAN, bathopphapDataset_4[i++]);

        mydatabase.insertOrThrow(Database.BAT_HOP_PHAP_TABLE_NAME, null, cv);
    }
}
