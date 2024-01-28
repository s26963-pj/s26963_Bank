package com.example.s26963_bank.service;


import com.example.s26963_bank.model.Client;
import com.example.s26963_bank.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankService {

    private ClientRepository clientRepository;

    public Client add(Client client){

       return clientRepository.addClient(client);
    }
    public Client findClient(int id){
        return clientRepository.findClient(id);
    }
    public List<Client> getAllClientsWithBalance(double balance){
        return clientRepository.getAllClientsWithBalance(balance);
    }
    public List<Client> getAllClients(){
        return clientRepository.getAllClients();
    }
}
