package com.learn.iosystem.processcontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hechao on 2017/4/23.
 */
public class OSExecute {
    public static void operation() {
        command("javap /Users/hechao/Documents/Learn/IOSystem/target/classes/com/learn/iosystem/processcontroller/OSExecute.class");
    }

    public static void command(String command) {
        boolean err = false;

        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }



        } catch (IOException e) {
            if (!command.startsWith("CMD /C")) {
                command("CMD /C " + command);
            } else {
                throw new RuntimeException(e);
            }
            if (err) {
                throw new RuntimeException("Error executing " + command);
            }
        }
    }
}
