package catalogcar.catalogcar.DTO;

import catalogcar.catalogcar.utils.validation.UniqueName;
import catalogcar.catalogcar.Repository.BrandRepository;
import catalogcar.catalogcar.Repository.ModelRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class AddBrandsDto {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;
    @UniqueName
    private String name;
    private List<AddModelsDto> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @NotEmpty(message = "Название бренда не может быть пустым!")
    @Size(min = 1, max = 20)
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
    public AddBrandsDto(){}
    public AddBrandsDto(Date created, Date modified, String name){
        this.created = created;
        this.modified = modified;
        this.name = name;
    }
}
