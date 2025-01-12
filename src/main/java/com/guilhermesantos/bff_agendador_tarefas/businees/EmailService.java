package com.guilhermesantos.bff_agendador_tarefas.businees;


import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TarefasDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail gravarTarefa(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}

