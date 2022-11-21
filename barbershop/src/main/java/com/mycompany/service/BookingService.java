package com.mycompany.service;
import java.util.List;
import com.mycompany.models.Booking;
import com.mycompany.models.BookingCheck;
import com.mycompany.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private BookingCheck bookingCheck;
    
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }         
    public boolean add(Booking booking) {
        if(bookingCheck.check(booking))
        {
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }
    public Booking edit(int bookingId, Booking booking)
    {
        Booking b = bookingRepository.findById(bookingId).get();
        booking.setId(b.getId());
        bookingRepository.save(booking);
        return booking;
    }
    public void remove(int bookingId)
    {
        Booking booking = bookingRepository.findById(bookingId).get();
        bookingRepository.delete(booking);
    }
    public Booking findOne(int bookingId)
    {
        return bookingRepository.findById(bookingId).get();
    }
}
