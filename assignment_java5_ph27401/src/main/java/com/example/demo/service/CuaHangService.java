package com.example.demo.service;

import com.example.demo.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHang> getAll();

    void add(CuaHang cuaHang);

    void delete(UUID uuid);

    CuaHang detail(UUID uuid);

    Page<CuaHang> phanTrang(int page,int size);
}
