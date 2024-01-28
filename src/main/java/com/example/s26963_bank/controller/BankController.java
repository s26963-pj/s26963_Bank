package com.example.s26963_bank.controller;

import com.example.s26963_bank.exceptions.ValidationException;
import com.example.s26963_bank.model.Client;
import com.example.s26963_bank.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class BankController {

    private BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        try{
            Client result = bankService.add(client);

            return ResponseEntity.status(201).body(result);
        }catch (ValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Client> findClientWithId(@PathVariable int id){
        try {
            Client client = bankService.findClient(id);
            return ResponseEntity.ok(client);
        }catch (ValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClientList(){
        List<Client> clientList = bankService.getAllClients();

        return ResponseEntity.ok(clientList);
    }
    @GetMapping("/findByBalance/{balance}")
    public ResponseEntity<List<Client>> getAllClientsWithBalance(@PathVariable double balance){
        List<Client> result = bankService.getAllClientsWithBalance(balance);
        return ResponseEntity
                .status(HttpStatusCode.valueOf(200))
                .body(result);
    }


}
