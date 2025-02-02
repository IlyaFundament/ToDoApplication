package com.example.todo;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Random;


public class Database {

    private final ArrayList<Note> notes = new ArrayList<>();

    private static Database instance = null;

    @NonNull
    @Contract(" -> new")
    public static Database getInstanse() {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Note note = new Note(i, "Note" + i, random.nextInt(3));
            notes.add(note);
        }
    }

    public void add(Note note) {
        notes.add(note);
    }

    public void remove(int id) {
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId() == id) {
                notes.remove(note);
            }
        }
    }

    public ArrayList<Note> getNotes() {
        return new ArrayList<>(notes);
    }
}
