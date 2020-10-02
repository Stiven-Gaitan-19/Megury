package co.com.megury.service.dto;

import co.com.megury.domain.enums.State;

import java.io.Serializable;

public class DepartmentDTO implements Serializable {

    private Long id;
    private String name;
    private State departmentState;

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

    public State getDepartmentState() {
        return departmentState;
    }

    public void setDepartmentState(State departmentState) {
        this.departmentState = departmentState;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentState=" + departmentState +
                '}';
    }
}
