package com.example.hadeeralaa.trainingtask;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.app.AlertDialog;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seek_Bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSeekBar();
    }

    public  void getSeekBar()
    {
        // get seekbar id
        seek_Bar = (SeekBar) findViewById(R.id.seekBar1);
        final View red_box = findViewById(R.id.red_box);
        final View blue_box = findViewById(R.id.blue_box);
        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progress;
            @Override
            public  void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                if(progress < 3)
                {
                    red_box.setBackgroundColor(Color.parseColor("#cd3327"));
                    blue_box.setBackgroundColor(Color.parseColor("#005bcd"));
                }
                if(progress >= 3 && progress < 5)
                {
                    red_box.setBackgroundColor(Color.parseColor("#CF695B"));
                    blue_box.setBackgroundColor(Color.parseColor("#6065CB"));
                }
                if(progress >= 5 && progress < 10)
                {
                    red_box.setBackgroundColor(Color.parseColor("#C8B4B3"));
                    blue_box.setBackgroundColor(Color.parseColor("#B5B3C9"));
                }
                if(progress == 10)
                {
                    red_box.setBackgroundColor(Color.parseColor("#C8FAF9"));
                    blue_box.setBackgroundColor(Color.parseColor("#FBF9C8"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.More_Info:
                dialogBox();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void dialogBox() {
        // new obj from AlertDialog.Builder
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        alertDialogBuilder.setView(inflater.inflate(R.layout.dialog_style, null))
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent newIntent = new Intent(Intent.ACTION_VIEW);
                        newIntent.setData(Uri.parse("https://macdiscussions.udacity.com/t/training-task-3-for-students-who-completed-the-user-input-part/102430"));
                        if(newIntent.resolveActivity(getPackageManager()) != null)
                        {
                            startActivity(newIntent);
                        }
                    }
                });

        alertDialogBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        // change cancel button name
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setText("NOT NOW");
        // change ok button name
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setText("VISIT FORUMS");
    }
}
