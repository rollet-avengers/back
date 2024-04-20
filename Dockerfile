FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17-slim

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 Python 스크립트를 이미지에 추가
COPY gradlew /app/
COPY gradle /app/gradle
COPY build.gradle /app/
COPY settings.gradle /app/
COPY src /app/src

RUN chmod +x ./gradlew && \
    ./gradlew build -x test && \
    mv build/libs/*.jar app.jar && \
    rm -rf src && \
    rm -rf build

# 서버가 실행될 때 사용되는 포트
EXPOSE 3000

# 컨테이너를 시작할 때 Python 스크립트를 실행
CMD ["java", "-jar", "app.jar"]