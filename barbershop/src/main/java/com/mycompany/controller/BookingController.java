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
//    private List<Booking> bookingList = new CopyOnWriteArrayList<>();
//    @PostConstruct
//    public void init() {
//        bookingList = bookingRepository.findAll();
//    }

    @GetMapping("/booking")
    public List<Booking> getBookingList() {
//        bookingRepository.findAll().forEach(bookingList::add);
//        System.out.println(bookingList.toString());
        return bookingRepository.findAll();
    }


    @GetMapping("/booking/{bookingId}")
    public Booking getBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        return bookingRepository.findById(bookingId).get();
    }

    @PutMapping("/booking/{bookingId}")
    public Booking editBooking(@PathVariable(name = "bookingId") Integer bookingId,
            @RequestBody Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity deleteBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        bookingRepository.delete(booking);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/booking")
    public void addBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
    }
}
