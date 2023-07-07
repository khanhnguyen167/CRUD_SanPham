package com.example.demo.service;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChiTietSpService {
    public List<ChiTietSp> getAll();

    public  void add(ChiTietSp chiTietSp);

    public  void xoa(UUID uuid);

    ChiTietSp detail(UUID id);

    Page<ChiTietSp> phanTrang(int page, int size);
}
