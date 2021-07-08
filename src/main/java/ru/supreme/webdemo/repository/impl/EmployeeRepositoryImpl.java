package ru.supreme.webdemo.repository.impl;

import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.EmployeeEntity;
import ru.supreme.webdemo.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    /**
     * Это поле - упрощенная версия таблицы в БД.
     * В этом списке мы будем хранить всех работников
     */
    private final List<EmployeeEntity> employeeEntityList = new ArrayList<>();

    /**
     * Проинициализируем в конструкторе наше хранилище(List<Employee>) начальными значениями
     */
    public EmployeeRepositoryImpl() {
        employeeEntityList.add(new EmployeeEntity(1L, "Knyaz", "Developer", 1L));
        employeeEntityList.add(new EmployeeEntity(2L, "Koshka", "Dealer", 1L));
        employeeEntityList.add(new EmployeeEntity(3L, "Eye of Sauron", "Engineer", 2L));
    }

    @Override
    public List<EmployeeEntity> findAllEmployees() {
        return employeeEntityList;
    }
    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {
        employeeEntityList.add(employeeEntity);
    }
    @Override
    public  void deleteEmployee(Long id) {
        for (int i = 0; i < employeeEntityList.size(); ++i) {
            if (employeeEntityList.get(i).getId().equals(id))
                employeeEntityList.remove(i);
        }
    }
    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        for (EmployeeEntity employeeEntity : employeeEntityList) {
            if (employeeEntity.getId().equals(id))
                return employeeEntity;
        }
        return null;
    }

}
