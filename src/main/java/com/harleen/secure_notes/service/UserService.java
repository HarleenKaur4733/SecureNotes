package com.harleen.secure_notes.service;

import java.util.List;

import com.harleen.secure_notes.entity.Note;

public interface UserService {

    List<Note> getAllNotesForUser(Long userId);

    Note createNoteForUser(Long userId, Note note);

    Note updateNoteForUser(Long userId, Long noteId, Note note);

    void deleteNoteForUser(Long userId, Long noteId);

    List<Note> getAllNotes();
}
