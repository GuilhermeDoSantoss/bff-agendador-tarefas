package com.guilhermesantos.bff_agendador_tarefas.infrastructure.exceptions;

public class IlegalArgumentException extends RuntimeException {

    public IlegalArgumentException(String message) {

        super(message);
    }

    public IlegalArgumentException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
