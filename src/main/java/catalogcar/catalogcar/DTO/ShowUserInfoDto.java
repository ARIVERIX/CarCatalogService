package catalogcar.catalogcar.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ShowUserInfoDto {
    private int id;
    private Boolean is_active;
    private String first_name;
    private String last_name;
    private String email;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public ShowUserInfoDto(){}
    public ShowUserInfoDto(Boolean is_active, String first_name,  String last_name){
        this.is_active = is_active;
        this.first_name = first_name;
        this.last_name = last_name;
    }
}

