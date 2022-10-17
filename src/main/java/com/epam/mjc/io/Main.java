package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = fileReader.getFileFromResources("Profile.txt");
        Profile profile = fileReader.getDataFromFile(file);
        System.out.println(profile);
    }

}
