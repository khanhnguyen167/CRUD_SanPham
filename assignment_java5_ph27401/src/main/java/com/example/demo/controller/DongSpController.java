package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSp;
import com.example.demo.service.DongSpService;
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
@RequestMapping("/dongsp/")
public class DongSpController {
    @Autowired
    DongSpService dongSpService;

    @GetMapping("hien-thi")
    public String hienThi(Model model,
                          @RequestParam(name = "page", defaultValue = "0") Integer page,
                          @RequestParam(name = "size", defaultValue = "3") Integer size
    ) {

        Page<DongSp> list = dongSpService.phanTrang(page, size);
        model.addAttribute("lophocPage", list);
        model.addAttribute("sp", new DongSp());
        return "/dongsp/index";
    }

    @PostMapping("add")
    public String add(Model model, @Valid @ModelAttribute("sp") DongSp dongSp,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<DongSp> list = dongSpService.phanTrang(page, size);
            model.addAttribute("list", list);
            return "/dongsp/index";
        }
        dongSpService.add(dongSp);
        return "redirect:/dongsp/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        dongSpService.xoa(uuid);
        return "redirect:/dongsp/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID uuid, Model model) {
        DongSp sp = dongSpService.detail(uuid);
        model.addAttribute("sp", sp);
        return "/dongsp/update";
    }

//    @PostMapping("update")
//    public String updated( Model model,@ModelAttribute("sp") DongSp dongSp) {
//       dongSpService.add(dongSp);
//        return "redirect:/dongsp/hien-thi";
//    }

    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("sp") DongSp dongSp, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/dongsp/update";
        }
        dongSpService.add(dongSp);
        return "redirect:/dongsp/hien-thi";
    }



}
