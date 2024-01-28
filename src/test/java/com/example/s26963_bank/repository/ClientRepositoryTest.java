package com.example.s26963_bank.repository;

import com.example.s26963_bank.model.Client;
import com.example.s26963_bank.model.CurrencyClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {
    private static ClientRepository clientRepository;

    @BeforeAll
    public static void setUp(){
        clientRepository = new ClientRepository();
    }
    @BeforeEach
    public void cleanUp(){
        clientRepository.deleteAll();
    }

    @Test
    void shouldAddClientAccount(){
        Client client = new Client("2443", 443, CurrencyClass.PLN, "Lena", "Marco");
        Client result = assertDoesNotThrow(() -> clientRepository.addClient(client));

        assertEquals(client.getName(), result.getName());
    }

    @Test
    void shouldFindById(){
        Client client = new Client("2443", 443, CurrencyClass.PLN, "Lena", "Marco");
        Client addedClient = clientRepository.addClient(client);

        assertEquals(addedClient.getClientId(), client.getClientId());
    }

}