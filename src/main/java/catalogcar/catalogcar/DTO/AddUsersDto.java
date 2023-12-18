package catalogcar.catalogcar.DTO;


import catalogcar.catalogcar.Model.UserRole;
import catalogcar.catalogcar.utils.validation.UniqueName;
import catalogcar.catalogcar.utils.validation.UniqueNameN;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class AddUsersDto {
    private int id;
    private Boolean is_active;
    private Date created;
    private String first_name;
    private String last_name;
    private Date modified;
    private String email;
    private String password;
    @UniqueNameN
    private String username;

    private UserRole.Role role;
    private AddOffersDto offers;

    @NotEmpty(message = "Email не может быть пустым!")
    @Size(min = 6, max = 25)
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

    public Date getCreated() {return created;}

    public void setCreated(Date created) {this.created = created;}

    @NotEmpty(message = "Имя не может быть пустым!")
    @Size(min = 1, max = 15, message = "Год может быть не больше 4 символов.")
    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    @NotEmpty(message = "Фамилия не может быть пустой!")
    @Size(min = 1, max = 25)
    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public Date getModified() {return modified;}

    public void setModified(Date modified) {this.modified = modified;}

    @NotEmpty(message = "Пароль не может быть пустым!")
    @Size(min = 4, max = 10, message = "Пароль может быть от 4 до 10 символов.")
    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    @NotEmpty(message = "Ник пользователя не может быть пустым!")
    @Size(min = 4, max = 10, message = "Ник не может содержать меньше 4 символов.")
    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public UserRole.Role getRole() {
        return role;
    }

    public void setRole(UserRole.Role role) {
        this.role = role;
    }

    public AddOffersDto getOffers() {return offers;}

    public void setOffers(AddOffersDto offers) {this.offers = offers;}

    public AddUsersDto(){}
    public AddUsersDto(Boolean is_active, String email, Date created, String first_name, String last_name,
                       Date modified, String password, String username, UserRole.Role role){
        this.is_active = is_active;
        this.email = email;
        this.created = created;
        this.first_name = first_name;
        this.last_name = last_name;
        this.modified = modified;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}

