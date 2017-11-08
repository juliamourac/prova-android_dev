package br.com.example.testfinder.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.example.testfinder.R;

public class AddAddressActivity extends AppCompatActivity {

    TextView edtAddress;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        edtAddress = (TextView) findViewById(R.id.edt_address);
        btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //verifica se há um endereço digitado
                if (edtAddress.getText().toString().isEmpty()){
                    Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
                }else {
                    //retorna o endereço para a MainActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie_name", edtAddress.getText().toString());
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}