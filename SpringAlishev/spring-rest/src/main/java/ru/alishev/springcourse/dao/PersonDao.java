package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        Person person = null;
        try {
            PreparedStatement preparedStatementstatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatementstatement.setInt(1, id);
            ResultSet resultSet = preparedStatementstatement.executeQuery();
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return person;
        //  return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {

        try {
            PreparedStatement preparedStatementstatement =
                    connection.prepareStatement("INSERT INTO Person VALUES(1, ?,?,?)");
            preparedStatementstatement.setString(1, person.getName());
            preparedStatementstatement.setInt(2, person.getAge());
            preparedStatementstatement.setString(3, person.getEmail());
            preparedStatementstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(int id, Person updatedPerson) {
        try {
            PreparedStatement preparedStatementstatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
            preparedStatementstatement.setString(1, updatedPerson.getName());
            preparedStatementstatement.setInt(2, updatedPerson.getAge());
            preparedStatementstatement.setString(3, updatedPerson.getEmail());
            preparedStatementstatement.setInt(4,id);
            preparedStatementstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }

    public void delete(int id) {

        try {
            PreparedStatement preparedStatementstatement =
                    connection.prepareStatement("DELETE FROM Person  WHERE id=?");
            preparedStatementstatement.setInt(1,id);
            preparedStatementstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        people.removeIf(person -> person.getId() == id);
    }
}
