using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CollectorKeystroke
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            timer1.Start();
        }

        int ticks = 0;
        int keydown_num, keyup_num, keypress_num;
        int cnt_record=0, attime;

        public struct keyrecord
        {
            public string key;
            public int key_down;
            public int key_up;
            public keyrecord (string key_, int downtime, int uptime)
            {
                key = key_;
                key_down = downtime;
                key_up = uptime;
            }
        }

        List<keyrecord> listkey = new List<keyrecord>();

        private void checkattime ()
        {
            if (attime == cnt_record) upbottom.Enabled = false;
            if (attime == 1) backbottom.Enabled = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            attime--;
            keyrecord tmp = listkey[attime - 1];
            key.Text = tmp.key;
            keydown.Text = tmp.key_down.ToString();
            keyup.Text = tmp.key_up.ToString();
            keypress.Text = (tmp.key_up-tmp.key_down).ToString();
            if (attime == cnt_record) upbottom.Enabled = false;
            if (attime == 1) backbottom.Enabled = false;
            if (attime < cnt_record) upbottom.Enabled = true;
            if (attime > 1) backbottom.Enabled = true;
        }

        private void upbottom_Click(object sender, EventArgs e)
        {
            attime++;
            keyrecord tmp = listkey[attime - 1];
            key.Text = tmp.key;
            keydown.Text = tmp.key_down.ToString();
            keyup.Text = tmp.key_up.ToString();
            keypress.Text = (tmp.key_up - tmp.key_down).ToString();
            if (attime == cnt_record) upbottom.Enabled = false;
            if (attime == 1) backbottom.Enabled = false;
            if (attime < cnt_record) upbottom.Enabled = true;
            if (attime > 1) backbottom.Enabled = true;
        }

        private void textBox1_KeyDown(object sender, KeyEventArgs e)
        {
            keydown_num = ticks;
            keydown.Text = keydown_num.ToString();
            key.Text = e.KeyCode.ToString();
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_KeyUp(object sender, KeyEventArgs e)
        {
            keyup_num = ticks;
            keyup.Text = keyup_num.ToString();
            keypress_num = keyup_num - keydown_num;
            keypress.Text = keypress_num.ToString();

            listkey.Add(new keyrecord(e.KeyCode.ToString(), keydown_num, keyup_num));

            cnt_record++;
            count.Text = cnt_record.ToString();
            attime = cnt_record;
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            ticks++;
            tickkk.Text = ticks.ToString();
        }
    }
}
