/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.service.BookingService;
import com.mycompany.models.Booking;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private List<Booking> bookingList = new CopyOnWriteArrayList<>();
    @PostConstruct
    public void init() {
        bookingList.add(null);
    }

    @GetMapping("/booking")
    public List<Booking> getBookingList() {
        return bookingList;
    }


    @GetMapping("/booking/{bookingId}")
    public Booking getBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        return bookingList.get(bookingId);
    }

    @PutMapping("/booking/{bookingId}")
    public Booking editBooking(@PathVariable(name = "bookingId") Integer bookingId,
            @RequestBody Booking booking) {
        bookingList.set(bookingId, booking);
        return booking;
    }

    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity deleteBooking(@PathVariable(name = "bookingId") Integer bookingId) {
        bookingList.remove(bookingId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/booking")
    public ResponseEntity addBooking(@RequestBody Booking booking) {
        bookingList.add(booking);
        return ResponseEntity.ok().body(booking);
    }
}
