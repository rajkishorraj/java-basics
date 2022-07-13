package com.myjavacode.designpattern.behaviourial;

import java.util.ArrayList;
import java.util.List;

public class CommandPattern {

    //client class
    public static void main(String[] args) {
        FileOperationExecutor fileOperationExecutor =
                new FileOperationExecutor();
        fileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("some.txt")));

        TextFile textFile = new TextFile("some text");

        fileOperationExecutor.executeOperation(textFile::open);
    }
}

//invoker class which invoked command api
class FileOperationExecutor {
    //here we have textFileOperations as referenced variable
    //although final variable can not be re assigned but if final variable is referncing an object
    //the object states can be changed
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public void executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        textFileOperation.execute();
    }
}

//command api
@FunctionalInterface
interface TextFileOperation {
    void execute();
}

class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.open();
    }
}

class SaveTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void execute() {
        textFile.save();
    }
}


//receiver object
class TextFile {
    private String name;

    TextFile(String name) {
        this.name = name;
    }

    public void open() {};

    public void save() {};
}


