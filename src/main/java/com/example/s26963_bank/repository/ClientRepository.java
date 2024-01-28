package com.example.s26963_bank.repository;

import com.example.s26963_bank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {
    private List<Client> clientList = new ArrayList<>();

    public Client addClient(Client client){
        clientList.add(client);

        return client;
    }
    public List<Client> getAllclients(){
        return clientList;
    }
    public void deleteAll(){
        clientList = new ArrayList<>();
    }
}
