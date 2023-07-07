package com.example.demo.service.impl;

import com.example.demo.entity.DongSp;
import com.example.demo.repository.DongSpRepository;
import com.example.demo.service.DongSpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSpServiceImpl implements DongSpService {

    @Autowired
    DongSpRepository dongSpRepository;
    @Override
    public List<DongSp> getAll() {
        return dongSpRepository.findAll();
    }

    @Override
    public void add(DongSp dongSp) {
        dongSpRepository.save(dongSp);
    }

    @Override
    public void xoa(UUID uuid) {
        dongSpRepository.deleteById(uuid);
    }

    @Override
    public DongSp detail(UUID uuid) {
        return dongSpRepository.getById(uuid);
    }

    @Override
    public Page<DongSp> phanTrang(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return dongSpRepository.findAll(pageable);
    }
}
