package catalogcar.catalogcar.DTO;
import catalogcar.catalogcar.Model.Offer;
import catalogcar.catalogcar.Model.Model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

public class AddOffersDto {
    private int id;
    private Date created;
    private String description;
    private Offer.Engine engine;
    private String imageUrl;
    private Integer mileage;
    private Date modified;
    private BigDecimal price;
    private Offer.Transmission transmission;
    private Integer year;
    private int model_id;
    private int seller_id;

    public AddOffersDto(Date created, String description, Offer.Engine engine, String imageUrl, Integer mileage,
                        Date modified, BigDecimal price, Offer.Transmission transmission, Integer year, Integer model_id, Integer seller_id) {
        this.created = created;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.modified = modified;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model_id = model_id;
        this.seller_id = seller_id;
    }

    public AddOffersDto() {}

    @NotNull(message = "Id модели не может быть пустым!")
    @Min(value = 1)
    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }
    @NotNull(message = "Id покупателя не может быть пустым!")
    @Min(value = 1)
    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

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

    @NotEmpty(message = "Описание не может быть пустым!")
    @Size(min = 5, max = 180, message = "Описание может быть не меньше 5 символов.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Offer.Engine getEngine() {
        return engine;
    }

    public void setEngine(Offer.Engine engine) {
        this.engine = engine;
    }

    @NotEmpty(message = "Ссылка на изображение не может быть пустым!")
    @Size(min = 7, max = 100, message = "Ссылка не меньше 7 символов.")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull(message = "Расстояние пробега не может быть пустым!")
    @Min(value = 2, message = "Минимальный пробег 10 км.")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @NotNull(message = "Цена не может быть пустой!")
    @Min(value = 2, message = "Цена не может быть меньше 4 символов.")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Offer.Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Offer.Transmission transmission) {
        this.transmission = transmission;
    }

    @NotNull(message = "Год начала не может быть пустым!")
    @Min(value = 4, message = "Год может быть только 4 символа!")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
