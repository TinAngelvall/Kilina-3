package com.example.kilina_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VitalsInfo extends AppCompatActivity {

    private List<VitalsList> userVitals = new ArrayList<>();

    private Button saveBtn;
    private Button cleanBtn;
    private EditText stepsEtx;
    private EditText weightEtx;
    private TextView textView;
    private static final String TAG = "Мои записи";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals_info);

        initViews();
    }

    private void initViews() {

        saveBtn = findViewById(R.id.save);
        cleanBtn = findViewById(R.id.clean);
        stepsEtx = findViewById(R.id.steps);
        weightEtx = findViewById(R.id.weight);
        textView = findViewById(R.id.textView);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажатие кнопки сохранить");
                try {
                    userVitals.add(new VitalsList(
                            Integer.parseInt(stepsEtx.getText().toString()),
                            Integer.parseInt(weightEtx.getText().toString())));
                } catch (Exception ex) {
                    Toast.makeText(VitalsInfo.this, R.string.message, Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Ошибка при вводе значений жизненных показателей");
                }

                StringBuilder sb = new StringBuilder();

                for (VitalsList vitalsList : userVitals) {
                    sb.append("Количество шагов: \t").append(vitalsList.getSteps()).append("\n")
                            .append("Вес: \t").append(vitalsList.getWeight()).append("\n");
                }
                textView.setText(sb.toString());
            }
        });
        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Нажатие кнопки Очистить");
                try {
                    userVitals.add(new VitalsList(
                            Integer.parseInt(stepsEtx.getText().toString()),
                            Integer.parseInt(weightEtx.getText().toString())));
                } catch (Exception ex) {
                    Toast.makeText(VitalsInfo.this, R.string.messageClean, Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Ошибка при вводе значений жизненных показателей");
                }
                stepsEtx.setText("");
                weightEtx.setText("");
            }
        });
    }
}