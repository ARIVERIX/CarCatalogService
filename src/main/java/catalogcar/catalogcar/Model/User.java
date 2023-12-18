package catalogcar.catalogcar.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String email;
    private String first_name;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole.Role role;
    private String username;
    private String last_name;
    private String password;
    private Boolean is_active;
    @OneToMany(mappedBy = "seller",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Offer> offers;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public UserRole.Role getRole() {
        return role;
    }
    public void setRole(UserRole.Role role) {
        this.role = role;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {this.email = email;}
    @Column(name = "first_name")
    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    @Column(name = "last_name")
    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    @Column(name = "password")
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Set<Offer> getOffers() {return offers;}
    public void setOffers(Set<Offer> offers) {this.offers = offers;}
    @Column(name = "is_active")
    public Boolean getIs_active() {return is_active;}
    public void setIs_active(Boolean is_active) {this.is_active = is_active;}
    protected User() {}
}
