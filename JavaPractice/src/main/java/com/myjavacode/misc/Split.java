package com.myjavacode.misc;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.util.FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class Split {

    public static void main(String[] args) throws IOException, CsvValidationException {
        System.out.println(1 << 4);
    }

    public static void splitFileIntoSmallerFiles(String sourceFilePath, String destinationFilePath, String extension, long maxLinesInAFile) throws RuntimeException {
        long createdFileCount = 1;

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(sourceFilePath));
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(destinationFilePath + createdFileCount + extension));

            String line;
            int lineCount = 1;
            String columnsLine = bufferedReader.readLine();
            bufferedWriter.write(columnsLine);
            bufferedWriter.newLine();

            while ((line = bufferedReader.readLine()) != null) {
                if(lineCount % maxLinesInAFile == 0) {
                    bufferedWriter.close();

                    bufferedWriter = Files.newBufferedWriter(Paths.get(destinationFilePath + createdFileCount++ + extension));
                    bufferedWriter.write(columnsLine);
                    bufferedWriter.newLine();
                    lineCount++;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                lineCount++;
            }

            bufferedWriter.close();
        } catch (IOException ioException) {
            throw new RuntimeException("Error while splitting the file", ioException);
        }
    }

    public static void csvToListOfMap(int ind) throws CsvValidationException, IOException {
        final char delimiter = '|';
        List<Map<String, Object>> dataMapList;
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader("/home/um-143-user/Pictures/1.csv"))
                .withCSVParser(new CSVParserBuilder().withSeparator(delimiter).build())
                .build()) {
            List<String> columnNames = Arrays.stream(csvReader.readNext()).collect(Collectors.toList());
            dataMapList = new ArrayList<>();

            Object[] nextRow;
            while ((nextRow = csvReader.readNext()) != null) {
                Map<String, Object> dataMap = new HashMap<>();

                for (int index = 0; index < nextRow.length; index++) {
                    String columnName = columnNames.get(index);
                    Object columnValue = nextRow[index];
                    if (new HashSet<>(Collections.singletonList("sdf")).contains(columnName)) {
                        dataMap.put(columnName, parseDateTypeData((String)columnValue));
                    } else {
                        dataMap.put(columnName, "".equals(columnValue) ? null : columnValue);
                    }
                }
                dataMap.put("UPDATED_AT", System.currentTimeMillis());
                dataMapList.add(dataMap);
            }
        }
    }

    public static String parseDateTypeData(String textData) {
       SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = simpleDateFormat.parse(textData);
            simpleDateFormat.applyPattern("yyyy-MM-dd");
            return simpleDateFormat.format(date);
        } catch (ParseException parseException) {
            return null;
        }
    }

    public static boolean checkBoolean(String textData) {
        return "true".equalsIgnoreCase(textData) || "false".equalsIgnoreCase(textData);
    }

    public static void extractGzipFile(Path sourceFilePath, Path destinationFilePath) {
        try (GZIPInputStream gzipInputStream = new GZIPInputStream(Files.newInputStream(sourceFilePath))) {
            Files.copy(gzipInputStream, destinationFilePath);
        } catch (IOException exception) {
            throw new RuntimeException("Error while extracting gzip file ", exception);
        }
    }

    public static void extractZIPFile(Path sourceFilePath, Path destinationFilePath) {
        try (ZipFile zipFile = new ZipFile(sourceFilePath.toFile())){
            zipFile.extractAll(destinationFilePath.toString());
        } catch (IOException exception) {
            throw new RuntimeException("Exception while extracting zip file " + exception);
        }
    }

    public static void createDirectory() {
        Path path = Paths.get("/home/um-143-user/Pictures/test1");
        try {
            Files.createDirectory(path);
        } catch (IOException exception) {
            throw new RuntimeException("Error while creating a directory " + exception);
        }
    }

    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/um-143-user/Downloads/scrub_data/txt_file.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        System.out.println(Arrays.asList(stringBuilder.toString().split("\\|")));
    }

    public static void mapList() {
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> mp = new HashMap<>();
        mp.put("raj", "kr");

        list.add(mp);

        mp.clear();

        mp.put("k", "l");
        list.add(mp);
        mp.clear();

        System.out.println(list);
    }

    public static void checkFinally() {
        try{
            int x = 6;
//            throw new RuntimeException("dsf");
        } catch (IllegalArgumentException exception) {
//            throw new RuntimeException("sdfsf");
        } finally {
            System.out.println("value " + 7);
        }

        Character ch = '7';

    }

}
