package com.trianaTourist.cynthiaLab.dtos.poiDtos;

import com.trianaTourist.cynthiaLab.model.Categoria;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.ExistCategory;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.LocatedValid;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UrlValid;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@UrlValid(coverPhoto = "coverPhoto", photo2 = "photo2", photo3 = "photo3", message = "{POI.url.valid}")
public class POIDto {

    @NotBlank(message = "{POI.name.blank}")
    private String name;

    @NotBlank(message = "{POI.location.blank}")
    @Pattern(
            regexp = "^(\\-?\\d+(\\.\\d+)?),\\w*(\\-?\\d+(\\.\\d+)?)$",
            message = "{estacionServicio.maps.validate}"
    )
    @LocatedValid(location = "location", message = "{POI.location.valid}")
    private String location;

    @Lob
    private String description;

    @Past
    private LocalDateTime date;

    @ExistCategory
    @NotNull(message = "{POI.categoria.blank}")
    private Long categoria;

    @URL
    @NotBlank(message = "{url.null}")
    private String coverPhoto;

    @URL
    private String photo2;

    @URL
    private String photo3;
}
