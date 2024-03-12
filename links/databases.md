# 1. Настраиваем базу данных

Накатываем миграцию в зависимости от того какую БД используем (все команды запускать из корня проекта).

## Развертывание базы данных в Docker
Если у вас не установлена база данных, то при наличии docker-а это сделать проще простого:

### PostgreSQL

```bash
docker pull postgres
docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```

Если у вас какие-то свои параметры отличные от тех, что используются в команде выше, то вы можете их прописать в файлике
[application.properties](../src/main/resources/application.properties)

