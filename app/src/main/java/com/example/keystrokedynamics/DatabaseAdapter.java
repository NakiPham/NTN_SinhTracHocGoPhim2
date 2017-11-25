package com.example.keystrokedynamics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DatabaseAdapter extends BaseAdapter {
    String [] b1_x,b1_y,b2_x,b2_y,b3_x,b3_y,b4_x,b4_y,b5_x,b5_y,b6_x,b6_y,
            b1_size, b2_size, b3_size, b4_size, b5_size, b6_size,
            p1_GIU,p2_GIU,p3_GIU,p4_GIU,p5_GIU,p6_GIU,
            b1_apluc, b2_apluc, b3_apluc, b4_apluc, b5_apluc, b6_apluc,
            p1_p2_BAY,p2_p3_BAY,p3_p4_BAY,p4_p5_BAY,p5_p6_BAY,
            p1_p2_tgBA,p2_p3_tgBA,p3_p4_tgBA,p4_p5_tgBA,
            p1_p2_tgDOI,p2_p3_tgDOI,p3_p4_tgDOI,p4_p5_tgDOI,p5_p6_tgDOI,
            total_time;
    LayoutInflater inflater;
    Context con;
    DatabaseAdapter(
            String [] b1_x,String [] b1_y,
            String [] b2_x,String [] b2_y,
            String [] b3_x,String [] b3_y,
            String [] b4_x,String [] b4_y,
            String [] b5_x,String [] b5_y,
            String [] b6_x,String [] b6_y,
            String [] b1_size,
            String [] b2_size,String [] b3_size,
            String [] b4_size,String [] b5_size,
            String [] b6_size,
            String [] p1_GIU,String [] p2_GIU,
            String [] p3_GIU,String [] p4_GIU,
            String [] p5_GIU,String [] p6_GIU,
            String [] b1_apluc,
            String [] b2_apluc,String [] b3_apluc,
            String [] b4_apluc,String [] b5_apluc,
            String [] b6_apluc,
            String [] p1_p2_BAY,String [] p2_p3_BAY,String [] p3_p4_BAY,String [] p4_p5_BAY,String [] p5_p6_BAY,
            String [] p1_p2_tgBA,String [] p2_p3_tgBA,String [] p3_p4_tgBA,String [] p4_p5_tgBA,String []
                    p1_p2_tgDOI,String [] p2_p3_tgDOI,String [] p3_p4_tgDOI,String [] p4_p5_tgDOI,String [] p5_p6_tgDOI,String []
                    total_time, Context con){

        this.b1_x=b1_x;
        this.b1_y=b1_y;
        this.b2_x=b2_x;
        this.b2_y=b2_y;
        this.b3_x=b3_x;
        this.b3_y=b3_y;
        this.b4_x=b4_x;
        this.b4_y=b4_y;
        this.b5_x=b5_x;
        this.b5_y=b5_y;
        this.b6_x=b6_x;
        this.b6_y=b6_y;
        this.b1_size=b1_size;
        this.b2_size=b2_size;
        this.b3_size=b3_size;
        this.b4_size=b4_size;
        this.b5_size=b5_size;
        this.b6_size=b6_size;

        this.p1_GIU=p1_GIU;
        this.p2_GIU=p2_GIU;
        this.p3_GIU=p3_GIU;
        this.p4_GIU=p4_GIU;
        this.p5_GIU=p5_GIU;
        this.p6_GIU=p6_GIU;

        this.b1_apluc=b1_apluc;
        this.b2_apluc=b2_apluc;
        this.b3_apluc=b3_apluc;
        this.b4_apluc=b4_apluc;
        this.b5_apluc=b5_apluc;
        this.b6_apluc=b6_apluc;

        this.p1_p2_BAY=p1_p2_BAY;
        this.p2_p3_BAY=p2_p3_BAY;
        this.p3_p4_BAY=p3_p4_BAY;
        this.p4_p5_BAY=p4_p5_BAY;
        this.p5_p6_BAY=p5_p6_BAY;
        this.p1_p2_tgBA =p1_p2_tgBA ;
        this.p2_p3_tgBA =p2_p3_tgBA ;
        this.p3_p4_tgBA =p3_p4_tgBA ;
        this.p4_p5_tgBA =p4_p5_tgBA ;
        this.p1_p2_tgDOI=p1_p2_tgDOI;
        this.p2_p3_tgDOI=p2_p3_tgDOI;
        this.p3_p4_tgDOI=p3_p4_tgDOI;
        this.p4_p5_tgDOI=p4_p5_tgDOI;
        this.p5_p6_tgDOI=p5_p6_tgDOI;

        this.total_time=total_time;
        this.con=con;
        inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }
    @Override
    public int getCount() {
        return b1_x.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View cV, ViewGroup p) {
        TextView b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,testnumber,pt,ft,vad,kuku,kdkd,tgBA,tkuku,tkdkd;
        View r=inflater.inflate(R.layout.show,null);

        b1=(TextView)r.findViewById(R.id.b1);
        b2=(TextView)r.findViewById(R.id.b2);
        b3=(TextView)r.findViewById(R.id.b3);
        b4=(TextView)r.findViewById(R.id.b4);
        b5=(TextView)r.findViewById(R.id.b5);
        b6=(TextView)r.findViewById(R.id.b6);

        testnumber=(TextView)r.findViewById(R.id.text);
        pt=(TextView)r.findViewById(R.id.text_press);
        ft=(TextView)r.findViewById(R.id.text_flight);
        vad=(TextView)r.findViewById(R.id.text_vad);
        tgBA=(TextView)r.findViewById(R.id.t);


        b1.setText("Button 1 : ( "+b1_x[pos]+" , "+b1_y[pos]+" ) , \nSize : "+b1_size[pos]+" , \napluc : "+b1_apluc[pos]);
        b2.setText("Button 2 : ( "+b2_x[pos]+" , "+b2_y[pos]+" ) , \nSize : "+b2_size[pos]+" , \napluc : "+b2_apluc[pos]);
        b3.setText("Button 3 : ( "+b3_x[pos]+" , "+b3_y[pos]+" ) , \nSize : "+b3_size[pos]+" , \napluc : "+b3_apluc[pos]);
        b4.setText("Button 4 : ( "+b4_x[pos]+" , "+b4_y[pos]+" ) , \nSize : "+b4_size[pos]+" , \napluc : "+b4_apluc[pos]);
        b5.setText("Button 5 : ( "+b5_x[pos]+" , "+b5_y[pos]+" ) , \nSize : "+b5_size[pos]+" , \napluc : "+b5_apluc[pos]);
        b6.setText("Button 6 : ( "+b6_x[pos]+" , "+b6_y[pos]+" ) , \nSize : "+b6_size[pos]+" , \napluc : "+b6_apluc[pos]);

        pt.setText("GIU Time : "+p1_GIU[pos]+" , "+p2_GIU[pos]+" , "+p3_GIU[pos]+" , "+p4_GIU[pos]+" , "+p5_GIU[pos]+" , "+p6_GIU[pos]);
        ft.setText("BAY Time : "+p1_p2_BAY[pos]+" , "+p2_p3_BAY[pos]+" , "+p3_p4_BAY[pos]+" , "+p4_p5_BAY[pos]+" , "+p5_p6_BAY[pos]);

        vad.setText("tgDOI Time : "+p1_p2_tgDOI[pos]+" , "+p2_p3_tgDOI[pos]+" , "+p3_p4_tgDOI[pos]+" , "+p4_p5_tgDOI[pos]+" , "+p5_p6_tgDOI[pos]+" , ");

        tgBA.setText("tgBA Time : "+p1_p2_tgBA[pos]+" , "+p2_p3_tgBA[pos]+" , "+p3_p4_tgBA[pos]+" , "+p4_p5_tgBA[pos]+"  ");
        testnumber.setText("#TestCase "+(total_time.length-pos) +" Total Time : "+ total_time[pos]);
        return r;
    }
}
