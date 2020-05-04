package org.sergh.app.execution;

import org.sergh.app.entity.Call;

/**
 * Интерфейс сервиса для обработки объекта класса Call и приобразования значений
 * полей объекта в JSON для последующей передачи к отправке, а также формирования
 * набора данных для построения графики отображения времени обработки POST запросов.
 */
public interface ExecutorCalls {

    /**
     * Метод для ручного формирования запроса с JSON телом запроса к API приложения
     *
     */
    void simpleExecutor();

    /**
     * Метод запускает автоматическое порождение объектов класса Call,
     * поля заполняются случайными данными
     *
     *
     *
     */
    void parallelExecutor();

    /**
     * Метод принимает
     *
     * @param call объект класса Call
     * @return String с JSON телом запроса к API приложения
     */
    String ObjToJson(Call call);

}