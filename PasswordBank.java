import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


class PasswordBank {

    HashMap<String, String> bank;

    PasswordBank() {
        bank = new HashMap<>();

        bank.put("Hello", "World");


        Gson gson = new GsonBuilder().create();

        try (FileWriter file = new FileWriter("bank.json")) {
            file.write(gson.toJson(bank));
            System.out.println("Success.");
        } catch (IOException ioe) {
            System.out.println("Failed to write to JSON.");
        }

    }
}

