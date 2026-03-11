package com.harleen.secure_notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harleen.secure_notes.entity.Note;
import com.harleen.secure_notes.service.NoteService;

@RestController
public class NoteController {

    @Autowired
    private NoteService userService;

    @GetMapping("/notes/user/{userId}")
    public List<Note> getAllNotesForUser(@PathVariable Long userId) {
        return userService.getAllNotesForUser(userId);
    }

    @PostMapping("/notes/user/{userId}")
    public Note createNoteForUser(@PathVariable Long userId, @RequestBody Note note) {
        return userService.createNoteForUser(userId, note);
    }

    @PutMapping("/notes/user/{userId}/note/{noteId}")
    public Note updateNoteForUser(@PathVariable Long userId, @PathVariable Long noteId, @RequestBody Note note) {
        return userService.updateNoteForUser(userId, noteId, note);
    }

    @GetMapping("/notes/all")
    public List<Note> getAllNotes() {
        return userService.getAllNotes();
    }

    @DeleteMapping("/notes/user/{userId}/note/{noteId}")
    public String deleteNoteForUser(@PathVariable Long userId, @PathVariable Long noteId) {
        userService.deleteNoteForUser(userId, noteId);
        return "Note deleted successfully";
    }

}
