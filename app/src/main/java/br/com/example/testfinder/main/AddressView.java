package br.com.example.testfinder.main;

import java.util.ArrayList;

/**
 * Created by 726556 on 08/11/17.
 */
//Criação da interface para a comunicação entre o AddAddressActivity
public interface AddressView {
    //Metodo para atualizar a lista de endereços
    void updateList(ArrayList<String> adressList);
}
