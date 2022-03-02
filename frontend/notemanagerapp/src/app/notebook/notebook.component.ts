import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NoteService } from './note.service';

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
})
export class NotebookComponent implements OnInit {

  public notes: Note[] = [];

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
      }
      }
    );
  }

}
