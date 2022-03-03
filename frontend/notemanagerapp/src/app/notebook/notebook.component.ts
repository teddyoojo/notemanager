import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NoteService } from './note.service';
import {
  faPenToSquare,
  faUpRightAndDownLeftFromCenter,
} from '@fortawesome/free-solid-svg-icons';
import { faTrashCan } from '@fortawesome/free-solid-svg-icons';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
})
export class NotebookComponent implements OnInit {
  public notes: Note[] = [];
  public noteForm: FormGroup = new FormGroup({
    noteHeader: new FormControl(''),
    noteContent: new FormControl(''),
  });
  faPenToSquare = faPenToSquare;
  faTrashCan = faTrashCan;

  constructor(private noteService: NoteService) {}

  ngOnInit() {
    this.getNotes();
  }

  public getNotes(): void {
    this.noteService.getNotes().subscribe({
      next: (response: Note[]) => {
        this.notes = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }
  public toggleModal(): void {
    const element = document.getElementById('addNoteModal');
    element?.classList.toggle('is-active');
  }
  public onAddNote(noteData: { noteHeader: any; noteContent: any }) {
    const note: Note = new Note();
    note.noteHeader = noteData.noteHeader;
    note.noteContent = noteData.noteContent;
    this.noteService.addNote(note).subscribe({
      next: (response: Note) => {
        this.getNotes();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
      complete: () => {
        this.toggleModal();
        this.noteForm.reset();
      },
    });
  }
}
