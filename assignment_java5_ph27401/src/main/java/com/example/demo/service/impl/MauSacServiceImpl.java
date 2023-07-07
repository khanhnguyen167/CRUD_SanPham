package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void delete(UUID uuid) {
        mauSacRepository.deleteById(uuid);
    }

    @Override
    public MauSac detail(UUID id) {
        return mauSacRepository.getById(id);
    }

    @Override
    public Page<MauSac> phanTrang(Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        return mauSacRepository.findAll(pageable);
    }
}
