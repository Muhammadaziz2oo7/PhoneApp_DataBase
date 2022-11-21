package uz.muhamadaziz.phoneappdatabase

interface Service {
    fun addPhone(phonedata: Phonedata)

    fun deletePhone(phonedata: Phonedata)

    fun getAllPhoneList(): List<Phonedata>
}