package com.example.demo.service;

import com.example.demo.entity.DongSp;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface DongSpService {
    List<DongSp> getAll();

    void add(DongSp dongSp);

    void xoa(UUID uuid);

    DongSp detail(UUID uuid);

    Page<DongSp> phanTrang(Integer page,Integer size);
}
