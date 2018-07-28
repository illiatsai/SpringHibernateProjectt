package by.htp.main.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "news")
//@Service("news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_news")
    private int id;
    @Column(name = "header")
    private String headerNews;
    @Column(name = "description")
    private String bodyNews;
    @Column(name = "rubric")
    private String rubric;
    @Column(name = "preview")
    private String preview;
    @Column(name = "date")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull
    private Date date;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "news_tags",
            joinColumns = {@JoinColumn(name = "id_news")},
            inverseJoinColumns = { @JoinColumn(name = "id_tags")})
    private List<Tags> tags;

    public News(int id, String headerNews, String bodyNews, String rubric, String preview, Date date, List<Tags> tags) {
        this.id = id;
        this.headerNews = headerNews;
        this.bodyNews = bodyNews;
        this.rubric = rubric;
        this.preview = preview;
        this.date = date;
        this.tags = tags;
    }

    public News(String headerNews, String bodyNews, String rubric, String preview, Date date) {
        this.headerNews = headerNews;
        this.bodyNews = bodyNews;
        this.rubric = rubric;
        this.preview = preview;
        this.date = date;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeaderNews() {
        return headerNews;
    }

    public void setHeaderNews(String headerNews) {
        this.headerNews = headerNews;
    }

    public String getBodyNews() {
        return bodyNews;
    }

    public void setBodyNews(String bodyNews) {
        this.bodyNews = bodyNews;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getRubric() {
        return rubric;
    }

    public void setRubric(String rubric) {
        this.rubric = rubric;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News newsN = (News) o;

        if (id != newsN.id) return false;
        if (headerNews != null ? !headerNews.equals(newsN.headerNews) : newsN.headerNews != null) return false;
        if (bodyNews != null ? !bodyNews.equals(newsN.bodyNews) : newsN.bodyNews != null) return false;
        if (date != null ? !date.equals(newsN.date) : newsN.date != null) return false;
        return tags != null ? tags.equals(newsN.tags) : newsN.tags == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (headerNews != null ? headerNews.hashCode() : 0);
        result = 31 * result + (bodyNews != null ? bodyNews.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", headerNews='" + headerNews + '\'' +
                ", bodyNews='" + bodyNews + '\'' +
                ", date='" + date + '\'' +
                ", tags =" + tags.toString() +
                '}';
    }

    public void printAllNewsToConsole(){
        System.out.println(this.getHeaderNews());
        System.out.println(this.getPreview());
        System.out.println(tags.toString());
        System.out.println();

    }
}
