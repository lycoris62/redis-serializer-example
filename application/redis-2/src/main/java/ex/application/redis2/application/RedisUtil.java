package ex.application.redis2.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisUtil {

    private final ObjectMapper objectMapper;
    private final StringRedisTemplate stringRedisTemplate;

    public <T> boolean save(String key, T value) {
        try {
            String json = objectMapper.writeValueAsString(value);
            stringRedisTemplate.opsForValue().set(key, json);
            return true;
        } catch (JsonProcessingException e) {
            log.error("redis save error", e);
            return false;
        }
    }

    public <T> Optional<T> get(String key, Class<T> clazz) {
        String json = stringRedisTemplate.opsForValue().get(key);

        if (json == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(objectMapper.readValue(json, clazz));
        } catch (JsonProcessingException e) {
            log.error("redis get error", e);
            return Optional.empty();
        }
    }
}
