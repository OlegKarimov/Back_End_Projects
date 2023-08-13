# Задание

Самостоятельно реализовать проект (до 08.08.2023) - упор на него, а не предыдущие ДЗ.

Реализовать функционал "списка задач для пользователя"

Пользователю можно назначать задачи.

User - то же самое, что и у нас
- List<Task> tasks - задачи, которые назначены пользователю

Task
- id
- String description
- String title
- LocalDate startDate
- LocalDate finishDate
- User executor - исполнитель задачи

Необходимо реализовать endpoint:

+++ POST /users - добавление пользователя
+++ POST /users/{users-id}/tasks - добавление задачи пользователю. В теле запроса передаем задачу
+++ GET  /users - получение всех пользователей
+++ GET /users/{user-id}/tasks - получение всех задач определенного пользователя

Предусмотреть валидацию (валидация пользователей как у меня)
Валидация задачи:
- описание не может быть null/пустым
- название не может быть null/пустым
- (со звездочкой) написать свой валидатор -
дата начала не может быть раньше текущей даты (LocalDate.now()
дата окончания не может быть раньше текущей даты
для этого сделать аннотацию @BeforeCurrentDate

* Использовать базу H2 - tasks_db
* Документация нужна на все endpoints, в том числе с ошибками
* ТЕСТЫ НЕ ПИШЕМ

ПРОВЕРКА:
- Я полагаю, что вы написали код, как у меня, поэтому сам код пока не смотрю
- Если что-то не работает - сообщаем мне
- Для проверки скидываем файл requests.http (просто отдельный файл) + репозиторий
- На проверку только проект, в котором вы уверены
- Создать НОВЫЙ ПРОЕКТ через Spring Initializr