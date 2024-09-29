package ex.application.redis2.application;

import ex.application.redis2.dto.Product;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j(topic = "redis2")
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisUtil redisUtil;

    @PostConstruct
    public void init() {
        Product product = redisUtil.get("1", Product.class).orElseThrow();
        log.info("product:{}", product);
    }
}
