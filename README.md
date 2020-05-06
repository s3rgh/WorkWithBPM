# Тестовое задание РТ БПМ

## Тестовое задание на позицию тестировщика
1.	Создать триал на https://s-quickbpm.io/ru/
2.	Создать приложение https://help.quickbpm.io/hc/ru/articles/360007235031
3.	Написать программу (скрипт), которая с использованием 
[API](https://help.quickbpm.io/hc/ru/articles/360013707832) 
создаст в приложении 1000 элементов в 4 параллельных потока.
4.	Составить отчёт о выполненных запросах: минимальное, максимальное и среднее время выполнения запроса (графика и визуализация приветствуется).

## Описание

- Приложение QuickBPM

[Приложение](https://6v5bk3r7iujya.s-quickbpm.ru/enterCalls/calls) выполнено в виде простого справочника для записи входящих звонков

<details>

![Enter Calls](http://i.piccy.info/i9/2844ce99b496d1bfe5e1f65c34ee035a/1588622282/224488/1376530/quickBpm.jpg)
</details>

- Настройки формы

<details>

![Настройки формы](http://i.piccy.info/i9/45919f522ccb0faa9e06ab6a3834f17f/1588622477/53031/1376530/formsettings.png)
</details>

## Описание реализации

- Сущности:

**Call**
```java
   String __name               - наименование входящего звонка
   Date dateAndTime            - дата и время входящего звонка 
   String companyName          - наименование компании входящего звонка 
   String firstName            - имя звонившего 
   String lastName             - фамилия звонившего
   List<Phone> phoneNumber     - номер телефона и его тип
   String testMessage          - текст сообщения
    
```

**Phone**

```java
   String number               - номер телефона
   String type                 - тип телефона (домашний или рабочий)
```

**PhoneTypes**

```java
    work                       - домашний
    home                       - рабочий 
```

- Интерфейсы

```java
    SenderJson                 - интерфейс для отправки POST запроса на указанный API
    ExecutorCalls              - интерфейс для взаимодействия с отправкой и построением графики
    GraphicBuilder             - интерфейс для вывода графики (фактически не использую)
```

- Сервисы
```java
GraphicBuilderService          - построение графики 
ExecutorCallsService           - взаимодействие с отправкой POST запроса и вызов построения графики  
SenderJsonService              - отправка POST запроса
```

## Запуск приложения

## При запуске приложения будет выдан запрос для ввода количества звонков:

Приложение запускает автоматическое формирование звонков после чего отображается диаграмма среднего, минимального и максимально затраченного времени на отправку и получение  ответов на POST запрос

![Результат времени выполнения запросов](https://s8.hostingkartinok.com/uploads/images/2020/05/b19b6c419d4fe6779cced73092ed6f6d.png)

в результате в приложении QuickBPM отобразятся новые записи

![Результат в QuickBPM](https://s8.hostingkartinok.com/uploads/images/2020/05/6068057c5fe61c2e4317b8f2111871e2.png)



## Зависимости
[gson](https://github.com/google/gson)
```xml
<dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.8.6</version>
</dependency>
```




