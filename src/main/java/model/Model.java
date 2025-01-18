package model;
import entity.Gender;
import entity.Person;

import java.sql.*;
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
    public Connection connection;
    {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crud_db",
                    "postgres", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public Model() {
        this.model = new HashMap<>();
    }
    public void add(Person person) {
        try (Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate("INSERT INTO list (name, gender, birthdate) " +
                    "VALUES ('" + person.getName() + "', '" +person.getGender() + "', '"+ format.format(person.getBirthDate()) +"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateID(String id, String name, String gender, String birthdate ) {
        try (Statement statement = connection.createStatement()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteID(String id) {
        try (Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate("DELETE FROM list WHERE id = '" + id + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public Map<Integer, Person> returnActualList() {
        model.clear();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM list");
            while (resultSet.next()) {
                Person person = null;
                if (resultSet.getString(3).equalsIgnoreCase("male")) {
                    person = Person.createMale(resultSet.getString(2), format.parse(resultSet.getString(4)));
                } else if (resultSet.getString(3).equalsIgnoreCase("female")) {
                    person = Person.createFemale(resultSet.getString(2), format.parse(resultSet.getString(4)));
                }
                System.out.println(person.toString());
                model.put(Integer.parseInt(resultSet.getString(1)), person);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return model;
    }
}
