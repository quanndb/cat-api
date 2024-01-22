package com.catgpt.catgpt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class chat_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String data;
    private String date;

    public chat_data() {

    }
    public chat_data(long id,String username,String data,String date){
        this.id=id;
        this.username=username;
        this.data=data;
        this.date=date;
    }

    public chat_data(String username,String data,String date){
        this.username=username;
        this.data=data;
        this.date=date;
    }
}
