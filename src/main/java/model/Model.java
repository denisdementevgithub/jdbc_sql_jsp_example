package model;
import entity.Gender;
import entity.Person;
import logic.Utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Model {
    private static Model instance = new Model();
    private HashMap<Integer, Person> model;
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public static Model getInstance() {
        return instance;
    }
    public Model() {
        this.model = new HashMap<>();
    }
    public void add(Person person) {
        try (Connection connection = Utils.getConnection();
             Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate("INSERT INTO list (name, gender, birthdate) " +
                    "VALUES ('" + person.getName() + "', '" +person.getGender() + "', '"+ format.format(person.getBirthDate()) +"');");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateID(String id, String name, String gender, String birthdate ) {
        try (Connection connection = Utils.getConnection();
             Statement statement = connection.createStatement()) {
            if (name != null || birthdate != null || gender != null) {
                StringBuilder SQLrequstPart = new StringBuilder("UPDATE list SET");
                if (name != null) {
                    SQLrequstPart.append(" name = '" + name + "'");
                }
                if (birthdate != null) {
                    SQLrequstPart.append(", birthdate  = '" + birthdate + "'");
                }
                if (gender != null) {
                    if (gender.equalsIgnoreCase("male")) {
                        SQLrequstPart.append(", gender = '" + Gender.MALE + "'");
                    } else if (gender.equalsIgnoreCase("female")) {
                        SQLrequstPart.append(", gender = '" + Gender.FEMALE + "'");
                    } else {
                        throw new RuntimeException();
                    }
                }
                String SQLrequest = (SQLrequstPart.append(" WHERE id = " + id + ";")).toString();
                int result = statement.executeUpdate(SQLrequest);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteID(String id) {
        try (Connection connection = Utils.getConnection();
             Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate("DELETE FROM list WHERE id = '" + id + "';");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

        public Map<Integer, Person> returnActualList() {
        model.clear();
        try (Connection connection = Utils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM list");
            while (resultSet.next()) {
                Person person = null;
                if (resultSet.getString(3).equalsIgnoreCase("male")) {
                    person = Person.createMale(resultSet.getString(2), format.parse(resultSet.getString(4)));
                } else if (resultSet.getString(3).equalsIgnoreCase("female")) {
                    person = Person.createFemale(resultSet.getString(2), format.parse(resultSet.getString(4)));
                }
                model.put(Integer.parseInt(resultSet.getString(1)), person);
            }
        } catch (SQLException | ParseException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }

}
