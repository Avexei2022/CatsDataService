# Spring Security
## CatsDataService

### Небольшое Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя.

![Домашняя страница](https://drive.google.com/thumbnail?id=1IPemxpZqS9wGgrO-1z-79zk0D7pfjbBY&sz=s800)

Реализована форма входа для аутентификации пользователей с использованием стандартных средств Spring Security.

![Форма входа для аутентификаци](https://drive.google.com/thumbnail?id=1Rg_O72rVSFRiXpK3nzzY6SrzttHJq4z1&sz=s800)

Создан ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN
(login: admin password: admin)

![private-data](https://drive.google.com/thumbnail?id=15MQHJxliVj268wJ7XYKaIo89z0J2-I-V&sz=s800)

![Admin`s page](https://drive.google.com/thumbnail?id=114vGuHWHAMVPwT81m2RMF7qTpfjRV6fF&sz=s800)

Создан ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от их роли.  
(login: user1 password: user1), (login: user2 password: user2), (login: user3 password: user3)

![public-data](https://drive.google.com/thumbnail?id=16zL8KLbVgYBqYr3bkReQZUCskZILDGde&sz=s800)

![User`s page](https://drive.google.com/thumbnail?id=19_AV6KIKQoIacOLK3dpTZG6iLHEvv0u2&sz=s800)


Если аутентифицированный пользователь, не имеющий роли ADMIN пытается получить доступ к /private-data,
то выводится сообщение о запрете доступа.

![User`s page](https://drive.google.com/thumbnail?id=1gqnM2WT6hnSZmtjSssher22JhE4arILM&sz=s800)

Если неаутентифицированный пользователь пытается получить доступ к /private-data
или к /public-data, он перенаправляется на форму входа.

![Форма входа для аутентификаци](https://drive.google.com/thumbnail?id=1Rg_O72rVSFRiXpK3nzzY6SrzttHJq4z1&sz=s800)

## Запуск -> CatsDataServiceApplication

## Вход -> http://localhost:8080

 

