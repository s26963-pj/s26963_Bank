package com.example.s26963_bank.controller;

import com.example.s26963_bank.exceptions.ValidationException;
import com.example.s26963_bank.model.Client;
import com.example.s26963_bank.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class BankController {

    private BankService bankService;

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        try{
            Client result = bankService.add(client);

            return ResponseEntity.status(201).body(result);
        }catch (ValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clientList = bankService.getAllClients();
        return ResponseEntity.ok(clientList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientWithId(@RequestParam int id){
        try {
            Client client = bankService.findClient(id);
            return ResponseEntity.ok(client);
        }catch (ValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("{id}/{balance}")
    public ResponseEntity<List<Client>> getAllClientsWithBalance(@RequestParam double balance){
        try{
            List<Client> result = bankService.getAllClientsWithBalance(balance);
            return ResponseEntity.ok(result);
        }catch (ValidationException e){
            return ResponseEntity.badRequest().build();
        }
    }


}
