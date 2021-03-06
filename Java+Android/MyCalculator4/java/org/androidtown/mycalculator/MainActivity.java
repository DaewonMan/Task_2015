package org.androidtown.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText); // id 찾기
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aStr = editText.getText().toString();
                String bStr = editText2.getText().toString();

                int a = 0;
                int b = 0;

                try {
                    a = Integer.parseInt(aStr);
                    b = Integer.parseInt(bStr);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }

                Calculator calculator = new MyCalculator();
                int result = calculator.add(a, b);

                calculator = new FriendCalculator(getApplicationContext());
                result = calculator.add(a, b);

                editText3.setText(String.valueOf(result));
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aStr = editText.getText().toString();
                String bStr = editText2.getText().toString();

                int a = 0;
                int b = 0;

                Calculator calculator = new MyCalculator();
                int result = 0;
                try {
                    a = Integer.parseInt(aStr);
                    b = Integer.parseInt(bStr);
                    result = calculator.subtract(a, b);

                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "빼기는 안됩니다.", Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

                editText3.setText(String.valueOf(result));
            }
        });
    }
}
