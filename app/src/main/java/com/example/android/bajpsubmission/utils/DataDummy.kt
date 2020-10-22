package com.example.android.bajpsubmission.utils

import com.example.android.bajpsubmission.data.MoviesEntity
import com.example.android.bajpsubmission.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                moviesId = 1,
                title = "Parasite",
                year = "2019",
                description = "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/tv2gjDxaxyhVNDESFLJ6oGT10sL.jpg",
                director = "Bong Joon-ho",
                cast = "Kang-ho Song, Sun-kyun Lee, Yeo-jeong Jo"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 2,
                title = "Inception",
                year = "2010",
                description = "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.",
                poster = "https://image.tmdb.org/t/p/original/edv5CZvWj09upOsy2Y6IwDhK8bt.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/s3TBrRGB1iav7gFOCNx3H31MoES.jpg",
                director = "Christopher Nolan",
                cast = "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 3,
                title = "The Shawshank Redemption",
                year = "1994",
                description = "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                poster = "https://image.tmdb.org/t/p/original/lyQBXzOQSuE59IsHyhrp0qIiPAz.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/9Xw0I5RV2ZqNLpul6lXKoviYg55.jpg",
                director = "Frank Darabont",
                cast = "Tim Robbins, Morgan Freeman, Bob Gunton"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 4,
                title = "Forrest Gump",
                year = "1994",
                description = "A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.",
                poster = "https://image.tmdb.org/t/p/original/clolk7rB5lAjs41SD0Vt6IXYLMm.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/4f5AsEwMiKobYBalZWKbkrIcoQV.jpg",
                director = "Robert Zemeckis",
                cast = "Tom Hanks, Robin Wright, Gary Sinise"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 5,
                title = "Django Unchained",
                year = "2012",
                description = "With the help of a German bounty hunter, a freed slave sets out to rescue his wife from a brutal Mississippi plantation owner.",
                poster = "https://image.tmdb.org/t/p/original/7oWY8VDWW7thTzWh3OKYRkWUlD5.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/2oZklIzUbvZXXzIFzv7Hi68d6xf.jpg",
                director = "Quentin Tarantino",
                cast = "Jamie Foxx, Christoph Waltz, Leonardo DiCaprio"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 6,
                title = "Downfall",
                year = "2004",
                description = "In April of 1945, Germany stands at the brink of defeat with the Russian Army closing in from the east and the Allied Expeditionary Force attacking from the west. In Berlin, capital of the Third Reich, Adolf Hitler proclaims that Germany will still achieve victory and orders his generals and advisers to fight to the last man. When the end finally does come, and Hitler lies dead by his own hand, what is left of his military must find a way to end the killing that is the Battle of Berlin, and lay down their arms in surrender.",
                poster = "https://image.tmdb.org/t/p/original/gsmCtO2K1SeFki8f0tbBYTh5l9t.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/7GaIhvhZ9szV0AdYgejtZ8fXaEB.jpg",
                director = "Oliver Hirschbiegel",
                cast = "Bruno Ganz, Alexandra Maria Lara, Ulrich Matthes"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 7,
                title = "Your Name.",
                year = "2016",
                description = "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.",
                poster = "https://image.tmdb.org/t/p/original/Asz9VYlxb02xa7H9OObDxL7pwZJ.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/dIWwZW7dJJtqC6CgWzYkNVKIUm8.jpg",
                director = "Makoto Shinkai",
                cast = "Ryunosuke Kamiki, Mone Kamishiraishi, Masami Nagasawa"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 8,
                title = "Inglourious Basterds",
                year = "2009",
                description = "In Nazi-occupied France during World War II, a group of Jewish-American soldiers known as \"The Basterds\" are chosen specifically to spread fear throughout the Third Reich by scalping and brutally killing Nazis. The Basterds, lead by Lt. Aldo Raine soon cross paths with a French-Jewish teenage girl who runs a movie theater in Paris which is targeted by the soldiers.",
                poster = "https://image.tmdb.org/t/p/original/8QlExkCx89u240o3q7n3DREsq5d.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/yVPcPk96E6Qffiyez2oJc7OKD2A.jpg",
                director = "Quentin Tarantino",
                cast = "Brad Pitt, Mélanie Laurent, Christoph Waltz"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 9,
                title = "Darkest Hour",
                year = "2017",
                description = "A thrilling and inspiring true story begins on the eve of World War II as, within days of becoming Prime Minister of Great Britain, Winston Churchill must face one of his most turbulent and defining trials: exploring a negotiated peace treaty with Nazi Germany, or standing firm to fight for the ideals, liberty and freedom of a nation. As the unstoppable Nazi forces roll across Western Europe and the threat of invasion is imminent, and with an unprepared public, a skeptical King, and his own party plotting against him, Churchill must withstand his darkest hour, rally a nation, and attempt to change the course of world history.",
                poster = "https://image.tmdb.org/t/p/original/cHZYUky7hZME9alvcmVoqzdV0kJ.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/zXwFJMwvQcJFitP9GcHZvHAHGe8.jpg",
                director = "Joe Wright",
                cast = "Gary Oldman, Kristin Scott Thomas, Lily James"
            )
        )

        movies.add(
            MoviesEntity(
                moviesId = 10,
                title = "The Death of Stalin",
                year = "2017",
                description = "When tyrannical dictator Josef Stalin dies in 1953, his parasitic cronies square off in a frantic power struggle to become the next Soviet leader. Among the contenders are the dweebish Georgy Malenkov, the wily Nikita Khrushchev and Lavrenti Beria, the sadistic secret police chief.",
                poster = "https://image.tmdb.org/t/p/original/66nL9hKPerEZMOeCQuWD322Nm8g.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/amjwic2EEr6pLrnZudbGDemWDLZ.jpg",
                director = "Armando Iannucci",
                cast = "Steve Buscemi, Simon Russell Beale, Jason Isaacs"
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                tvShowId = 1,
                title = "The Walking Dead",
                currentSeason = "Season 10 | 2019",
                description = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                poster = "https://image.tmdb.org/t/p/original/wmv0oIun52Xeq65sBKfHiUkiBKc.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/qgnq0zbCBidOQrpMOufONN6H2Pj.jpg",
                creator = "Frank Darabont",
                cast = "Andrew Lincoln, Norman Reedus, Danai Gurira"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 2,
                title = "Attack on Titan",
                currentSeason = "Season 4 | 2020",
                description = "Several hundred years ago, humans were nearly exterminated by Titans. Titans are typically several stories tall, seem to have no intelligence, devour human beings and, worst of all, seem to do it for the pleasure rather than as a food source. A small percentage of humanity survived by walling themselves in a city protected by extremely high walls, even taller than the biggest Titans. Flash forward to the present and the city has not seen a Titan in over 100 years. Teenage boy Eren and his foster sister Mikasa witness something horrific as the city walls are destroyed by a Colossal Titan that appears out of thin air. As the smaller Titans flood the city, the two kids watch in horror as their mother is eaten alive. Eren vows that he will murder every single Titan and take revenge for all of mankind.",
                poster = "https://image.tmdb.org/t/p/original/lK0NAXT7mcJrC3NK8vpXwK5EJQu.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/wg0GsFpeHAFPbbcfsntTQBggWCo.jpg",
                creator = "Hajime Isayama",
                cast = "Yūki Kaji, Marina Inoue, Yui Ishikawa"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 3,
                title = "Sherlock",
                currentSeason = "Season 4 | 2017 | Ended",
                description = "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                poster = "https://image.tmdb.org/t/p/original/7WTsnHkbA0FaG6R9twfFde0I9hl.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/zrCOCAozai5NkaVQR09qyrvzVpZ.jpg",
                creator = "Mark Gatiss, Steven Moffat ",
                cast = "Benedict Cumberbatch, Martin Freeman, Mark Gatiss"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 4,
                title = "Death Note ",
                currentSeason = "Season 1 | 2006 | Ended",
                description = "Light Yagami is an ace student with great prospects—and he’s bored out of his mind. But all that changes when he finds the Death Note, a notebook dropped by a rogue Shinigami death god. Any human whose name is written in the notebook dies, and Light has vowed to use the power of the Death Note to rid the world of evil. But will Light succeed in his noble goal, or will the Death Note turn him into the very thing he fights against?",
                poster = "https://image.tmdb.org/t/p/original/nrTHZUlI8f2iBNMbycqOd2cQQVO.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/qDOPIr8evcYQpXbJjoZ1G4wzv8g.jpg",
                creator = "Bong Joon-ho",
                cast = "Mamoru Miyano, Aya Hirano, Noriko Hidaka"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 5,
                title = "Mr. Robot ",
                currentSeason = "Season 4 | 2019",
                description = "A contemporary and culturally resonant drama about a young programmer, Elliot, who suffers from a debilitating anti-social disorder and decides that he can only connect to people by hacking them. He wields his skills as a weapon to protect the people that he cares about. Elliot will find himself in the intersection between a cybersecurity firm he works for and the underworld organizations that are recruiting him to bring down corporate America.",
                poster = "https://image.tmdb.org/t/p/original/oKIBhzZzDX07SoE2bOLhq2EE8rf.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/fjjwzAVkdxT2EEPgiU6uXUzIjGy.jpg",
                creator = "Sam Esmail",
                cast = "Rami Malek, Christian Slater, Carly Chaikin"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 6,
                title = "One Piece ",
                currentSeason = "Wano Country Arc | 2020",
                description = "Years ago, the fearsome pirate king Gol D. Roger was executed, leaving a huge pile of treasure and the famous \"One Piece\" behind. Whoever claims the \"One Piece\" will be named the new pirate king. Monkey D. Luffy, a boy who consumed one of the \"Devil's Fruits\", has it in his head that he'll follow in the footsteps of his idol, the pirate Shanks, and find the One Piece. It helps, of course, that his body has the properties of rubber and he's surrounded by a bevy of skilled fighters and thieves to help him along the way. Monkey D. Luffy brings a bunch of his crew followed by, Roronoa Zoro, Nami, Usopp, Sanji, Tony-Tony Chopper, Nico Robin, Franky, and Brook. They will do anything to get the One Piece and become King of the Pirates!..",
                poster = "https://image.tmdb.org/t/p/original/uStT6g4khexdKPyaiosp0fj3zEz.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/npg6pCyEYcCS6Ok9fbiIdcA60lH.jpg",
                creator = "Eiichiro Oda",
                cast = "Mayumi Tanaka, Kazuya Nakai, Akemi Okamura"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 7,
                title = "Heroes",
                currentSeason = "Redemption | 2009 | Ended",
                description = "Common people discover that they have super powers. Their lives intertwine as a devastating event must be prevented.",
                poster = "https://image.tmdb.org/t/p/original/tV1BK0nfX5X2uveaaYbHot0JfJj.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/4QMjJCtt82VqBAavDfuWuUONoRS.jpg",
                creator = "Tim Kring",
                cast = "Adrian Pasdar, Hayden Panettiere, Milo Ventimiglia"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 8,
                title = "Prison Break",
                currentSeason = "Season 5| 2017 | Ended",
                description = "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",
                poster = "https://image.tmdb.org/t/p/original/j7HFOunuAVpOdiBhXpjwRxIgK5y.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/ovaQot7DgQXjmU99jUpGlne6EJO.jpg",
                creator = "Paul Scheuring",
                cast = "Wentworth Miller, Dominic Purcell, Robert Knepper"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 9,
                title = "The Boys ",
                currentSeason = "Season 2 | 2020",
                description = "A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.",
                poster = "https://image.tmdb.org/t/p/original/e7oHnWqqdC9JRxKCJFfpUaKX66U.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/n6vVs6z8obNbExdD3QHTr4Utu1Z.jpg",
                creator = "Eric Kripke",
                cast = "Karl Urban, Jack Quaid, Antony Starr"
            )
        )

        tvShow.add(
            TvShowEntity(
                tvShowId = 10,
                title = "Fargo",
                currentSeason = "Season 4 | 2020",
                description = "A close-knit anthology series dealing with stories involving malice, violence and murder based in and around Minnesota.",
                poster = "https://image.tmdb.org/t/p/original/9ZIhl17uFlXCNUputSEDHwZYIEJ.jpg",
                backdrop = "https://image.tmdb.org/t/p/original/xcJLhsFGVC4LVvucSqVXks2mnUJ.jpg",
                creator = "Noah Hawley",
                cast = "Billy Bob Thornton, Colin Hanks, Martin Freeman"
            )
        )
        return tvShow
    }
}
