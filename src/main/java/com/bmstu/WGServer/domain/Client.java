package com.bmstu.WGServer.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;


//Класс создающий таблицу в базе данных для клиентских устройств

@Entity
@Table
@ToString(of = {"id", "name"})
@EqualsAndHashCode(of={"id"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String localIp;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }
}
