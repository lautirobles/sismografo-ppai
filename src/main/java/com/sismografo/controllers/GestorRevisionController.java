package com.sismografo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sismografo.services.GestorRevisionService;
import com.sismografo.dto.EventoSismicoDto;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gestor-revision")
public class GestorRevisionController {

    private final GestorRevisionService gestorRevisionService;

    public GestorRevisionController(GestorRevisionService gestorRevisionService){
        this.gestorRevisionService = gestorRevisionService;
    }


    // paso 6: el gestor busca todos los eventos no revisados, el front envia la request a /gestor-revision
    @GetMapping("/auto-detectados")
    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        return gestorRevisionService.buscarEventosNoRevisados();
    }

    @PatchMapping("/bloquear/{idEvento}")
    public String bloquearEvento(@PathVariable Long idEvento) {
        gestorRevisionService.bloquearEvento(idEvento);
        return "Evento con ID " + idEvento + " bloqueado correctamente.";
    }

}
