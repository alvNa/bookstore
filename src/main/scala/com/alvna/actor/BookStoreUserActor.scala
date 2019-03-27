package com.alvna.actor

import akka.actor._

class BookStoreUserActor extends Actor with ActorLogging{

  def receive = {

    case x: Any => log.info(s"Message Not Supported, ${x.getClass}")
  }
}
