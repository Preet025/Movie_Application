import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { AuthGuard } from './guard/auth.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MovieInfoComponent } from './movie-info/movie-info.component';
import { MoviesearchComponent } from './moviesearch/moviesearch.component';
import { PopularComponent } from './popular/popular.component';
import { RegisterComponent } from './register/register.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { TvshowsComponent } from './tvshows/tvshows.component';
import { UpcomingComponent } from './upcoming/upcoming.component';

const routes: Routes = [
  {
    path: "auth",
    component: SidebarComponent,
    children: [
      {
        path: "login",
        component: LoginComponent
      },
      {
        path: "register",
        component: RegisterComponent
      }
    ]
  },
  {
    path: "dashboard",
    component: DashboardComponent,
    children: [
      {
        path: "home",
        component: HomeComponent
      },
      {
      path: "moviesearch",
      component: MoviesearchComponent
    },
    {
      path: "popular",
      component: PopularComponent
    },
    {
      path: "tvshows",
      component: TvshowsComponent
    },
    {
      path: "upcoming",
      component: UpcomingComponent
    },
      {
        path: "movie-info",
        canActivate: [AuthGuard],
        component: MovieInfoComponent
      },
      {
        path: "favourite",
        canActivate: [AuthGuard],
        component: FavouriteComponent
      }
    ]
  },
  {
    path: "",
    redirectTo: "dashboard/home",
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
