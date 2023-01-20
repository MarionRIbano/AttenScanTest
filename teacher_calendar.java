package com.example.attenscantest;
import androidx.annotation.NonNull;
import android.widget.Button;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class teacher_calendar extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_calendar);

        calendar = (CalendarView)
                findViewById(R.id.calendar);
        date_view = (TextView)
                findViewById(R.id.date_view);

        calendar.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override

                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int Year, int Month, int DayOfMonth)

                    {
                        String Date = DayOfMonth + "/" + (Month + 1) + "/" + Year;
                        date_view.setText(Date);
                    }
                }
        );
    }
}