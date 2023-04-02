package com.example.demo.observer;

import com.example.demo.entity.Plane;

import java.util.List;

public class Subscriber implements Observer{
    @Override
    public void handleUpdate(List<Plane> planes) {
        System.out.println("Buy Ticket!Thanks for choosing our company \n");
        //return message;
    }
}
