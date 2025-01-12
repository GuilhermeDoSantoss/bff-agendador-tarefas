package com.guilhermesantos.bff_agendador_tarefas.businees;


import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.EnderecoDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.LoginRequestDTO;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.TelefoneDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.UsuarioDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.EnderecoDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TelefoneDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.UsuarioDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioClient client;
    private UsuarioDTOResponse UsuarioDTO;


    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(UsuarioDTO);
    }

    public UsuarioDTOResponse loginUsuario(LoginRequestDTO dto){
        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
    return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
       return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){
        return atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
       return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return client.cadastraTelefone(dto, token);
    }

}
