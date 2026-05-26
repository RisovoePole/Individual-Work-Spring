# ScheduleGen

Проект для автоматизации формирования учебного расписания.  
Текущая версия приложения содержит базовую архитектуру Spring Boot, схему базы данных, миграции Flyway и REST API для работы с сущностью `Discipline` (дисциплина).

> В проекте уже подготовлена инфраструктура для дальнейшей генерации расписания, однако на текущий момент основной публичный API сосредоточен на CRUD-операциях над дисциплинами.

---

## Содержание

- [Описание](#описание)
- [Технологии](#технологии)
- [Архитектура проекта](#архитектура-проекта)
- [База данных и миграции](#база-данных-и-миграции)
- [Переменные окружения](#переменные-окружения)
- [Запуск проекта](#запуск-проекта)
- [API](#api)
- [Валидация и ошибки](#валидация-и-ошибки)
- [Swagger / OpenAPI](#swagger--openapi)
- [Полезные заметки](#полезные-заметки)

---

## Описание

`ScheduleGen` — Spring Boot-приложение, предназначенное для работы с учебным расписанием.

В основе проекта лежат:

- Spring Boot;
- PostgreSQL;
- Flyway для миграций;
- JPA/Hibernate для доступа к данным;
- DTO-слой для REST API;
- глобальная обработка ошибок;
- кастомная валидация входных данных.

---

## Технологии

- **Java 21**
- **Spring Boot 3.1.5**
- **Spring Web**
- **Spring Data JPA**
- **Spring Validation**
- **Flyway**
- **PostgreSQL**
- **Hibernate 6**
- **Lombok**
- **SpringDoc OpenAPI / Swagger**
- **Docker**

---

## Архитектура проекта

### Основные пакеты

``` text
src/main/java/com/ScheduleGen/
├── ScheduleGenApplication.java
├── api/
│   ├── controllers/
│   │   └── DisciplinesController.java
│   ├── CustomValidations/
│   │   ├── NotSpacesOnly.java
│   │   └── NotSpacesOnlyValidator.java
│   └── dtos/
│       ├── CreateRequestDTOs/
│       ├── PatchRequestDTOs/
│       ├── ResponseDTOs/
│       └── UpdateRequestDTOs/
├── application/
│   ├── ErrorResponse.java
│   ├── GlobalExceptionHandler.java
│   └── mappers/
│       └── DisciplineMapper.java
├── domain/
│   ├── businessExceptions/
│   ├── entities/
│   │   └── Discipline.java
│   └── services/
│       └── DisciplineService.java
└── infrastructure/
    └── persistence/
        ├── entities/
        ├── mappers/
        │   └── DisciplineEntityMapper.java
        └── repos/
```

## База данных и миграции

Схема и тестовые данные управляются через Flyway. Миграции находятся в папке `sql/migrations`.

Перед запуском убедитесь, что PostgreSQL доступен и настроены переменные окружения (см. ниже).

## Переменные окружения

Минимальные переменные для запуска приложения (пример для локальной разработки):

- `SPRING_DATASOURCE_URL`: URL базы данных PostgreSQL, например `jdbc:postgresql://localhost:5432/schedulegen`
- `SPRING_DATASOURCE_USERNAME`: имя пользователя БД
- `SPRING_DATASOURCE_PASSWORD`: пароль пользователя БД
- `SPRING_PROFILES_ACTIVE` (опционально): профиль Spring (например, `dev`)

Файлы миграций применяются автоматически Flyway при старте приложения.

## Запуск проекта

Рекомендуемые команды через `just` (файл `Justfile` есть в корне проекта):

- Инициализация (создаст `.env` из примера, если его ещё нет):

```bash
just init
```

- Поднять базу и выполнить миграции:

```bash
just up
```

- Поднять только бэкенд (предполагается, что БД уже поднята):

```bash
just dev
```

- Явно выполнить миграции (если нужно):

```bash
just migrate
```

Альтернативы без `just`:

```bash
# Локально с Maven Wrapper
./mvnw clean package
./mvnw spring-boot:run

# Через Docker compose
docker compose up --build
```

По умолчанию приложение доступно по адресу `http://localhost:8080`.

Файл переменных примера: `.env.example` — при `just init` копируется в `.env`. Проверьте и при необходимости отредактируйте значения `DB_LOCAL_URL`, `DB_USER`, `DB_PASSWORD` перед запуском миграций.

## API

`Discipline` CRUD доступен по базовому пути `/disciplines`.

Основные endpoint'ы (JSON):

- `POST /disciplines` — создать дисциплину. Тело: `CreateDisciplineDTO`.
- `GET /disciplines` — получить список всех дисциплин.
- `GET /disciplines/{id}` — получить дисциплину по `id`.
- `PUT /disciplines` — обновить дисциплину целиком (`UpdateDisciplineDTO`).
- `PATCH /disciplines` — частичное обновление (`PatchDisciplineDTO`).
- `DELETE /disciplines/{id}` — удалить по `id`.

Примеры запросов:

```bash
# Create
curl -X POST http://localhost:8080/disciplines \
    -H "Content-Type: application/json" \
    -d '{"name":"Математика","studySemester":2,"credits":3.0,"specializationId":1}'

# Get all
curl http://localhost:8080/disciplines

# Get by id
curl http://localhost:8080/disciplines/1

# Update (full)
curl -X PUT http://localhost:8080/disciplines \
    -H "Content-Type: application/json" \
    -d '{"id":1,"name":"Математика","studySemester":3,"credits":4.0,"specializationId":1}'

# Patch (partial)
curl -X PATCH http://localhost:8080/disciplines \
    -H "Content-Type: application/json" \
    -d '{"id":1,"credits":3.5}'

# Delete
curl -X DELETE http://localhost:8080/disciplines/1
```

## Валидация и ошибки

В проекте есть глобальная обработка исключений (`GlobalExceptionHandler`) и кастомные валидаторы (например, `NotSpacesOnly`). Ошибки возвращаются в стандартизированном виде через `ErrorResponse`.

### Поля Discipline

При работе с API дисциплин используются следующие поля:

- `id` (Integer) — идентификатор (не передаётся при создании, требуется при обновлении/удалении)
- `name` (String) — название дисциплины, макс. 40 символов, не пусто
- `studySemester` (Integer) — номер семестра, положительное число
- `credits` (Float) — количество кредитов, положительное число
- `specializationId` (Integer) — идентификатор специальности, положительное число

## Swagger / OpenAPI

SpringDoc OpenAPI подключён — UI доступен по одному из URL:

- `http://localhost:8080/swagger-ui.html`
- `http://localhost:8080/swagger-ui/index.html`

## Полезные заметки

- Миграции Flyway лежат в `sql/migrations`.
- DTO находятся в `src/main/java/com/ScheduleGen/api/dtos`.
- Контроллер `DisciplinesController` находится в `src/main/java/com/ScheduleGen/api/controllers`.

### Postman коллекция

Готовая Postman коллекция находится в `postman/ScheduleGen.postman_collection.json` — её можно импортировать в Postman через `File -> Import` или перетащив файл в окно приложения. В коллекции используется переменная `baseUrl` по умолчанию `http://localhost:8080`.
