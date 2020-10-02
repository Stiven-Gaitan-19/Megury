package co.com.megury.service.dto;

import java.io.Serializable;

public class StoreDTO implements Serializable {

    private Long id;
    private String storeName;
    private String address;
    private String phoneNumber;
    private String storeEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    @Override
    public String toString() {
        return "StoreDTO{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                '}';
    }
}
