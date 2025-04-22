package com.agenda.trancas.controller;

import com.agenda.trancas.DTO.AgendamentoDTO;
import com.agenda.trancas.model.Agendamento;
import com.agenda.trancas.service.AgendamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*") // Permite acesso do front-end React
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping
    public Agendamento criar(@RequestBody AgendamentoDTO dto) {
        return service.agendar(dto);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return service.listarTodos();
    }
}
