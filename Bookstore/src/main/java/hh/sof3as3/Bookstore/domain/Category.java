package hh.sof3as3.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Represent a table in relational database
public class Category {
    @Id // Creates id for column
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates automatically a unique primary key
    private Long categoryid;
    //@Column(name="category_name")
    private String name;

    @JsonIgnoreProperties ("category")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

    // konstruktorit
    public Category() {
        
    }

    public Category( String name) {
        super();
        this.name = name;
    }

    // getterit
    public Long getCategoryid() {
        return categoryid;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    // setterit
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "categoryid=" + categoryid + ", name=" + name;
    }

}
