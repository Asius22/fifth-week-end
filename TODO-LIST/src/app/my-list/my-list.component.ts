import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.scss']
})
export class MyListComponent {

  todos: string[] = [];
  input: string = "";

  constructor() {
  }

  btnClicked() {
    if (this.input != "") {

      this.todos.push(this.input)
      this.input = ""
    }
  }

  deleteElement(str: string) {
    this.todos.forEach(
      (element, index) => {
        if (element == str) this.todos.splice(index, 1)
      }
    )
  }
}
