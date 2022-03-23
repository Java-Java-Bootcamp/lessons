# User Management API

## TODO

- Доработать метод GET /users/<account> так, чтобы он возвращал HTTP 404 Not Found, если не удалось найти пользователя
- Доработать метод DELETE /users/<account> так, чтобы он возвращал HTTP 404 Not Found, если не удалось найти пользователя
- Доработать метод PUT /users/<account> так, чтобы он возвращал HTTP 400 Bad Request, если <account> не совпадате с полем acccount в теле запроса
- Написать Unit Tests на класс `UserService`

## API

```yaml

# Нужно создать CRUD-операции для управления пользователия
# C - create
# R - read
# U - update
# D - delete

# REST-API
# URI
User:
    account: string # идентификаторов URI
    name: string
    lastname: string

URI: /users/<account>
# например
URI: /users/oagafonov

endpoint: /users
# R - read
# read all users
GET: /users
respose: List of User
# read one user
GET: /users/<account>
respose: User
# C - create
POST: /users
request: User
# U - update
PUT: /users/<account>
request: User
# U - update
PATCH: /users/<account>
request:
name: "new name"
# D - delete
DELETE: /users/<account>
```