package com.example.prova_p1_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btnVoltar = findViewById(R.id.btn_voltar);

        TextView tvResultado = findViewById(R.id.textResultado);

        Intent intent = getIntent();
        String contribuicaoMensal = intent.getStringExtra("contribuicao_mensal");

        tvResultado.setText(contribuicaoMensal);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(ResultActivity.this, FormActivity.class);
                    startActivity(intent);

                } catch (Exception error) {
                    Log.d("LOGS_APP", "Falha ao iniciar atividade do resultado");
                }
            }
        });
    }
}
