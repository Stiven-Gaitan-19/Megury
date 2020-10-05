package co.com.megury.service.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable {

    private Long id;
    private Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
