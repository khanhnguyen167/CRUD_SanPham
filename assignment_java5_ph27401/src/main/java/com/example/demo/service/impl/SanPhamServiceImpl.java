package com.example.demo.service.impl;

import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void xoa(UUID uuid) {
        sanPhamRepository.deleteById(uuid);
    }

    @Override
    public void addOrUpdate(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham detail(UUID uuid) {
        return sanPhamRepository.getById(uuid);
    }

    @Override
    public Page<SanPham> phanTrang(Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        return sanPhamRepository.findAll(pageable);
    }
}
