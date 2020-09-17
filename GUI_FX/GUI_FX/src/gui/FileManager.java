package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    private List<String> decodedFileContents;
    private File file;
    public FileManager(File file) {
        this.file = file;
    }

    private static final String HEADER = "encrypted_secretheader";

    public boolean decodeFile(String password) throws Exception {
        Scanner scan = new Scanner(file);

        List<String> encodedFileContents = new ArrayList<>();
        while (scan.hasNextLine()) {
            encodedFileContents.add(scan.nextLine());
        }

        if(encodedFileContents.size() < 1) {
            throw new Exception("no header found");
        }

        String header = encodedFileContents.remove(0);
        String decodedHeader = decodeLine(header, password);
        if(!decodedHeader.equals(HEADER)) //invalid password
            return false;

        decodedFileContents = new ArrayList<>();
        for (String line : encodedFileContents) {
            decodedFileContents.add(decodeLine(line, password));
        }
        return true;
    }

    public static void saveAndEncode(File file, List<String> content, String password) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        pw.println(encodeLine(HEADER, password));
        for(String line : content)
            pw.println(encodeLine(line, password));
        pw.flush();
        pw.close();
    }

    public List<String> getDecodedFileContents() {
        return decodedFileContents;
    }

    public static String encodeLine(String line, String password) {
        return codeLine(line, false, password);
    }

    public static String decodeLine(String line, String password) {
        return codeLine(line, true, password);
    }

    private static String codeLine(String line, boolean decode, String password) {

        int shift = getShiftNumber(password);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < line.length(); i++)
        {
            char c;
            if(decode)
                c = (char) (line.charAt(i) + shift);
            else //encode
                c = (char)(line.charAt(i) - shift);

            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static int getShiftNumber(String password)
    {
        int charSum = 0;
        for (int i = 0; i < password.length(); i++) {
            charSum += password.charAt(i);
        }
        return charSum;
    }
}
