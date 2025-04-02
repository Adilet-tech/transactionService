# Используем официальный образ OpenJDK
FROM openjdk:21-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar-файл в контейнер
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем точку входа
ENTRYPOINT ["java", "-jar", "app.jar"]
