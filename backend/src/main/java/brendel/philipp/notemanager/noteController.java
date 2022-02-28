package brendel.philipp.notemanager;

import brendel.philipp.notemanager.service.NoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class noteController {
    private final NoteService noteService;

    public noteController(NoteService noteService) {
        this.noteService = noteService;
    }
}
