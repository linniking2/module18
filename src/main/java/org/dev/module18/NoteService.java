package org.dev.module18;
import org.dev.module18.Note;
import org.dev.module18.NoteRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Note update(Long id, Note note) {
        Note existingNote = findById(id);
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        return noteRepository.save(existingNote);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
