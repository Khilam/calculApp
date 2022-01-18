package com.example.mytestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView moyenne, totalView,note1,note2,note3,note4,note5,note6,note7,note8, message;
    float not1, not2, not3, not4, not5, not6,not7,not8;

    int totNbMat= 17;
    int coefMath =4;
    int coefPhys = 4;
    int coefAng=3;
    int coefFran=2;
    int coefRest=1;
    private float ArrayList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
     note1 = findViewById(R.id.editNote1);
     note2 = findViewById(R.id.editNote2);
     note3 = findViewById(R.id.editNote3);
     note4 = findViewById(R.id.editNote4);
     note5 = findViewById(R.id.editNote5);
     note6 = findViewById(R.id.editNote6);
     note7 = findViewById(R.id.editNote7);
     note8 = findViewById(R.id.editNote8);
     moyenne = findViewById(R.id.editTextMoyen);
     totalView = findViewById(R.id.editTextTotal);
     message = findViewById(R.id.message);
     btn = findViewById(R.id.button);
     btn.setOnClickListener(new View.OnClickListener() {
         @SuppressLint("ResourceAsColor")
         @Override
         public void onClick(View view) {
             not1 = Float.parseFloat(String.valueOf(note1.getText()));
             not2 = Float.parseFloat(String.valueOf(note2.getText()));
             not3 = Float.parseFloat(String.valueOf(note3.getText()));
             not4 = Float.parseFloat(String.valueOf(note4.getText()));
             not5 = Float.parseFloat(String.valueOf(note5.getText()));
             not6= Float.parseFloat(String.valueOf(note6.getText()));
             not7 = Float.parseFloat(String.valueOf(note7.getText()));
              not8= Float.parseFloat(String.valueOf(note8.getText()));
            float total = Total(not1, not2, not3,not4, not5, not6, not7, not8, totNbMat);
             totalView.setText(String.valueOf(total));
             float moyen = Moyenne (total, totNbMat);
             moyenne.setText(String.valueOf(moyen));

            if (moyen>=10){
                message.setText("felicitaions !");
                message.setTextColor(getResources().getColor(R.color.green));


            }else{
                message.setText("hard luck !");
                message.setTextColor(getResources().getColor(R.color.red));

            }




         }
     });






    }

    public float Moyenne(float total, float totNbMat) {
 float moyenne = total/totNbMat;
        return moyenne;



    }


    private float Total( float not1, float not2, float not3,float not4, float not5,float not6, float not7, float not8, int totNbMat) {

        float total = (coefMath * not1)+(coefPhys * not2) +(coefAng * not3) + (coefFran *not4)+(coefRest* not5)+(coefRest * not6) +(coefRest* not7)+ (coefRest * not8);
        return total;
    }

}