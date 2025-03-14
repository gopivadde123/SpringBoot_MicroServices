package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.APIResponseDto;
import net.javaguides.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="http://localhost:8085",value="DEPARTMENT-SERVICE")
// Here Spring Cloud load balancer automatically handles load balancing-
//- By calling available instances in department-service by using the ID
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
