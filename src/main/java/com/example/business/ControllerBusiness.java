package com.example.business;
 
import com.example.dto.EventoRequestDTO;
import com.example.dto.LugarDTO;
import com.example.dto.RegistroRequestDTO;
import com.example.repository.*;
import com.example.model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.util.LoggerUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Component
public class ControllerBusiness {

	@Autowired
	LoggerUtil log;

	@Autowired
    EventoRepository eventoRepository;


	public EventoEntity crearEvento(EventoRequestDTO eventoRequestDTO) {
		EventoEntity evento = new EventoEntity();
		evento.setNombre(eventoRequestDTO.getNombre());
		evento.setFecha(eventoRequestDTO.getFecha());
		evento.setDescripcion(eventoRequestDTO.getDescripcion());
		evento.setEstado(eventoRequestDTO.isEstado());

		List<String> lugaresId = new ArrayList<>();
		for (String lugarId : eventoRequestDTO.getLugares()) {
			LugarEntity lugar = lugarRepository.findById(lugarId)
					.orElseThrow(() -> new RuntimeException("Lugar no encontrado con ID: " + lugarId));
			lugaresId.add(lugar.getId());
		}
		evento.setLugaresId(lugaresId);

		return eventoRepository.save(evento);
	}

	public List<EventoEntity> getDataEvento() {
		log.info("Get All Events ", "Try to get All Event");
		List<EventoEntity> result = new ArrayList<EventoEntity>();
		eventoRepository.findAll().forEach((final EventoEntity r) -> result.add(r));
		return result;
	}
   
	@Autowired
    LugarRepository lugarRepository;

	public void addDataLugar(LugarEntity data) {
		lugarRepository.save(data);
	}

	public void updateLugar(LugarEntity data) {
		lugarRepository.updateLugar(data.getId(), data.getNombre(), data.getCapacidad());
	}
	public void updateCapacidad(LugarEntity data) {
		lugarRepository.updateCapacidad(data.getId(), data.getCapacidad());
	}

	public List<LugarEntity> getDataLugar()  {
		List<LugarEntity> result = new ArrayList<LugarEntity>();
		lugarRepository.findAll().forEach((final LugarEntity r) -> result.add(r));
		return result;
	}
   
	@Autowired
    RegistroRepository registroRepository;

	public void addDataRegistro(RegistroEntity data) {
		registroRepository.save(data);
	}

	public List<RegistroEntity> getDataRegistro() {
		List<RegistroEntity> result = new ArrayList<RegistroEntity>();
		registroRepository.findAll().forEach((final RegistroEntity r) -> result.add(r));
		return result;
	}


	@Transactional
	public RegistroEntity registrarPersonaEvento(RegistroRequestDTO data) {
		EventoEntity eventoEntity = eventoRepository.findById(data.getEventoId())
				.orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));

		List<String> lugaresIds = eventoEntity.getLugaresId();

		lugaresIds.forEach(s -> {
			LugarEntity lugar = lugarRepository.findById(s)
					.orElseThrow(() -> new RuntimeException("Lugar no encontrado con ID: " + s));
			if (lugar.getCapacidad() <= 0) {
				throw new IllegalArgumentException("No hay capacidad disponible en el lugar con ID " + lugar.getId());
			}

			lugar.setCapacidad(lugar.getCapacidad() - 1);
			lugarRepository.save(lugar);
		});

		RegistroEntity registro = new RegistroEntity();
		registro.setNombres(data.getNombres());
		registro.setApellidos(data.getApellidos());
		registro.setFecha(data.getFecha());
		registro.setEvento(eventoEntity);

		return registroRepository.save(registro);
	}
}
