package br.ulbra.contadorpasso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtPassos;
    RadioButton rbCurto, rbMedio, rbLongo;
    CheckBox checkCorrida;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPassos = findViewById(R.id.edtPassos);
        rbCurto = findViewById(R.id.rbCurto);
        rbMedio = findViewById(R.id.rbMedio);
        rbLongo = findViewById(R.id.rbLongo);
        checkCorrida = findViewById(R.id.checkCorrida);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String texto = edtPassos.getText().toString();

                if (texto.isEmpty()) {
                    txtResultado.setText("Digite a quantidade de passos");
                    return;
                }

                int passos = Integer.parseInt(texto);

                double tamanhoPasso = 0;

                if (rbCurto.isChecked()) {
                    tamanhoPasso = 0.5;
                }

                else if (rbMedio.isChecked()) {
                    tamanhoPasso = 0.7;
                }

                else if (rbLongo.isChecked()) {
                    tamanhoPasso = 1.0;

                }



                double distancia = passos * tamanhoPasso;

                 if (checkCorrida.isChecked()) {
                    distancia = distancia * 1.10;
                }

                txtResultado.setText(
                        "Distância percorrida: " +
                                String.format("%.0f", distancia) +
                                " metros"
                );
            }
        });
    }
}