package com.guilhermesantos.bff_agendador_tarefas.infrastructure.exceptions;

public class BusinessExceptions extends RuntimeException{

    public BusinessExceptions(String mensagem){
        super(mensagem);
    }

    public BusinessExceptions(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

}
