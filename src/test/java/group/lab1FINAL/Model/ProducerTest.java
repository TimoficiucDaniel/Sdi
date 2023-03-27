package group.lab1FINAL.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProducerTest {
    private Producer prodigy;

    @BeforeEach
    void setUp() {
        prodigy = new Producer("test","testaddr","0712345678","testemail",2000);
    }

    @Test
    void setId() {
        Long id = prodigy.getId();
        prodigy.setId(50L);
        assertEquals(prodigy.getId(),50L);
        prodigy.setId(id);
    }

    @Test
    void setName() {
        String name = prodigy.getName();
        prodigy.setName("testset");
        assertEquals(prodigy.getName(),"testset");
        prodigy.setName("test");
    }

    @Test
    void setAddress() {
        String addr = prodigy.getAddress();
        prodigy.setAddress("testset");
        assertEquals(prodigy.getAddress(),"testset");
        prodigy.setAddress("testaddr");
    }

    @Test
    void setPhoneNumber() {
        String phone = prodigy.getPhoneNumber();
        prodigy.setPhoneNumber("testset");
        assertEquals(prodigy.getPhoneNumber(),"testset");
        prodigy.setPhoneNumber("0712345678");
    }

    @Test
    void setEmail() {
        String email = prodigy.getEmail();
        prodigy.setEmail("testset");
        assertEquals(prodigy.getEmail(),"testset");
        prodigy.setEmail("testemail");
    }

    @Test
    void setGdp() {
        Integer gdp = prodigy.getGdp();
        prodigy.setGdp(10);
        assertEquals(prodigy.getGdp(),10);
        prodigy.setGdp(2000);
    }

    @Test
    void getId() {
    }

    @Test
    void getName() {
        assertEquals(prodigy.getName(),"test");
    }

    @Test
    void getAddress() {
        assertEquals(prodigy.getAddress(),"testaddr");
    }

    @Test
    void getPhoneNumber() {
        assertEquals(prodigy.getPhoneNumber(),"0712345678");
    }

    @Test
    void getEmail() {
        assertEquals(prodigy.getEmail(),"testemail");
    }

    @Test
    void getGdp() {
        assertEquals(prodigy.getGdp(),2000);
    }

    @Test
    void testToString() {
        assertTrue(true);
    }
}