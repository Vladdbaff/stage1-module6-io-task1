package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream in = new FileInputStream(file)) {
            for (int i; (i = in.read()) != -1;) {
                sb.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getProfileFromFileStringData(sb.toString());
    }



    public File getFileFromResources(String fileName) {
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }

    public Profile getProfileFromFileStringData(String data) {
        String[] fields = data.split("\n");
        Profile profile = new Profile();
        for (String field: fields) {
            if (field.startsWith("Name: ")) {
                profile.setName(field.replace("Name: ", ""));
            } else if (field.startsWith("Age: ")) {
                profile.setAge(Integer.parseInt(field.replace("Age: ", "")));
            } else if (field.startsWith("Email: ")) {
                profile.setEmail(field.replace("Email: ", ""));
            } else if (field.startsWith("Phone: ")) {
                profile.setPhone(Long.parseLong(field.replace("Phone: ", "")));
            }
        }
        return profile;
    }
}
