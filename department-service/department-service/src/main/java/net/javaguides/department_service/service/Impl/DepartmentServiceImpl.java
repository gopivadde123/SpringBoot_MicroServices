package net.javaguides.department_service.service.Impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
       Department department = new Department(
               departmentDto.getId(),
               departmentDto.getDepartmentName(),
               departmentDto.getDepartmentDescription(),
               departmentDto.getDepartmentCode()
       );

       Department savedDepartment= departmentRepository.save(department);
       DepartmentDto savedDepartmentDto = new DepartmentDto(
               savedDepartment.getId(),
               savedDepartment.getDepartmentName(),
               savedDepartment.getDepartmentDescription(),
               savedDepartment.getDepartmentCode()
       );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }

}
