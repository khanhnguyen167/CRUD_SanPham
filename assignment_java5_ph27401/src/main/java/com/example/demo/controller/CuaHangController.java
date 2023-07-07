package com.example.demo.controller;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSp;
import com.example.demo.service.CuaHangService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {
    @Autowired
    CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String ht(Model model,
                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                     @RequestParam(name = "size", defaultValue = "5") Integer size

    ) {
        Page<CuaHang> list = cuaHangService.phanTrang(page, size);
        model.addAttribute("ch", new CuaHang());
        model.addAttribute("lophocPage", list);
        return "/cuahang/index";
    }

//    @PostMapping("add")
//    public  String add(@Valid  @ModelAttribute("ch") CuaHang cuaHang,
//                          Model model,
//                          @RequestParam(name = "page", defaultValue = "0") Integer page,
//                          @RequestParam(name = "size", defaultValue = "5") Integer size,
//                          BindingResult result){
//        if(result.hasErrors()){
//            Page<CuaHang> list = cuaHangService.phanTrang(page, size);
//            model.addAttribute("lophocPage",list);
//            return "/cuahang/index";
//        }
//        cuaHangService.add(cuaHang);
//        return "redirect:/cua-hang/hien-thi";
//    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("ch") CuaHang cuaHang, BindingResult result, Model model,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<CuaHang> list = cuaHangService.phanTrang(page, size);
            model.addAttribute("lophocPage", list);
            return "/cuahang/index";
        }
        cuaHangService.add(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }


    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        cuaHangService.delete(uuid);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("ch", cuaHangService.detail(id));
        return "/cuahang/update";
    }

//    @PostMapping("update")
//    public String update1(@ModelAttribute("ch") CuaHang cuaHang) {
//        cuaHangService.add(cuaHang);
//        return "redirect:/cua-hang/hien-thi";
//    }
    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("ch") CuaHang cuaHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/cuahang/update";
        }
        cuaHangService.add(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

}
