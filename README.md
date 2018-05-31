# Tests 
1. Устанавливаем последнюю версию chromedriver (https://sites.google.com/a/chromium.org/chromedriver/downloads).
2. Заходим в IntellIJ IDEA и нажимаем Import Project (загружаем проект Autotest).
3. В каждом тесте из папки «Tests» прописываем путь до драйвера в @Before class (System.setProperty) вместо моего "/Users/aguseva/chromedriver" или просто даем команду mvn clean test -Dwebdriver.chrome.driver=<path to chromedriver>
4. Запускаем тесты.
5. Возможно, потребуется обновление используемых библиотек, которые прописаны в файле pom.xml проекта.
Для обновления нужно перейти на https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java, выбрать последнюю версию и скопировать данные в pom.xml (или ivy.xml (в зависимости от сборки)) вместо устаревших. То же проделать с библиотекой junit - https://mvnrepository.com/artifact/junit/junit (подробнее об этом можно посмотреть в гайде http://www.autotest.org.ua/perviy-autotest-s-selenium-webdriver-java-1/.

В тестах проверяются положительные проверки функционала:

    1. Войти/Выйти из ЛК - LoginTest
    2. Пополнить счет (Карты для тестов: 4222222222222/4007000000027) - TopUpTest
    3. Привязать бота к c2s-номеру и взять в аренду номер c2s - C2STest
    4. Создать бота (via API) - ViaApiTest
    5. Создать бота с помощью конструктора - ViaBuilderTest
    6. Привязать бота к телеграм-боту - TelegramTest
    7. Привязать бота к MBF(Microsoft-боту) и привязать бота к скайп-боту - MBFTest
    


PS логины/пароли/токены во внешних ресурсах: 

1) Telegram

Name: AutoTestMappsBot
Number: +7 (916) 235-25-98
Token: 529094454:AAHNSE7wJ9_qCZphqIQ1WJyRlXzWgaBSiSs


2) MBF/Gmail (для входа в gmail те же данные)

eyeline.api.ai@gmail.com

пароль — hL3-5KY-ckC-b5E


В MBF

App Name: AutoTestMapps

ID: 276f514b-0567-4b52-b393-fdbfed45e0fe

App password: mwzhCCRE7@diqWTI1243$%=
