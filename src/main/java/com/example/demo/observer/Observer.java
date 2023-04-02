package com.example.demo.observer;

import com.example.demo.entity.Plane;

import java.util.List;

public interface Observer {
    void handleUpdate(List<Plane> plane);
}
