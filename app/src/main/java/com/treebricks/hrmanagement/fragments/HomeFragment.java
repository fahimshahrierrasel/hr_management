package com.treebricks.hrmanagement.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.treebricks.hrmanagement.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private PieChart attendancePieChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        attendancePieChart = view.findViewById(R.id.attendance_pie_chart);
        setAttendancePieChart();

    }

    private void setAttendancePieChart()
    {
        attendancePieChart.setUsePercentValues(true);
        attendancePieChart.getDescription().setEnabled(false);
        attendancePieChart.setExtraOffsets(5, 10, 5, 5);

        attendancePieChart.setDragDecelerationFrictionCoef(0.95f);

        attendancePieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        attendancePieChart.setRotationEnabled(true);
        attendancePieChart.setHighlightPerTapEnabled(true);

        attendancePieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = attendancePieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        attendancePieChart.setEntryLabelColor(Color.WHITE);
        attendancePieChart.setEntryLabelTextSize(20f);

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ColorTemplate.rgb("#4CAF50"));
        colors.add(ColorTemplate.rgb("#F44336"));

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(66.7f, "Present"));
        entries.add(new PieEntry(33.3f, "Absent"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        attendancePieChart.setData(data);
        attendancePieChart.highlightValues(null);
        attendancePieChart.invalidate();
    }

}
