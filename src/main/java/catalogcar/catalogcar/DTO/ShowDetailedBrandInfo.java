package catalogcar.catalogcar.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class ShowDetailedBrandInfo {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;
    private String name;
    private List<AddModelsDto> models;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
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

    public List<AddModelsDto> getModels() {
        return models;
    }

    public void setModels(List<AddModelsDto> models) {
        this.models = models;
    }
    public ShowDetailedBrandInfo(){}
    public ShowDetailedBrandInfo(Date created, Date modified, String name){
        this.created = created;
        this.modified = modified;
        this.name = name;
    }
}
