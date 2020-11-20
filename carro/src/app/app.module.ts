import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './views/template/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from './views/template/footer/footer.component';
import { NavComponent } from './views/template/nav/nav.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './component/home/home.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { CarroFormComponent } from './component/carro/carro-form/carro-form.component';
import { CarroListComponent } from './component/carro/carro-list/carro-list.component';
import { ModeloFormComponent } from './component/modelo/modelo-form/modelo-form.component';
import { ModeloListComponent } from './component/modelo/modelo-list/modelo-list.component';
import { FabricanteFormComponent } from './component/fabricante/fabricante-form/fabricante-form.component';
import { FabricanteListComponent } from './component/fabricante/fabricante-list/fabricante-list.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    CarroFormComponent,
    CarroListComponent,
    ModeloFormComponent,
    ModeloListComponent,
    FabricanteFormComponent,
    FabricanteListComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
