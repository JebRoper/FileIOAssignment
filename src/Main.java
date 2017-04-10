import java.io.*;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {
        Path tmpDir = Paths.get("/Users/admin/tmp");
        Path cantSeeFile = Paths.get("/Users/admin/tmp/cantsee");
        String fileSeparator = System.getProperty("file.separator");
        Path file2 = Paths.get(tmpDir + fileSeparator + ".hipv");


        if (!Files.exists(file2)) {
            try {
                Files.createFile(file2);
            } catch (IOException e) {
                System.out.println("can't create file");
            }
        } else {
            System.out.println(file2 + " already exists");

        }

        if (!Files.exists(cantSeeFile)) {
            try {
                Files.createFile(cantSeeFile);
            } catch (IOException e) {
                System.out.println("can't create file");
            }
        } else {
            System.out.println(cantSeeFile + " already exists");
        }

        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(tmpDir + fileSeparator + "anotherone.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset, StandardOpenOption.APPEND)) {
            writer.write(LocalDateTime.now().toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.printf("ERROR " + e.getMessage());
        }
            int count = 0;
        BufferedReader br = Files.newBufferedReader(cantSeeFile);
        StringBuilder builder = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            System.out.println(line +  count++);
            line = br.readLine();


        }

        if (Files.exists(cantSeeFile)) {
            System.out.println("Good - file should exist");
        } else {
            System.out.println("False - file should exist");
        }
        if (Files.isReadable(cantSeeFile)) {
            System.out.println("Good - read the file");
        } else {
            System.out.println("Error - why cant we read the file");
        }
        if (Files.isWritable(cantSeeFile)) {
            System.out.println("Good - can write to the file");
        } else {
            System.out.println("Error - should be able to write to the file");
        }
        if (Files.isDirectory(cantSeeFile)) {
            System.out.println("FALSE - this is not a directory");
        } else {
            System.out.println("Good - this is not a directory");
        }
        if (Files.isRegularFile(cantSeeFile)) {
            System.out.println("Good - it is a file");
        } else {
            System.out.println("False - this is a file");
        }
        if (Files.isHidden(cantSeeFile)) {
            System.out.println("ERROR - It should not be hidden");
        } else {
            System.out.println("Good - it should not be hidden");
        }
        if (Files.isExecutable(cantSeeFile)) {
            System.out.println("False - file is not executable");
        } else {
            System.out.println("Good - file should not be executable");
        }
        if (Files.notExists(cantSeeFile)) {
            System.out.println("False - file should exists");
        } else {
            System.out.println("Good - the file does exist");
        }
        if (Files.isHidden(file2)) {
            System.out.println("Good - the file is hidden");
        } else {
            System.out.println("False - the file is hidden");
        }

    }
}











