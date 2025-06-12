package com.example.demoforrohit.JPA;


import com.example.demoforrohit.Entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface appInterface extends JpaRepository<App, Long> {
}
