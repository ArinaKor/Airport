package com.example.demo.observer;

import com.example.demo.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public class NewsPlane implements Observed{
   private List<Plane> plane;
    private List<Observer> subscribers;

    public NewsPlane() {
        subscribers = new ArrayList<>();
        plane = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: subscribers){
            observer.handleUpdate(this.plane);
        }

    }

    public void addPlane(Plane plane) {
        this.plane.add(plane);
        notifyObservers();
    }
    public void removePlane(Plane plane){
        this.plane.remove(plane);
        notifyObservers();

    }
}
