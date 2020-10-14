package br.eti.arnaud.mercadobdm.model

abstract class Item(
    val title: String,
    val description: String,
    val price: String,
    val unit: String,
    val photo: String,
    val contact: Contact,
    val featured: Boolean
)