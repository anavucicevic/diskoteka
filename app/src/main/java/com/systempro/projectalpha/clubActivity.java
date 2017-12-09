package com.systempro.projectalpha;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class clubActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        Intent intent= getIntent();
        int id= intent.getIntExtra("id", 1);
        ImageView ivCover=(ImageView)findViewById(R.id.ivCover);
        if (id==1)
        {
            ivCover.setImageResource(R.drawable.klub1);
        }
        else if(id==2)
        {
            ivCover.setImageResource(R.drawable.klub2);
        }
        else {
            ivCover.setImageResource(R.drawable.klub2);
        }
        LinearLayout llRoot=(LinearLayout)findViewById(R.id.llRoot);


            RelativeLayout rlEvent1=addEvent("Prvi event","nesto","04.12.2017","Monday");
            RelativeLayout rlEvent2=addEvent("Prvi event","nesto","05.12.2017","Tuesday");
            RelativeLayout rlEvent3=addEvent("Prvi event","nesto","06.12.2017","abc");
            RelativeLayout rlEvent4=addEvent("Prvi event","nesto","07.12.2017","Monday");
            llRoot.addView(rlEvent1);
            llRoot.addView(rlEvent2);
            llRoot.addView(rlEvent3);
            llRoot.addView(rlEvent4);

        }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics =getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private RelativeLayout addEvent(String title, String description, String date, String dow)
    {
        RelativeLayout rlEvent1 = new RelativeLayout(this);
        LinearLayout.LayoutParams lllp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(150));
        rlEvent1.setBackgroundColor(Color.DKGRAY);
        rlEvent1.setLayoutParams(lllp);

        LinearLayout llDate = new LinearLayout(this);
        llDate.setId(R.id.llDate);
        RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(30));
        llDate.setBackgroundColor(Color.BLACK);
        llDate.setPadding(dpToPx(8), 0, dpToPx(8), 0);
        llDate.setLayoutParams(rllp);

        TextView tvdotw = new TextView(this);
        tvdotw.setText(dow);
        lllp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lllp.weight = 1;

        TextView tvDate = new TextView(this);
        tvDate.setText(date);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tvDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        tvdotw.setLayoutParams(lllp);
        tvDate.setLayoutParams(lllp);

        llDate.addView(tvdotw);
        llDate.addView(tvDate);
        rlEvent1.addView(llDate);

        ImageView ivEvent = new ImageView(this);
        ivEvent.setId(R.id.ivEvent);
        rllp = new RelativeLayout.LayoutParams(dpToPx(100), dpToPx(150));
        rllp.addRule(RelativeLayout.BELOW, R.id.llDate);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_START);
        rllp.setMargins(8, 8, 8, 8);

        ivEvent.setLayoutParams(rllp);
        ivEvent.setBackgroundColor(Color.RED);
        rlEvent1.addView(ivEvent);

        TextView tvEventTile = new TextView(this);
        tvEventTile.setId(R.id.tvEventTile);
        tvEventTile.setText(title);
        tvEventTile.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF, R.id.ivEvent);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_END);
        rllp.addRule(RelativeLayout.BELOW, R.id.llDate);
        rllp.setMargins(dpToPx(8), dpToPx(32), dpToPx(8), dpToPx(0));
        tvEventTile.setLayoutParams(rllp);
        rlEvent1.addView(tvEventTile);

        TextView tvEventDescription = new TextView(this);
        tvEventDescription.setId(R.id.tvEventDescription);
        tvEventDescription.setText(title);
        tvEventDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF, R.id.ivEvent);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_END);
        rllp.addRule(RelativeLayout.BELOW, R.id.tvEventTile);
        rllp.setMargins(dpToPx(8), dpToPx(0), dpToPx(8), dpToPx(8));
        tvEventDescription.setLayoutParams(rllp);
        rlEvent1.addView(tvEventDescription);

        Button btnTables = new Button(this);
        btnTables.setId(R.id.btnTables);
        btnTables.setText(R.string.btnTable);
        btnTables.setAllCaps(true);
        btnTables.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF, R.id.ivEvent);
        rllp.addRule(RelativeLayout.BELOW, R.id.tvEventDescription);
        rllp.setMargins(dpToPx(55), 0, 0, 0);
        btnTables.setLayoutParams(rllp);
        rlEvent1.addView(btnTables);

        Button btnTables2 = new Button(this);
        btnTables2.setId(R.id.btnTables2);
        btnTables2.setText(R.string.btnTable2);
        btnTables2.setAllCaps(true);
        btnTables2.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF, R.id.btnTables);
        rllp.addRule(RelativeLayout.BELOW, R.id.tvEventDescription);
        rllp.setMargins(dpToPx(55), 0, 0, 0);
        btnTables2.setLayoutParams(rllp);
        rlEvent1.addView(btnTables2);

        Button btnTables3 = new Button(this);
        btnTables3.setId(R.id.btnTables3);
        btnTables3.setText(R.string.btnTable3);
        btnTables3.setAllCaps(true);
        btnTables3.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF, R.id.btnTables2);
        rllp.addRule(RelativeLayout.BELOW, R.id.tvEventDescription);
        rllp.setMargins(dpToPx(55), 0, 0, 0);
        btnTables3.setLayoutParams(rllp);
        rlEvent1.addView(btnTables3);


        return rlEvent1;
    }
}
