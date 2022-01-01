## Liveness와 Readiness
- Liveness
    * 애플리케이션이 살아있는가?
    * 상태가 비정상이고 복구하지 못한다면 보통 애플리케이션을 재기동 한다.
    * LivenessState.CORRECT
    * LivenessState.BROKEN
- Readiness
    * 요청을 받을 준비가 되었는가?
    * 준비가 될때까지 해당 서버로 요청을 보내지 않고 다른 서버로 보낸다.
    * ReadinessState.ACCEPTING_TRAFFIC
    * ReadinessState.REFUSING_TRAFFIC
- 애플리케이션 내부에서 상태 정보 조회하기
    * 스프링 부트 2.3부터 자동으로 빈으로 등록해주는 ApplicationAvailability를 통해서 확인할 수 있다.

```java
class Main {
    @Autowired ApplicationAvailability availability;

    LivenessState livenessState = availabilityProvider.getLivenessState();
    ReadinessState readinessState = availabilityProvider.getReadinessState();
}
```

- 애플리케이션 밖에서 상태 정보 조회하기, Actuator /health 엔드포이트 사용
    * 해당 Health 그룹은 쿠버네티스에 배포할 때는 true로 제공한다.
    * Liveness: actuator/health/liveness
    * Readiness: actuator/health/readiness

```properties
management.endpoint.health.probes.enabled=true
```

- 애플리케이션 상태 변경하기
    * 스프링 ApplicationEventPublisher를 사용해서 이벤트를 전파하는 방법으로 상태 변경한다.

```java
AvailabilityChangeEvent.publish(this.applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
```

- 애플리케이션 상태 변경 감지하기

```java
@Async
@EventListener
public void onStateChanged(AvailabilityChangeEvent<ReadinessState> readiness) {
// 이벤트 처리
}
```

- 참고
    * https://spring.io/blog/2020/03/25/liveness-and-readiness-probes-with-spring-boot