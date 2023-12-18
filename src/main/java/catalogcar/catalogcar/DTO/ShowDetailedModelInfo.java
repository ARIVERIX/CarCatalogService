package catalogcar.catalogcar.DTO;

import catalogcar.catalogcar.Model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class ShowDetailedModelInfo {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", updatable = false)
    private Date created;
    private int end_year;
    private String image_url;
    private Model.Category category;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified")
    private Date modified;
    private String name;
    private int start_year;
    private AddOffersDto offers;

    public Model.Category getCategory() {
        return category;
    }
    public void setCategory(Model.Category category) {
        this.category = category;
    }
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}
    public int getEnd_year() {return end_year;}
    public void setEnd_year(int end_year) {this.end_year = end_year;}
    public String getImage_url() {return image_url;}
    public void setImage_url(String image_url) {this.image_url = image_url;}
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getStart_year() {return start_year;}
    public void setStart_year(int start_year) {this.start_year = start_year;}
    public AddOffersDto getOffers() {return offers;}
    public void setOffers(AddOffersDto offers) {this.offers = offers;}
    public ShowDetailedModelInfo() {}
    public ShowDetailedModelInfo(Date created, Integer end_year, String image_url, Date modified,
                       String name, Integer start_year) {
        this.created = created;
        this.end_year = end_year;
        this.image_url = image_url;
        this.modified = modified;
        this.name = name;
        this.start_year = start_year;
    }
}
