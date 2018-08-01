import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class BookserviceService {

  result: any;

  constructor(private http: HttpClient) {}

    rateBook(ratingValue, bookId) {
    const uri = 'http://localhost:8080/openlibrary/ratings';
    const obj = {
      bookId: bookId,
      mark: ratingValue
    };
    this
      .http
      .post(uri, obj)
      .subscribe(res =>
        console.log('Done'));
  }

  addBook(title, authorFirstName, authorLastName, isdn) {
    const uri = 'http://localhost:8080/openlibrary/books';
    const obj = {
      title: title,
      authorFirstName: authorFirstName,
      authorLastName: authorLastName,
      isdn: isdn
    };
    this
      .http
      .post(uri, obj)
      .subscribe(res =>
        console.log('Done'));
  }

  getBooks() {
    const uri = 'http://localhost:8080/openlibrary/books';
    return this
      .http
      .get(uri)
      .map(res => {
        return res;
      });
  }


  getBookById(id) {
    const uri = 'http://localhost:8080/openlibrary/books/' + id;
    return this
      .http
      .get(uri)
      .map(res => {
        return res;
      });
  }

  updateBook(title, authorFirstName, authorLastName, isdn, id) {
    const uri = 'http://localhost:8080/openlibrary/books/' + id;
    console.info("###########updateBook###########");
    const obj = {
      title: title,
      authorFirstName: authorFirstName,
      authorLastName: authorLastName,
      isdn: isdn
    };
    this
      .http
      .put(uri, obj)
      .subscribe(res => console.log('Done'));
  }

  deleteBook(id) {
    const uri = 'http://localhost:8080/openlibrary/books/' + id;
    return this
      .http
      .delete(uri)
      .map(res => {
        return res;
      });
  }

}
