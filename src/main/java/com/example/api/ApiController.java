package com.example.api;


import com.example.util.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.business.ControllerBusiness;

import com.example.dto.*;
import com.example.model.*;
import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Accion exitosa"),
        @ApiResponse(code = 500, message = "Internal Server Error")
})
@Api(value = "app-eventos-corporativos-api ApiController", description = "Eventos Corporativos es un app que se encarga de verificar diponilibades de lugares y permitir la creación de eventos en ellos. Adicional debe permiitr el registro de personas al evento",  tags = {"",""})
public class ApiController {

    @Autowired
    ControllerBusiness controllerBusiness;

	@Value("${spring.application.version}")
	private String version;

	@GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity<>(version, HttpStatus.OK);
    }

	@ApiOperation(value = "Obtener lista de Evento", notes = "Retorna listado de Evento del sistema xxxxx")
	@GetMapping("evento")
    public List<EventoResponseDTO> getEvento() {
       return MapperUtil.mapAll(controllerBusiness.getDataEvento(),EventoResponseDTO.class);
    }

    @PostMapping("evento")
    public ResponseEntity<EventoEntity> crearEvento(@RequestBody EventoRequestDTO eventoRequestDTO) {
        EventoEntity nuevoEvento = controllerBusiness.crearEvento(eventoRequestDTO);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

	@ApiOperation(value = "Obtener lista de Lugar", notes = "Retorna listado de Lugar del sistema xxxxx")
	@GetMapping("lugar")
    public List<LugarResponseDTO> getLugar() {
        return MapperUtil.mapAll(controllerBusiness.getDataLugar(),LugarResponseDTO.class);
    }

	@PostMapping("lugar")
    public ResponseEntity<LugarRequestDTO> putLugar(@RequestBody LugarRequestDTO dto) {
		
		LugarEntity data = MapperUtil.map(dto,LugarEntity.class);
	    controllerBusiness.addDataLugar(data);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("lugar")
    public ResponseEntity<LugarRequestDTO> updateLugar(@RequestBody LugarRequestDTO dto ){

        LugarEntity data = MapperUtil.map(dto,LugarEntity.class);
        controllerBusiness.updateLugar(data);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PutMapping("lugar/capacidad")
    public ResponseEntity<LugarRequestDTO> updateCapacidadLugar(@RequestBody LugarRequestDTO dto ){

        LugarEntity data = MapperUtil.map(dto,LugarEntity.class);
        controllerBusiness.updateCapacidad(data);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

	@ApiOperation(value = "Obtener lista de Registro", notes = "Retorna listado de Registro del sistema xxxxx")
	@GetMapping("registro")
    public List<RegistroResponseDTO> getRegistro() {
       return MapperUtil.mapAll(controllerBusiness.getDataRegistro(),RegistroResponseDTO.class);
    }

	@PostMapping("registro")
    public ResponseEntity<RegistroRequestDTO> putRegistro(@RequestBody RegistroRequestDTO dto) {

	    controllerBusiness.registrarPersonaEvento(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }








}
