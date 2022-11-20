package com.mycompany.service;
import java.util.List;
import com.mycompany.models.Booking;
import com.mycompany.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }         
    public Booking add(Booking booking) {
        return bookingRepository.save(booking);
    }
}
