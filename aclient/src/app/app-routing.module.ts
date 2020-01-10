import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {RegularComponent} from './components/regular/regular.component';
import {UlistComponent} from './components/ulist/ulist.component';
import {AdminComponent} from './components/admin/admin.component';
import {AddContentComponent} from './components/add-content/add-content.component';
import {DetailComponent} from './components/detail/detail.component';
import {CastComponent} from './components/cast/cast.component';

const appRoutes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'regular', component: RegularComponent},
  {path: 'top', component: RegularComponent},
  {path: 'watchlist', component: RegularComponent},
  {path: 'ulist', component: UlistComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'addcontent', component: AddContentComponent},
  {path: 'regular/detail/:id', component: DetailComponent},
  {path: 'watchlist/detail/:id', component: DetailComponent},
  {path: 'top/detail/:id', component: DetailComponent},
  {path: 'cast/:id', component: CastComponent},

];
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
