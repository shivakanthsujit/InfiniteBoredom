package io.github.shivakanthsujit.infiniteboredom;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.Random;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button button;
    TextView mess;
    TextView[] list = new TextView[6];
    int[] no = new int[6];
    int done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        mess = (TextView)findViewById(R.id.message);
        list[0] = (TextView)findViewById(R.id.power);
        list[1] = (TextView)findViewById(R.id.mind);
        list[2] = (TextView)findViewById(R.id.space);
        list[3] = (TextView)findViewById(R.id.reality);
        list[4] = (TextView)findViewById(R.id.time);
        list[5] = (TextView)findViewById(R.id.soul);
        button.setOnClickListener(this);
        for(int i = 0; i < 6; ++i)
            no[i] = 0;
        done = 0;
    }

    public void onClick(View v)
    {   done=0;
        if( v.getId() == R.id.button)
        {
            Random rand = new Random();
            int infi = rand.nextInt(6);
            String[] stones = new String[]{"Power Stone", "Mind Stone","Space Stone","Reality Stone", "Time Stone","Soul Stone"};
            String[] col = new String[]{"#8F3C8E","#FEED00","#1A4D9C","#E61A25","#3BAA34","#F07B1E"};

            mess.setText("The "+ stones[infi] + " has been obtained");
            final ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.main);
            layout.setBackgroundColor(Color.parseColor(col[infi]));
            no[infi]++;
            for(int i = 0; i < 6; ++i)
            {
                if(no[i] > 0)
                {
                    list[i].setText(""+no[i]);
                    done++;
                }

            }
            if(done == 6)
            {
                open();
                for(int i = 0; i < 6; ++i)
                    {
                        no[i] = 0;
                        list[i].setText("");
                        layout.setBackgroundColor(Color.parseColor("#303030"));
                        mess.setText("");
                        }
                done = 0;

            }



        }
        /*if( v.getId() == R.id.reset)
        {

        }*/
    }

    public void open(){
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Now a snap of my fingers ..... ");
                alertDialogBuilder.setPositiveButton("*SNAP",
                        new android.content.DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                android.widget.Toast.makeText(getApplicationContext(), "You wake up dazed, the Infinity Stones gone. Start Again", android.widget.Toast.LENGTH_SHORT).show();
                            }
                        });

        alertDialogBuilder.setNegativeButton("",new android.content.DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
