package com.wrongwrong.lifesliderkt.calc

import java.lang.RuntimeException

//データの出典：https://www.mhlw.go.jp/toukei/saikin/hw/life/life17/dl/life17-15.pdf

private val male = intArrayOf( //男性の生存人数
    //0から49歳
    100000, 99809, 99779, 99758, 99745,
    99735, 99727, 99719, 99711, 99704,
    99697, 99689, 99681, 99672, 99661,
    99647, 99630, 99609, 99582, 99550,
    99513, 99471, 99425, 99376, 99326,
    99275, 99226, 99177, 99127, 99077,
    99025, 98970, 98912, 98852, 98789,
    98725, 98657, 98586, 98511, 98429,
    98340, 98243, 98139, 98027, 97905,
    97771, 97623, 97458, 97274, 97071,
    //50から105歳
    96846, 96600, 96332, 96038, 95714,
    95357, 94966, 94541, 94080, 93579,
    93030, 92428, 91769, 91047, 90255,
    89383, 88424, 87373, 86226, 84987,
    83657, 82223, 80678, 79014, 77232,
    75326, 73300, 71133, 68800, 66268,
    63517, 60544, 57349, 53935, 50305,
    46479, 42479, 38346, 34146, 29952,
    25848, 21932, 18250, 14862, 11816,
    9148, 6876, 5001, 3507, 2362,
    1521, 932, 540, 294, 150, 71
)

private val female = intArrayOf( //女性の生存人数
    //0から49歳
    100000,99821,99793,99774,99761,
    99753,99745,99739,99734,99729,
    99724,99720,99716,99710,99704,
    99695,99685,99675,99663,99649,
    99633,99615,99596,99576,99556,
    99536,99514,99491,99466,99441,
    99415,99387,99357,99326,99292,
    99255,99216,99175,99132,99086,
    99035,98978,98914,98844,98768,
    98684,98594,98495,98386,98266,
    //50から105歳
    98136, 97994, 97839, 97672, 97494,
    97304, 97102, 96885, 96653, 96404,
    96139, 95856, 95554, 95228, 94874,
    94487, 94067, 93610, 93108, 92559,
    91960, 91312, 90612, 89851, 89015,
    88088, 87062, 85919, 84636, 83181,
    81530, 79667, 77578, 75237, 72612,
    69677, 66414, 62816, 58893, 54660,
    50152, 45412, 40518, 35545, 30538,
    25539, 20810, 16496, 12699, 9477,
    6844, 4772, 3207, 2072, 1284, 761
)

//入力チェック
private fun checkInput(start: Int, end: Int){
    if(start < 0 || end < 0 || end <= start || 105 < end) {
        throw RuntimeException("異常入力[start:$start, end:$end]")
    }
}
//男性の生存率計算
fun calcMaleSurvivalRate(start: Int, end: Int): Double{
    checkInput(start, end)
    return 1.0 - ((male[start] - male[end]).toDouble() / male[start].toDouble())
}
//女性の生存率計算
fun calcFemaleSurvivalRate(start: Int, end: Int): Double{
    checkInput(start, end)
    return 1.0 - ((female[start] - female[end]).toDouble() / female[start].toDouble())
}
