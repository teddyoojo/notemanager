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

    //hopefully works, saves current date to the note, can be extended to time aswell
    public Note addNote(Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();
        note.setDate(dtf.format(now));

        return noteRepo.save(note);
    }

    public List<Note> findAllNotes () {
        return noteRepo.findAll();
    }

    public Note updateNote(Note note) {
        return noteRepo.save(note);
    }

    //hopefully works, search has to be exact
    public Note findNoteByDate(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd");
        String searchDate = dtf.format(date);
        return noteRepo.findNoteByDate(searchDate).orElseThrow(() -> new UserNotFoundException("Note by date " + searchDate + " was not found")); //creating and throwing Exception

    }

    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }
}
