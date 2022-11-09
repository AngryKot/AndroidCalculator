package com.example.testproj;


import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText ta;
    EditText tb;
    TextView lr;
    EditText td;
    //TextView le;
    EditText tP;



    private Button b_plus;
    private Button b_minus;
    private Button b_divide;
    private Button b_mult;
    private Button b_Sin;
    private Button b_Cos;
    private Button b_Tan;
    private Button b_Sqrt;
    private Button b_Pow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ta = findViewById(R.id.txtA);
        tb = findViewById(R.id.txtB);
        lr = findViewById(R.id.labC);
        td = findViewById(R.id.txtD);
       // le = findViewById(R.id.labE);
        tP = findViewById(R.id.txtPow);

        b_plus = findViewById(R.id.b_plus);
        b_minus = findViewById(R.id.b_minus);
        b_divide = findViewById(R.id.b_div);
        b_mult = findViewById(R.id.b_mult);

        b_Sin = findViewById(R.id.b_Sin);
        b_Cos = findViewById(R.id.b_Cos);
        b_Tan = findViewById(R.id.b_Tan);
        b_Sqrt = findViewById(R.id.b_Sqrt);
        b_Pow = findViewById(R.id.b_Pow);


    }

    public void doAdd(View v) {

        //Вводим переменные, с которыми будем оперировать:
        float value_a = 0;
        float value_b = 0;
        //float value_c = 0;
        float value_c = 0;
        float value_d = 0;

        //Принимаем значения для value1 и value2 с элементов ввода:
        value_a = Float.parseFloat(ta.getText().toString());
        value_b = Float.parseFloat(tb.getText().toString());
        //value_c=Float.parseFloat(number_c.getText().toString());

        //Описываем действия кнопок:
        switch (v.getId()) {
            case R.id.b_plus:
                value_c = value_a + value_b;
                break;
            case R.id.b_minus:
                value_c = value_a - value_b;
                break;
            case R.id.b_mult:
                value_c = value_a * value_b;
                break;
            case R.id.b_div:
                if (value_b!=0) {
                    value_c = value_a / value_b;
                }
                else {
                    createDialog("Делить на 0 нельзя!");
                }
                break;
            default:
                break;
        }


        //настраиваем отображение результата:
        lr.setText(" = " + value_c);
   }
    public void Mathfunct(View v) {
        double value_d;
        double value_c = 0;
        double value_pow;
        value_d=Double.parseDouble(td.getText().toString());
       // value_d = Double.parseDouble(td.getText().toString());


        switch (v.getId()) {
            case R.id.b_Sin:
                value_c = Math.sin(value_d);
                break;
            case R.id.b_Cos:
                value_c = Math.cos(value_d);
                break;
            case R.id.b_Tan:
                value_c = Math.tan(value_d);
                break;
            case R.id.b_Pow:
                value_pow = Double.parseDouble(tP.getText().toString());
                value_c = Math.pow(value_d, value_pow);
                break;
            case R.id.b_Sqrt:
                if (value_d>0) {
                    value_c = Math.sqrt(value_d);
                }
                else{
                    createDialog("Из отрицательного числа нельзя получить корень!");
                }
                break;
            default:
                break;
        }
        lr.setText(" = " + value_c);
    }
    private void createDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Что-то пошло не так...").setMessage(message).setPositiveButton("Ок", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) { }
        }); builder.create().show(); }
}