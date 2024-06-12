package com.example.dto;

import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "EventoResponseDTO Description")
public class EventoResponseDTO {

    @ApiModelProperty(value = "Data Exmaple for EventoResponseDTO", required = true, example = "nombre")
    private String nombre;

    @ApiModelProperty(value = "Data Exmaple for EventoResponseDTO", required = true, example = "2023-01-15")
    private Date fecha;

    @ApiModelProperty(value = "Data Exmaple for EventoResponseDTO", required = true, example = "descripcion")
    private String descripcion;

    @ApiModelProperty(value = "Data Exmaple for EventoResponseDTO", required = true, example = "true")
    private boolean estado;

}
