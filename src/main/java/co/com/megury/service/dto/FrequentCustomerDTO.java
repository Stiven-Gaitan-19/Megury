package co.com.megury.service.dto;

import java.io.Serializable;

public class FrequentCustomerDTO implements Serializable {

    private Long id;
    private String nameCompany;
    private String nit;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FrequentCustomerDTO{" +
                "id=" + id +
                ", nameCompany='" + nameCompany + '\'' +
                ", nit='" + nit + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
