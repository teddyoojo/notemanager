package brendel.philipp.notemanager.service;

import brendel.philipp.notemanager.exceptions.UserNotFoundException;
import brendel.philipp.notemanager.model.Note;
import brendel.philipp.notemanager.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Note addNote(Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        dtf.format(now);
        note.setDate(now);
        return noteRepo.save(note);
    }

    public List<Note> findAllNotes () {
        return noteRepo.findAll();
    }

    public Note updateNote(Note note) {
        return noteRepo.save(note);
    }

    public Note findNoteByDate(LocalDateTime searchDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        dtf.format(searchDate);
        return noteRepo.findNoteByDate(searchDate).orElseThrow(() -> new UserNotFoundException("Note by date " + searchDate + " was not found")); //creating and throwing Exception

    }

    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }
}
