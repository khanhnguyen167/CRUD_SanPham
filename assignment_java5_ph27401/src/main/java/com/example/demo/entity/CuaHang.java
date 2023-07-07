package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "CuaHang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống")
    private String ten;

    @Column(name = "DiaChi")
    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @Column(name = "ThanhPho")
    @NotBlank(message = "Không được để trống")
    private String thanhPho;

    @Column(name = "QuocGia")
    @NotBlank(message = "Không được để trống")
    private String quocGia;
}
