package Developers.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gvaldes on 30/11/2016.
 */
@Configuration
@EntityScan("entities")
@ComponentScan("services.impl")
public class Configuracion {
}
