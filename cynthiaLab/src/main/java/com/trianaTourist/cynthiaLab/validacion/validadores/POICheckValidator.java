package com.trianaTourist.cynthiaLab.validacion.validadores;

import com.trianaTourist.cynthiaLab.model.Route;
import com.trianaTourist.cynthiaLab.repo.RouteRepository;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.POICheck;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class POICheckValidator implements ConstraintValidator<POICheck,String> {

    @Autowired
    private RouteRepository repository;

    private String idRoute;
    private String idPOI;

    @Override
    public void initialize(POICheck constraintAnnotation) {
        idRoute = constraintAnnotation.idRoute();
        idPOI = constraintAnnotation.idPOI();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String idRouteValue = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(idRoute);
        String idPOIValue = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(idPOI);

        if(repository.findById(Long.parseLong(idRouteValue)).isPresent()){
            Route ruta = repository.findById(Long.parseLong(idRouteValue)).get();
            ruta.getSteps().stream().map(poi->{
                if(poi.getId().equals(Long.parseLong(idPOIValue))){
                    return true;
                }
                return false;
            });
        }
        return false;
    }
}
