package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "ChucVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được để trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được để trống")
    private String ten;
}
