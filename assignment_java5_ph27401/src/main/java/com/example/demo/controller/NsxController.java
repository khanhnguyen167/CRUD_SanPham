package com.example.demo.controller;

import com.example.demo.entity.Nsx;
import com.example.demo.service.NsxService;
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
@RequestMapping("/nsx/")
public class NsxController {


    @Autowired
    NsxService nsxService;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size
    ) {
        Page<Nsx> list = nsxService.phanTrang(page, size);
//        model.addAttribute("list",nsxService.getAll());
        model.addAttribute("lophocPage", list);
        model.addAttribute("nsx", new Nsx());
        return "/nsx/index";
    }


//    @PostMapping("add")
//    public  String add(@ModelAttribute("nsx") Nsx nsx){
//        nsxService.addOrUpdate(nsx);
//        return "redirect:/nsx/hien-thi";
//    }


    @PostMapping("add")
    public String add(Model model, @Valid @ModelAttribute("nsx") Nsx nsx,
                      BindingResult result,
                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {
        if (result.hasErrors()) {
            Page<Nsx> list = nsxService.phanTrang(page, size);
//        model.addAttribute("list",nsxService.getAll());
            model.addAttribute("lophocPage", list);
//            model.addAttribute("nsx", new Nsx());
            return "/nsx/index";
        }
        nsxService.addOrUpdate(nsx);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID uuid) {
        nsxService.xoa(uuid);
        return "redirect:/nsx/hien-thi";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("nsx", nsxService.detail(id));
        return "/nsx/update";
    }

//    @PostMapping("update")
//    public String update1(@ModelAttribute("nsx") Nsx nsx) {
//        nsxService.addOrUpdate(nsx);
//        return "redirect:/nsx/hien-thi";
//    }


    @PostMapping("update")
    public String update1(@Valid @ModelAttribute("nsx") Nsx nsx, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/nsx/update";
        }
        nsxService.addOrUpdate(nsx);
        return "redirect:/nsx/hien-thi";
    }
}
