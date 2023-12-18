package catalogcar.catalogcar.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ShowOfferInfoDto {
    private int id;
    private String description;
    private BigDecimal price;
    private Integer year;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

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

    public ShowOfferInfoDto() {}

    public ShowOfferInfoDto(Date created, String description, BigDecimal price, Integer year) {
        this.created = created;
        this.description = description;
        this.price = price;
        this.year = year;
    }
}
