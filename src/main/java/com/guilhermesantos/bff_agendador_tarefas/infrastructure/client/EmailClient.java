package com.guilhermesantos.bff_agendador_tarefas.infrastructure.client;

import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

   void enviarEmail(@RequestBody TarefasDTOResponse dto);
}
