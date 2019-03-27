package com.alvna.actor

import com.alvna.message.FindBook
import akka.actor.{Actor, ActorLogging, Props}
import akka.pattern.pipe
import com.alvna.App.{f, log}
import com.alvna.repository.BookRepository

import scala.concurrent.Future
import com.alvna.model.Book

object InventoryClerkActor {
  def props(): Props = Props(classOf[InventoryClerkActor])
}

class InventoryClerkActor extends Actor with ActorLogging{

  def receive: Receive = {
    case x: FindBook => findBook(x.id)
    case _ => log.info("Default message")
  }

  private def findBook(id: Int) ={
    log.info(s"Actor $id")
    val f = BookRepository.findBook(id)
    log.info(s"Actor retrieved $id")
    sender ! f
  }


}
