package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    public List<NhanVien> getAll();

    public  void add(NhanVien nhanVien);

    public  void xoa(UUID uuid);

    NhanVien detail(UUID id);

    Page<NhanVien> phanTrang(int page, int size);
}
