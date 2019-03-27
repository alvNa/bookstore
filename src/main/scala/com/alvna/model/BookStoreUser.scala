package com.alvna.model

import java.util.Date

case class BookStoreUser(id: Long,
               firstName: String,
               lastName: String,
               email: String,
               createTs: Date,
               modifyTs: Date,
               deleted: Boolean)