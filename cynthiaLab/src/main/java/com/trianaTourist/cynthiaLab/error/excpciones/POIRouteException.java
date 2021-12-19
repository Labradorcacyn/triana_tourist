package com.trianaTourist.cynthiaLab.error.excpciones;

public class POIRouteException extends EntityNotFoundException {
    public POIRouteException(String id, Class clazz){
        super(String.format("No se puede incluir de nuevo el punto de interes en la ruta %s con ID: %s", clazz.getName(), id));
    }
}
