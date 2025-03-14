package net.javaguides.department_service.controller;

import lombok.AllArgsConstructor;
import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
   // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
       DepartmentDto savedDepartment= departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    // Build get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
       DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
