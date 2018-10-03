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
 * This file is the script that interacts with the actual password bank which is a json file.
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

    HashMap<String, String> bank;
    private Gson gson = new GsonBuilder().create();

    PasswordBank() throws Exception {

        try {
            Type type = new TypeToken<HashMap<String, String>>(){}.getType();
            bank = gson.fromJson(new FileReader("bank.json"), type);
        } catch (FileNotFoundException e) {
            throw new Exception("Failed to open to json file");
        }
    }

    void addPair(String username, String password) throws Exception {

        bank.put(username, password);

        try (FileWriter file = new FileWriter("bank.json")) {
            file.write(gson.toJson(bank));
        } catch (IOException ioe) {
            throw new Exception("Failed to write to json file");
        }

    }
}

