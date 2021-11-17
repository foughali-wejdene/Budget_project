package com.epsi.buget_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.time.Month;

public class ChooseAnalyticActivity extends AppCompatActivity {

    private CardView todayCardView , weekCardView , monthCardView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_analytic);

        todayCardView = findViewById(R.id.todayCardView);
        weekCardView = findViewById(R.id.weekCardView);
        monthCardView = findViewById(R.id.monthCardView);

        todayCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ChooseAnalyticActivity.this, DailyAnalyticsActivity.class);
                startActivity(intent);
            }
        });


        weekCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ChooseAnalyticActivity.this, WeeklyAnalysticsActivity.class);
                startActivity(intent);
            }
        });


        monthCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ChooseAnalyticActivity.this, MonthlyAnalysticsActivity.class);
                startActivity(intent);
            }
        });






    }
}