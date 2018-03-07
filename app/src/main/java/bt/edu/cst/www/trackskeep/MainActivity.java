package bt.edu.cst.www.trackskeep;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/*
 * The code in this app is not at all optimized and all the values are hardcoded.
*/

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView miss,m1,m2,m3,m4,m5,trial;
    Button submit;
    int totalMiss1,totalMiss2,totalMiss3,totalMiss4,totalMiss5;
    String displayToast="+1 hour Missed for ";
    String ms1,ms2,ms3,ms4,ms5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
            m1=(TextView)findViewById(R.id.missed1);
            m2=(TextView)findViewById(R.id.missed2);
            m3=(TextView)findViewById(R.id.missed3);
            m4=(TextView)findViewById(R.id.missed4);
            m5=(TextView)findViewById(R.id.missed5);
        Cursor res=myDb.getAllData();
        if(res!=null && res.getCount()>0) {
            while(res.moveToNext()) {
                this.m1.setText(res.getString(0));
                this.m2.setText(res.getString(1));
                this.m3.setText(res.getString(2));
                this.m4.setText(res.getString(3));
                this.m5.setText(res.getString(4));
            }
            Toast.makeText(this, "Track Updated Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to Access SQLite Database", Toast.LENGTH_SHORT).show();
        }
        trial=(TextView)findViewById(R.id.textView);
        submit=(Button)findViewById(R.id.apply);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                butSubmit();
            }
        });

    }
    public void butOne(View v) {
        miss=(TextView)findViewById(R.id.missed1);
        int num=Integer.parseInt(miss.getText().toString());
        totalMiss1=num+1;
        Toast.makeText(this, displayToast+"Human Computer Interaction", Toast.LENGTH_LONG).show();
        miss.setText(""+totalMiss1);
    }
    public void butTwo(View v) {
        miss=(TextView)findViewById(R.id.missed1);
        if(Integer.parseInt(miss.getText().toString())==0)
            totalMiss1=0;
        else
            totalMiss1=Integer.parseInt(m1.getText().toString());
            if(totalMiss1==0)
                totalMiss1=0;
            totalMiss1-=1;
        miss.setText(""+totalMiss1);
    }
    public void butThree(View v) {
        miss=(TextView)findViewById(R.id.missed2);
        int num=Integer.parseInt(miss.getText().toString());
        totalMiss2=num+1;
        Toast.makeText(this, displayToast+"Object  Oriented Analysis & Design", Toast.LENGTH_LONG).show();
        miss.setText(""+totalMiss2);
    }
    public void butFour(View v) {
        miss=(TextView)findViewById(R.id.missed2);
        if(Integer.parseInt(miss.getText().toString())==0)
            totalMiss2=0;
        else
            totalMiss2=Integer.parseInt(m2.getText().toString());
            if(totalMiss2==0)
                totalMiss2=0;
            totalMiss2-=1;
        miss.setText(""+totalMiss2);
    }
    public void butFive(View v) {
        miss=(TextView)findViewById(R.id.missed3);
        int num=Integer.parseInt(miss.getText().toString());
        totalMiss3=num+1;
        Toast.makeText(this, displayToast+"Cryptography & Network Security", Toast.LENGTH_LONG).show();
        miss.setText(""+totalMiss3);
    }
    public void butSix(View v) {
        miss=(TextView)findViewById(R.id.missed3);
        if(Integer.parseInt(miss.getText().toString())==0)
            totalMiss3=0;
        else
            totalMiss3=Integer.parseInt(m3.getText().toString());
            if(totalMiss3==0)
                totalMiss3=0;
            totalMiss3-=1;
        miss.setText(""+totalMiss3);
    }
    public void butSeven(View v) {
        miss=(TextView)findViewById(R.id.missed4);
        int num=Integer.parseInt(miss.getText().toString());
        totalMiss4=num+1;
        Toast.makeText(this, displayToast+"Systems Programming", Toast.LENGTH_LONG).show();
        miss.setText(""+totalMiss4);
    }
    public void butEight(View v) {
        miss=(TextView)findViewById(R.id.missed4);
        if(Integer.parseInt(miss.getText().toString())==0)
            totalMiss4=0;
        else
            totalMiss4=Integer.parseInt(m4.getText().toString());
            if(totalMiss4==0)
                totalMiss4=0;
            totalMiss4-=1;
            miss.setText(""+totalMiss4);
    }
    public void butNine(View v) {
        miss=(TextView)findViewById(R.id.missed5);
        int num=Integer.parseInt(miss.getText().toString());
        totalMiss5=num+1;
        Toast.makeText(this, displayToast+"E-Commerce Technology", Toast.LENGTH_LONG).show();
        miss.setText(""+totalMiss5);
    }
    public void butTen(View v) {
        miss=(TextView)findViewById(R.id.missed5);
        if(Integer.parseInt(miss.getText().toString())==0)
            totalMiss5=0;
        else
            totalMiss5=Integer.parseInt(m5.getText().toString());
            if(totalMiss5==0)
                totalMiss5=0;
            totalMiss5-=1;
            miss.setText(""+totalMiss5);
    }

    public void butSubmit() {
        Cursor res;
        boolean rest;
        m1=(TextView)findViewById(R.id.missed1);
        m2=(TextView)findViewById(R.id.missed2);
        m3=(TextView)findViewById(R.id.missed3);
        m4=(TextView)findViewById(R.id.missed4);
        m5=(TextView)findViewById(R.id.missed5);
        ms1=m1.getText().toString();
        ms2=m2.getText().toString();
        ms3=m3.getText().toString();
        ms4=m4.getText().toString();
        ms5=m5.getText().toString();

        res=myDb.getAllData();
        if(res!=null && res.getCount()!=0) {
            rest=myDb.updateTrack(1,ms1,ms2,ms3,ms4,ms5);
            if(rest)
                Toast.makeText(this, "Attendance Updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();

        } else {
            rest=myDb.insertTrack(1,ms1,ms2,ms3,ms4,ms5);
            if(rest)
                Toast.makeText(this, "Attendance Updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
        }

    }
}
