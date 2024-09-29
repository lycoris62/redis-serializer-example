# redis-serializer-example

## 실행 방법

- 도커 실행
- redis1, redis2 실행 
    - 자동으로 도커 컴포즈 서포트가 레디스 띄움

## 대강의 흐름

1. 레디스1 실행 시 레디스에 데이터 저장 
2. 레디스2 실행 시 레디스1에 저장된 데이터를 가져옴

---

- GenericJackson2JsonRedisSerializer
    - 레디스1에 저장된 데이터를 레디스2에서 가져올 때 에러 발생
    - `@class` 필드에 패키지 정보를 넣어서 redis2에서도 패키지를 일치시켜줘야 됨.
- Jackson2JsonRedisSerializer
    - `@class` 필드가 없지만, RedisTemplate<S, V> 에서 사용하는 V마다 템플릿 만들어줘야 됨.
- StringSerializer 
  - 레디스에 저장하는 레디스1이나, 레디스에서 가져오는 레디스2에서나 문자열과 객체 사이 변환 과정이 필요함.
  - 하지만 class 타입을 지정해줄 필요가 없고, 패키지까지 일치시킬 필요가 없다. 
    - 이거로 채택 땅땅땅 
