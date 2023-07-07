package com.example.demo.service;

import com.example.demo.entity.Nsx;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NsxService {
    List<Nsx> getAll();

    void xoa(UUID uuid);

    void addOrUpdate(Nsx nsx);

    Nsx detail(UUID uuid);

    Page<Nsx> phanTrang(Integer page,Integer size);
}
