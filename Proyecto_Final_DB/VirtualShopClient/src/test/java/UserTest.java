import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    User u = new User("37433301L", "1234", "Pepe", "pepe@gmail.com", "123456789", "Mi casa");

    @Test
    void getDni() {
        assertTrue("37433301L".equals(u.getDni()));
    }

    @Test
    void getPassword() {
        assertTrue("1234".equals(u.getPassword()));
    }

    @Test
    void getName() {
        assertTrue("Pepe".equals(u.getName()));
    }

    @Test
    void getEmail() {
        assertTrue("pepe@gmail.com".equals(u.getEmail()));
    }

    @Test
    void setEmail() {
        String newEmail = "pmanolo@gmail.com";
        u.setEmail(newEmail);
        assertTrue(newEmail.equals(u.getEmail()));
    }

    @Test
    void getPhone() {
        assertTrue("123456789".equals(u.getPhone()));
    }

    @Test
    void setPhone() {
        String newPhone = "299229922";
        u.setPhone(newPhone);
        assertTrue(newPhone.equals(u.getPhone()));
    }

    @Test
    void getAddress() {
        assertTrue("Mi casa".equals(u.getAddress()));
    }

    @Test
    void setAddress() {
        String newAddress = "Av Colon, 53";
        u.setAddress(newAddress);
        assertTrue(newAddress.equals(u.getAddress()));
    }

    @Test
    void verifyDNI() {
        String dni = "14698120Q";
        assertTrue(User.verifyDNI(dni));

        String notDNI = "12345678E";
        assertFalse(User.verifyDNI(notDNI));
    }

    @Test
    void verifyEmail() {
        String email = "test@test.com";
        assertTrue(User.verifyEmail(email));

        String notEmail = "sadas@as";
        assertFalse(User.verifyEmail(notEmail));
    }

    @Test
    void verifyPhone() {
        String phone = "123536789";
        assertTrue(User.verifyPhone(phone));
    }
}