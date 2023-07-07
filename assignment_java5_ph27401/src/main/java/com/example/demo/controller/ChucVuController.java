package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;

    @GetMapping("hien-thi")
    public String ht(Model model,
                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                     @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Page<ChucVu> list = chucVuService.phanTrang(page, size);
        model.addAttribute("cv", new ChucVu());
        model.addAttribute("lophocPage", list);
        return "/chucvu/index";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("cv") ChucVu chucVu, BindingResult result, Model model,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            // Handle validation errors
            Page<ChucVu> list = chucVuService.phanTrang(page, size);
            model.addAttribute("lophocPage", list);
            return "/chucvu/index";
        }
        // No validation errors, proceed with adding the ChucVu object
        chucVuService.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        chucVuService.xoa(uuid);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("cv", chucVuService.detail(id));
        return "/chucvu/update";
    }

    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("cv") ChucVu chucVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/chucvu/update";
        }
        chucVuService.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

}
