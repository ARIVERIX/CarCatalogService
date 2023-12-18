package catalogcar.catalogcar.DTO;

import catalogcar.catalogcar.Model.UserRole;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShowDetailedUserInfo {
    private int id;
    private Boolean is_active;
    private String first_name;
    private String image_url;
    private UserRole.Role role;
    private String last_name;
    private String email;
    private String username;
    private AddOffersDto offers;
    private AddOffersDto seller_Id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified;

    public UserRole.Role getRole() {
        return role;
    }

    public void setRole(UserRole.Role role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Boolean getIs_active() {return is_active;}

    public void setIs_active(Boolean is_active) {this.is_active = is_active;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getImage_url() {return image_url;}

    public void setImage_url(String image_url) {this.image_url = image_url;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public AddOffersDto getOffers() {return offers;}

    public void setOffers(AddOffersDto offers) {this.offers = offers;}

    public AddOffersDto getSeller_Id() {return seller_Id;}

    public void setSeller_Id(AddOffersDto seller_Id) {this.seller_Id = seller_Id;}
    public ShowDetailedUserInfo(){}
    public ShowDetailedUserInfo(Boolean is_active, String email, Date created, String first_name, String image_url, String last_name,
                      Date modified, String username){
        this.is_active = is_active;
        this.email = email;
        this.created = created;
        this.first_name = first_name;
        this.image_url = image_url;
        this.last_name = last_name;
        this.modified = modified;
        this.username = username;

    }
}

