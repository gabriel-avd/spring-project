package entities;

/**
 * Created by gvaldes on 25/11/2016.
 */
public class Developer {
    private Long id;

    public Developer(Long id){
        this.id=id;
    }
    public Developer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
