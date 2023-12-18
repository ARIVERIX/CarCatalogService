package catalogcar.catalogcar.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShowBrandInfoDto {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
    private String name;


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShowBrandInfoDto(){}
    public ShowBrandInfoDto(Date created, String name){
        this.created = created;
        this.name = name;
    }
}
