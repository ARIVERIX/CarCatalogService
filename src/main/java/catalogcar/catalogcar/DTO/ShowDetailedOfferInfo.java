package catalogcar.catalogcar.DTO;

import catalogcar.catalogcar.Model.Offer;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ShowDetailedOfferInfo {
    private int id;
    private String description;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    private Offer.Engine engine;
    private Offer.Transmission transmission;
    private Integer year;
    private int model_id;
    private int seller_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    public Offer.Engine getEngine() {
        return engine;
    }

    public void setEngine(Offer.Engine engine) {
        this.engine = engine;
    }

    public Offer.Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Offer.Transmission transmission) {
        this.transmission = transmission;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ShowDetailedOfferInfo() {}

    public ShowDetailedOfferInfo(Date created, String description, String imageUrl, Integer mileage,
                       BigDecimal price, Integer year, Integer model_id, Integer seller_id) {
        this.created = created;
        this.description = description;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.year = year;
        this.model_id = model_id;
        this.seller_id = seller_id;
    }
}
