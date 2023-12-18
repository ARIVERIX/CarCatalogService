package catalogcar.catalogcar.DTO;
import catalogcar.catalogcar.Model.Model;
import catalogcar.catalogcar.utils.validation.UniqueName;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class AddModelsDto {
    private int id;
    private Model.Category category;
    private Date created;
    private int end_year;
    private String image_url;
    private Date modified;
    @UniqueName
    private String name;
    private int start_year;
    private Integer brand_id;
    private AddOffersDto offers;
    private AddOffersDto model_id;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}


    public Model.Category getCategory() {return category;}
    public void setCategory(Model.Category category) {this.category = category;}
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @NotNull(message = "Поле Год запуска в производство не может быть пустым!")
    @Min(value = 4, message = "Год состоит из 4 символов.")
    public int getStart_year() {return start_year;}
    public void setStart_year(int start_year) {this.start_year = start_year;}

    @NotNull(message = "Год выпуска не может быть пустым!")
    @Min(value = 4, message = "Год может быть только 4 символа.")
    public int getEnd_year() {return end_year;}
    public void setEnd_year(int end_year) {this.end_year = end_year;}

    @NotEmpty(message = "Ссылка на изображение не может быть пустой!")
    @Size(min = 7, max = 100, message = "Впишите инимум 7 символов.")
    public String getImage_url() {return image_url;}
    public void setImage_url(String image_url) {this.image_url = image_url;}
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

    @NotEmpty(message = "Имя не может быть пустым!")
    @Size(min = 3, max = 50)
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    @NotNull(message = "Id бренда не может быть пустым!")
    @Min(value = 1)
    public Integer getBrand_id() {
        return brand_id;
    }
    public void setBrand_id(Integer brandId) {
        this.brand_id = brandId;
    }
    public AddOffersDto getOffers() {return offers;}
    public void setOffers(AddOffersDto offers) {this.offers = offers;}
    public AddOffersDto getModel_id() {return model_id;}
    public void setModel_id(AddOffersDto model_id) {this.model_id = model_id;}

    public AddModelsDto() {}
    public AddModelsDto(Model.Category category, Date created, Integer end_year, String image_url, Date modified,
                        String name, Integer start_year, Integer brand_id) {
        this.category = category;
        this.created = created;
        this.end_year = end_year;
        this.image_url = image_url;
        this.modified = modified;
        this.name = name;
        this.start_year = start_year;
        this.brand_id = brand_id;
    }
}
