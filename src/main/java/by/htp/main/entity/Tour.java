package by.htp.main.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    //@NotNull
    private Date startDate;
    @Column(name = "end_date")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    //@NotNull
    private Date endDate;
    @Column(name = "price")
    private Integer price;
    //???
    /*private List<Country> listOfCountries;*/

    /*public Tour(int id, String name, String description, Date startDate, Date endDate, BigDecimal price, List<Country> listOfCountries) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.listOfCountries = listOfCountries;
    }*/

    public Tour(int id, String name, String description, Date startDate, Date endDate, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Tour() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    /*public List<Country> getListOfCountries() {
        return listOfCountries;
    }

    public void setListOfCountries(List<Country> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return id == tour.id &&
                Objects.equals(name, tour.name) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(startDate, tour.startDate) &&
                Objects.equals(endDate, tour.endDate) &&
                Objects.equals(price, tour.price)
                //&& Objects.equals(listOfCountries, tour.listOfCountries)
                ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, startDate, endDate, price
                //, listOfCountries
        );
    }
}
