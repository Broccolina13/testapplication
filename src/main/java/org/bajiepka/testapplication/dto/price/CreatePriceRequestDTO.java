package org.bajiepka.testapplication.dto.price;

public class CreatePriceRequestDTO {
    private Integer price;

    public CreatePriceRequestDTO() {
    }
    public CreatePriceRequestDTO(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }
}
