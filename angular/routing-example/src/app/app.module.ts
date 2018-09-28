import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { PagesComponent } from './pages/pages.component';
import { RouterModule,Routes } from '@angular/router';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'pages', component: PagesComponent },
  {path: 'about', component: AboutComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: '**', component: PagenotfoundComponent}
  
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    PagesComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
