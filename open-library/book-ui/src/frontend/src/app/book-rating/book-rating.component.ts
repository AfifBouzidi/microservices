import {Book} from '../book';
import {Component, OnInit, OnChanges} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {FormsModule} from '@angular/forms';
import {BookserviceService} from '../bookservice.service';
import {Router} from '@angular/router';
import {NgbRating} from '@ng-bootstrap/ng-bootstrap';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-book-rating',
  templateUrl: './book-rating.component.html',
  styleUrls: ['./book-rating.component.css']
})
export class BookRatingComponent implements OnInit {

  selected = 0;
  books: any;

  constructor(private router: Router, private http: HttpClient, private bookserviceService: BookserviceService, config: NgbRatingConfig) {
    config.max = 5;
  }

  getBooks() {
    this.bookserviceService.getBooks().subscribe(res => {
      this.books = res;
    });
  }

  ngOnInit() {
    this.getBooks();
  }

  rate(book) {
      console.info(book.id);
      console.info(book.ratings);
      this.bookserviceService.rateBook(book.ratings, book.id);
  }

}
