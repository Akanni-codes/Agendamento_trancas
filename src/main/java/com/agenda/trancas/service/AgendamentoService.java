package com.agenda.trancas.service;

import com.agenda.trancas.DTO.AgendamentoDTO;
import com.agenda.trancas.model.Agendamento;
import com.agenda.trancas.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepo;
    private final ClienteRepository clienteRepo;
    private final ModeloTrancaRepository modeloRepo;
    private final MaterialRepository materialRepo;
    private final LocalAtendimentoRepository localRepo;

    public AgendamentoService(AgendamentoRepository agendamentoRepo, ClienteRepository clienteRepo,
                              ModeloTrancaRepository modeloRepo, MaterialRepository materialRepo,
                              LocalAtendimentoRepository localRepo) {
        this.agendamentoRepo = agendamentoRepo;
        this.clienteRepo = clienteRepo;
        this.modeloRepo = modeloRepo;
        this.materialRepo = materialRepo;
        this.localRepo = localRepo;
    }

    @Transactional
    public Agendamento agendar(AgendamentoDTO dto) {
        Agendamento ag = new Agendamento();
        ag.setDataAgendamento(dto.dataAgendamento());
        ag.setCliente(clienteRepo.findById(dto.clienteId()).orElseThrow());
        ag.setModelo(modeloRepo.findById(dto.modeloId()).orElseThrow());
        ag.setMaterial(materialRepo.findById(dto.materialId()).orElseThrow());
        ag.setLocal(localRepo.findById(dto.localId()).orElseThrow());

        double valor = ag.getModelo().getPrecoBase();
        ag.setValorTotal(valor);
        ag.setSinalPago(false);

        return agendamentoRepo.save(ag);
    }
}
