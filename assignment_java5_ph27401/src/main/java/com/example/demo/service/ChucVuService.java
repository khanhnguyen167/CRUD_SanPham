package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    public List<ChucVu> getAll();

    public  void add(ChucVu chucVu);

    public  void xoa(UUID uuid);

    ChucVu detail(UUID id);

    Page<ChucVu> phanTrang(int page, int size);
}
