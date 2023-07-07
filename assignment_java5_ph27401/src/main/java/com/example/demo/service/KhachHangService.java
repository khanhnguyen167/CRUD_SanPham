package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    void add(KhachHang khachHang);

    void xoa(UUID uuid);

    KhachHang detail(UUID uuid);

    Page<KhachHang> phanTrang(Integer page,Integer size);


}
