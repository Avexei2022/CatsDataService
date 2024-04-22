package ru.gb.group_4546_5984.spring_sem07_task1.service;

import org.springframework.stereotype.Service;

/**
 * Сервис пользователей
 */
@Service
public class UserService {

    /**
     * Заголовок страницы пользователя
     * @return текст заголовка
     */
    public String getText() {
        return "Пользовательская страница";
    }

    /**
     * Заголовок страницы Public-data
     * @return текст заголовка
     */
    public String getPublicText() {
        return "Public Cat`s Data";
    }

    /**
     * Изображение на странице Public-data
     * @return картинка
     */
    public String getCat() {
        return "/img/public-cat.svg";
    }
}
