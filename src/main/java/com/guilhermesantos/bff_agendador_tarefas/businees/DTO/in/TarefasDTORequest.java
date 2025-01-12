package com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guilhermesantos.bff_agendador_tarefas.businees.Enuns.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {


    private String nomeTrefa;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;

}
