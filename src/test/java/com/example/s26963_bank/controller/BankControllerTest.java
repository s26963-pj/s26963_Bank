package com.example.s26963_bank.controller;

import com.example.s26963_bank.model.Client;
import com.example.s26963_bank.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static com.example.s26963_bank.model.CurrencyClass.PLN;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BankControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void cleanUp(){
        clientRepository.deleteAll();
    }

    @Test
    void shouldSaveNewStudent() throws JsonProcessingException {
        Client client = new Client("544543654", 1300,PLN,"Matt", "Eddams");

        String json = objectMapper.writeValueAsString(client);

        Client result = webTestClient.post().uri("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(json)
                .exchange()
                .expectStatus().isEqualTo(201)
                .expectBody(Client.class)
                .returnResult().getResponseBody();

        assertEquals(result.getName(), client.getName());
    }

    @Test
    void shouldReturnAllStudents(){
        Client client = new Client("54454676554", 100,PLN,"Eleonora", "Kowalska");

        clientRepository.addClient(client);

        List<Client> result = webTestClient.get().uri("/client")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Client.class)
                .returnResult().getResponseBody();

        assertEquals(result.get(0).getName(), client.getName());
    }
}