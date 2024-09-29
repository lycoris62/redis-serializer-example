package ex.application.redis1.application;

import ex.application.redis1.dto.Product;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "redis1")
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisUtil redisUtil;

    @PostConstruct
    public void init() {
        log.info("RedisService init");
        Product product = new Product("1", "product1", 100);
        redisUtil.save(product.id(), product);
    }
}
