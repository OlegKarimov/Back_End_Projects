## Spring Security

* Spring Security - фреймворк, который позволяет настроить безопасность внутри вашего приложения
* Spring Boot Security Starter - фреймворк, включает в себя Spring Security, автоматически настраивает безопасность внутри Spring Boot-приложения

### 01. Хеширование паролей

* Нельзя хранить пароли на сервере в открытом виде:
  * Люди часто используют одни и те же пароли на разных сайтах
  * Тогда, при взломе сервера, злоумышленники получат пары логин/email + пароль
  * Они смогут взломать другие аккаунты пользователя
* Пароли нужно защищать - хэшировать
* В базе данных храним хэшированные пароли
* При регистрации пользователя мы хэшируем пароль и сохраняем в базу вместе с email/username/логином
* При входе:
  * Найти хэш пароля в базе по email/username/логину
  * Сравнить то, что ввел пользователь с хешем

#### BCrypt

* BCrypt - алгоритм хеширования паролей
* BCryptPasswordEncoder - реализация BCrypt в Spring Security
  * `String passwordEncoder.encode(String password)` - функция хеширования пароля
  * `boolean passwordEncoder.matches(String rawPassword, String passwordHash)` - функция сравнения "сырого пароля" и хеша

* Пример кода использования `BCryptPasswordEncoder`:

```
// класс для работы с алгоритмом BCrypt
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
Scanner scanner = new Scanner(System.in);
// считали пароль
String password = scanner.nextLine();
// шифрование/хеширование/защита пароля
String passwordHash = passwordEncoder.encode(password);
System.out.println(passwordHash);
// считали пароль еще раз
String rawPassword = scanner.nextLine();
// выводим результат сравнения нового пароля с защищенным
System.out.println(passwordEncoder.matches(rawPassword, passwordHash));
```

* Алгоритм работы BCrypt

```

encode(rawPassword)

endode(qwerty007) -> [$2a$][10$][n3rp26v67E/J4noztDZiKO][z/2swiGI4KOzY8uByQkud37FKUuKATa] или
             [$2a$][10$][/xvplTuClQ6AulFnyyWQFO][vh35PovNHnyFg8jP2ddJSZdcI55AY36]

Из чего он состоит?

$2a$ - идентификтор алгоритма (в нашем случае BCrypt)
10$ - количество раундов хеширования (в данном случае 10)
n3rp26v67E/J4noztDZiKO - соль
z/2swiGI4KOzY8uByQkud37FKUuKATa - непосредственно хэш

1. Подаем на вход строку -> qwerty007
2. Генерируем случайную "соль" -> n3rp26v67E/J4noztDZiKO
3. Соединяем соль и пароль и делаем хеш -> hash(qwerty007 + n3rp26v67E/J4noztDZiKO) = z/2swiGI4KOzY8uByQkud37FKUuKATa
4. Формируем результат: $2a$10$ + n3rp26v67E/J4noztDZiKO + z/2swiGI4KOzY8uByQkud37FKUuKATa

Главная "фишка" нашего алгоритма в том, что один и тот же парль может быть хеширован разными результатами.
Поскольку я применяю всегда случайную "соль", я всегда при хешировании буду получать разные результаты
Таким образом, нельзя из хеша получить исходный пароль, соответствия нет
Случайная соль участвует в хешировании, поэтому из хеша нельзя получить пароль

Как происходит проверка?

matches(rawPassword, hashPassword)

matches(qwerty007, $2a$10$n3rp26v67E/J4noztDZiKOz/2swiGI4KOzY8uByQkud37FKUuKATa

1. Выделяем из сохраненного хеша соль - n3rp26v67E/J4noztDZiKO
2. Выделяем из хеша непосредственно хеш - z/2swiGI4KOzY8uByQkud37FKUuKATa
3. Заново хешируем введенный пароль с солью и сравниваем с тем, что есть
  hash(qwerty007 + n3rp26v67E/J4noztDZiKO) = z/2swiGI4KOzY8uByQkud37FKUuKATa
  
Таким образом, мы проверяем, мог ли быть получен сохраненный хэш из того, что ввел пользователь и той соли, которую мы использовали.
То есть мы не смотрим чистый пароль, а смотрим, могли ты мы получить из такого пароля тот же хеш.
```

