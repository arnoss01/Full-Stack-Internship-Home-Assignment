package ma.dnaengineering.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

import ma.dnaengineering.backend.dao.EmployeeDao;
import ma.dnaengineering.backend.model.Employee;
import ma.dnaengineering.backend.service.EmployeeService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeTest {



    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeDao employeeRepository;


    @BeforeEach
    void saveEmployees() throws IOException  {
        ClassPathResource resource = new ClassPathResource("employees.csv");
        Path filePath = resource.getFile().toPath();
           
        MultipartFile file = new MockMultipartFile(filePath.toString(), "data".getBytes());
            employeeService.saveEmployees(file);
       

        // Add assertions as needed
    }
 
    @Test
    void getAllEmployeesSortedByName() {
        
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(1000,employees.size());
    }
/* *.
    @Test
    void getJobSummaries() {
        // Mock data
        Map<String, Double> mockSummaries = Collections.singletonMap("Developer", 60000.0);

        // Mock repository method if needed

        // Call the service method
        Map<String, Double> result = employeeService.getJobSummaries();

        // Add assertions as needed
        assertEquals(mockSummaries, result);
    }
    */
    
    
}
