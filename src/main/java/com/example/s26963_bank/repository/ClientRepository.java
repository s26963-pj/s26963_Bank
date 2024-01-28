package com.example.s26963_bank.repository;

import com.example.s26963_bank.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {
    private List<Client> clientList = new ArrayList<>();

    //Adding client to repo
    public Client addClient(Client client){
        clientList.add(client);

        return client;
    }
    //Just printing all clients
    public List<Client> getAllClients(){
        return clientList;
    }
    //Finds client with clientId
    public Client findClient(int id){
        Client result = null;
        for (Client client : clientList){
            if (client.getClientId() == id){
                result = client;
            }
        }
        return result;
    }
    //Finds all clients with balance greater than X
    public List<Client> getAllClientsWithBalance(double balance){
        List<Client> result = new ArrayList<>();
        for (Client client : clientList){
            if (client.getBalance() > balance){
                result.add(client);
            }
        }
        return result;
    }
    public void deleteAll(){
        clientList = new ArrayList<>();
    }
}