### 02. Внедрение хеширования на этапе регистрации

* Добавить зависимость:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

* Создать необходимо поле в классе `User`:

```
private String hashPassword
```

* Создать бин для `BCrypt` (например в классе с main-методом):

```
@Bean
public PasswordEncoder passwordEncoder() {
  return new BCryptPasswordEncoder();
}
```

* Создать поле для Inject-а вышеуказанного бина в `UsersServiceImpl`

```
private final PasswordEncoder passwordEncoder;
```

* Сделать хеширование пароля в методе с регистрацией (добавлением) поля:

```
User user = User.builder()
  .email(newUser.getEmail())
  .hashPassword(passwordEncoder.encode(newUser.getPassword()))
  .role(User.Role.USER)
  .state(User.State.NOT_CONFIRMED).build();
```

### 03. Безопасность на основе сессий

* `Аутентификация` - "вход пользователя", проверка его данных для входа (email + password)
* `Авторизация` - проверка, имеет ли право пользователь на получение какого-либо ресурса или выполнение какой-либо операции
  * Может ли `Marsel` получить список всех других пользователей
  * Может ли `Marsel` добавить статью
* В нашем приложении:
  * аутентификация будет реализована на основе сессий (не самый распространенный метод, но для нашей ситуации - подходит)
  * авторизация будет реализована на основе ролей

* Сессия - объект, который хранится на сервере и, по своей сути, объединяет множество запросов от клиента.
* На клиенте (в браузере) - хранится только идентификатор сессии, а не сами данные.
* Cookie - текстовая информация формата "ключ-значение", привязывается определенному домену.
* То есть, если куку выдал домен `google.com`, то браузер не будет ее отправлять на `instagram.com`
* Сама выдача куки браузеру происходит через заголовок `Set-Cookie` (заставляет браузер запомнить куку и всегда отправлять ее на домен, который ее выдал)
* Отправка куки в запросе происходит через заголовок `Cookie`

![image](https://raw.githubusercontent.com/ait-tr/cohort23/main/back_end/lesson_20/img/1.png)

#### Алгоритм аутентификации

1. Пользователь отправляет свой логин и пароль на сервер
2. Сервер достает пользователя по логину из базы
3. Сервер проверяет с помощью PasswordEncoder-а его пароль
4. Если все окей - создает сессию с определенным идентификатором
5. С сессией ассоциирует пользователя и сохраняет эту пару в хранилище сессий в оперативной памяти
6. Пользователю в браузер отправляет куку с идентификатором сессии
7. Браузер запоминает эту куку и каждый следующий запрос сопровождает ей

#### Алгоритм авторизации

1. Пользователь выполняет какой-либо запрос, сопровождая его кукой с ID-сессии
2. Сервер находит по ID эту сессию
3. Сервер достает ассоциированного с ней пользователя
4. Сервер проверяет, соответствует ли его роль запрашиваемой операции
5. Если все ок - возвращает нужный результат

### 04. Настройка Spring Security

1. `UserDetails` - интерфейс, который позволяет Spring Security подружить ваш класс для описания пользователя со своей логикой
   * `Authority` - возможности (права), которые имеет пользователь. Зачастую авторити = роль пользователя
2. `AuthenticatedUser` - наш класс, который имплементирует `UserDetails`, содержит "ответы на вопросы" Spring Security для нашего пользователя
3. `UserDetailsService` - интерфейс, который описывает логику "получения" пользователя из хранилища

![image](https://raw.githubusercontent.com/ait-tr/cohort23/main/back_end/lesson_20/img/2.png)