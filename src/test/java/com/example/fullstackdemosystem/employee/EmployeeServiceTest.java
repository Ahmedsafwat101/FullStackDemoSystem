package com.example.fullstackdemosystem.employee;

import com.example.fullstackdemosystem.employee.dto.EmployeeResponseDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper employeeMapper;
    private EmployeeService underTest;


    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeRepository, employeeMapper);

    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void addEmployee() {
        //given
        Employee employee = new Employee(
                "Ahmed",
                "Ahmed@gmail.com",
                "Admin",
                "+201126638220",
                ""
        );

        //when
        underTest.addEmployee(employee);
        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor
                = ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        assertThat(employeeArgumentCaptor.getValue()).isEqualTo(employee);
    }

    @Test
    void updateEmployee() {

    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void findEmployee() {
        //given
        Long id = 1L;
        Employee employee = new Employee(
                "Ahmed",
                "Ahmed@gmail.com",
                "Admin",
                "1",
                "+201126638220",
                ""
        );
        employee.setId(id);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setId(1L);
        when(employeeMapper.EmployeeToEmployeeDto(employee)).thenReturn(employeeResponseDTO);

        //when
        when(employeeRepository.findById(id)).thenReturn(Optional.of((employee)));
        EmployeeResponseDTO employeeDTO = underTest.findEmployee(id);
        //then
        verify(employeeRepository).findById(id);
        assertThat(id).isEqualTo(employeeDTO.getId().longValue());
    }

    @Test
    void findAllEmployees() {
        //when
        underTest.findAllEmployees();
        //then
        verify(employeeRepository).findAll();
    }
}