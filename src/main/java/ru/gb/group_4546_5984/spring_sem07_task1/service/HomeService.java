package ru.gb.group_4546_5984.spring_sem07_task1.service;

import org.springframework.stereotype.Service;

/**
 * Сервис домашней страницы
 */
@Service
public class HomeService {

    /**
     * Заголовок домашней страницы
     * @return текст заголовка
     */
    public String getText() {
        return "Домашняя страница";
    }

    /**
     * Изображение на домашней странице
     * @return картинка
     */
    public String getCat() {
        return "/img/pet-house.svg";
    }
}
