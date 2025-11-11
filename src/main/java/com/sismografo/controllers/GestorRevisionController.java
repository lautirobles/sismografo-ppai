package com.sismografo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.sismografo.services.GestorRevisionService;
import com.sismografo.dto.EventoSismicoDto;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping
    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        return gestorRevisionService.buscarEventosNoRevisados();
    }


}
