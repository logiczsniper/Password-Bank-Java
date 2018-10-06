import org.junit.Test
import org.junit.Before
import org.junit.After


/**
 * Tests for the bank interaction methods within PasswordBank.java
 *
 * @author Logan Czernel
 * @since 06-10-2018
 */


class PasswordBankTests {

    PasswordBank newTestBank

    @Before
    void setup() {
        // At the start of each test, get a fresh read of bank.json
        newTestBank = new PasswordBank()
    }

    @Test
    void testAddPair() {
        // Ensure that adding a pair of credentials results in the following return message
        assert newTestBank.addPair("username", "password") == "The credentials have been added!"
    }

    @Test
    void testGetPair() {
        // Add a pair to have it's password fetched
        newTestBank.addPair("username", "password")
        assert newTestBank.getPair("username") == "Password: password"
    }

    @Test
    void testDeletePair() {
        // Add a pair to be deleted as the test
        newTestBank.addPair("username", "password")
        assert newTestBank.deletePair("username") == "The credentials have been deleted!"
    }

    @Test
    void testClearBank() {
        // Clearing the bank should result in the following return message
        assert newTestBank.clearBank() == "All credentials have been deleted!"
    }

    @After
    void teardown() {
        // After every test, clear the bank to ensure they do not conflict with each other
        newTestBank.clearBank()
    }
}
