
package practice;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

class FileContainer implements Comparable<FileContainer> {
    int[] arr;
    int index;

    public FileContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(FileContainer o) {
        return this.arr[this.index] - o.arr[o.index];
    }
}

public class SortedFileMerge {
    public static void main(String[] args) throws IOException {

        File folder = new File("/Users/sudhanshu.singh/Documents/fileMerge/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getName() + ", path =" + listOfFiles[i].getAbsolutePath());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

        Map<Integer, String[]> rowMap = new TreeMap<>();
        String[] header = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            try (Reader reader = Files.newBufferedReader(Paths.get(listOfFiles[i].getAbsolutePath()));
                 CSVReader csvReader = new CSVReader(reader);) {
                header = csvReader.readNext();
                // Reading Records One by One in a String array
                String[] nextRecord;

                while ((nextRecord = csvReader.readNext()) != null) {
                    rowMap.put(Integer.parseInt(nextRecord[0]), nextRecord);
                    System.out.println("row number: " + nextRecord[0]);
                    System.out.println("rest_data : " + nextRecord[1]);
                    System.out.println("==========================");
                }
            }
        }

        try (Writer writer = Files.newBufferedWriter(Paths.get(folder.getAbsolutePath() + "/merged.csv"));
             CSVWriter csvWriter = new CSVWriter(writer);) {
            csvWriter.writeNext(header);
            // Reading Records One by One from map and put them into file
            String[] nextRecord;
            for (Map.Entry<Integer, String[]> entry : rowMap.entrySet()) {
                csvWriter.writeNext(entry.getValue());
                System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
            }
        }
    }
}
