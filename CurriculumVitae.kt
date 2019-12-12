import SectionName.*

/**
 * code available at https://tinyurl.com/mg6cv20r3
 */
fun main() {
    print(cv)
}

val cv = CurriculumVitae(
    Section(
        ContactDetails,
        Info("Maciej Górski"),
        Info("+48606612169"),
        Info("maciek.gorski@gmail.com"),
        Info("mg6maciej@linkedin", "https://www.linkedin.com/in/mg6maciej"),
        Info("mg6maciej@github", "https://github.com/mg6maciej"),
        Info("MaciejGórski@stackoverflow", "https://stackoverflow.com/users/2183804/maciejg%c3%b3rski"),
        Info("mg6maciej@twitter", "https://twitter.com/mg6maciej")
    ),
    Section(
        Experience,
        Info("Userfeeds", "https://blog.userfeeds.io", "Startup w/ Ethereum, Docker, Spring, Neo4j, Kotlin, Python and more", 2017, 2018),
        Info("EL Passion", "https://www.elpassion.com", "Android, Kotlin, Java, automation", 2014, 2016),
        Info("Cybercom", "https://www.cybercom.com", "Android, Java, trainer", 2011, 2013),
        Info("Gamelion", "https://game-lion.com", "J2ME, Java", 2009, 2010),
        Info("CTDP", "http://ctdp.pl", "J2EE, Spring, Java", 2009, 2009),
        Info("o2.pl", "https://www.o2.pl", "J2ME, Java", 2008, 2009)
    ),
    Section(
        Projects,
        Info("Tokn'talk", "https://twitter.com/tokntalkclub", "Social platform for crypto-collectibes' owners"),
        Info("ZnanyLekarz", "https://play.google.com/store/apps/details?id=pl.znanylekarz", "Working on two Android apps for patients and doctors"),
        Info("Android Maps Extensions", "https://github.com/mg6maciej/android-maps-extensions", "Library extending capabilities of Google Maps Android API"),
        Info("Yafi", "https://play.google.com/store/apps/details?id=pl.mg6.yafi", "Online chess client"),
        Info("GrainLang", "https://github.com/grainlang", "Object-based programming language")
    ),
    Section(
        ActivitiesAndHobbies,
        Info("International speaker", "https://slides.com/mg6maciej", "Talking about Android, testing & automation", startYear = 2012),
        Info("Writing technical articles", "https://programistamag.pl", startYear = 2012),
        Info("Cycling around the world", "https://instagram.com/mg6maciej", startYear = 2010),
        Info("Playing board games", startYear = 1988),
        Info("Thinking", startYear = 1984)
    )
)

class CurriculumVitae(vararg val sections: Section) {
    
    override fun toString() = "Curriculum Vitae\n\n" + sections.joinToString("\n\n", transform = Section::toString)
}

class Section(val name: SectionName, vararg val info: Info) {
    
    override fun toString() = (listOf(name) + info).joinToString("\n    ", transform = Any::toString)
}

class Info(
    val summary: String,
    val link: String? = null,
    val details: String? = null,
    val startYear: Int? = null,
    val endYear: Int? = null
) {
    
    override fun toString() = listOfNotNull(summary, link, details, datesToString()).joinToString("  |  ")
    
    private fun datesToString() = if (startYear != null) {
        if (endYear != null) {
            "$startYear - $endYear"
        } else {
            "since $startYear"
        }
    } else {
        null
    }
}

enum class SectionName {
    
    ContactDetails,
    Experience,
    Projects,
    ActivitiesAndHobbies;
    
    override fun toString() = name.replace(Regex("(?<=[a-z])(?=[A-Z])"), " ")
}
