package com.example.demo.repository;

import com.example.demo.entity.Nsx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NsxRepositoty extends JpaRepository<Nsx, UUID> {
}
