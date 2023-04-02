package com.example.demo.Controller;

import com.example.demo.entity.Plane;
import com.example.demo.observer.NewsPlane;
import com.example.demo.observer.Observer;
import com.example.demo.observer.Subscriber;
import com.example.demo.repository.PlaneRepository;
import com.example.demo.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Controller
public class MainController /*implements Observed*/ {
    @Autowired
     private PlaneRepository planeRepository;
    @Autowired
    private PlaneService planeService;

    @GetMapping("/plane")
    public String getCurrentAircraftPositions(Model model) {
        List<Plane> list = this.planeRepository.findAll();
        model.addAttribute("list", list);
        return "plane";
    }
    /*@GetMapping("/plane")
    public String getAllPlanes( Pageable pageable, Model model){
        Page<Plane> list = planeRepository.findAll(pageable);
        model.addAttribute("list", list);
        return "plane";

    }*/
    @GetMapping("/plane/{id_flight}")
    public String findById(@PathVariable(value = "id_flight") int id_flight, Model model){
        Plane plane = this.planeService.findByID(id_flight);
        if(!planeRepository.existsById(id_flight)){
            return "redirect:/plane";
        }
        model.addAttribute("plane", plane);
        return "planeFind";
    }
    @PostMapping("/plane/{id_flight}/delete")
    public String delete(@PathVariable(value = "id_flight") int id_flight, Model model){
        planeRepository.deleteById(id_flight);
        NewsPlane newsPlane = new NewsPlane();
        Observer firstSubscriber = new Subscriber();
        newsPlane.addObserver(firstSubscriber);
        Plane pl = planeService.findByID(id_flight);
        newsPlane.removePlane(pl);/*
        model.addAttribute("message", message);*/


        return "redirect:/plane";
    }
    @GetMapping("/plane/{id_flight}/update")
    public String update(@PathVariable(value = "id_flight") int id_flight, Model model){
        Plane plane = this.planeService.findByID(id_flight);
        if(!planeRepository.existsById(id_flight)){
            return "redirect:/plane";
        }
        model.addAttribute("plane", plane);
        return "editPlane";
    }
    @RequestMapping("/plane/{id_flight}/update")
    public String update(@PathVariable(value = "id_flight") int id_flight, @RequestParam Date date_flight, @RequestParam Time time_flight, @RequestParam String town,
                         @RequestParam String airport1, @RequestParam int distance, @RequestParam String airport2, @RequestParam Date date2,
                         @RequestParam Time time2, @RequestParam int count_transfer, @RequestParam String type_ticket,
                         @RequestParam float price_ticket, @RequestParam String company, @RequestParam int max_weight, Model model){
        Plane plane = planeService.findByID(id_flight);
       // model.addAttribute("plane", plane);
        plane.setDate_flight(date_flight);
        plane.setTime_flight(time_flight);
        plane.setTown(town);
        plane.setAirport1(airport1);
        plane.setDistance(distance);
        plane.setAirport2(airport2);
        plane.setDate2(date2);
        plane.setTime2(time2);
        plane.setCount_transfer(count_transfer);
        plane.setType_ticket(type_ticket);
        plane.setPrice_ticket(price_ticket);
        plane.setCompany(company);
        plane.setMax_weight(max_weight);
        planeRepository.save(plane);
        return "redirect:/plane";
    }
    @GetMapping("/plane/add")
    public String addPlane(Model model){
        return "addPlane";
    }
    @PostMapping("/plane/add")
    public String addNew(@RequestParam Date date_flight, @RequestParam Time time_flight, @RequestParam String town,
                         @RequestParam String airport1, @RequestParam int distance, @RequestParam String airport2, @RequestParam Date date2,
                         @RequestParam Time time2, @RequestParam int count_transfer, @RequestParam String type_ticket,
                         @RequestParam float price_ticket, @RequestParam String company, @RequestParam int max_weight, Model model){
        Plane plane = new Plane();
        plane.setDate_flight(date_flight);
        plane.setTime_flight(time_flight);
        plane.setTown(town);
        plane.setAirport1(airport1);
        plane.setDistance(distance);
        plane.setAirport2(airport2);
        plane.setDate2(date2);
        plane.setTime2(time2);
        plane.setCount_transfer(count_transfer);
        plane.setType_ticket(type_ticket);
        plane.setPrice_ticket(price_ticket);
        plane.setCompany(company);
        plane.setMax_weight(max_weight);
        planeRepository.save(plane);
        return "redirect:/plane";
    }
    @GetMapping("/plane/findSomething")
    public String findPlaneTown(Model model){
        return "planeFindBySomething";
    }

   @PostMapping("/plane/findSomething")
   public String findByTown(@RequestParam Time time1, @RequestParam Time time2, @RequestParam Date date1, @RequestParam Date date2,@RequestParam String contact, @RequestParam String town, Model model){
       List<Plane> list = null;
       if(contact.equals("1")){
           list = planeRepository.findByAirport1(town);
       } else if (contact.equals("2")) {
           list = planeRepository.findByAirport2(town);
       }else if(contact.equals("3")){
           list = planeRepository.findByDate1(date1, date2);
       }else if(contact.equals("4")){
           list = planeRepository.findPlaneByTime_flightBetween(time1, time2);
       }
       if(list.isEmpty()){
           String notFound = "We can not found this!!!";
           model.addAttribute("notFound", notFound);
           return "planeFindBySomething";
       }
       else{
           model.addAttribute("list", list);
           return "planeFindBySomething";
       }
   }
   /*@PostMapping("/plane/findSomething2")
   public String findByTown(@RequestParam String airport1, @RequestParam String airport2,
                            @RequestParam Date date1, @RequestParam Date date2, Model model) {
       List<Plane> list = null;
       if(!airport1.isEmpty()&&!airport2.isEmpty()){
           list = planeRepository.findByAirport1(airport1);
           list = (planeRepository.findByAirport2(airport2));
       }
       model.addAttribute("list", list);
       return "planeFindBySomething2";
   }*/

}
