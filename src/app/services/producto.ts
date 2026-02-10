import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../model/producto.model';

@Injectable({
  providedIn: 'root',
})
export class ProductoService{
  
   private baseUrl = "http://localhost:8080/api/productos"

  constructor(private http: HttpClient){  }
  
  findAll(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.baseUrl);
  } 

  findOne(id: number): Observable<Producto>{
  return this.http.get<Producto>(`${this.baseUrl}/${id}`);
  }
  save(Producto: Producto): Observable<Producto>{
  return this.http.post<Producto>(this.baseUrl, Producto);
  }

  update(id: number, producto: Producto): Observable<Producto>{
  return this.http.put<Producto>(`${this.baseUrl}/${id}`, producto);
  }

  delete(id: number): Observable<void>{
  return this.http.delete<void>(`${this.baseUrl}/${id}`);}
}
