/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.models.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author HP
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    @Query("select u from User u where u.emailAddress = ?1")
//    User myCustomQuery(String emailAddress);
//       List<Booking> findAll();
}
