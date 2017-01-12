package services.impl;

import entities.Developer;
import services.DevelopersService;
import org.springframework.stereotype.Service;

/**
 * Created by gvaldes on 30/11/2016.
 */
@Service
public class DevelopersServiceImpl implements DevelopersService{
    public Developer getDeveloperById(Long id){
        return new Developer(id);
    }
}
