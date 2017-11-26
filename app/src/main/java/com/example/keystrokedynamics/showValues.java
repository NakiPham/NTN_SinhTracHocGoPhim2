package com.example.keystrokedynamics;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import junit.runner.Version;

/**
 * Created by hp on 25/11/2017.
 */

    public class showValues extends AppCompatActivity {
        String [] b1_x,b1_y,b2_x,b2_y,b3_x,b3_y,b4_x,b4_y,b5_x,b5_y,b6_x,b6_y,
                b1_size, b2_size, b3_size, b4_size, b5_size, b6_size,
                p1_GIU,p2_GIU,p3_GIU,p4_GIU,p5_GIU,p6_GIU,
                b1_apluc, b2_apluc, b3_apluc, b4_apluc, b5_apluc, b6_apluc,
                p1_p2_BAY,p2_p3_BAY,p3_p4_BAY,p4_p5_BAY,p5_p6_BAY,
                p1_p2_tgDOI,p2_p3_tgDOI,p3_p4_tgDOI,p4_p5_tgDOI,p5_p6_tgDOI,
                p1_p2_tgBA,p2_p3_tgBA,p3_p4_tgBA,p4_p5_tgBA,
                tong_THOIGIAN;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_values);


            Intent in=getIntent();


            ListView l=(ListView)findViewById(R.id.listView);
            DBHelper mydbhelper=new DBHelper(this,Database.KEYSTROKE_DYNAMICS,null,Database.Version);
            SQLiteDatabase mydatabase=mydbhelper.getWritableDatabase();
            Cursor cur=mydatabase.rawQuery("select * from " + Database.TABLE_NAME, null);
            int count = cur.getCount();
            b1_x=new String[count];
            b1_y=new String[count];
            b2_x=new String[count];
            b2_y=new String[count];
            b3_x=new String[count];
            b3_y=new String[count];
            b4_x=new String[count];
            b4_y=new String[count];
            b5_x=new String[count];
            b5_y=new String[count];
            b6_x=new String[count];
            b6_y=new String[count];
            b1_size=new String[count];
            b2_size=new String[count];
            b3_size=new String[count];
            b4_size=new String[count];
            b5_size=new String[count];
            b6_size=new String[count];
            p1_GIU=new String[count];
            p2_GIU=new String[count];
            p3_GIU=new String[count];
            p4_GIU=new String[count];
            p5_GIU=new String[count];
            p6_GIU=new String[count];
            b1_apluc=new String[count];
            b2_apluc=new String[count];
            b3_apluc=new String[count];
            b4_apluc=new String[count];
            b5_apluc=new String[count];
            b6_apluc=new String[count];
            p1_p2_BAY=new String[count];
            p2_p3_BAY=new String[count];
            p3_p4_BAY=new String[count];
            p4_p5_BAY=new String[count];
            p5_p6_BAY=new String[count];
            p1_p2_tgDOI=new String[count];
            p2_p3_tgDOI=new String[count];
            p3_p4_tgDOI=new String[count];
            p4_p5_tgDOI=new String[count];
            p5_p6_tgDOI=new String[count];
            p1_p2_tgBA=new String[count];
            p2_p3_tgBA=new String[count];
            p3_p4_tgBA=new String[count];
            p4_p5_tgBA=new String[count];
            tong_THOIGIAN=new String[count];

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
            int i=0,q=0;
            for(c.moveToLast();!c.isBeforeFirst();c.moveToPrevious(),i++) {
                q = 0;
                b1_x[i] = c.getString(q++);
                b1_y[i] = c.getString(q++);
                b2_x[i] = c.getString(q++);
                b2_y[i] = c.getString(q++);
                b3_x[i] = c.getString(q++);
                b3_y[i] = c.getString(q++);
                b4_x[i] = c.getString(q++);
                b4_y[i] = c.getString(q++);
                b5_x[i] = c.getString(q++);
                b5_y[i] = c.getString(q++);
                b6_x[i] = c.getString(q++);
                b6_y[i] = c.getString(q++);
                b1_size[i] = c.getString(q++);
                b2_size[i] = c.getString(q++);
                b3_size[i] = c.getString(q++);
                b4_size[i] = c.getString(q++);
                b5_size[i] = c.getString(q++);
                b6_size[i] = c.getString(q++);
                b1_apluc[i] = c.getString(q++);
                b2_apluc[i] = c.getString(q++);
                b3_apluc[i] = c.getString(q++);
                b4_apluc[i] = c.getString(q++);
                b5_apluc[i] = c.getString(q++);
                b6_apluc[i] = c.getString(q++);
                p1_GIU[i] = c.getString(q++);
                p2_GIU[i] = c.getString(q++);
                p3_GIU[i] = c.getString(q++);
                p4_GIU[i] = c.getString(q++);
                p5_GIU[i] = c.getString(q++);
                p6_GIU[i] = c.getString(q++);
                p1_p2_BAY[i] = c.getString(q++);
                p2_p3_BAY[i] = c.getString(q++);
                p3_p4_BAY[i] = c.getString(q++);
                p4_p5_BAY[i] = c.getString(q++);
                p5_p6_BAY[i] = c.getString(q++);
                p1_p2_tgBA[i] = c.getString(q++);
                p2_p3_tgBA[i] = c.getString(q++);
                p3_p4_tgBA[i] = c.getString(q++);
                p4_p5_tgBA[i] = c.getString(q++);
                p1_p2_tgDOI[i] = c.getString(q++);
                p2_p3_tgDOI[i] = c.getString(q++);
                p3_p4_tgDOI[i] = c.getString(q++);
                p4_p5_tgDOI[i] = c.getString(q++);
                p5_p6_tgDOI[i] = c.getString(q++);
                tong_THOIGIAN[i] = c.getString(q++);

            }
            l.setAdapter(new DatabaseAdapter(b1_x,b1_y,b2_x,b2_y,b3_x,b3_y,b4_x,b4_y,b5_x,b5_y,b6_x,b6_y,
                    b1_size, b2_size, b3_size, b4_size, b5_size, b6_size,
                    p1_GIU,p2_GIU,p3_GIU,p4_GIU,p5_GIU,p6_GIU,
                    b1_apluc, b2_apluc, b3_apluc, b4_apluc, b5_apluc, b6_apluc,
                    p1_p2_BAY,p2_p3_BAY,p3_p4_BAY,p4_p5_BAY,p5_p6_BAY,
                    p1_p2_tgBA,p2_p3_tgBA,p3_p4_tgBA,p4_p5_tgBA,
                    p1_p2_tgDOI,p2_p3_tgDOI,p3_p4_tgDOI,p4_p5_tgDOI,p5_p6_tgDOI,
                    tong_THOIGIAN,showValues.this));

        }

    }

