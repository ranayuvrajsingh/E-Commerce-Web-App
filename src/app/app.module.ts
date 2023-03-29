import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//execution
import {MatButtonModule} from '@angular/material/button';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { authInterceptorProviders } from './services/auth.Interceptor';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import {MatListModule} from '@angular/material/list';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { ViewproductsComponent } from './pages/viewproducts/viewproducts.component';
import { ProductinfoComponent } from './pages/productinfo/productinfo.component';
import { AddnewproductComponent } from './pages/admin/addnewproduct/addnewproduct.component';
import { DeleteproductComponent } from './pages/admin/deleteproduct/deleteproduct.component';
import { CartComponent } from './pages/cart/cart.component';
import { UsersidebarComponent } from './pages/user/usersidebar/usersidebar.component';
import { UserprofileComponent } from './pages/user/userprofile/userprofile.component';


// import {MatTableModule} from '@angular/material/table';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    UserdashboardComponent,
    DashboardComponent,
    ProfileComponent,
   
    SidebarComponent,
     WelcomeComponent,
     
     ViewproductsComponent,
     ProductinfoComponent,
     AddnewproductComponent,
     DeleteproductComponent,
     CartComponent,
     UsersidebarComponent,
     UserprofileComponent,
  
    
   
  
  

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
  
    
  
  
    
    

   
    
    
  
   
   
    
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
