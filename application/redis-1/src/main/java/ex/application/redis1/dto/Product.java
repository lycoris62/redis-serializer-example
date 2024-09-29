package ex.application.redis1.dto;

public record Product(
    String id,
    String name,
    int amount
) {
}
