package com.bmstu.WGServer.Controller;

import com.bmstu.WGServer.domain.Client;
import com.bmstu.WGServer.repo.ClientRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/*
Класс отвечающий на запросы по мэппингу client
Реализован REST контроллер который принимает и
обрабатывает запросы от фронтенда для работы с базой данных устройств
 */
@RestController
@RequestMapping("client")
public class ClientsController {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientsController(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }


    @GetMapping
    public List<Client> list(){
        return clientRepo.findAll();
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") Client client){

        return client;
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientRepo.save(client);
    }

    @PutMapping("{id}")
    public Client update(
            @PathVariable("id") Client clientFromDb,
            @RequestBody Client client){
        BeanUtils.copyProperties(client,clientFromDb, "id");
        return clientRepo.save(clientFromDb);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Client client){
        clientRepo.delete(client);
    }
}
