package com.othonbatista.calculadora;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private void calcula (int id) {

        // Recuperar o conteúdo das caixa de edição (EditText)
        EditText edNumero1 = (EditText) findViewById(R.id.editNumero1);
        EditText edNumero2 = (EditText) findViewById(R.id.editNumero2);

        double num1 = Double.parseDouble(edNumero1.getText().toString());
        double num2 = Double.parseDouble(edNumero2.getText().toString());

        CalculadoraCerebro cerebro = new CalculadoraCerebro(num1, num2);

        double resultado = 0.0;

        String operacao = "";
        String operando = "";

        switch (id)
        {
            case R.id.btSomar:
            case R.id.action_somar:

                resultado = cerebro.executaOperacao('+');

                operacao = "Soma";

                operando = "+";

                break;

            case R.id.btSubtrair:
            case R.id.action_subtrair:

                resultado = cerebro.executaOperacao('-');

                operacao = "Subtração";

                operando = "-";

                break;

            case R.id.btMultiplicar:
            case R.id.action_multiplicar:

                resultado = cerebro.executaOperacao('*');

                operacao = "Multiplicação";

                operando = "*";

                break;

            case R.id.btDividir:
            case R.id.action_dividir:

                resultado = cerebro.executaOperacao('/');

                operacao = "Divisão";

                operando = "/";

                break;
        }

        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

        dialogo.setTitle("Resultado da " + operacao);

        dialogo.setMessage(num1 + " " + operando + " " + num2 + " = " + resultado);

        dialogo.setNeutralButton("Fechar", null);

        dialogo.show();

    }


    public void buttonOperacaoOnClick (View v) {

        calcula (v.getId());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        calcula (item.getItemId());

        return super.onOptionsItemSelected(item);
    }

}
