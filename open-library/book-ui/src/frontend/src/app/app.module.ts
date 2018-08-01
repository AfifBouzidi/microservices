import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {BookCreateComponent} from './book-create/book-create.component';
import {BookRatingComponent} from './book-rating/book-rating.component';
import {BookDisplayComponent} from './book-display/book-display.component';
import {Routes} from '@angular/router';
import {BookEditComponent} from './book-edit/book-edit.component';
import {BookserviceService} from './bookservice.service';
import { FormsModule } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

export const appRoutes: Routes = [
  {
    path: 'manage',
    component: BookCreateComponent
  },
  {
    path: 'rating',
    component: BookRatingComponent
  },
  {
    path: 'display',
    component: BookDisplayComponent
  },
  {
    path: 'edit/:id',
    component: BookEditComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    BookCreateComponent,
    BookRatingComponent,
    BookDisplayComponent,
    BookEditComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), HttpClientModule, ReactiveFormsModule, FormsModule, NgbModule.forRoot()
  ],
  providers: [BookserviceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
