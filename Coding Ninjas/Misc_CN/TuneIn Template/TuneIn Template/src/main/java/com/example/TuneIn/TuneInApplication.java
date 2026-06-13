package com.example.TuneIn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TuneInApplication {

    public static void main(String[] args) {
    	
    	
        // Context initialized
        Scanner scanner = new Scanner(System.in);
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TuneIn");
        System.out.println("Welcome to Music Playlist Application");

        
        User user = context.getBean("myUser", MyUser.class);
        // Enter User details
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        user.setUserDetail(name, age);
        while (true) {
            System.out.println();
            System.out.println("Do you want to add Songs to the playlist \n1. Yes \n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                break;
            } else {
                System.out.println("Enter name of the song");
                String songName = scanner.nextLine();
                Song song = context.getBean("mySong", MySong.class);
                song.setName(songName);
                user.getPlaylist().addSong(song);
            }
        }

        System.out.println("Your Playlist with reference Id: " + user.getPlaylist().hashCode() + " is Ready!!");
        for (Song song : user.getPlaylist().getPlaylistSongs()) {
            System.out.println("Song name: " + song.getSongName() + "\t Reference Id: " + song.hashCode());
        }

    }

}
