package com.guilhermesantos.bff_agendador_tarefas.controller;


import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.EnderecoDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.LoginRequestDTO;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.TelefoneDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.in.UsuarioDTORequest;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.EnderecoDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.TelefoneDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.UsuarioDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.DTO.out.ViaCepDTOResponse;
import com.guilhermesantos.bff_agendador_tarefas.businees.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login e usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping
    @Operation(summary = "Salvar Usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "400", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO){
        return ResponseEntity.ok((UsuarioDTOResponse) usuarioService.salvaUsuario(usuarioDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login Usuários", description = "Login do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credencias inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginRequestDTO usuarioDTO){
        return usuarioService(usuarioDTO);
    }


    @GetMapping
    @Operation(summary = "Bascar dados de usuários por Email",
            description = "Buscar dados do usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "403", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorEmail(@RequestParam("email") String email,
                                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deletar Usuários por Id", description = "Deleta usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader("Authorization") String token){
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualizar Dados de Usuários",
            description = "Atualizar dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(value = responseCode == "401", description = "Credenciais inválidas")
    public ResponseEntity<UsuarioDTOResponse> atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                                                   @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(token, dto));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza Endereços de Usuários",
            description = "Atualiza endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço aualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<EnderecoDTOResponse> atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id,dto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza Telefone de Usuários",
            description = "Atualiza telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone atualizado com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<TelefoneDTOResponse> atualizaTelefone (@RequestBody TelefoneDTORequest dto,
                                                                 @RequestParam("id") Long id,
                                                                 @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(usuarioService.atualizaTelefone(dto, id));
    }
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @PostMapping("/endereco")
    @Operation(summary = "Salva Endereço de Usuários",
            description = "Salva endereço de usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDTOResponse> cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                                                @RequestHeader("Authorization")String token){
    return ResponseEntity.ok(usuarioService.cadastraEndereco(token, dto, token));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Salva Telefone de Usuários",
            description = "Salva telefone de usuário")
    @ApiResponse(responseCode = "200", description = "Telefone salvo com sucesso")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDTOResponse> cadastraTelefone (@RequestBody TelefoneDTORequest dto,
                                                                 @RequestParam("Authorization") String token){
        return ResponseEntity.ok(usuarioService.cadastraTelefone(token, dto));
    }


    @GetMapping("/endereco/{cep}")
    @Operation(summary = "Busca endereco pelo cep",
            description = "Busca dados de endereco recebendo um cep")
    @ApiResponse(responseCode = "200", description = "Dados de endereço retornados com sucesso")
    @ApiResponse(responseCode = "400", description = "Cep inválido")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ViaCepDTOResponse> buscarEndereco (@PathVariable("cep") String cep){
        return ResponseEntity.ok(usuarioService.buscarEnderecoPorCep(cep));
    }
 }
