package com.example.demo.repository;

import com.example.demo.entity.DongSp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongSpRepository extends JpaRepository<DongSp, UUID> {
}
