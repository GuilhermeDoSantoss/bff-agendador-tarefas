package com.guilhermesantos.bff_agendador_tarefas.businees;

import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.LoginRequestDTO;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TarefasDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.Enuns.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static sun.security.jgss.GSSUtil.login;


@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")

    public void buscaTarefasProximaHora() {
        public LoginRequestDTO converterParaRequestDTO String token = login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo
                (horaFutura, horaFuturaMaisCinco, token);
        log.info("Tarefas encontradas " + listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuario " + tarefa.getEmailUsuario());
            tarefasService.alteraStatus(StatusNotificacaoEnum.notificado, tarefa.getId(),
                    token);
        });
        log.info("Finalizada a busca e notificaçao dee tarefas");
        public String login (LoginRequestDTO dto){
            return usuarioService.loginUsuario(dto);
        }

    }

}