/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.service.BookingService;
import com.mycompany.models.Booking;
import com.mycompany.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    BookingService BookingService;

    @GetMapping("/booking")
    public List<Booking> getBookingList() {
        return BookingService.findAll();
    }


    @GetMapping("/booking/{bookingId}")
    public Booking getBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        return BookingService.findOne(bookingId);
    }

    @PutMapping("/booking/{bookingId}")
    public Booking editBooking(@PathVariable(name = "bookingId") Integer bookingId,
            @RequestBody Booking booking) {
        BookingService.edit(bookingId, booking);
        return booking;
    }

    @DeleteMapping("/booking/{bookingId}")
    public String deleteBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        BookingService.remove(bookingId);
        return "Booking has been deleted";
    }

    @PostMapping("/booking")
    public String addBooking(@RequestBody Booking booking){
//        System.out.println("a");
        if(!BookingService.add(booking))
            return "Failed, please chose a different time or employee";
        else
            return "Booking added sucessfully";
    }
}
