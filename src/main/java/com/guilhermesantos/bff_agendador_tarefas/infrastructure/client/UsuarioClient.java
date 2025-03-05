package com.guilhermesantos.bff_agendador_tarefas.infrastructure.client;

import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.EnderecoDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.LoginRequestDTO;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.TelefoneDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.UsuarioDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.EnderecoDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TelefoneDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.UsuarioDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscarUsuarioPorEmail(@RequestParam("email") String email,
                                             @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTOResponse usuarioDTO);

    @PostMapping("/login")
   String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone (@RequestBody TelefoneDTORequest dto,
                                          @RequestParam("id") Long id,
                                          @RequestHeader("Authorization") String token);


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader(value = "Authorization", required = false)String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone (@RequestBody TelefoneDTORequest dto,
                                          @RequestHeader(value = "Authorization", required = false) String token);

    @GetMapping("/endereco/{cep}")
   ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);

}
