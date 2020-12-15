package utils;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserOperations {
    public static User validateByCredentials(String login, String psw, int sys_id) {
        Connection connection = DBOperations.connectionToDB();
        User currentUser = null;
        try {
            String selectUser = "SELECT * FROM user AS u WHERE u.login = ? AND u.psw = ? AND u.courseIS_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, psw);
            preparedStatement.setInt(3, sys_id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                currentUser = new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    public static User getUserById(int id) {
        Connection connection = DBOperations.connectionToDB();
        User currentUser = null;
        try {
            String selectUser = "SELECT * FROM user AS u WHERE u.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                currentUser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getString(7), rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    public static List<User> getAllUsersInSys(int sysId) {
        Connection connection = DBOperations.connectionToDB();
        List<User> users = new ArrayList<>();
        User user;
        try {
            String selectUser = "SELECT * FROM user AS u WHERE u.courseIS_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectUser);
            preparedStatement.setInt(1, sysId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6), rs.getString(7), rs.getInt(9));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User insertUser(String name, String surname, String login, String psw, int year, boolean isModerator, String bankAcc, int course_id) {
        Connection connection = DBOperations.connectionToDB();

        try {
            String insertUser = "INSERT INTO user (`name`, `surname`, `login`, `psw`, `year`, `is_moderator`, `bank_acc`, `courseIS_id` ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, psw);
            preparedStatement.setInt(5, year);
            preparedStatement.setBoolean(6, isModerator);
            preparedStatement.setString(7, bankAcc);
            preparedStatement.setInt(8, course_id);
            preparedStatement.execute();
            return validateByCredentials(login, psw, course_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User updateUser(String name, String surname, String login, String psw, int year, boolean isModerator, String bankAcc, int course_id) {
        Connection connection = DBOperations.connectionToDB();

        try {
            String insertUser = "UPDATE user SET `name` = ?, `surname` = ?, `psw` = ?, `year` = ?, `is_moderator` = ?, `bank_acc` = ? WHERE login = ? and courseis_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, psw);
            preparedStatement.setInt(4, year);
            preparedStatement.setBoolean(5, isModerator);
            preparedStatement.setString(6, bankAcc);
            preparedStatement.setString(7, login);
            preparedStatement.setInt(8, course_id);
            preparedStatement.executeUpdate();
            return validateByCredentials(login, psw, course_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteUser(int id) {
        Connection connection = DBOperations.connectionToDB();

        try {
            String deleteUser = "DELETE FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
