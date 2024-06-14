import kotlin.math.absoluteValue

fun main() {

    var arrayMatches = arrayListOf<NumberOfHeads>()
    for (i in 0..9) {
        arrayMatches.add(settingGoals((0..5).random(), (0..5).random()))
        println("Match  #${i + 1} ended with a score ${arrayMatches[i].numberFirstTeam} : ${arrayMatches[i].numberSecondTeam}")
    }

    arrayMatches =
        arrayMatches.filterNot { it.numberFirstTeam == it.numberSecondTeam } as ArrayList<NumberOfHeads>

    var i = 1
    for (item in arrayMatches) {
        println("The winning match #$i ended with a score ${item.numberFirstTeam} : ${item.numberSecondTeam}")
        i++
    }

    var maxGap = 0
    arrayMatches.forEach {
        if (maxGap < (it.numberSecondTeam - it.numberFirstTeam).absoluteValue) {
            maxGap = (it.numberSecondTeam - it.numberFirstTeam).absoluteValue
        }
    }
    println("the maximum gap in the score of the match is $maxGap")

    val set =
        (arrayMatches.filter { (it.numberSecondTeam - it.numberFirstTeam).absoluteValue == maxGap }).toSet()

    set.forEach {
        println("Matches with the maximum gap in the score ${it.numberFirstTeam} : ${it.numberSecondTeam}")
    }
}

fun settingGoals(firstTeamGoals: Int, secondTeamsGoals: Int) = NumberOfHeads(firstTeamGoals, secondTeamsGoals)

class NumberOfHeads(val numberFirstTeam: Int, val numberSecondTeam: Int)