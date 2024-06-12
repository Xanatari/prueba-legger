package com.example.dto;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "RegistroRequestDTO Description")
public class RegistroRequestDTO {

    @ApiModelProperty(value = "Data Exmaple for RegistroRequestDTO", required = true, example = "nombres")
    private String nombres;
	
    @ApiModelProperty(value = "Data Exmaple for RegistroRequestDTO", required = true, example = "apellidos")
    private String apellidos;
	
    @ApiModelProperty(value = "Data Exmaple for RegistroRequestDTO", required = true, example = "2023-01-15")
    private Date fecha;

    @ApiModelProperty(value = "Data Exmaple for RegistroRequestDTO", required = true, example = "Evento Id")
    private String eventoId;

}
