/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.models;

import com.mycompany.repository.BookingRepository;
import com.mycompany.service.BookingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP
 */
public class BookingCheck {
    @Autowired
    BookingRepository bookingRepository;
    
    public boolean check(Booking booking)
    {
        List<Booking> bookingList = bookingRepository.findAll();
        System.out.println(bookingList);
        for(Booking b: bookingList)
        {
//            System.out.println(b.getEmployee() + booking.getEmployee() + b.getEmployee().equals(booking.getEmployee()));
//            System.out.println(b.getSet_date().toString()+ booking.getSet_date().toString() + b.getSet_date().equals(booking.getSet_date()));
//            System.out.println(b.getSet_hour().toString()+ booking.getSet_hour().toString()+ b.getSet_hour().equals(booking.getSet_hour()));
//           
//            System.out.println();
            if(b.getEmployee().equals(booking.getEmployee())
                    && b.getSet_date().equals(booking.getSet_date())
                    && b.getSet_hour().equals(booking.getSet_hour()))
            {
                return false;
            }
        }
        return true;
    }
}
