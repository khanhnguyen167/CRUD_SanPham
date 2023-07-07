package com.example.demo.controller;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/khachhang/")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("hien-thi")
    public String ht(Model model,
                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                     @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Page<KhachHang> lophocPage = khachHangService.phanTrang(page, size);
        model.addAttribute("lophocPage",lophocPage);
        model.addAttribute("kh",new KhachHang());
        return "/khachhang/index";
    }
//    @PostMapping("add")
//    public  String add(@ModelAttribute("kh") KhachHang khachHang){
//        khachHangService.add(khachHang);
//        return "redirect:/khachhang/hien-thi";
//    }

    @PostMapping("add")
    public String add(Model model, @Valid @ModelAttribute("kh") KhachHang khachHang,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<KhachHang> lophocPage = khachHangService.phanTrang(page, size);
            model.addAttribute("lophocPage",lophocPage);
            return "/khachhang/index";
        }
        khachHangService.add(khachHang);
        return "redirect:/khachhang/hien-thi";
    }


    @GetMapping("delete/{id}")
    public  String detail(@PathVariable("id")UUID uuid){
        khachHangService.xoa(uuid);
        return "redirect:/khachhang/hien-thi";
    }


    @GetMapping("update/{id}")
    public  String update(Model model,@PathVariable("id")UUID uuid){
        khachHangService.detail(uuid);
        model.addAttribute("kh",khachHangService.detail(uuid));
        return "/khachhang/update";
    }


//    @PostMapping("update")
//    public  String update1(@ModelAttribute("kh") KhachHang khachHang){
//        khachHangService.add(khachHang);
//        return "redirect:/khachhang/hien-thi";
//    }
    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/khachhang/update";
        }
        khachHangService.add(khachHang);
        return "redirect:/khachhang/hien-thi";
    }


}
