package net.javaguides.employee_service.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.employee_service.dto.APIResponseDto;
import net.javaguides.employee_service.dto.DepartmentDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.APIClient;
import net.javaguides.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
  //  @Autowired
    // private WebClient webClient;
    private APIClient apiClient;

//    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        System.out.println("employeeDto.getId()+----"+employeeDto.getId());
        System.out.println("employeeDto.getId()+----"+employeeDto.getFirstName());
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
       Employee savedEmployee= employeeRepository.save(employee);
       EmployeeDto savedEmployeeDto=new EmployeeDto(
               savedEmployee.getId(),
               savedEmployee.getFirstName(),
               savedEmployee.getLastName(),
               savedEmployee.getEmail(),
               savedEmployee.getDepartmentCode()
       );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();
        // below is communication with Rest Template
//       ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8084/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//
//        DepartmentDto departmentDto=responseEntity.getBody();
        // WebClient
//       DepartmentDto departmentDto=webClient.get()
//               .uri("http://localhost:8084/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
 DepartmentDto departmentDto =apiClient.getDepartment(employee.getDepartmentCode());

       EmployeeDto employeeDto=new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
