package brendel.philipp.notemanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private LocalDateTime date;
    @Lob
    private String noteHeader;
    @Lob
    private String noteContent;

    public Note() {}
    public Note(String noteHeader, String noteContent) {
        this.noteHeader = noteHeader;
        this.noteContent = noteContent;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getNoteHeader() {
        return noteHeader;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setNoteHeader(String noteHeader) {
        this.noteHeader = noteHeader;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}