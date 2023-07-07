package com.example.demo.service.impl;

import com.example.demo.entity.Nsx;
import com.example.demo.repository.NsxRepositoty;
import com.example.demo.service.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NsxServiceImpl implements NsxService  {

    @Autowired
    NsxRepositoty nsxRepositoty;
    @Override
    public List<Nsx> getAll() {
        return nsxRepositoty.findAll();
    }

    @Override
    public void xoa(UUID uuid) {
        nsxRepositoty.deleteById(uuid);
    }

    @Override
    public void addOrUpdate(Nsx nsx) {
        nsxRepositoty.save(nsx);
    }

    @Override
    public Nsx detail(UUID uuid) {
        return nsxRepositoty.getById(uuid);
    }

    @Override
    public Page<Nsx> phanTrang(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return nsxRepositoty.findAll(pageable);
    }
}
