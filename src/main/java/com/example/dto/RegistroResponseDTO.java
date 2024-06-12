package com.example.dto;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "RegistroResponseDTO Description")
public class RegistroResponseDTO {

    @ApiModelProperty(value = "Data Exmaple for RegistroResponseDTO", required = true, example = "nombres")
    private String nombres;

    @ApiModelProperty(value = "Data Exmaple for RegistroResponseDTO", required = true, example = "apellidos")
    private String apellidos;

    @ApiModelProperty(value = "Data Exmaple for RegistroResponseDTO", required = true, example = "2023-01-15")
    private Date fecha;

}
