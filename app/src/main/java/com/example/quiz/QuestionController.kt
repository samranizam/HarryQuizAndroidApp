package com.example.quiz
object QuestionController {
    fun getQuestions(): ArrayList<QuestionModel> {
        val questionList = ArrayList<QuestionModel>()

        val q1 = QuestionModel(1, "What does Dumbledore tell Harry he saw in the Mirror of Erised in book 1?? ", "his brother and sister",
                "new pair of glasses", "fancy hat", "woolen socks", 4)
               questionList.add(q1)
        val q2 = QuestionModel(2, "Which character was NOT an Animagus?? ",
                "prof. McGonagall", "Remus Lupin", "James Potter", "Pete Pettigrew", 2)
        questionList.add(q2)
        val q3 = QuestionModel(3, "technically Argus filtch was? ", "squib",
                "muggle", "just a very rude man!", "caretaker", 1)
        questionList.add(q3)
        val q4 = QuestionModel(4, "What name does Harry give Stan when he gets on the Knight Bus in book 3?? ",
                "Ron Weasley", "Justin Finch", "Neville Longbottom", "Dean Thomas", 3)
        questionList.add(q4)
        val q5 = QuestionModel(5, "What does S.P.E.W started by Hermoine stands for?? ", "Stop the Poor Elf Workers",
                "Stop the Preposterous Elf Working", "Seize the power of Elfish Working", "Society for the Promotion of Elfish Welfare", 4)
        questionList.add(q5)
        val q6 = QuestionModel(6, "Which Hogwarts teacher had to be re-cast after the actor playing this character died?? ",
                "Dumbledore", "Grubblyplank", "Hagrid", "Flitwick", 1)
        questionList.add(q6)
        val q7 = QuestionModel(7, "You can only see a Thestral if you.. ", "believe in deathly hallows",
                "have seen death", "bow to them", "wear special goggles", 2)
        questionList.add(q7)
        val q8 = QuestionModel(8, "Who is the ghost of Gryffindor tower", "Bloody Baron", "Fat Friar",
                "Sir Nicholas", "Grey Lady", 3)
        questionList.add(q8)
        val q9 = QuestionModel(9, "Which Weasley brother marries former Beauxbatons student Fleur Delacour ", "Bill",
                "Charlie", "Percy", "Fred", 1)
        questionList.add(q9)
        val q10 = QuestionModel(10, "Who was Harry's love intrest before Ginny Weasley?? ", "Hermoine Granger",
                "Cho Chang", "Fleur Delacour", "Luna Lovegood", 2)
        questionList.add(q10)
       return questionList
    }
}


