package com.alvna

import akka.actor.ActorSystem
import akka.actor._
import akka.event.Logging
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.alvna.actor.InventoryClerkActor
import com.alvna.message.FindBook
import com.alvna.model.Book

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

import scala.util.{Failure, Success}

/**
 * @author ${user.name}
 */
object App extends App {

  implicit val system = ActorSystem("bookstore")
  implicit val executionContext = system.dispatcher
  implicit val materializer = ActorMaterializer()
  implicit val timeout = Timeout(5 seconds)

  val log = Logging(system, getClass)

  log.info(s">>> ${getClass.getName()} Welcome!!")

  val actor = system.actorOf(InventoryClerkActor.props, "inventory")

  val f = actor ? FindBook(1);

  f onComplete {
    case Success(resp) => {
      log.info(s">>> ---------------------------------")
      log.info(s">>> Receiving message: $resp")
      log.info(s">>> ---------------------------------")
    }
    case Failure(t: Throwable) => log.error(s"Shit, something went wrong: $t")
  }

  log.info(s">>> ${getClass.getName()} End!!")

  //system.shutdown

}
