package com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in;

import io.swagger.v3.oas.annotations.info.Contact;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {
    private String email;
    private String senha;

}
