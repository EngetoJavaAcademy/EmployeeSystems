package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static String NAME_OF_FILE = "emp.csv";

    public static void main(String[] args) throws IOException {

        Map<String, String> personData = new HashMap<>();
        personData.put("Jan Novak","director");
        personData.put("Marek Vondra", "lector");
        String[] headers = { "name", "position"};

        FileWriter sw = new FileWriter(NAME_OF_FILE);

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers).build();

        try (final CSVPrinter printer = new CSVPrinter(sw, csvFormat)) {
            personData.forEach((author, title) -> {
                try {
                    System.out.println(author + " " + title);
                    printer.printRecord(author, title);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }



    }
}