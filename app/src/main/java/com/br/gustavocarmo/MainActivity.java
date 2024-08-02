package com.br.gustavocarmo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnVirgula;
    private Button btnEnter;
    private Button btnBackspace;

    calculadora calculadora = new calculadora(0);
    private EditText visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnBackspace = findViewById(R.id.btnBackspace);
        btnVirgula = findViewById(R.id.btnVirgula);
        btnEnter = findViewById(R.id.btnEnter);

        visor = findViewById(R.id.editTextNumberDecimal);
        visor.setShowSoftInputOnFocus(false);
        visor.setText("0");
        btn0.setOnClickListener(botaoClick("0"));
        btn1.setOnClickListener(botaoClick("1"));
        btn2.setOnClickListener(botaoClick("2"));
        btn3.setOnClickListener(botaoClick("3"));
        btn4.setOnClickListener(botaoClick("4"));
        btn5.setOnClickListener(botaoClick("5"));
        btn6.setOnClickListener(botaoClick("6"));
        btn7.setOnClickListener(botaoClick("7"));
        btn8.setOnClickListener(botaoClick("8"));
        btn9.setOnClickListener(botaoClick("9"));

        btnVirgula.setOnClickListener(botaoClick(","));


        btnBackspace.setOnClickListener((view -> {
            int inicioSelecao = visor.getSelectionStart();
            inicioSelecao = Math.max(inicioSelecao, 0);

            int finalSelecao = visor.getSelectionEnd();
            if (inicioSelecao == finalSelecao){
                visor.getText().delete(inicioSelecao - 1, finalSelecao);
            }
            else{
                visor.getText().delete(inicioSelecao, finalSelecao);
            }

        }));

        btnEnter.setOnClickListener(view -> {
            double valor = Double.valueOf(visor.getText().toString());

            calculadora.setNumero(valor);
            calculadora.enter();
        });
    }

    public View.OnClickListener botaoClick(final String id) {
        return (v) -> {
            String value = visor.getText().toString();
            if (value == "0"){
                int inicioSelecaocase0 = visor.getSelectionStart();
                inicioSelecaocase0 = Math.max(inicioSelecaocase0, 0);
                int finalSelecao = visor.getSelectionEnd();
                int inicioSelecao = visor.getSelectionStart();
                visor.getText().delete(inicioSelecaocase0 -1, finalSelecao);
                visor.getText().replace(inicioSelecao, finalSelecao, id);
            }
            else{


                int inicioSelecao = visor.getSelectionStart();
                int finalSelecao = visor.getSelectionEnd();

                visor.getText().replace(inicioSelecao, finalSelecao, id);
            }
        };
    }
}