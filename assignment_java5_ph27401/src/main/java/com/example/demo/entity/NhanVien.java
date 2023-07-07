package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")

    @NotBlank(message = "Không được để trống")
    private String ma;

    @Column(name = "Ho")
    @NotBlank(message = "Không được để trống")
    private String ho;

    @Column(name = "TenDem")
    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống")
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "Id")
    private ChucVu chucVu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "Id")
    private CuaHang cuaHang;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    public String namSinh() {
        if (ngaySinh != null && ngaySinh.length() >= 4) {
            return ngaySinh.substring(0, 4);
        } else {
            return "";
        }
    }

    public Integer tuoi() {
        Integer tuoi1 = Integer.valueOf(namSinh());
        return tuoi1;
    }

}
