package com.alvna.repository

import scala.concurrent.Future
import com.alvna.model.Book
import java.util.Date

object BookRepository extends  BookRepository {

}


class BookRepository {

  def findBook(id: Int): Future[Book] ={
    val b = new Book(1,"Book1","Pepe","Autor",Array.empty,0,0, new Date(),new Date(),false )
    Future.successful(b)
  }
}
