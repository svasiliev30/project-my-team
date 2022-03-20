# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin: sproshchaev@gmail.com
* Other community or team contact:
  clame023@gmail.com
  evgenusn@gmail.com
  konstfilin1962@gmail.com
  vasiljevserj777@gmail.com

### Spring Initalizr https://start.spring.io/ ###
https://start.spring.io
Project: Maven Project, Language: Java
Spring Boot: 2.6.4
Project Metadata
- Group: ru.sbp
- Artifact: bank-financial-processing-system
- Name: bank-financial-processing-system
- Description: Bank (Financial processing system)
  Packaging: War
  Java: 8
  Dependencies: Spring Data JPA, Spring Web

### PostgreSQL ###
1. Run SQL Shell (psql): Server [localhost], Database [postgres], Port [5432], Username [postgres], password 12345
2. Set codepage: psql \! chcp1251
3. Databases list: \l

4. Create dump use pg_dump (https://help.sweb.ru/entry/113/)
   Change directory (cd) C:\Program Files\PostgreSQL\14\bin>
   pg_dump -d backofficedb -h localhost -p 5432 -U postgres -F p -f C:\Users\...\Documents\backofficedb
   (password 12345)

5. Restore dump (https://help.sweb.ru/entry/113/)
   Change directory (cd) C:\Program Files\PostgreSQL\14\bin>
   pg_restore -h localhost -U postgres -F p -d backofficedb C:\Users\...\Documents\backofficedb

6. Or use pgadmin https://betacode.net/11913/backup-and-restore-postgres-database-with-pgadmin)
   Backup-file: db\backup\pgAdmin\backofficedb.dump

   (*) Для того, чтобы восстановить БД из файла backofficedb.backup необходимо:
   - удалить через pgAdmin БД backofficedb
   - создать через pgAdmin новую БД c именем backofficedb
   - на созданной БД backofficedb выбрать Restore (файл БД, UTF8, postgres)

7. Data type (Типы данных)
- integer
- character varying, Length/Persion XX (соответствует varchar(XX))

=================================от 28.02.2022========================================================
Bank (Financial processing system)
----------------------------------
1. Проект bank-financial-processing-system создан на основе архетипа maven-archetype-quickstart
2. Добавлены следующие зависимости в pom.xml:
   2.1. junit (модульное тестирование)
   2.2. junit-jupiter-api (модульное тестирование)
   2.3. slf4j-api (логирование)
   2.4. logback-classic (логирование)
   2.5. spring-boot-starter-aop (Spring AOP)
   2.6. postgresql
   2.7. sqlite-jdbc
   2.8. sqlite-dialect
   2.9. jackson-dataformat-xml (серелизация/десерелизация)
   2.10. gson (серелизация/десерелизация)
   2.11. spring-boot-starter-web (для запуска web-сервера)
   2.12. hibernate-core (Spring Data)
   2.13. spring-data-jpa (Spring Data)
   2.14. spring-context (Spring)

3. Точка входа App
4. Spring конфигурация в класса ru.sbp.config.ServerConfig
5. REST-контроллер в классе ru.sbp.controllers.ServerController
6. DAO пакеты
7. Properties-файл resources/app.properties
   7.1. наименование "systemName"
   7.2. номер-порта "portApp"
8. Настроено сквозное логирование в классе ru.sbp.aop.ServerLoggerAspect c использованием slf4j и logback-classic
9. Логирование с использованием slf4j и logback-classic, конфигурация в resources/logback.xml

PostgreSQL
----------
port: 5432, user: postgres, password: 12345
----------
Таблица BankData
CREATE TABLE BankData (ID INTEGER PRIMARY KEY, BIC VARCHAR(10), FullName VARCHAR(100), AbbreviatedName VARCHAR(50), License VARCHAR(100), RegisteredAddress VARCHAR(50), PostalAddress VARCHAR(50), CorrespondentAccount VARCHAR(20), KPP VARCHAR(20), INN VARCHAR(20), OGRN VARCHAR(20), SWIFT VARCHAR(50));

yaml - вместо app.prop.!!!

======================================================План действий.txt (Олег) ======================================================================
Предлагаю составить план на короткое время (типа спринт):
1) Загрузить общий проект с БитБакета на свой компьютер и запустить
   Проверить работоспособность программы перейдя по ссылке localhost:8080/bank/test
   - должна вернуться "не пустая" страница

2) Запилить интерфейсы (у каждого по проекту есть своя "веб-морда")
   По аналогии с тестовой страницей делаем свою "Веб-морду"
   Нужно согласовать общую папку для хранения html/jsp
   Требования к "веб-морде":
   Минимальный функционал!! (т.е. чтобы запустилось по сстлке "извне" типа как в тесте)
   Желательно что нибудь подгрузить со "своей" таблицы из БД

3) Весь новый функционал пилим в своей локальной ветке общего репозитория
   По готовности загружаем данные в develop_m из БитБакета (обновляем из общего репозитория, вдруг кто то чего нибудь уже напилил)
   Локально Мёрджим (объединяем) со своей веткой
   Выгружаем в свою ветку удаленного репозитория БитБакета
   и через PullRequest добавляем свой функционал в ветку develop_m (в ПР нужно добавить Романа(trv))

Если есть у кого что изменить/добавить прошу дополнить этот документ
