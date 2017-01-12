package Developers.Controllers;

import entities.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import services.DevelopersService;


/**
 * Created by gvaldes on 25/11/2016.
 */
@RestController
public class DevelopersController {

    @Autowired
    private
    DevelopersService developersService;

    @RequestMapping(value="/descripcion", method = RequestMethod.GET)
    public ResponseEntity index()
    {
        Developer dev= new Developer();

        dev = getDevelopersService().getDeveloperById(40L);

        return new ResponseEntity(dev, HttpStatus.OK);
    }

    public DevelopersService getDevelopersService() {
        return developersService;
    }

    public void setDevelopersService(DevelopersService developersService) {
        this.developersService = developersService;
    }
}
