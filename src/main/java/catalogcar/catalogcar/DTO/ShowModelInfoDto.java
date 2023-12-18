package catalogcar.catalogcar.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class ShowModelInfoDto {
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", updatable = false)
    private Date created;
    private int end_year;
    private String name;
    private int start_year;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}
    public int getEnd_year() {return end_year;}
    public void setEnd_year(int end_year) {this.end_year = end_year;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getStart_year() {return start_year;}
    public void setStart_year(int start_year) {this.start_year = start_year;}
    public ShowModelInfoDto() {}
    public ShowModelInfoDto(Date created, Integer end_year, String name, Integer start_year) {
        this.created = created;
        this.end_year = end_year;
        this.name = name;
        this.start_year = start_year;
    }
}
