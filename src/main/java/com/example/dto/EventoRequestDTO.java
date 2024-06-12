package com.example.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.model.LugarEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "EventoRequestDTO Description")
public class EventoRequestDTO {

    @ApiModelProperty(value = "Data Exmaple for EventoRequestDTO", required = true, example = "nombre")
    private String nombre;
	
    @ApiModelProperty(value = "Data Exmaple for EventoRequestDTO", required = true, example = "2023-01-15")
    private Date fecha;
	
    @ApiModelProperty(value = "Data Exmaple for EventoRequestDTO", required = true, example = "descripcion")
    private String descripcion;
	
    @ApiModelProperty(value = "Data Exmaple for EventoRequestDTO", required = true, example = "true")
    private boolean estado;

    @ApiModelProperty(value = "Data Exmaple for EventoRequestDTO", required = true, example = "true")
    private List<String> lugares;
	
}
