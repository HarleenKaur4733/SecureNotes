package com.harleen.secure_notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harleen.secure_notes.entity.Note;
import com.harleen.secure_notes.entity.User;
import com.harleen.secure_notes.repository.NoteRepository;
import com.harleen.secure_notes.repository.UserRepository;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Note> getAllNotesForUser(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    @Override
    public Note createNoteForUser(Long userId, Note note) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        note.setUser(user);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(Long userId, Long noteId, Note note) {
        // Implementation for updating a note for a specific user
        Note existingNote = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        if (!existingNote.getUser().getId().equals(userId)) {
            throw new RuntimeException("Note does not belong to the user");
        }
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNoteForUser(Long userId, Long noteId) {
        // Implementation for deleting a note for a specific user
        Note existingNote = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        if (!existingNote.getUser().getId().equals(userId)) {
            throw new RuntimeException("Note does not belong to the user");
        }
        noteRepository.delete(existingNote);
    }

    @Override
    public List<Note> getAllNotes() {
        // Implementation for getting all notes
        return noteRepository.findAll();
    }

}
