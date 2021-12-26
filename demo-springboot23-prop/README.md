## 스프링 부트 애플리케이션 도커 이미지 만들기
- 스프링 부트 애플리케이션을 도커 이미지로 만드는 방법
- Dockerfile

```dockerfile
FROM openjdk:11.0.8-jre-slim
WORKDIR application
ARG JAR_FILE=target/demo*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]
```

- 이미지 빌드하기

```bash
docker build -t demo-springboot23 .
```

- 도커 컨네이터 실행하기

```bash
docker run --rm -p 8080:8080 demo-springboot23 
```

- 도커 이미지 탐색기 “dive”
    * https://github.com/wagoodman/dive
- 참고
    * https://docs.spring.io/spring-boot/docs/2.3.0.RELEASE/maven-plugin/reference/html/#introduction