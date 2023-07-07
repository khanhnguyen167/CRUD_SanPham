package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void xoa(UUID uuid) {
        khachHangRepository.deleteById(uuid);
    }

    @Override
    public KhachHang detail(UUID uuid) {
        return khachHangRepository.getById(uuid);
    }

    @Override
    public Page<KhachHang> phanTrang(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return khachHangRepository.findAll(pageable);
    }

}
