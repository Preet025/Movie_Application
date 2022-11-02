import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HoverDirective } from './hover.directive';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MovieInfoComponent } from './movie-info/movie-info.component';
import { YouTubePlayerModule } from '@angular/youtube-player';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatTooltipModule} from '@angular/material/tooltip';
import { FavouriteComponent } from './favourite/favourite.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatSelectModule} from '@angular/material/select';
import { MoviesearchComponent } from './moviesearch/moviesearch.component';
import {MatChipsModule} from '@angular/material/chips';
import { PopularComponent } from './popular/popular.component';
import { TvshowsComponent } from './tvshows/tvshows.component';
import { UpcomingComponent } from './upcoming/upcoming.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    DashboardComponent,
    MovieInfoComponent,
    FavouriteComponent,
    MoviesearchComponent,
    PopularComponent,
    MoviesearchComponent,
    HoverDirective,
    PopularComponent,
    TvshowsComponent,
    UpcomingComponent
  ],
  imports: [
    BrowserModule,
    MatChipsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatGridListModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    HttpClientJsonpModule,
    YouTubePlayerModule,
    MatFormFieldModule,
    MatButtonModule,
    MatTooltipModule,
    FlexLayoutModule,
    MatSelectModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
