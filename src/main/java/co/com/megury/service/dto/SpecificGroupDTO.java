package co.com.megury.service.dto;

import java.io.Serializable;

public class SpecificGroupDTO implements Serializable {

    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return "SpecificGroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
