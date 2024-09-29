package ex.application.redis2.dto;

public record Product(
    String id,
    String name,
    int amount
) {
}
