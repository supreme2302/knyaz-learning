package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.Employee;
import ru.supreme.webdemo.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    /**
     * Это поле - упрощенная версия таблицы в БД.
     * В этом списке мы будем хранить всех работников
     */
    private final List<Employee> employeeList = new ArrayList<>();

    /**
     * Проинициализируем в конструкторе наше хранилище(List<Employee>) начальными значениями
     */
    public EmployeeRepositoryImpl() {
        employeeList.add(new Employee(1L, "Knyaz", "Developer"));
        employeeList.add(new Employee(2L, "Koshka", "Dealer"));
        employeeList.add(new Employee(3L, "Eye of Sauron", "Engineer"));
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeList;
    }
    @Override
    public void saveEmployee(Employee employee) {
        employeeList.add(employee);
    }
    @Override
    public  void deleteEmployee(Long numbId) {
        int i = 0;
        for(Employee e : employeeList) {
            if (e.getId().equals(numbId)) {
                employeeList.remove(i);
            }
            i++;
        }
    }
}
