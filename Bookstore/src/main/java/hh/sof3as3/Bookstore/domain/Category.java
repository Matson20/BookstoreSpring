package hh.sof3as3.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Represent a table in relational database
public class Category {
    @Id // Creates id for column
    @GeneratedValue(strategy = GenerationType.AUTO) // Generates automatically a unique primary key
    private Long categoryid;
    @Column(name="category_name")
    private String name;

    // konstruktorit
    public Category() {
        
    }

    public Category( String name) {
        super();
        this.name = name;
    }

    // getterit
    public Long getCategoryId() {
        return categoryid;
    }
    public String getName() {
        return name;
    }

    // setterit
    public void setCategoryId(Long categoryId) {
        this.categoryid = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "categoryId=" + categoryid + ", name=" + name;
    }

    

    

}
