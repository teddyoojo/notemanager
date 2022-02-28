package brendel.philipp.notemanager.repo;

import brendel.philipp.notemanager.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Long> {
}
