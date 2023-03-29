  import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddnewproductComponent } from './pages/admin/addnewproduct/addnewproduct.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { DeleteproductComponent } from './pages/admin/deleteproduct/deleteproduct.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';

import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProductinfoComponent } from './pages/productinfo/productinfo.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { UserprofileComponent } from './pages/user/userprofile/userprofile.component';
import { UsersidebarComponent } from './pages/user/usersidebar/usersidebar.component';
import { ViewproductsComponent } from './pages/viewproducts/viewproducts.component';
import { AdminGuard } from './services/admin.guard';
import { NormalGuard } from './services/normal.guard';

const routes: Routes = [

  
  {
    path:'',
    component: HomeComponent,
    pathMatch:'full',
  },
  {                                            
    path:'signup',
    component: SignupComponent,
    pathMatch:'full',
  },
  {
    path:'login',
    component: LoginComponent,
    pathMatch:'full',
  },
  {
    path:'admin',
    component: DashboardComponent,
    // pathMatch:'full',
    canActivate:[AdminGuard],
    children:[

      
      {  path:'',
         component: HomeComponent,
      // pathMatch:'full',
       }
      ,
      {
        path:'',
        component:WelcomeComponent,
        
      },
      {
        path:'profile',
        component:ProfileComponent,
        
      },
      {
        path:'addnewproduct',
        component:AddnewproductComponent,
        //pathMatch:'full',
        // canActivate:[NormalGuard],
      },
      {
        path:'productinfo',
        component:ProductinfoComponent,
        // pathMatch:'full',
        // canActivate:[NormalGuard],
      },
      {
        path:'viewproduct',
        component: ViewproductsComponent,
        // pathMatch:'full',
        // canActivate:[NormalGuard],
      },
      {
        path:'deleteproduct',
        component:DeleteproductComponent,
        //pathMatch:'full',
        // canActivate:[NormalGuard],
      },
     
  
    ],
 },
 

 //User

  {
    path:'userdash',
    component: UserdashboardComponent,
    // pathMatch:'full',
    canActivate:[NormalGuard],
    children:[

      {  path:'',
         component: HomeComponent,
      // pathMatch:'full',
       }
      ,
      {
        path:' ',
        component:WelcomeComponent,
        
      },
      {
        path:'userprofile',
        component:UserprofileComponent,
        
      },
     
      {
        path:'viewproduct',
        component: ViewproductsComponent,
        // pathMatch:'full',
        // canActivate:[NormalGuard],
      },
      {
        path:'productinfo',
        component:ProductinfoComponent,
        // pathMatch:'full',
        // canActivate:[NormalGuard],
      },
      
     
  
    ],
 },



  {
    path:'userprofile',
    component:  UserprofileComponent,
    // pathMatch:'full',
    canActivate:[NormalGuard],
  },
  {
    path:'viewproduct',
    component: ViewproductsComponent,
    // pathMatch:'full',
    // canActivate:[NormalGuard],
  },
  {
    path:'productinfo',
    component:ProductinfoComponent,
    // pathMatch:'full',
    // canActivate:[NormalGuard],
  },

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
