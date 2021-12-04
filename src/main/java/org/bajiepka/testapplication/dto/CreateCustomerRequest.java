package org.bajiepka.testapplication.dto;

public record CreateCustomerRequest(
        String name,
        String lastName,
        String postalCode,
        String clientAge) {
}
