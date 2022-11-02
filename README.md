# Дипломный проект по профессии «Тестировщик»

Дипломный проект — автоматизация тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.

## Отчеты
* [План автоматизации](https://github.com/AntonKopylov89/Travel_tour_web_service_testing/blob/main/Documents/Plan.md)
* [Отчет по итогам тестирования](https://github.com/AntonKopylov89/Travel_tour_web_service_testing/blob/main/Documents/Report.md)
* [Отчет по итогам автоматизации](https://github.com/AntonKopylov89/Travel_tour_web_service_testing/blob/main/Documents/Summary.md)


## Описание приложения

### Бизнес-часть

Приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:

1. Обычная оплата по дебетовой карте.
2. Уникальная технология: выдача кредита по данным банковской карты.


Само приложение не обрабатывает данные по картам, а пересылает их банковским сервисам:
* сервису платежей, далее Payment Gate;
* кредитному сервису, далее Credit Gate.

Приложение в собственной СУБД должно сохранять информацию о том, успешно ли был совершён платёж и каким способом. Данные карт при этом сохранять не допускается.

## Запуск авто-тестов
### Необходимое ПО:
* IntelliJ IDEA
* Docker Desktop

### Запуск
* В терминале выполнить команду git clone https://github.com/AntonKopylov89/Travel_tour_web_service_testing
* В терминале выполнить команду docker-compose up -d для запуска контейнеров с MySql, PostgreSQL и Node.js.
* Запуск приложения: 
    * В терминале выполнить команду (запустится с СУБД MySQL): 
    ```
    java -jar artifacts/aqa-shop.jar &
    ```
    * для запуска с СУБД PostgreSQL в терминале выполнить команду: 
    ```
    java -jar artifacts/aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app &
    ```
* запуск тестов с Allure:
   * для запуска с СУБД MySQL в терминале выполнить команду: 
   ```
   ./gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app -Dusername=app -Dpassword=pass --infoean test
   ```
   * для запуска с СУБД PostgreSQL в терминале выполнить команду:  
   ```
   ./gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app -Dusername=app -Dpassword=pass --infoean test
   ```
* для получения отчета Allure в терминале выполнить команду: 
  ```
  ./gradlew allureReport allureServe
  ```
