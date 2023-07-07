package com.example.demo.controller;

import com.example.demo.entity.DongSp;
import com.example.demo.entity.Nsx;
import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
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
@RequestMapping("/sanpham/")
public class SanPhamController {

    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") Integer page,
                          @RequestParam(value = "size",defaultValue = "5") Integer size
    ){
        Page<SanPham> list = sanPhamService.phanTrang(page,size);
//        model.addAttribute("list",nsxService.getAll());
        model.addAttribute("lophocPage",list);
        model.addAttribute("sp",new SanPham());
        return "/sanpham/index";
    }


//    @PostMapping("add")
//    public  String add(@ModelAttribute("sp") SanPham sanPham){
//        sanPhamService.addOrUpdate(sanPham);
//        return "redirect:/sanpham/hien-thi";
//    }

    @PostMapping("add")
    public String add(Model model, @Valid @ModelAttribute("sp") SanPham sanPham,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<SanPham> list = sanPhamService.phanTrang(page,size);
//        model.addAttribute("list",nsxService.getAll());
            model.addAttribute("lophocPage",list);

            return "/sanpham/index";
        }
        sanPhamService.addOrUpdate(sanPham);
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("delete/{id}")
    public  String delete(@PathVariable("id") UUID uuid){
        sanPhamService.xoa(uuid);
        return "redirect:/sanpham/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model){
        model.addAttribute("sp",sanPhamService.detail(id));
        return  "/sanpham/update";
    }

//    @PostMapping("update")
//    public  String update1(@ModelAttribute("nsx") SanPham sanPham){
//        sanPhamService.addOrUpdate(sanPham);
//        return "redirect:/sanpham/hien-thi";
//    }

    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("sp") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return  "/sanpham/update";
        }
        sanPhamService.addOrUpdate(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
}
