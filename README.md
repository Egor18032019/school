# Простая система управления задачами с использованием Spring Boot и Spring Data JPA. 
# Система позволяеть создавать, просматривать, обновлять и удалять задачи.
Запуск
 ```shell
docker-compose up --build
```
* БД содержит таблицу tasks.
* Примеры запросов:
Получить список всех задач.
 ```shell
curl -i -X GET http://localhost:8080/tasks
```
Получить информацию о задаче по её id.
 ```shell
curl -i -X GET http://localhost:8080/tasks/100000
```
Создать новую задачу.
```shell
curl -i -X POST http://127.0.0.1:8080/tasks -H 'Content-Type: application/json' -d '{"title":"All done !","description":"All done !","dueDate":"2024-03-08T14:27:40.523557414","completed":"false"}'
```
Обновить информацию о задаче.
```shell
curl -i -X PUT http://127.0.0.1:8080/tasks/100000 -H 'Content-Type: application/json' -d '{"title":"2","description":"2","dueDate":"2024-04-08T14:27:40.523557414","completed":"true"}'
```
Удалить задачу.
 ```shell
curl -i -X DELETE http://localhost:8080/tasks/100002
```
 