package brendel.philipp.notemanager.service;

import brendel.philipp.notemanager.exceptions.NoteNotFoundException;
import brendel.philipp.notemanager.model.Note;
import brendel.philipp.notemanager.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    //saves current date to the note, can be extended to time aswell
    public Note addNote(Note note) {
        note.setDate(LocalDateTime.now());
        return noteRepo.save(note);
    }

    public List<Note> findAllNotes () {
        return noteRepo.findAll();
    }

    public Note updateNote(Note note) {
        return noteRepo.save(note);
    }

    public Note findNoteById(Long id) {
        return noteRepo.findNoteById(id).orElseThrow(() -> new NoteNotFoundException("Note by ID " + id + " was not found")); //creating and throwing Exception
    }


    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }
}
