package com.example.dto;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "LugarResponseDTO Description")
public class LugarResponseDTO {

    @ApiModelProperty(value = "Data Exmaple for LugarResponseDTO", required = true, example = "Lugar Id")
    private String id;

    @ApiModelProperty(value = "Data Exmaple for LugarResponseDTO", required = true, example = "nombre")
    private String nombre;

    @ApiModelProperty(value = "Data Exmaple for LugarResponseDTO", required = true, example = "15")
    private int capacidad;

}
