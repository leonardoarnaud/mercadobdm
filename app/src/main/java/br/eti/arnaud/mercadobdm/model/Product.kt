package br.eti.arnaud.mercadobdm.model

class Product(
    title: String,
    description: String,
    price: String,
    unit: String,
    photo: String,
    contact: Contact,
    featured: Boolean
) : Item(title, description, price, unit, photo, contact, featured)