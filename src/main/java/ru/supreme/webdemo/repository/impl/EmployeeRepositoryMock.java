package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Deprecated
public class EmployeeRepositoryMock implements EmployeeRepository {

    /**
     * Это поле - упрощенная версия таблицы в БД.
     * В этом списке мы будем хранить всех работников
     */
    private final List<EmployeeEntity> employeeList = new ArrayList<>();

    /**
     * Проинициализируем в конструкторе наше хранилище(List<Employee>) начальными значениями
     */
    public EmployeeRepositoryMock() {
//        employeeList.add(new EmployeeEntity(1L, "Knyaz", "Developer"));
//        employeeList.add(new EmployeeEntity(2L, "Koshka", "Dealer"));
//        employeeList.add(new EmployeeEntity(3L, "Eye of Sauron", "Engineer"));
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return employeeList;
    }
    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeList.add(employeeEntity);
    }
    @Override
    public  void deleteEmployee(Long id) {
        for (int i = 0; i < employeeList.size(); ++i) {
            if (employeeList.get(i).getId().equals(id))
                employeeList.remove(i);
        }
    }
    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        for (EmployeeEntity employeeEntity : employeeList) {
            if (employeeEntity.getId().equals(id))
                return employeeEntity;
        }
        return null;
    }

}
