import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {


    public static void main(String... args) {
        String[] record = null;
        HashMap<String, String> myRecord = new HashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/record.csv"))) {
            List<String[]> r = reader.readAll();

            String[] headers = Arrays.toString(r.get(0)).split(",");

            List<String[]> records = r.stream().skip(1).collect(Collectors.toList());


            for (String[] values : records) {
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i].replace("[", "").replace("]", "");
                    myRecord.put(header, values[i]);
//                    System.out.println(myRecord.keySet());
                }
                System.out.println(myRecord.keySet()+","+myRecord.values());
                for (Map.Entry<String, String> record1: myRecord.entrySet()) {
                    System.out.println("key: " + record1.getKey() + " value: " + record1.getValue());

                }
            }


//            System.out.println(collect);
//            r.forEach(x -> test(Arrays.toString(x)));

//            HashMap<String, String> expected = Files.readAllLines(
//                    Paths.get("src/test/resources/record.csv"))
//                    .stream()
//                    .map(line -> line.split(","))
//                    .filter(line -> line.length > 1)
//                    .collect(Collectors.toMap(key -> key[0], value -> value[1], (val1, val2) -> val1, HashMap::new));
//
//            System.out.println(expected);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (CsvException csvException) {
            csvException.printStackTrace();
        }

    }

    private static String[] test(List<String[]> records) {
        String[] record = null;
        for (String[] values : records) {

            for (String value : values) {

                record = value.split(",");

                for (int i = 0; i < record.length; i++) {
//                    myRecord.put(header[i], record[i]);
                }

            }
        }
        return record;
    }


}


