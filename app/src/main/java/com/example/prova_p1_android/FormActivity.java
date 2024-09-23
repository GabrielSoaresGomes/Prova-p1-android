package com.example.prova_p1_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class FormActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.btn_calcular);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(FormActivity.this, ResultActivity.class);

                    EditText inputMontanteDesejado = findViewById(R.id.input_montante_desejado);
                    EditText inputTaxaJurosAnual = findViewById(R.id.input_taxa_juros_anual);
                    EditText inputAnosAteAposentadoria = findViewById(R.id.input_ano_ate_aposentadoria);

                    float montandeDesejado = Float.parseFloat(inputMontanteDesejado.getText().toString());
                    float taxaJurosAnual = Float.parseFloat(inputTaxaJurosAnual.getText().toString());
                    float anosAteAposentadoria = Float.parseFloat(inputAnosAteAposentadoria.getText().toString());

                    float taxaJurosMensal = taxaJurosAnual / 100 * 12;
                    float mesesAteAposentadoria = anosAteAposentadoria * 12;
                    double contribuicaoMensal = (montandeDesejado * taxaJurosMensal) / ( Math.pow((1 + taxaJurosMensal), mesesAteAposentadoria) - 1);
                    Log.d("LOGS_APP", String.valueOf(contribuicaoMensal));

                    intent.putExtra("contribuicao_mensal", String.valueOf(contribuicaoMensal));

                    startActivity(intent);
                } catch (Exception error) {
                    Log.e("LOGS_APP", "Erro ao carregar primeira tela no start", error);
                }
            }
        });
    }
}
