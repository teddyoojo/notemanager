package brendel.philipp.notemanager.service;

import brendel.philipp.notemanager.model.Note;
import brendel.philipp.notemanager.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public Note addNote(Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        dtf.format(now);
        note.setDate(now);
        return noteRepo.save(note);
    }
}
