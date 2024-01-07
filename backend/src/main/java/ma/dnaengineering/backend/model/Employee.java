package ma.dnaengineering.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

   // id,employee_name,job_title,salary

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String employeeName; 
   private String jobTitle;
   private Double salary;

    
}
