package org.sergh.app.interaction;


/**
 * Интерфейс сервиса для выполнения отправки одиночного POST-запроса к API приложения,
 * а также отправки множества запросов и вычисления времени их выполнения
 */
public interface SenderJson {

    /**
     * Метод отправляет строку json
     *
     * @param json на внешний API приложения и возвращает время обработки запроса
     * @return timeForRequest
     */
    int postJson(String json);

}