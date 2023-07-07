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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "KhachHang")
@Builder
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống")
    private String ten;

    @Column(name = "TenDem")
    @NotBlank(message = "Không được để trống")
    private String tenDem;

    @Column(name = "Ho")
    @NotBlank(message = "Không được để trống")
    private String ho;

    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @Column(name = "Sdt")
    @NotBlank(message = "Không được để trống")
    private String sdt;

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
