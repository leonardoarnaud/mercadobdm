package br.eti.arnaud.mercadobdm.model

data class Product(
    val title: String,
    val description: String,
    val price: String,
    val photo: String,
    val contact: Contact,
    val featured: Boolean
)