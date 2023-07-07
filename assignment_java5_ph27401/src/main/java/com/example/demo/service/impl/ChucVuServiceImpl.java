package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {


    @Autowired
    ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public void add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void xoa(UUID uuid) {
        chucVuRepository.deleteById(uuid);
    }

    @Override
    public ChucVu detail(UUID id) {
        return   chucVuRepository.getById(id);

    }

    @Override
    public Page<ChucVu> phanTrang(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return chucVuRepository.findAll(pageable);
    }

}
