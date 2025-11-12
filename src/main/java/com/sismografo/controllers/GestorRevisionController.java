package com.sismografo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sismografo.services.GestorRevisionService;
import com.sismografo.dto.EventoSismicoDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import com.sismografo.dto.DatosSismosDto;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sismografo.dto.ModificacionDto;

@RestController
@RequestMapping("/revision-manual")
public class GestorRevisionController {

    private final GestorRevisionService gestorRevisionService;

    public GestorRevisionController(GestorRevisionService gestorRevisionService){
        this.gestorRevisionService = gestorRevisionService;
    }


    @GetMapping("/auto-detectados")
    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        return gestorRevisionService.buscarEventosNoRevisados();
    }

    @PatchMapping("/bloquear/{idEvento}")
    public DatosSismosDto bloquearEvento(@PathVariable Long idEvento) {
        return gestorRevisionService.bloquearEvento(idEvento);
        
    }

    @PatchMapping("/mapa/{solicitud}")
    public void tomarSolicitud(@PathVariable Boolean solicitud){
        gestorRevisionService.tomarSolicitud(solicitud);
    }

    @PatchMapping("/modificar/{modificacion}")
    public String[] tomarModificacion(@PathVariable Boolean modificacion, @RequestBody(required = false) ModificacionDto modificacionInfo) {
    return gestorRevisionService.tomarModificacion(modificacion, modificacionInfo);
}

    
    @PatchMapping("/rechazar/{opc}")
    public void rechazarEvento(@PathVariable String opc) {
        gestorRevisionService.tomarAccion(opc);
        
    }

}
