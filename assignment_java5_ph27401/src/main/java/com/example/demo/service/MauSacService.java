package com.example.demo.service;

import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    void add(MauSac mauSac);

    void delete(UUID uuid);

    MauSac detail(UUID id);

    Page<MauSac> phanTrang(Integer page,Integer size);
}
