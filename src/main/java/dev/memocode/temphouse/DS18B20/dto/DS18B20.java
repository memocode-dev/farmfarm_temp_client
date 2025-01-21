package dev.memocode.temphouse.DS18B20.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class DS18B20  {
    private Double temperature;
}
