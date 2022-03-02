import { Component, OnInit } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title(title: any) {
      throw new Error('Method not implemented.');
  }
  faCoffee = faCoffee;
  constructor() {}
  ngOnInit() {}
}
