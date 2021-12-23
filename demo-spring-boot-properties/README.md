## 프로퍼티 변경
- 스프링 부트 2.1에 변경된 프로퍼티 또는 새로 생긴 프로퍼티
- 스프링 데이터 JPA 부트스크랩 모드 지원
    * 애플리케이션 구동 시간을 줄이기 위해 스프링 데이터 JPA 리파지토리 생성을 지연 시키는 설정
    * spring.data.jpa.repositories.bootstrap-mode=deferred
    * DEFERRED: 애플리케이션 구동 이후에 리파지토리 인스턴스 만들어 주입해준다.
    * LAZY: 애플리케이션 구동 이후에도 만들지 않다가 처음으로 사용할 시점에 만들어 주입해준다.
- HibernateProperties
    * JpaProperties에서 하이버네이트 관련 프로퍼티를 분리
- 마이그레이션 툴
    * 프로퍼티를 마이그레이션 하지 않더라도 기존 프로퍼티로 애플리케이션이 구동 가능하며 프로퍼티가 어떻게 바뀌었는지 알려주는 툴.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-properties-migrator</artifactId>
        <scope>runtime</scope>
    </dependency>
    ```
- 참고
    * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1.0-Configuration-Changelog
