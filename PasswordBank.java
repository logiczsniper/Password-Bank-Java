import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This file is the script that interacts with the actual password bank which is a json file. To do this, it stores a
 * hash map which will be created based off the json data, modified based on user input, and then written to update
 * the json file.
 *
 * @author Logan Czernel
 * @since 02-10-2018
 */


class PasswordBank {

    /**
     * Holds methods to:
     * Add a username - password pair
     * Delete a username - password pair
     * Get a password with a provided username.
     */

    private HashMap<String, String> bank;
    private Gson gson = new GsonBuilder().create();

    /**
     * Upon init, read from the json file and save the hash map in a variable.
     *
     * @throws Exception a warning to stop the program. If the json file cannot be read, the program will not work.
     */
    PasswordBank() throws Exception {

        try {
            Type type = new TypeToken<HashMap<String, String>>() {
            }.getType();
            bank = gson.fromJson(new FileReader("bank.json"), type);
        } catch (FileNotFoundException e) {
            throw new Exception("Failed to open to json file");
        }
    }

    /**
     * Adds the given username and password to the json file.
     *
     * @param username the username to be added.
     * @param password the password to be added.
     * @return a string that will be displayed to the user that notifies them of the outcome.
     * @throws Exception stops the program if the json file could not be written to.
     */
    String addPair(String username, String password) throws Exception {

        if (username.equals("") && password.equals("")) {
            return "Please enter a username and password!";
        } else if (username.equals("")) {
            return "Please enter a username.";
        } else if (password.equals("")) {
            return "Please enter a password";
        }

        if (bank.get(username) != null) {
            return "The credentials are already saved!";
        }

        bank.put(username, password);

        try (FileWriter file = new FileWriter("bank.json")) {
            file.write(gson.toJson(bank));
            return "The credentials have been added!";
        } catch (IOException ioe) {
            throw new Exception("Failed to write to json file");
        }
    }

    /**
     * Deletes the username and password pair given the username.
     *
     * @param username the username that corresponds to the credentials to be deleted.
     * @return a string that will be displayed to the user that notifies them of the outcome.
     * @throws Exception stops the program if the json file could not be written to.
     */
    String deletePair(String username) throws Exception {

        if (bank.get(username) == null) {
            return "The credentials do not exist!";
        }

        bank.remove(username);

        try (FileWriter file = new FileWriter("bank.json")) {
            file.write(gson.toJson(bank));
            return "The credentials have been deleted!";
        } catch (IOException ioe) {
            throw new Exception("Failed to write to json file");
        }
    }

    /**
     * Retrieves the password of the given username.
     *
     * @param username the username that corresponds to the desired password.
     * @return the password of the given username.
     */
    String getPair(String username) {

        if (bank.get(username) != null) {
            return "Password: " + bank.get(username);
        } else {
            return "There are no credentials associated with that username!";
        }
    }

    /**
     * Empties out the password bank.
     *
     * @return a string that will be displayed to the user that notifies them of the outcome.
     * @throws Exception stops the program if the json file could not be written to.
     */
    String clearBank() throws Exception {

        bank.clear();

        try (FileWriter file = new FileWriter("bank.json")) {
            file.write(gson.toJson(bank));
            return "All credentials have been deleted!";
        } catch (IOException ioe) {
            throw new Exception("Failed to write to json file");
        }
    }
}

