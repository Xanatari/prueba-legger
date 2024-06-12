package com.example.dto;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "LugarRequestDTO Description")
public class LugarRequestDTO {

    @ApiModelProperty(value = "Data Exmaple for LugarRequestDTO", required = true, example = "nombre")
    private String nombre;
	
    @ApiModelProperty(value = "Data Exmaple for LugarRequestDTO", required = true, example = "15")
    private int capacidad;

    @ApiModelProperty(value = "Data Exmaple for LugarRequestDTO", required = true, example = "15")
    private String id;
}
