package com.bmstu.WGServer.Controller;

import com.bmstu.WGServer.Utils.Requests;
import com.bmstu.WGServer.domain.Client;
import com.bmstu.WGServer.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
Класс отвечающий на запросы по мэппингу api
Реализован REST контроллер который принимает и
обрабатывает запросы от фронтенда и передает их на андроид приложение
 */
@RestController
@RequestMapping("api")
public class ApiController {

    private final ClientRepo clientRepo;

    @Autowired
    public ApiController(ClientRepo clientRepo){
        this.clientRepo = clientRepo;
    }
    //Метод обрабатывающий запрос на проверку онлайна устройства
    @PostMapping("checkOnline/{id}")
    public String checkOnline(@PathVariable("id") Client client){
        return SendRequest(Requests.isOnline,client.getLocalIp(),9999);
    }

    //Метод обрабатывающий запрос на получение геопозиции устройства
    @PostMapping("getLocation/{id}")
    public String getLocation(@PathVariable("id") Client client){
        return SendRequest(Requests.getLocation,client.getLocalIp(),9999);
    }
    //Метод отправляющий запросы с использованием сокета на клиентское устройство
    private String SendRequest(String req,String ip, int port){
        try {
            System.out.println("Sending request: " + req + ", to: " + ip);
            //Создание сокета
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 5000);
            //Создание потоков для получения и отправки данных через сокет
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String line;
            //Отправка запроса на клиентское устройство
            out.writeUTF(req);
            out.flush();
            //получение ответа
            line = in.readUTF();
            System.out.println(line);
            socket.close();
            System.out.println("Got response: "+ line + ", from: "+ ip);
            return line;
        }catch (Exception e){
            System.out.println("Didnt get response");
        }

        return "Null";
    }
}
