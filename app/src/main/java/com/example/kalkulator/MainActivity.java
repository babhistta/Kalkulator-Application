package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Deklarasi Widget yang kita miliki dahulu sebelum digunakan.
        Button btnHitung = (Button) findViewById(R.id.btnHitung);
        final TextView lblHasil = (TextView) findViewById(R.id.lblHasil);
        final EditText txtBil1 = (EditText) findViewById(R.id.txtBil1);
        final EditText txtBil2 = (EditText) findViewById(R.id.txtBil2);
        final RadioGroup rgHitung = (RadioGroup) findViewById(R.id.rgHitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNumeric(txtBil1.getText().toString()) && isNumeric(txtBil2.getText().toString())){
                    double bil1= Double.parseDouble(txtBil1.getText().toString());
                    double bil2= Double.parseDouble(txtBil2.getText().toString());
                    // Switcher untuk memilih pilihan Operator perhitungan.
                    switch (rgHitung.getCheckedRadioButtonId()){
                        case R.id.rbTambah:
                            lblHasil.setText("Hasil = "+(bil1+bil2));
                            break;
                        case R.id.rbBagi:
                            lblHasil.setText("Hasil = "+(bil1/bil2));
                            break;
                        case R.id.rbKurang:
                            lblHasil.setText("Hasil = "+(bil1-bil2));
                            break;
                        case R.id.rbKali:
                            lblHasil.setText("Hasil = "+(bil1*bil2));
                            break;
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Tidak boleh kosong dan hanya angka",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }public static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}