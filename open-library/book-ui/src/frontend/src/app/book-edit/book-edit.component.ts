import {Book} from '../Book';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {BookserviceService} from '../bookservice.service';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {

  book: any;
  angForm: FormGroup;

  constructor(private route: ActivatedRoute, private fb: FormBuilder, private router: Router, private bookserviceService: BookserviceService) {
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

  editBook(title, authorFirstName, authorLastName, isdn) {
    this.route.params.subscribe(params => {
      this.bookserviceService.updateBook(title, authorFirstName, authorLastName, isdn, params['id']);
    });
    this.router.navigate(['display']);
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.book = this.bookserviceService.getBookById(params['id']).subscribe(res => {
        this.book = res;
      });
    });
  }

}
