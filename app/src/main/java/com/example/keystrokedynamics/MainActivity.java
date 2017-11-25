package com.example.keystrokedynamics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hp on 25/11/2017.
 */

public class MainActivity extends AppCompatActivity {
    String app_password;
    private ProgressDialog mProgressDialog;
    double apluc_t;
    private int _progress = 0;
    private Handler _progressHandler;
    boolean checksum;
    int contro_macdinh;
    double XUONG_cuoicung;
    double tong_THOIGIAN;
    TextView e1, e2, e3, e4, e5, e6;
    double[] tgBATDAU, tgGIU, khacBIET, tgDOI, tgBA, t_x, t_y, t_thoiluongGIU, t_size, t_apluc;
    double[] input_layer;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t0, nhap, xemBANGHI, thi_nghiem, right_wrong;
    double t1_x, t1_y, t2_x, t2_y, t3_x, t3_y, t4_x, t4_y, t5_x, t5_y, t6_x, t6_y, t7_x, t7_y, t8_x, t8_y, t9_x, t9_y, t0_x, t0_y;
    int[] location = new int[2];
    int contentHeight, contentWidth;
    Switch mySwitch;
    int status;
    int counter;
    double t1_thoiluongGIU, t2_thoiluongGIU, t3_thoiluongGIU, t4_thoiluongGIU,
            t5_thoiluongGIU, t6_thoiluongGIU, t7_thoiluongGIU, t8_thoiluongGIU,
            t9_thoiluongGIU, t0_thoiluongGIU;
    @Override
    protected void onCreate (Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        counter = 0;

        e1 = (TextView) findViewById(R.id.password_1);
        e2 = (TextView) findViewById(R.id.password_2);
        e3 = (TextView) findViewById(R.id.password_3);
        e4 = (TextView) findViewById(R.id.password_4);
        e5 = (TextView) findViewById(R.id.password_5);
        e6 = (TextView) findViewById(R.id.password_6);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        t9 = (TextView) findViewById(R.id.t9);
        t0 = (TextView) findViewById(R.id.t0);
        nhap = (TextView) findViewById(R.id.nhap);
        xemBANGHI= (TextView) findViewById(R.id.xoa);
        thi_nghiem= (TextView) findViewById(R.id.thi_nghiem_no);
        right_wrong= (TextView) findViewById(R.id.right_wrong);
        mySwitch= (Switch) findViewById(R.id.switch1);
        initialiseVariables();
        status = 0;

        mySwitch.setChecked(false);
        //đính kèm 1 listener trong trường hợp có thay đổi
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {
                    status = 1;
                } else {
                    status = 0;
                }

            }
        });


        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("0");
                normalizeData(0);

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("1");
                normalizeData(1);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("2");
                normalizeData(2);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("3");
                normalizeData(3);

            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("4");
                normalizeData(4);

            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("5");
                normalizeData(5);

            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("6");
                normalizeData(6);

            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("7");
                normalizeData(7);

            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("8");
                normalizeData(8);

            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPassword("9");
                normalizeData(9);

            }
        });
        t0.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t0_x = (double) event.getRawX();
                t0_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t0_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t0_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t1_x = (double) event.getRawX();
                t1_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t1_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t1_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t2_x = (double) event.getRawX();
                t2_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t2_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t2_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t3_x = (double) event.getRawX();
                t3_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t3_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t3_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t4_x = (double) event.getRawX();
                t4_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t4_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t4_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t5_x = (double) event.getRawX();
                t5_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t5_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t5_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t6.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t6_x = (double) event.getRawX();
                t6_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t6_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t6_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t7.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t7_x = (double) event.getRawX();
                t7_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t7_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t7_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t8.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t8_x = (double) event.getRawX();
                t8_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){                         apluc_t = (double) event.getPressure() / 1000;                     }else{                         apluc_t = (double) event.getPressure();                     }                     t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t8_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t8_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        t9.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                t9_x = (double) event.getRawX();
                t9_y = (double) event.getRawY();

                t_size[contro_macdinh] = 0.5 - (double) event.getSize();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    XUONG_cuoicung = System.currentTimeMillis();
                    tgBATDAU[contro_macdinh] = XUONG_cuoicung;
                    if((double) event.getPressure() > 1){
                        apluc_t = (double) event.getPressure() / 1000;
                    }else{
                        apluc_t = (double) event.getPressure();
                    }
                    t_apluc[contro_macdinh] = 1 - apluc_t;
                    if (contro_macdinh != 0) {
                        khacBIET[contro_macdinh - 1] = 0.35 + ((tgBATDAU[contro_macdinh] - tgBATDAU[contro_macdinh - 1] - tgGIU[contro_macdinh - 1] * 1000) / 1000);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    t9_thoiluongGIU = ((System.currentTimeMillis() - XUONG_cuoicung) / 1000);
                    tgGIU[contro_macdinh] = 0.3 - t9_thoiluongGIU;
                    if (contro_macdinh != 0) {
                        tgDOI[contro_macdinh - 1] = 0.9 - (tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1]);
                        if (contro_macdinh > 1) {
                            tgBA[contro_macdinh - 2] = 1.3 - (tgGIU[contro_macdinh - 2] + tgGIU[contro_macdinh - 1] + tgGIU[contro_macdinh] + khacBIET[contro_macdinh - 1] + khacBIET[contro_macdinh - 2]);
                        }
                    }
                }
                return false;
            }

        });
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checksum && contro_macdinh >= app_password.length()) {
                    DBHelper mydbhelper = new DBHelper(MainActivity.this, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
                    SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
                    ContentValues cv = new ContentValues();

                    cv.put(Database.b1_x, t_x[0]);
                    cv.put(Database.b1_y, t_y[0]);
                    cv.put(Database.b2_x, t_x[1]);
                    cv.put(Database.b2_y, t_y[1]);
                    cv.put(Database.b3_x, t_x[2]);
                    cv.put(Database.b3_y, t_y[2]);
                    cv.put(Database.b4_x, t_x[3]);
                    cv.put(Database.b4_y, t_y[3]);
                    cv.put(Database.b5_x, t_x[4]);
                    cv.put(Database.b5_y, t_y[4]);
                    cv.put(Database.b6_x, t_x[5]);
                    cv.put(Database.b6_y, t_y[5]);
                    cv.put(Database.b1_size, t_size[0]);
                    cv.put(Database.b2_size, t_size[1]);
                    cv.put(Database.b3_size, t_size[2]);
                    cv.put(Database.b4_size, t_size[3]);
                    cv.put(Database.b5_size, t_size[4]);
                    cv.put(Database.b6_size, t_size[5]);
                    cv.put(Database.p1_GIU, tgGIU[0]);
                    cv.put(Database.p2_GIU, tgGIU[1]);
                    cv.put(Database.p3_GIU, tgGIU[2]);
                    cv.put(Database.p4_GIU, tgGIU[3]);
                    cv.put(Database.p5_GIU, tgGIU[4]);
                    cv.put(Database.p6_GIU, tgGIU[5]);
                    cv.put(Database.b1_apluc, t_apluc[0]);
                    cv.put(Database.b2_apluc, t_apluc[1]);
                    cv.put(Database.b3_apluc, t_apluc[2]);
                    cv.put(Database.b4_apluc, t_apluc[3]);
                    cv.put(Database.b5_apluc, t_apluc[4]);
                    cv.put(Database.b6_apluc, t_apluc[5]);
                    cv.put(Database.p1_p2_BAY, khacBIET[0]);
                    cv.put(Database.p2_p3_BAY, khacBIET[1]);
                    cv.put(Database.p3_p4_BAY, khacBIET[2]);
                    cv.put(Database.p4_p5_BAY, khacBIET[3]);
                    cv.put(Database.p5_p6_BAY, khacBIET[4]);
                    cv.put(Database.p1_p2_tgBA, tgBA[0]);
                    cv.put(Database.p2_p3_tgBA, tgBA[1]);
                    cv.put(Database.p3_p4_tgBA, tgBA[2]);
                    cv.put(Database.p4_p5_tgBA, tgBA[3]);
                    cv.put(Database.p1_p2_tgDOI, tgDOI[0]);
                    cv.put(Database.p2_p3_tgDOI, tgDOI[1]);
                    cv.put(Database.p3_p4_tgDOI, tgDOI[2]);
                    cv.put(Database.p4_p5_tgDOI, tgDOI[3]);
                    cv.put(Database.p5_p6_tgDOI, tgDOI[4]);
                    //tong_THOIGIAN = (khacBIET[0]) + (khacBIET[1]) + (khacBIET[2]) + (khacBIET[3]) + (tgGIU[0]) + (tgGIU[1]) + (tgGIU[2]) + (tgGIU[3]) + (tgGIU[4])+ (tgGIU[5]);;
                    tong_THOIGIAN = 0;
                    cv.put(Database.tong_THOIGIAN, tong_THOIGIAN);

                    long r = mydatabase.insertOrThrow(Database.TABLE_NAME, null, cv);
                    if (r > 0) {

                        Toast.makeText(MainActivity.this, "Dữ liệu gõ phím đã được nhập thành công", Toast.LENGTH_SHORT).show();

                        Cursor cur = mydatabase.rawQuery("SELECT * from " + Database.TABLE_NAME, null);
                        int count = cur.getCount();
                        Cursor cur_training = mydatabase.rawQuery("SELECT * from " + Database.TRAINING_TABLE_NAME, null);
                        int count_training = cur_training.getCount();
                        String col[] = new String[]{Database.TRAINING_STATUS};
                        Cursor c = mydatabase.query(Database.TRAINING_TABLE_NAME, col, null, null, null, null, null);
                        c.moveToLast();
                        int stat = Integer.parseInt(c.getString(0));


                        if(count_training < 31 || stat == 0) {
                            if (count < 30) {
                                ContentValues cval = new ContentValues();
                                cval.put(Database.TRAINING_STATUS, 0+"");
                                mydatabase.insertOrThrow(Database.TRAINING_TABLE_NAME, null, cval);
                                right_wrong.setTextColor(Color.GREEN);
                                right_wrong.setText("Thí nghiệm No." + count + " đã hợp lệ ");
                                initialiseVariables();
                            } else {
                                /** Tạo một tiến trình trên dialog của màn hình**/
                                mProgressDialog = new ProgressDialog(MainActivity.this);

                                /** đóng tiến trình  */
                                mProgressDialog.setCancelable(false);

                                /** tạo con xoay */
                                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                mProgressDialog.show();
                                mProgressDialog.setMessage(" Đang huấn luyện mạng... ");
                                final Handler mHandler = new Handler(Looper.getMainLooper());
                                final Timer timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    public void run() {
                                        mHandler.post(new Runnable() {
                                            public void run() {

                                                trainingData training = new trainingData(MainActivity.this);
                                                training.generateHopphapDataset();
                                                Log.e("Dữ liệu  : ", "Tải dữ liệu thành công");
                                                trainingActivity ta = new trainingActivity(MainActivity.this);
                                                ta.performTraining();
                                                mProgressDialog.dismiss();

                                            }
                                        });
                                        timer.cancel();
                                    }
                                }, 100);
                                right_wrong.setTextColor(Color.GREEN);
                                right_wrong.setText("Huấn luyện hoàn thành thành công!!");
                                ContentValues cval = new ContentValues();
                                cval.put(Database.TRAINING_STATUS, 1 + "");
                                mydatabase.insertOrThrow(Database.TRAINING_TABLE_NAME, null, cval);
                            }
                        }else{
                            thi_nghiem.setText("Testing Phase ");
                            startTesting();
                            initialiseVariables();
                        }

                    } else {
                        Cursor cur = mydatabase.rawQuery("SELECT * from " + Database.TABLE_NAME, null);
                        int count = cur.getCount();
                        Toast.makeText(MainActivity.this, "Mật khẩu không hợp lệ.", Toast.LENGTH_SHORT).show();
                        initialiseVariables();
                        right_wrong.setTextColor(Color.RED);
                        right_wrong.setText("Thí nghiệm no." + count + " thất bại. Xin thử lại.");
                        thi_nghiem.setText("#Thí nghiệm no. " + count);
                    }
                } else {

                    Toast.makeText(MainActivity.this, "Mật khẩu không hợp lệ.", Toast.LENGTH_SHORT).show();
                    initialiseVariables();
                    right_wrong.setTextColor(Color.RED);
                    right_wrong.setText("Thí nghiệm thất bại. Xin thử lại.");

                }
            }
        });
        xemBANGHI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialiseVariables();
            }
        });

    }

    private void startTesting() {
        errorbackPropagation e = new errorbackPropagation(MainActivity.this);

        e.initialiseHiddenLayer();
        e.initialiseInputLayer();
        e.initialiseOutputLayer();
        e.initialiseWeightsAndBias();
        e.initialiseTargetOutput();
        e.setHopphaptargetOutput();
        e.initialiseInputForHiddenLayer();
        e.initialiseInputForOutputLayer();

        e.getFinalWeightsFromInputToHidden(MainActivity.this);
        e.getFinalWeightsFromHiddenToOutput();
        //e.getFinalBiasHidden();
        //e.getFinalBiasOutput();

        input_layer = new double[45];
        setInputLayer();
        e.getInputLayer(input_layer);
        e.functionHiddenLayer();
        e.functionOutputLayerTesting();


    }

    private void normalizeData(int i) {

        switch (i) {
            case 0:
                t0.getLocationOnScreen(location);
                t0.post(new Runnable() {
                    public void run() {

                        contentWidth = t0.getWidth() + location[0];
                        contentHeight = t0.getHeight() + location[1];
                        if (contentWidth != 0) {
                            t0_x = ((t0_x - location[0]) / (contentWidth - location[0])) / 10;
                            t0_y = ((t0_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t0_x;
                            t_y[contro_macdinh - 1] = t0_y;

                        }

                    }
                });
                break;
            case 1:
                t1.getLocationOnScreen(location);
                t1.post(new Runnable() {
                    public void run() {

                        contentWidth = t1.getWidth() + location[0];
                        contentHeight = t1.getHeight() + location[1];
                        if (contentWidth != 0) {
                            t1_x = ((t1_x - location[0]) / (contentWidth - location[0])) / 10;
                            t1_y = ((t1_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t1_x;
                            t_y[contro_macdinh - 1] = t1_y;
                        }
                    }
                });

                break;
            case 2:
                t2.getLocationOnScreen(location);
                t2.post(new Runnable() {
                    public void run() {

                        contentHeight = t2.getHeight() + location[1];
                        contentWidth = t2.getWidth() + location[0];
                        if (contentWidth != 0) {

                            t2_x = ((t2_x - location[0]) / (contentWidth - location[0])) / 10;
                            t2_y = ((t2_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t2_x;
                            t_y[contro_macdinh - 1] = t2_y;
                        }

                    }
                });
                break;
            case 3:
                t3.getLocationOnScreen(location);
                t3.post(new Runnable() {
                    public void run() {

                        contentHeight = t3.getHeight() + location[1];
                        contentWidth = t3.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t3_x = ((t3_x - location[0]) / (contentWidth - location[0])) / 10;
                            t3_y = ((t3_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t3_x;
                            t_y[contro_macdinh - 1] = t3_y;
                        }
                    }
                });
                break;
            case 4:
                t4.getLocationOnScreen(location);
                t4.post(new Runnable() {
                    public void run() {

                        contentHeight = t4.getHeight() + location[1];
                        contentWidth = t4.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t4_x = ((t4_x - location[0]) / (contentWidth - location[0])) / 10;
                            t4_y = ((t4_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t4_x;
                            t_y[contro_macdinh - 1] = t4_y;
                        }
                    }
                });
                break;
            case 5:
                t5.getLocationOnScreen(location);
                t5.post(new Runnable() {
                    public void run() {

                        contentHeight = t5.getHeight() + location[1];
                        contentWidth = t5.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t5_x = ((t5_x - location[0]) / (contentWidth - location[0])) / 10;
                            t5_y = ((t5_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t5_x;
                            t_y[contro_macdinh - 1] = t5_y;
                        }
                    }
                });
                break;
            case 6:
                t6.getLocationOnScreen(location);
                t6.post(new Runnable() {
                    public void run() {

                        contentHeight = t6.getHeight() + location[1];
                        contentWidth = t6.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t6_x = ((t6_x - location[0]) / (contentWidth - location[0])) / 10;
                            t6_y = ((t6_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t6_x;
                            t_y[contro_macdinh - 1] = t6_y;
                        }
                    }
                });
                break;
            case 7:
                t7.getLocationOnScreen(location);
                t7.post(new Runnable() {
                    public void run() {

                        contentHeight = t7.getHeight() + location[1];
                        contentWidth = t7.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t7_x = ((t7_x - location[0]) / (contentWidth - location[0])) / 10;
                            t7_y = ((t7_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t7_x;
                            t_y[contro_macdinh - 1] = t7_y;
                        }
                    }
                });
                break;
            case 8:
                t8.getLocationOnScreen(location);
                t8.post(new Runnable() {
                    public void run() {

                        contentHeight = t8.getHeight() + location[1];
                        contentWidth = t8.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t8_x = ((t8_x - location[0]) / (contentWidth - location[0])) / 10;
                            t8_y = ((t8_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t8_x;
                            t_y[contro_macdinh - 1] = t8_y;
                        }
                    }
                });
                break;
            case 9:
                t9.getLocationOnScreen(location);
                t9.post(new Runnable() {
                    public void run() {

                        contentHeight = t9.getHeight() + location[1];
                        contentWidth = t9.getWidth() + location[0];
                        if (contentWidth != 0) {
                            t9_x = ((t9_x - location[0]) / (contentWidth - location[0])) / 10;
                            t9_y = ((t9_y - location[1]) / (contentHeight - location[1])) / 10;
                            t_x[contro_macdinh - 1] = t9_x;
                            t_y[contro_macdinh - 1] = t9_y;
                        }
                    }
                });
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Phóng to menu; điều này sẽ thêm các mục vào thanh tác vụ nếu nó hiện diện.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Xử lý thanh công cụ mục nhấp vào đây. Thanh tác vụ sẽ
        // tự động xử lý các nhấp chuột vào nút Home / Up
        int id = item.getItemId();

        switch (id) {
            case R.id.keystroke:
                Intent i = new Intent(MainActivity.this, showValues.class);
                startActivity(i);
                return true;
            case R.id.weight:
                Intent in = new Intent(MainActivity.this, showweights.class);
                startActivity(in);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setInputLayer() {
        int q = 0;
        input_layer[q++] = t_x[0];
        input_layer[q++] = t_y[0];
        input_layer[q++] = t_x[1];
        input_layer[q++] = t_y[1];
        input_layer[q++] = t_x[2];
        input_layer[q++] = t_y[2];
        input_layer[q++] = t_x[3];
        input_layer[q++] = t_y[3];
        input_layer[q++] = t_x[4];
        input_layer[q++] = t_y[4];
        input_layer[q++] = t_x[5];
        input_layer[q++] = t_y[5];
        input_layer[q++] = t_size[0];
        input_layer[q++] = t_size[1];
        input_layer[q++] = t_size[2];
        input_layer[q++] = t_size[3];
        input_layer[q++] = t_size[4];
        input_layer[q++] = t_size[5];
        input_layer[q++] = t_apluc[0];
        input_layer[q++] = t_apluc[1];
        input_layer[q++] = t_apluc[2];
        input_layer[q++] = t_apluc[3];
        input_layer[q++] = t_apluc[4];
        input_layer[q++] = t_apluc[5];
        input_layer[q++] = tgGIU[0];
        input_layer[q++] = tgGIU[1];
        input_layer[q++] = tgGIU[2];
        input_layer[q++] = tgGIU[3];
        input_layer[q++] = tgGIU[4];
        input_layer[q++] = tgGIU[5];
        input_layer[q++] = khacBIET[0];
        input_layer[q++] = khacBIET[1];
        input_layer[q++] = khacBIET[2];
        input_layer[q++] = khacBIET[3];
        input_layer[q++] = khacBIET[4];
        input_layer[q++] = tgBA[0];
        input_layer[q++] = tgBA[1];
        input_layer[q++] = tgBA[2];
        input_layer[q++] = tgBA[3];
        input_layer[q++] = tgDOI[0];
        input_layer[q++] = tgDOI[1];
        input_layer[q++] = tgDOI[2];
        input_layer[q++] = tgDOI[3];
        input_layer[q++] = tgDOI[4];
        input_layer[q++] = tong_THOIGIAN;
        q = 0;
        String print = "";
        for (int i = 0; i < 45; i++)
            print += input_layer[i] + ",";

        Log.e("login activity", print);

    }


    private void initialiseVariables() {
        DBHelper mydbhelper = new DBHelper(this, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
        SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
        Cursor cur = mydatabase.rawQuery("SELECT * from " + Database.PASSWORD_TABLE_NAME, null);
        int count = cur.getCount();
        if (count == 0) {
            //set Password
            setPassword();
        } else {
            //lấy lại mật khẩu
            String col[] = new String[]{Database.password};
            Cursor c = mydatabase.query(Database.PASSWORD_TABLE_NAME, col, null, null, null, null, null);
            c.moveToLast();
            app_password = c.getString(0);
        }
        cur = mydatabase.rawQuery("SELECT * from " + Database.TABLE_NAME, null);
        count = cur.getCount();
        thi_nghiem.setText("#Đăng nhập No. " + (count + 1));


        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");


        t1.setEnabled(true);
        t2.setEnabled(true);
        t3.setEnabled(true);
        t4.setEnabled(true);
        t5.setEnabled(true);
        t6.setEnabled(true);
        t7.setEnabled(true);
        t8.setEnabled(true);
        t9.setEnabled(true);
        t0.setEnabled(true);
        nhap.setEnabled(false);

        t1_y = 0;
        t1_x = 0;
        t2_y = 0;
        t2_x = 0;
        t3_y = 0;
        t3_x = 0;
        t3_y = 0;
        t3_x = 0;
        t4_y = 0;
        t4_x = 0;
        t5_y = 0;
        t5_x = 0;
        t6_y = 0;
        t6_x = 0;
        t7_y = 0;
        t7_x = 0;
        t8_y = 0;
        t8_x = 0;
        t9_y = 0;
        t9_x = 0;
        t0_y = 0;
        t0_x = 0;

        xemBANGHI.setEnabled(true);
        contro_macdinh = 0;
        checksum = true;
        tgBATDAU = new double[6];
        tgGIU = new double[6];
        khacBIET = new double[6];
        tgDOI = new double[6];
        tgBA = new double[6];
        t_x = new double[6];
        t_y = new double[6];
        t_size = new double[6];
        t_apluc = new double[6];
        t_thoiluongGIU = new double[6];
        tong_THOIGIAN = 0;
    }

    private void checkPassword(String s) {
        char[] pass = new char[app_password.length()];
        pass = app_password.toCharArray();
        if (contro_macdinh <= 6) {
            switch (contro_macdinh) {
                case 0:
                    e1.setText("*");

                    if (Integer.parseInt(pass[0] + "") != Integer.parseInt(s)) {

                        checksum = false;
                        break;
                    } else {


                        break;
                    }
                case 1:
                    e2.setText("*");

                    if (Integer.parseInt(pass[1] + "") != Integer.parseInt(s)) {

                        checksum = false;
                        break;
                    } else {

                        break;
                    }
                case 2:
                    e3.setText("*");

                    if (Integer.parseInt(pass[2] + "") != Integer.parseInt(s)) {
                        checksum = false;
                        break;
                    } else {

                        break;
                    }
                case 3:
                    e4.setText("*");

                    if (Integer.parseInt(pass[3] + "") != Integer.parseInt(s)) {
                        checksum = false;
                        break;
                    } else {

                        break;
                    }
                case 4:
                    e5.setText("*");

                    if (Integer.parseInt(pass[4] + "") != Integer.parseInt(s)) {
                        checksum = false;
                        break;
                    } else {

                        break;
                    }
                case 5:
                    e6.setText("*");

                    if (Integer.parseInt(pass[5] + "") != Integer.parseInt(s)) {
                        checksum = false;
                        break;
                    } else {

                        t1.setEnabled(false);
                        t2.setEnabled(false);
                        t3.setEnabled(false);
                        t4.setEnabled(false);
                        t5.setEnabled(false);
                        t6.setEnabled(false);
                        t7.setEnabled(false);
                        t8.setEnabled(false);
                        t9.setEnabled(false);
                        t0.setEnabled(false);
                        nhap.setEnabled(true);
                        xemBANGHI.setEnabled(true);
                        break;
                    }
            }
            contro_macdinh++;
        }
    }

    private void setPassword() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Hướng dẫn:");
        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.instructions, null);
        alertDialogBuilder.setPositiveButton("Đặt mật khẩu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Set Password");
                LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(R.layout.set_password, null);
                alertDialogBuilder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Dialog d = (Dialog) arg0;
                        EditText password = (EditText) d.findViewById(R.id.password);
                        EditText retype_password = (EditText) d.findViewById(R.id.retype_password);
                        if(password.getText().toString().length()==6) {

                            if (password.getText().toString().equals(retype_password.getText().toString())) {
                                app_password = password.getText().toString();
                                DBHelper mydbhelper = new DBHelper(MainActivity.this, Database.KEYSTROKE_DYNAMICS, null, Database.Version);
                                SQLiteDatabase mydatabase = mydbhelper.getWritableDatabase();
                                ContentValues c = new ContentValues();
                                c.put(Database.password, app_password);
                                mydatabase.insertOrThrow(Database.PASSWORD_TABLE_NAME, null, c);
                                ContentValues cv = new ContentValues();
                                cv.put(Database.TRAINING_STATUS, 0+"");
                                mydatabase.insertOrThrow(Database.TRAINING_TABLE_NAME, null, cv);
                                mydbhelper.close();
                                Toast.makeText(MainActivity.this, "Đặt mật khẩu thành công!", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity.this, "Mật khẩu không trùng khớp, xin thử lại!", Toast.LENGTH_SHORT).show();
                                setPassword();

                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Mật khẩu cần có 6 ký tự.", Toast.LENGTH_SHORT).show();
                            setPassword();
                        }
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setView(view);
                alertDialog.show();


            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setView(view);
        alertDialog.show();

    }
}


