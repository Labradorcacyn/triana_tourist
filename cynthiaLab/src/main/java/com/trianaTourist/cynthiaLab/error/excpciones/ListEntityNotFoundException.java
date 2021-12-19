package com.trianaTourist.cynthiaLab.error.excpciones;

public class ListEntityNotFoundException extends EntityNotFoundException{
    public ListEntityNotFoundException(Class clazz){
        super(String.format(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName())));
    }
}
