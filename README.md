Необходимо добавить методы на добавление работника, удаление, поиск по его id.

    1. Метод поиска работника по id должен иметь тип GET и возвращать найденного работника с HTTP кодом 200. Должен срабатывать по урлу /employees?id={id}, где {id} - идентификатор работника (например, /employees?id=1). Подсказка: использовать @RequestParam

    2. Метод на добавление должен иметь тип POST и возвращать только что созданного работника с HTTP кодом 201. Должен срабатывать по урлу /employees/create

    3. Метод на удаленеие работника по его id должен иметь тип DELETE и возвращать void с HTTP кодом 200. Должен срабатывать по урлу /employees/{id}, где id - идентификатор работника (например, /employees/1). Подсказка: использовать @PathVariable
    
Ссылки на полезную инфорамацию:

    HTTP коды
    https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%BA%D0%BE%D0%B4%D0%BE%D0%B2_%D1%81%D0%BE%D1%81%D1%82%D0%BE%D1%8F%D0%BD%D0%B8%D1%8F_HTTP
    
    Описание
    @RequestMapping
    @GetMapping
    @PostMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    @RequestParam
    @PathVariable
    https://www.baeldung.com/spring-requestmapping
