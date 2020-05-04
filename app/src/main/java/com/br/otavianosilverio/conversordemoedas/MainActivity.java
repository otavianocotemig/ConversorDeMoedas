package com.br.otavianosilverio.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.edit_real = this.findViewById(R.id.edit_real);
        this.mViewHolder.text_dolar = this.findViewById(R.id.text_dolar);
        this.mViewHolder.button_calcular = this.findViewById(R.id.button_calcular);
        this.mViewHolder.button_calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // verifica se o botao calcular foi clicado
        if (view.getId() == R.id.button_calcular){
            String valor_digitado = this.mViewHolder.edit_real.getText().toString();
            if (TextUtils.isEmpty(valor_digitado)){
           // if ("".equals(valor_digitado)){
               // Toast.makeText(this,this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
                this.mViewHolder.edit_real.setError("Informe um valor");
                this.mViewHolder.edit_real.requestFocus();
            }else{
                Double real = Double.valueOf(valor_digitado);
                this.mViewHolder.text_dolar.setText(String.format("%.2f",real/4));

            }
        }

    }


    private static class ViewHolder {
        private EditText edit_real;
        private TextView text_dolar;
        private Button  button_calcular;
    }
}

