package cz.ictpro.io.lesson;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = new BufferedReader(new FileReader("user.txt"));
            out = new BufferedWriter(new FileWriter("user_output.txt"));

            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

