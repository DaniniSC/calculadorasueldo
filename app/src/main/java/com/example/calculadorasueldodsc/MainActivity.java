package com.example.calculadorasueldodsc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText inputsueldobase, inputvalorhora, inputhoras, inputdias;
    private CheckBox cbpago, cbdescuento;
    private RadioGroup rgredondeo;
    private RadioButton rbredondeo, rbnoredondeo;
    private Button btnlimpiar, btncalcular;
    private TextView textdescuento, textpago;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputsueldobase = findViewById(R.id.inputsueldobase);
        inputvalorhora = findViewById(R.id.inputvalorhora);
        inputhoras = findViewById(R.id.inputhoras);
        inputdias = findViewById(R.id.inputdias);
        cbpago = findViewById(R.id.cbpago);
        cbdescuento = findViewById(R.id.cbdescuento);
        rgredondeo = findViewById(R.id.groupredondeo);
        rbredondeo = findViewById(R.id.radioredondeo);
        rbnoredondeo = findViewById(R.id.radiosinredondeo);
        btnlimpiar = findViewById(R.id.botonlimpiar);
        btncalcular = findViewById(R.id.botoncalcular);
        textdescuento = findViewById(R.id.textdescuento);
        textpago = findViewById(R.id.textpago);
    }

    public void calcular (View view) {
        double sueldo_base = Integer.parseInt(inputsueldobase.getText().toString());
        double valor_hora = Integer.parseInt(inputvalorhora.getText().toString());
        int horas = Integer.parseInt(inputhoras.getText().toString());
        int dias = Integer.parseInt(inputdias.getText().toString());
        int horas_mensuales = horas*dias;
        double pago = horas_mensuales*valor_hora; // Valor por hora ingreso por app
        double descuento = 0.00;


        if(cbpago.isChecked()) {
            textpago.setText(String.valueOf(pago));
        }
        if(cbdescuento.isChecked() && pago>1000) {
            descuento = pago - (pago*0.1);
            textdescuento.setText(String.valueOf(descuento));
        }
        if(rgredondeo.getCheckedRadioButtonId() == R.id.radioredondeo) {
            int pago_redondeo = (int)Math.round(pago);
            textpago.setText(String.valueOf(pago_redondeo));
            int descuento_redondeo = (int)Math.round(descuento);
            textdescuento.setText(String.valueOf(descuento_redondeo));
        }
    }

    public void limpiar (View view) {
        inputsueldobase.setText("");
        inputvalorhora.setText("");
        inputhoras.setText("");
        inputdias.setText("");
        cbdescuento.setChecked(false);
        cbpago.setChecked(false);
        rgredondeo.clearCheck();
        textdescuento.setText(String.valueOf("Descuento"));
        textpago.setText(String.valueOf("Pago"));
    }
}
