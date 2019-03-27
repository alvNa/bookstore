package com.alvna.common

import scala.concurrent.Future


/**
  * Extension for BookstoreRepository for dealing with entity types
  */
trait EntityRepository[FO <: EntityFieldsObject[Int, FO]] /*extends BookstoreRepository*/{
  /**
    * Load the entity from the repo
    * @param id The id of the entity
    * @return a Future wrapping an optional fields object
    */
  def loadEntity(id:Int):Future[Option[FO]]

  /**
    * Save the entity to the repo
    * @param vo The fields object representation of the entity
    * @return a Future wrapping the number of rows updated
    */
  def persistEntity(fo:FO):Future[Int]

  /**
    * Delete the entity from the repo
    * @param id The id of the entity to delete
    * @return a Future wrapping the number of rows updated
    */
  def deleteEntity(id:Int):Future[Int]
}

/**
  * Trait to mix into case classes that represent lightweight representations of the fields for
  * an entity modeled as an actor
  */
trait EntityFieldsObject[K, FO] extends Serializable{
  /**
    * Assigns an id to the fields object, returning a new instance
    * @param id The id to assign
    */
  def assignId(id:K):FO
  def id:K
  def deleted:Boolean
  def markDeleted:FO
}