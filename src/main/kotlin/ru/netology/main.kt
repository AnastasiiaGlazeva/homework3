package ru.netology

fun main(){
agoToText(90000)
cardcomission("Mastercard", 89000000, 100) //typeCard принимает значения VKPay Maestro Mastercard Visa Мир
}

//Первая задача
fun agoToText(sec : Int){
    var text  = ""
    val minut : Int = sec/60
    val hours : Int = minut/60

    println(minut)
    println(hours)

    when {
        minut < 1 -> text = "только что"
        (minut >= 1 && minut <60)  -> text = minut.toString() + endingsMin(minut) +" назад"
        (hours>=1 && hours<= 24) -> text = hours.toString() + endingsHours(hours)+" назад"
        (hours>24 && hours<=48) -> text = "сегодня"
        (hours>48 && hours<=78) -> text="вчера"
        (hours>78) -> text="давно"

    }
    println("Пользователь был $text")

}
fun endingsMin(summMin : Int): String {
 var typeOfMinute = ""
    when{
        (summMin >5 && summMin <20)  || summMin%10 == 5 || summMin%10 == 6|| summMin%10 == 7 || summMin%10 == 8 || summMin%10 == 9 || summMin%10 == 0 -> typeOfMinute=" минут"
        summMin%10 == 1 && !(summMin >5 && summMin <20) -> typeOfMinute=" минуту"
        summMin%10 == 2 || summMin%10 == 3 || summMin%10 == 4 && !(summMin >5 && summMin <20) -> typeOfMinute=" минуты"
    }
    return typeOfMinute
}

fun endingsHours(summHours : Int): String{
    var typeOfHours = ""
    when{
        (summHours >5 && summHours <20)  || summHours%10 == 5 || summHours%10 == 6|| summHours%10 == 7 || summHours%10 == 8 || summHours%10 == 9 || summHours%10 == 0 -> typeOfHours=" часов"
        summHours%10 == 1 && !(summHours >5 && summHours <20) ->  typeOfHours=" час"
        summHours%10 == 2 || summHours%10 == 3 || summHours%10 == 4 && !(summHours >5 && summHours <20) ->  typeOfHours=" часа"
    }
    return typeOfHours
}

//Вторая задача
fun cardcomission(typeCard: String, allSumm: Int, currentTrans: Int){
    var comission = 0

    when {
        (typeCard == "Visa" || typeCard == "Мир") ->
        {
            comission = currentTrans*75/10000
            if(comission<3500) comission = 3500
        }
        (typeCard == "Mastercard" || typeCard == "Maestro") ->
        {
            if(allSumm<7500000) {
                comission=0
            }
            else{
                comission = currentTrans*60/10000+2000
            }
        }
        (typeCard == "VKPay") -> comission=0

    }
    println("Комиссия составляет " +comission.toString()+" копеек")
}

