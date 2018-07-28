package by.htp.main.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_tag", unique = true, nullable = false)
    private int id;
    @Column(name = "tag")
    private String tag;
    @ManyToMany(mappedBy = "tags")
    private List<News> news;

    public Tags(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public Tags() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tags tags = (Tags) o;
        return id == tags.id &&
                Objects.equals(tag, tags.tag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tag);
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
