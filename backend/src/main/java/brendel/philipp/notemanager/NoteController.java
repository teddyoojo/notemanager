package brendel.philipp.notemanager;

import brendel.philipp.notemanager.model.Note;
import brendel.philipp.notemanager.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteService.findAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
    @GetMapping("/find/{searchDate}")
    public ResponseEntity<Note> getNoteByDate (@PathVariable("searchDate")LocalDateTime searchDate) {
        Note note = noteService.findNoteByDate(searchDate);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        Note newNote = noteService.addNote(note);
        return new ResponseEntity<>(newNote, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        Note updatedNote = noteService.updateNote(note);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
