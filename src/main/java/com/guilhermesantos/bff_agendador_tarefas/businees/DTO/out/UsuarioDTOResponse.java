package com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;
}
