package io.codelex.firstsample;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ExerciseController {

    private final ArrayList<String> savedText = new ArrayList<>();
    private final ArrayList<Person> savedPeople = new ArrayList<>();


    @GetMapping("/getTime")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = LocalTime.now();
        return currentTime.format(formatter);
    }

    @PostMapping("/saveText")
    public void saveText(@RequestParam String string) {
        savedText.add(string);
    }


    @GetMapping("/getSavedTexts")
    public String getSavedTexts() {
        String string = String.join(", ", savedText);
        return string;
    }

    @PostMapping("/savePerson")
    public void savePerson(@RequestBody Person person) {
        savedPeople.add(person);
    }
    @GetMapping("/getPersons")
    public List<Person> getPersons() {
        return savedPeople;
    }

}
