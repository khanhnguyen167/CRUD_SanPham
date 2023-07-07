package com.example.demo.controller;

import com.example.demo.entity.ChiTietSp;
import com.example.demo.service.ChiTietSpService;
import com.example.demo.service.DongSpService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.NsxService;
import com.example.demo.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/chitietsp/")
public class ChiTietSpController {
    @Autowired
    ChiTietSpService chiTietSpService;

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    NsxService nsxService;

    @Autowired
    MauSacService mauSacService;

    @Autowired
    DongSpService dongSpService;

    @GetMapping("hien-thi")
    public String ht(Model model,
                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                     @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Page<ChiTietSp> list = chiTietSpService.phanTrang(page, size);
        model.addAttribute("cts", new ChiTietSp());
        model.addAttribute("sanpham", sanPhamService.getAll());
        model.addAttribute("nsx", nsxService.getAll());
        model.addAttribute("mau", mauSacService.getAll());
        model.addAttribute("dongsp", dongSpService.getAll());
        model.addAttribute("lophocPage", list);
        return "/chitietsp/index";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cts") ChiTietSp chiTietSp, Errors errors, BindingResult result, Model model,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {

//            model.addAttribute("cts", new ChiTietSp());
            model.addAttribute("sanpham", sanPhamService.getAll());
            model.addAttribute("nsx", nsxService.getAll());
            model.addAttribute("mau", mauSacService.getAll());
            model.addAttribute("dongsp", dongSpService.getAll());
            Page<ChiTietSp> list = chiTietSpService.phanTrang(page, size);
            model.addAttribute("lophocPage", list);
            return "/chitietsp/index";
        } else {
            chiTietSpService.add(chiTietSp);
            return "redirect:/chitietsp/hien-thi";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        chiTietSpService.xoa(uuid);
        return "redirect:/chitietsp/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("cts", chiTietSpService.detail(id));
        model.addAttribute("sanpham", sanPhamService.getAll());
        model.addAttribute("nsx", nsxService.getAll());
        model.addAttribute("mau", mauSacService.getAll());
        model.addAttribute("dongsp", dongSpService.getAll());
        return "/chitietsp/update";
    }

    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("cts") ChiTietSp chiTietSp, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sanpham", sanPhamService.getAll());
            model.addAttribute("nsx", nsxService.getAll());
            model.addAttribute("mau", mauSacService.getAll());
            model.addAttribute("dongsp", dongSpService.getAll());
            return "/chitietsp/update";
        }
        chiTietSpService.add(chiTietSp);
        return "redirect:/chitietsp/hien-thi";
    }

}
