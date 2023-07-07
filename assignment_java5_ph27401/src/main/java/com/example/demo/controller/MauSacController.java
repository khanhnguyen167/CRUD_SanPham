package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String ht(
            Model model, @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Page<MauSac> list = mauSacService.phanTrang(page, size);
//        List<MauSac> list = mauSacService.getAll();
        model.addAttribute("lophocPage", list);
        model.addAttribute("ms", new MauSac());
        return "/mausac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }


//    @PostMapping("add")
//    public String add(@ModelAttribute("ms") MauSac mauSac) {
//        mauSacService.add(mauSac);
//        return "redirect:/mau-sac/hien-thi";
//    }

    @PostMapping("add")
    public String add(Model model, @Valid @ModelAttribute("ms") MauSac mauSac,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<MauSac> list = mauSacService.phanTrang(page, size);
            model.addAttribute("lophocPage", list);
            return "/mausac/index";
        }
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }


    @GetMapping("update/{id}")
    public String updatev(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("ms", mauSacService.detail(id));
        return "/mausac/update";
    }
//    @PostMapping("update")
//    public String update(@ModelAttribute("ms") MauSac mauSac) {
//        mauSacService.add(mauSac);
//        return "redirect:/mau-sac/hien-thi";
//    }

    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("ms") MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/mausac/update";
        }
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
