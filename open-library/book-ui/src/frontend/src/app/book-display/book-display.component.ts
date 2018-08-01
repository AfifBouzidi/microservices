import {Book} from '../book';
import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {BookserviceService} from '../bookservice.service';

@Component({
  selector: 'app-book-display',
  templateUrl: './book-display.component.html',
  styleUrls: ['./book-display.component.css']
})
export class BookDisplayComponent implements OnInit {

  books: any;
  constructor(private http: HttpClient, private bookserviceService: BookserviceService) {}

  getBooks() {
    this.bookserviceService.getBooks().subscribe(res => {
      this.books = res;
    });
  }

  ngOnInit() {
    this.getBooks();
  }

  deleteBook(id) {
    this.bookserviceService.deleteBook(id).subscribe(res => {
       this.getBooks();
    });
  }

}
