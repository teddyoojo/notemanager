package brendel.philipp.notemanager.service;

import brendel.philipp.notemanager.exceptions.UserNotFoundException;
import brendel.philipp.notemanager.model.Note;
import brendel.philipp.notemanager.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    //search has to be exact date
    public Note findNoteByDate(LocalDateTime date) {
        return noteRepo.findNoteByDate(date).orElseThrow(() -> new UserNotFoundException("Note by date " + date + " was not found")); //creating and throwing Exception
    }


    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }
}
