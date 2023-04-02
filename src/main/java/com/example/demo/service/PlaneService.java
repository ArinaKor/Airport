package com.example.demo.service;

import com.example.demo.entity.Plane;
import com.example.demo.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
public class PlaneService {
    private final PlaneRepository planeRepository;
    private static final String BASE_PACKAGE = "com.example.demo";
    public PlaneService() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        planeRepository = context.getBean(PlaneRepository.class);
    }
    // ticketObserver = new TicketObserver();
    @Autowired
    public PlaneService(PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }
    public List<Plane> findAllPlanes(){
        return planeRepository.findAll();
    }
    public Plane findByID(int id_flight){
        return planeRepository.findById(id_flight).orElse(null);
    }
    public Plane save(Plane plane){
        return planeRepository.save(plane);
    }
    public void delete(int id_flight){
        planeRepository.deleteById(id_flight);
    }
    public Iterable<Plane> getAllPlanes(Integer pageSize,Integer offset) {
        return planeRepository.findAll(PageRequest.of(offset,pageSize));
    }
}
