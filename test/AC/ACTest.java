package AC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ACTest {
    AC ac = new AC();

    @Test
    void testThatAcIsNotNull(){
        assertNotNull(ac);
    }

    @Test
    void testThatAcCanBeTurnedOn(){
    boolean isOff = !ac.isOn();
    assertTrue(isOff);
    ac.turnOn();
    assertTrue(ac.isOn());
    }

    @Test
    void testThatTemperatureCanBeIncreased(){
    ac.turnOn();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    ac.increaseTemperatureWhenRoomIsCold();
    assertEquals(30, ac.getTemperature());

    }

    @Test
    void testThatTemperatureCanBeDecreased(){
    ac.turnOn();
    ac.decreaseTemperature();
    ac.decreaseTemperature();
    assertEquals(16, ac.getTemperature());
    }

}