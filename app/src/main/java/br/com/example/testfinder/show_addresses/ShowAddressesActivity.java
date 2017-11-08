package br.com.example.testfinder.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import br.com.example.testfinder.R;
import br.com.example.testfinder.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;
import java.util.List;

public class ShowAddressesActivity extends AppCompatActivity {

    //Não julgamos necessário implementar o presenter, pois não existe processamento de dados que deveriam estar no presenter
    @BindView(R.id.rv_addresses)  RecyclerView rvAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);
        ButterKnife.bind(this);

        //captura a lista enviada pela MainActivity
        List<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);

        addressesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            //Implementação do clique simples em um item da lista
            @Override
            public void onClick(View view, String endereco) {
                //Implementação da visualização do mapa atraves de uma intent implicita
                Intent openMap = new Intent(Intent.ACTION_VIEW);
                openMap.setData(Uri.parse("geo:0,0?q=" +  Uri.encode(endereco) ));
                openMap.setPackage("com.google.android.apps.maps");
                if (openMap.resolveActivity(getPackageManager()) != null) {
                    //Comeca a activity openMap
                    startActivity(openMap);
                }
                else{
                    Toast toast​ = Toast.makeText(ShowAddressesActivity.this , "Impossível​ abrir o mapa", Toast.LENGTH_LONG);
                    toast​.show();
                }
            }

        });

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }

}