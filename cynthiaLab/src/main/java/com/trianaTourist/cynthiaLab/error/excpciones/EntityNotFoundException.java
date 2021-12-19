package com.trianaTourist.cynthiaLab.error.excpciones;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }
}
