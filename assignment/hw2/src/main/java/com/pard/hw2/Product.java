package com.pard.hw2;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    private Integer id;
    private String name;
    private Integer prize;
    private Integer amount;
}
