package br.com.example.testfinder.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.example.testfinder.R;
import br.com.example.testfinder.add_address.AddAddressActivity;
import br.com.example.testfinder.show_addresses.ShowAddressesActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;
import java.util.List;

// Nome: Julia Moura  RA: 619655
// Nome: Leonardo de Oliveira  RA:726556
public class MainActivity extends AppCompatActivity implements AddressView {

    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife
        ButterKnife.bind(this);
    }
    //Implementação do EventListener OnClick no botão adicionar endereço
    @OnClick(R.id.btn_add_address)
    public void openAddAddress ()
    {
        //Abre a Activity de adicionar endereço
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    //Implementação do butterknife no botão mostrar endereços
    @OnClick(R.id.btn_show_addresses)
    public void mostraEndereços ()
    {
        //verifica se há endereços cadastrados antes executar a activity
        if (lstAddresses.size() <= 0) {
            Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
        } else {
            //abre a ShowAddressActivity enviando a lista de endereços
            Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
            openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
            startActivity(openShowAddressActivity);
        }
    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        if (requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }
    }
    //Atualiza a lista de endereço
    @Override
    public void updateList(ArrayList<String> addressList) {
        lstAddresses = addressList;
    }

}