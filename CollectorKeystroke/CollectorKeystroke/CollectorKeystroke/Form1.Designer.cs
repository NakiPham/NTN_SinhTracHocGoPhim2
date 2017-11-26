namespace CollectorKeystroke
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.keypress = new System.Windows.Forms.TextBox();
            this.keydown = new System.Windows.Forms.TextBox();
            this.keyup = new System.Windows.Forms.TextBox();
            this.count = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.key = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.tickkk = new System.Windows.Forms.TextBox();
            this.backbottom = new System.Windows.Forms.Button();
            this.upbottom = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // keypress
            // 
            this.keypress.Location = new System.Drawing.Point(126, 111);
            this.keypress.Name = "keypress";
            this.keypress.Size = new System.Drawing.Size(129, 20);
            this.keypress.TabIndex = 0;
            // 
            // keydown
            // 
            this.keydown.Location = new System.Drawing.Point(126, 43);
            this.keydown.Name = "keydown";
            this.keydown.Size = new System.Drawing.Size(129, 20);
            this.keydown.TabIndex = 1;
            // 
            // keyup
            // 
            this.keyup.Location = new System.Drawing.Point(126, 79);
            this.keyup.Name = "keyup";
            this.keyup.Size = new System.Drawing.Size(129, 20);
            this.keyup.TabIndex = 2;
            // 
            // count
            // 
            this.count.Location = new System.Drawing.Point(126, 144);
            this.count.Name = "count";
            this.count.Size = new System.Drawing.Size(129, 20);
            this.count.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "KeyDown";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(14, 82);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "KeyUp";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(14, 147);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(73, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "KeysCaptured";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(13, 118);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(74, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "KeyPressTime";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 15);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(25, 13);
            this.label5.TabIndex = 8;
            this.label5.Text = "Key";
            // 
            // key
            // 
            this.key.Location = new System.Drawing.Point(126, 12);
            this.key.Name = "key";
            this.key.Size = new System.Drawing.Size(129, 20);
            this.key.TabIndex = 9;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(363, 12);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(245, 271);
            this.textBox1.TabIndex = 0;
            this.textBox1.KeyDown += new System.Windows.Forms.KeyEventHandler(this.textBox1_KeyDown);
            this.textBox1.KeyUp += new System.Windows.Forms.KeyEventHandler(this.textBox1_KeyUp);
            // 
            // timer1
            // 
            this.timer1.Interval = 10;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Alien Encounters Solid", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(6, 215);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(249, 17);
            this.label6.TabIndex = 11;
            this.label6.Text = "KeyStroke Dynamics";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Alien Encounters", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(55, 241);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(129, 17);
            this.label7.TabIndex = 12;
            this.label7.Text = "Collector";
            this.label7.Click += new System.EventHandler(this.label7_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(12, 177);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(33, 13);
            this.label8.TabIndex = 13;
            this.label8.Text = "Ticks";
            // 
            // tickkk
            // 
            this.tickkk.Location = new System.Drawing.Point(126, 174);
            this.tickkk.Name = "tickkk";
            this.tickkk.Size = new System.Drawing.Size(129, 20);
            this.tickkk.TabIndex = 14;
            // 
            // backbottom
            // 
            this.backbottom.Location = new System.Drawing.Point(271, 83);
            this.backbottom.Name = "backbottom";
            this.backbottom.Size = new System.Drawing.Size(75, 23);
            this.backbottom.TabIndex = 15;
            this.backbottom.Text = "Back";
            this.backbottom.UseVisualStyleBackColor = true;
            this.backbottom.Click += new System.EventHandler(this.button1_Click);
            // 
            // upbottom
            // 
            this.upbottom.Enabled = false;
            this.upbottom.Location = new System.Drawing.Point(271, 118);
            this.upbottom.Name = "upbottom";
            this.upbottom.Size = new System.Drawing.Size(75, 23);
            this.upbottom.TabIndex = 16;
            this.upbottom.Text = "Up";
            this.upbottom.UseVisualStyleBackColor = true;
            this.upbottom.Click += new System.EventHandler(this.upbottom_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(620, 295);
            this.Controls.Add(this.upbottom);
            this.Controls.Add(this.backbottom);
            this.Controls.Add(this.tickkk);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.key);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.count);
            this.Controls.Add(this.keyup);
            this.Controls.Add(this.keydown);
            this.Controls.Add(this.keypress);
            this.Name = "Form1";
            this.Text = "KeyStrokeDynamicsCollector";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox keypress;
        private System.Windows.Forms.TextBox keydown;
        private System.Windows.Forms.TextBox keyup;
        private System.Windows.Forms.TextBox count;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox key;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox tickkk;
        private System.Windows.Forms.Button backbottom;
        private System.Windows.Forms.Button upbottom;
    }
}

