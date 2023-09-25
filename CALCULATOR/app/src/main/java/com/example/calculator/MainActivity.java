package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText n1, n2;
    Button suma, resta, multi, div,potencia;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        suma = findViewById(R.id.Suma);
        resta = findViewById(R.id.Resta);
        multi = findViewById(R.id.Multi);
        div = findViewById(R.id.Div);
        potencia = findViewById(R.id.Potencia);
        resultado = findViewById(R.id.Resultado);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("+");
            }
        });

        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("-");
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("/");
            }
        });
        potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular("^");
            }
        });
    }
    public static int calcularPotencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }

    private void calcular(String operador) {
        String numero1Str = n1.getText().toString();
        String numero2Str = n2.getText().toString();

        if (!numero1Str.isEmpty() && !numero2Str.isEmpty()) {
            double numero1 = Double.parseDouble(numero1Str);
            double numero2 = Double.parseDouble(numero2Str);
            double resultadoCalculado = 0;

            switch (operador) {
                case "+":
                    resultadoCalculado = numero1 + numero2;
                    break;
                case "-":
                    resultadoCalculado = numero1 - numero2;
                    break;
                case "*":
                    resultadoCalculado = numero1 * numero2;
                    break;
                case "^":
                    int numerob = Integer.parseInt(numero1Str);
                    int numeroe = Integer.parseInt(numero2Str);
                    resultadoCalculado = calcularPotencia(numerob,numeroe);
                    break;
                case "/":
                    if (numero2 != 0) {
                        resultadoCalculado = numero1 / numero2;
                    } else {
                        resultado.setText("División por cero no posible");
                        return;
                    }
                    break;
            }

            resultado.setText("Resultado: " + resultadoCalculado);
        } else {
            resultado.setText("Por favor, ingresa números en ambos campos.");
        }
    }
}


