package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora.R;

public class MainActivity extends AppCompatActivity {

    private EditText etPantalla;
    private ICalculadora miLogica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPantalla = findViewById(R.id.etPantalla);
        miLogica = new CalculadoraLogica();

        // Configuración de botones numéricos y operadores básicos
        int[] botonesId = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnSuma, R.id.btnResta, R.id.btnMult, R.id.btnDiv
        };

        for (int id : botonesId) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                etPantalla.append(b.getText().toString());
            });
        }

        // Botón C (Limpiar pantalla completa)
        findViewById(R.id.btnC).setOnClickListener(v -> etPantalla.setText(""));

        // Botón Borrar (DEL - Borra el último carácter)
        findViewById(R.id.btnBorrar).setOnClickListener(v -> {
            String textoActual = etPantalla.getText().toString();
            if (textoActual.length() > 0) {
                etPantalla.setText(textoActual.substring(0, textoActual.length() - 1));
            }
        });

        // Botón Igual (Resuelve la expresión con jerarquía)
        findViewById(R.id.btnIgual).setOnClickListener(v -> {
            String expresion = etPantalla.getText().toString();
            if (!expresion.isEmpty()) {
                try {
                    double resultado = miLogica.resolverExpresion(expresion);
                    etPantalla.setText(String.valueOf(resultado));
                } catch (Exception e) {
                    etPantalla.setText("Error");
                }
            }
        });
    }
}