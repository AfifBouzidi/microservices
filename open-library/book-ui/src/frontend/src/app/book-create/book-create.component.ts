import { Book } from '../Book';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { BookserviceService } from '../bookservice.service';

@Component({
  selector: 'app-book-create',
  templateUrl: './book-create.html',
  styleUrls: ['./book-create.css']
})
export class BookCreateComponent implements OnInit {

  angForm: FormGroup;

  constructor(private fb: FormBuilder , private router: Router, private bookserviceService: BookserviceService) {
    this.createForm();
  }

  createForm() {
    this.angForm = this.fb.group({
      title: ['', Validators.required],
      authorFirstName: ['', Validators.required],
      authorLastName: ['', Validators.required],
      isdn: ['', Validators.required]
    });
  }

  addBook(title, authorFirstName, authorLastName, isdn) {
    this.bookserviceService.addBook(title, authorFirstName, authorLastName, isdn);
    this.router.navigate(['display']);
  }

  ngOnInit() {
  }

}
