package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.repository.ChiTietSpRepository;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChiTietSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ChiTietSpServiceImpl implements ChiTietSpService {

    @Autowired
    ChiTietSpRepository chiTietSpRepository;
    @Override
    public List<ChiTietSp> getAll() {
        return chiTietSpRepository.findAll();
    }

    @Override
    public void add(ChiTietSp chiTietSp) {
        chiTietSpRepository.save(chiTietSp);
    }

    @Override
    public void xoa(UUID uuid) {
        chiTietSpRepository.deleteById(uuid);
    }

    @Override
    public ChiTietSp detail(UUID id) {
        return chiTietSpRepository.getById(id);
    }

    @Override
    public Page<ChiTietSp> phanTrang(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return chiTietSpRepository.findAll(pageable);

    }
}
