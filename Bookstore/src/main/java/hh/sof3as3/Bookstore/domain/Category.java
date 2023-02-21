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
    private Long id;
    //@Column(name="category_name")
    private String name;

    // konstruktorit
    public Category() {
        
    }

    public Category( String name) {
        super();
        this.name = name;
    }

    // getterit
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // setterit
    public void setId(Long Id) {
        this.id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }

    

    

}
