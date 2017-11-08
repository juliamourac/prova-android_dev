package br.com.example.testfinder.main;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 726556 on 08/11/17.
 */

public class AddAddressPresenter {
    private AddressView addressView;
    private ArrayList<String> addressList = new ArrayList<>();

    //Construtor que recebe como parametro o AddressView
    AddAddressPresenter(AddressView addressView){
        this.addressView = addressView;
    }
    //Metodo para adicionar um novo endereco na lista e chama o metodo updatelist
    void addMovieInList(int requestCode, int resultCode, Intent data){
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            String movieName = data.getStringExtra("movie_name");
            addressList.add(movieName);
            addressView.updateList(addressList);
        }
    }

}
