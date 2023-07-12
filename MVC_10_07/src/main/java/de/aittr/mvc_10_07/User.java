package de.aittr.mvc_10_07;

public class User {
    private Long id;
    private String  name;
    private String city;
    private static Long counter = 0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User( String name, String city) {
        this.id = ++counter;
        this.name = name;
        this.city = city;

    }
}
