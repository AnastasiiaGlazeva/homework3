package ru.netology


fun main(){
println(agoToText(90))
    println(cardcomission(10000, "Visa", 1000)) //typeCard принимает значения VKPay Maestro Mastercard Visa Мир
}

    //Первая задача
    fun agoToText(sec : Int): String {

        val minut : Int = sec/60
        val hours : Int = minut/60

        println(minut)
        println(hours)

        val text= when {
            minut < 1 ->  "Пользователь был только что"
            (minut in 1..59)  ->  "Пользователь был "+minut.toString() + endingsMin(minut) +" назад"
            (hours in 1..24) ->  "Пользователь был "+hours.toString() + endingsHours(hours)+" назад"
            (hours in 25..48) ->  "Пользователь был сегодня"
            (hours in 49..78) -> "Пользователь был вчера"
            (hours>78) -> "Пользователь был давно"
            else-> ""
        }
        return text

    }
    fun endingsMin(summMin : Int): String {

        var typeOfMinute= when{
            summMin in 5..20  || summMin%10 in 5..9 || summMin%10 == 0 -> " минут"
            summMin%10 == 1 && !(summMin in 5..20) -> " минуту"
            summMin%10 in 2..4 && !(summMin in 5..20) -> " минуты"
            else -> ""
        }
        return typeOfMinute
    }

    fun endingsHours(summHours : Int): String{

        var typeOfHours = when{
            (summHours in 5..20)  || summHours%10 in 5..9 || summHours%10 == 0  -> " часов"
            summHours%10 == 1 && !(summHours in 5..20) ->  " час"
            summHours%10 in 2..4 && !(summHours in 5..20) ->  " часа"
            else -> ""
        }
        return typeOfHours
}

    //Вторая задача
    fun cardcomission(currentTrans: Int, typeCard: String = "VKPay", allSumm: Int = 0): Int{
        var comission = 0

        when (typeCard) {
            "Visa", "Мир" ->
            {
                comission = currentTrans*75/10000
                if(comission<3500) comission = 3500
            }
            "Mastercard","Maestro" ->
            {
                if(allSumm<7500000) {
                    comission=0
                }
                else{
                    comission = currentTrans*60/10000+2000
                }
            }
            ("VKPay") -> comission=0

        }
        return comission
    }

