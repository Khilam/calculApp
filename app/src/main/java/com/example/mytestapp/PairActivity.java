package com.example.mytestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class PairActivity extends AppCompatActivity {

    //DECLARATION
    Button btn;
    TextView note1, note2,note3,note4,note5,note6,note7,note8, total, moyenne, message;
    float not1, not2, not3, not4, not5, not6,not7,not8;

    //AFFECTATION

    int totNbMat= 17;
    int coefMath =4;
    int coefPhys = 4;
    int coefAng=3;
    int coefFran=2;
    int coefRest=1;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pair);
        //BINDING
        note1 = findViewById(R.id.editNote1);
        note2 = findViewById(R.id.editNote2);
        note3 = findViewById(R.id.editNote3);
        note4 = findViewById(R.id.editNote4);
        note5 = findViewById(R.id.editNote5);
        note6 = findViewById(R.id.editNote6);
        note7 = findViewById(R.id.editNote7);
        note8 = findViewById(R.id.editNote8);
        total = findViewById(R.id.editTextTotal);
        moyenne = findViewById(R.id.editTextMoyen);
        message = findViewById(R.id.message);
        btn = findViewById(R.id.button);
        // ONCLICK
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create ArrayList
                ArrayList<Pair<Float, Integer>> l = new ArrayList <Pair <Float, Integer>> ();
                not1 = Float.parseFloat(String.valueOf(note1.getText()));
                not2 = Float.parseFloat(String.valueOf(note2.getText()));
                not3 = Float.parseFloat(String.valueOf(note3.getText()));
                not4 = Float.parseFloat(String.valueOf(note4.getText()));
                not5 = Float.parseFloat(String.valueOf(note5.getText()));
                not6= Float.parseFloat(String.valueOf(note6.getText()));
                not7 = Float.parseFloat(String.valueOf(note7.getText()));
                not8= Float.parseFloat(String.valueOf(note8.getText()));
                //CREATE PAIRS
                l.add(new Pair<Float, Integer>(not1,coefMath));
                l.add(new Pair <Float, Integer>(not2,coefPhys ));
                l.add(new Pair <Float, Integer> (not3,coefAng));
                l.add(new Pair <Float, Integer> (not4,coefFran));
                l.add(new Pair <Float, Integer> (not5, coefRest));
                l.add(new Pair <Float, Integer> (not6, coefRest));
                l.add(new Pair <Float, Integer> (not7, coefRest));
                l.add(new Pair<Float, Integer>(not8, coefRest));
                float totall =  Total(l);
                total.setText(String.valueOf(totall));
                float moyen = Moyenne(totall, totNbMat);
                moyenne.setText(String.valueOf(moyen));
                if (moyen>=10){
                    message.setText("Congrats !");
                    message.setTextColor(getResources().getColor(R.color.green));
                } else {
                    message.setText(" next time");
                    message.setTextColor(getResources().getColor(R.color.red));
                }


            }
        });






    }
    public float Total (List <Pair<Float, Integer>> listnote) {
        float total1 = 0;
        for (Pair<Float, Integer> pair : listnote) {
            total1 = total1 + pair.first * pair.second;
        }
        return total1;
    }

    public float Moyenne (float totall, float totNbMat){
        float moyenne = totall/totNbMat;
        return moyenne;



    }

}
