package com.example.demo.service;

import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    void xoa(UUID uuid);

    void addOrUpdate(SanPham sanPham);

    SanPham detail(UUID uuid);

    Page<SanPham> phanTrang(Integer page, Integer size);
}
