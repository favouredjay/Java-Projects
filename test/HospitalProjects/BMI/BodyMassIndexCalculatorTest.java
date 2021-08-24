package HospitalProjects.BMI;

import HospitalProjects.BMI.Exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexCalculatorTest {
    BodyMassIndexCalculator calculator = new BodyMassIndexCalculator();
    @BeforeEach
    void setUp() throws InvalidInputException {
        calculator.setName("Sarah");
        calculator.setGender("female");
        calculator.setAge(221);
    }
    @Test
    void testThatAgeIsInvalid(){
        assertThrows(InvalidInputException.class,()->calculator.getAge());
    }

//    @Test
//    void testThatPatientIsNotNull(){
//        assertNotNull(calculator);
//    }
}