package co.com.megury.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="store")
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "store_name")
    private String storeName;

    @NotNull
    private String address;

    private String phoneNumber;

    @Column(unique = true, name = "store_email")
    private String storeEmail;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department department;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Owner owner;

    @OneToMany(mappedBy = "store")
    private Set<Brand> brands = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Bill> bills = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<GeneralGroup> generalGroups = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<FrequentCustomer> frequentCustomers = new HashSet<>();

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public Set<GeneralGroup> getGeneralGroups() {
        return generalGroups;
    }

    public void setGeneralGroups(Set<GeneralGroup> generalGroups) {
        this.generalGroups = generalGroups;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<FrequentCustomer> getFrequentCustomers() {
        return frequentCustomers;
    }

    public void setFrequentCustomers(Set<FrequentCustomer> frequentCustomers) {
        this.frequentCustomers = frequentCustomers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        return id != null ? id.equals( store.id ) : store.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
