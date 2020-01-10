import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserService} from './shared/user/user.service';
import { HttpClientModule} from '@angular/common/http';
import { UlistComponent } from './components/ulist/ulist.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { RegularComponent } from './components/regular/regular.component';
import { AdminComponent } from './components/admin/admin.component';
import { AddContentComponent } from './components/add-content/add-content.component';
import { DetailComponent } from './components/detail/detail.component';
import { CastComponent } from './components/cast/cast.component';


@NgModule({
  declarations: [
    AppComponent,
    UlistComponent,
    RegisterComponent,
    LoginComponent,
    RegularComponent,
    AdminComponent,
    AddContentComponent,
    DetailComponent,
    CastComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
