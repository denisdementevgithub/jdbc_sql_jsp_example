import entity.Person;
import model.Model;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class TestClass {
    private static Connection connection;
    @BeforeClass
    public static void getConnection() throws SQLException, ClassNotFoundException {
        Model model = new Model();
        connection = model.connection;
    }
    @Before
    public void testConnection() throws SQLException {
            Assert.assertTrue(connection.isValid(1));
    }
    @Test
    public void testAddReadUpdateDeletePerson() {
        Person testPerson = Person.createMale("Test", new GregorianCalendar(1991, 00,01).getTime());
        Model model = Model.getInstance();
        model.add(testPerson);
        Map<Integer, Person> testMap = model.returnActualList();
        Set<Integer> testKeys = testMap.keySet();
        int maxKey = testKeys.stream()
                .max(Comparator.naturalOrder())
                .get();
        Assert.assertEquals(testPerson, testMap.get(maxKey));
        model.updateID(Integer.toString(maxKey), "Test2", "FEMALE", "1999-05-15");
        Person updatePerson = Person.createFemale("Test2", new GregorianCalendar(1999, 4, 15).getTime());
        Assert.assertEquals(updatePerson, model.returnActualList().get(maxKey));
        model.deleteID(Integer.toString(maxKey));
        testKeys = model.returnActualList().keySet();
        Assert.assertFalse(testKeys.contains(maxKey));
    }
    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }
}



