package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.User;

/*
 * UserDAO Interface
 *
 * This interface contains all the database operations
 * related to the User table.
 *
 * The implementation of these methods will be written
 * in the UserDAOImpl class.
 */

public interface UserDAO {

    /*
     * Adds a new user to the database.
     *
     * @param user - User object containing user details
     * @return true if user is added successfully,
     *         otherwise false
     */
    boolean addUser(User user);

    /*
     * Fetches a user using the User ID.
     *
     * @param userId
     * @return User object
     */
    User getUserById(int userId);

    /*
     * Fetches a user using the Username.
     *
     * @param username
     * @return User object
     */
    User getUserByUsername(String username);

    /*
     * Returns all users from the database.
     *
     * @return List<User>
     */
    List<User> getAllUsers();

    /*
     * Updates an existing user's details.
     *
     * @param user
     * @return true if updated successfully,
     *         otherwise false
     */
    boolean updateUser(User user);

    /*
     * Deletes a user using the User ID.
     *
     * @param userId
     * @return true if deleted successfully,
     *         otherwise false
     */
    boolean deleteUser(int userId);

    /*
     * Checks whether the username and password
     * are valid for login.
     *
     * @param username
     * @param password
     * @return User object if login is successful,
     *         otherwise null
     */
    User loginUser(String username, String password);
}