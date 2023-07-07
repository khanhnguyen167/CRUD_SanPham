package com.example.demo.controller;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class NhanVienController {


    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @Autowired
    CuaHangService cuaHangService;

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<NhanVien> lopHocPage = nhanVienService.phanTrang(page, size);
        model.addAttribute("lophocPage", lopHocPage);
        model.addAttribute("chucVu", chucVuService.getAll());
        model.addAttribute("cuaHang", cuaHangService.getAll());
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("list", lopHocPage);
        return "index";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String removeNv(@PathVariable("id") UUID id) {
        nhanVienService.xoa(id);
        return "redirect:/nhan-vien/hien-thi";
    }

//    @PostMapping("/nhan-vien/add")
//    public String addNewNv(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
//                           @RequestParam(value = "size", defaultValue = "5") int size,
//                           @ModelAttribute("nv") NhanVien nhanVien
//    ) {
//        nhanVienService.add(nhanVien);
//        return "redirect:/nhan-vien/hien-thi";
//    }

    @PostMapping("/nhan-vien/add")
    public String add(Model model, @Valid          @ModelAttribute("nv") NhanVien nhanVien,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<NhanVien> lopHocPage = nhanVienService.phanTrang(page, size);
            model.addAttribute("lophocPage", lopHocPage);
            model.addAttribute("chucVu", chucVuService.getAll());
            model.addAttribute("cuaHang", cuaHangService.getAll());
//            model.addAttribute("nv", new NhanVien());
            model.addAttribute("list", lopHocPage);
            return "index";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id,
                             Model model) {
        model.addAttribute("chucVu", chucVuService.getAll());
        model.addAttribute("cuaHang", cuaHangService.getAll());
        model.addAttribute("nv", nhanVienService.detail(id));
        return "update";
    }

//    @PostMapping("/nhan-vien/update")
//    public String updateNv( @ModelAttribute("nv") NhanVien nhanVien,
//                         Model model
//    ) {
//
//        nhanVienService.add(nhanVien);
//        return "redirect:/nhan-vien/hien-thi";
//    }


    @PostMapping("/nhan-vien/update")
    public String update1(@Valid @ModelAttribute("nv") NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("chucVu", chucVuService.getAll());
            model.addAttribute("cuaHang", cuaHangService.getAll());

            return "update";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
