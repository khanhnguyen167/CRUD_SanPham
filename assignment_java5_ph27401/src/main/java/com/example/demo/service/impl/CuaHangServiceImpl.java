package com.example.demo.service.impl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    CuaHangRepository cuaHangRepository;
    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public void add(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void delete(UUID uuid) {
        cuaHangRepository.deleteById(uuid);
    }

    @Override
    public CuaHang detail(UUID uuid) {
        return cuaHangRepository.getById(uuid);
    }

    @Override
    public Page<CuaHang> phanTrang(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cuaHangRepository.findAll(pageable);
    }
}
