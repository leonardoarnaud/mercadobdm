package br.eti.arnaud.mercadobdm.model

class Contact(
    val name: String,
    val type: Int,
    val address: String
) {
    companion object{
        const val PHONE = 0
        const val EMAIL = 1
    }
}