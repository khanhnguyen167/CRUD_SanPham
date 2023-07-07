package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChiTietSp {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    Nsx nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    DongSp dongSp;

    @Column(name = "NamBH")
    @NotNull(message = "Khong duoc de trong")
    Integer namBh;

    @Column(name = "MoTa")
    @NotBlank(message = "Không được để trống")
    String moTa;

    @Column(name = "SoLuongTon")
    @NotNull(message = "Không được để trống")
    Integer soLuongTon;

    @Column(name = "GiaNhap")
    @NotNull(message = "Không được để trống")
    BigDecimal giaNhap;

    @Column(name = "GiaBan")
    @NotNull(message = "Không được để trống")
    BigDecimal giaBan;
}
