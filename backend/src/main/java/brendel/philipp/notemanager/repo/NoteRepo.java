package brendel.philipp.notemanager.repo;

import brendel.philipp.notemanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {

    Optional<Note> findNoteById(Long id);
}
