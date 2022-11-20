package com.mycompany;

import com.mycompany.models.Booking;
import com.mycompany.repository.BookingRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.mycompany.repository.BookingRepository;
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        BookingRepository bookingRepository = context.getBean(BookingRepository.class);
        
        // Lấy ra toàn bộ user trong db
//        userRepository.findAll()
//                .forEach(System.out::println);
        List<Booking> bookingList = new ArrayList<>();
//        BookingRepository bookingRepository;
        bookingRepository.findAll().forEach(bookingList::add);
        System.out.println(bookingList.toString());
    }
}
