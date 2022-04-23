package com.oscarmencos.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Double num1, num2, operacion;
    Boolean operacionAnterior;
    Lista lista;
    TextView resultado;

    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve,
            btnCero, btnPunto, btnSuma, btnResta, btnMultiplicacion, btnDivision, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUno = findViewById(R.id.btnUno);
        btnDos = findViewById(R.id.btnDos);
        btnTres = findViewById(R.id.btnTres);
        btnCuatro = findViewById(R.id.btnCuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSiete = findViewById(R.id.btnSiete);
        btnOcho = findViewById(R.id.btnOcho);
        btnNueve = findViewById(R.id.btnNueve);
        btnCero = findViewById(R.id.btnCero);
        btnPunto = findViewById(R.id.btnPunto);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnBorrar = findViewById(R.id.btnDel);

        resultado = findViewById(R.id.txtResultado);
        lista = new Lista();
        operacionAnterior = false;

    }

    public void numeroPresionado(View v) {
        String concatenacion;
        concatenacion = resultado.getText() + v.getTag().toString();

        if (operacionAnterior) {
            concatenacion = v.getTag().toString();
            operacionAnterior = false;
        }
        if (concatenacion.charAt(0) == '0') {
            concatenacion = concatenacion.substring(1);
        }
        resultado.setText(concatenacion);
    }

    public void enter(View v) {
        num1 = Double.parseDouble(resultado.getText().toString());
        lista.push(num1);
        resultado.setText("0");
    }

    public void operation(View v) {
        if (!operacionAnterior) {
            num1 = Double.parseDouble(resultado.getText().toString());
            lista.push(num1);
        }
        Integer number = Integer.parseInt(v.getTag().toString());
        obtenerNumeros();
        switch (number) {
            case 1:
                operacion = num1 + num2;
                break;
            case 2:
                operacion = num1 - num2;
                break;
            case 3:
                operacion = num1 * num2;
                break;
            case 4:
                operacion = num1 / num2;
                if (operacion.isNaN()) {
                    operacion = 0D;
                    break;
                }
                lista.push(operacion);
                break;
            default:
                System.out.println("Error");
                break;
        }

        lista.push(operacion);
        resultado.setText(operacion.toString());
        limpiarNumeros();
        operacionAnterior = true;
    }

    public void obtenerNumeros() {
        num2 = lista.pop();
        num1 = lista.pop();
        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Error, debe ingresar numeros para realizar la operacion.", Toast.LENGTH_LONG).show();
            limpiarNumeros();
        }
    }

    public void limpiarNumeros() {
        num1 = 0D;
        num2 = 0D;
    }

    public void delete(View v) {
        resultado.setText(resultado.getText().toString().substring(0, resultado.getText().toString().length() - 1));
    }

    public void clearAll(View v) {
        resultado.setText("0");
        limpiarNumeros();
        lista = new Lista();
    }
}