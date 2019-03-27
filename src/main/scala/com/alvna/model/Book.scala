package com.alvna.model

import java.util.Date

case class Book(id: Int,
                         title: String,
                         lastName: String,
                         author: String,
                         tags: Array[String],
                         costs: Double,
                         inventoryAmount: Int,
                         creteTs: Date,
                         modifyTs: Date,
                         deleted: Boolean
                        )
