## Mini Netflix Recommendation Engines
### Project Description
Mini Netflix recommendation engines based on [Collaborative Filtering](https://en.wikipedia.org/wiki/Collaborative_filtering) algorithm.

### Improvement
For this project, I only focus on building the core recommendation engines in the back end. For future usage, it will be better to build a user-friendly UI in the front end. Anyone who has interests in this project could fork or pull request.

### Demo
###### Demo 1 (General Recommendation)
Given rater ID 65, the number of minimal raters 5, and the number of top similar raters set to 10, the console output recommendation movies are (star sign means not recommended):
```
****** Interstellar 1308.0
The Imitation Game 1304.4
Rush 1264.4285714285713
Thor: The Dark World 1248.5
****** Fast & Furious 6 1246.3333333333333
****** Iron Man 3 1213.4
****** Pacific Rim 1211.3333333333333
X-Men: Days of Future Past 1209.3333333333333
Captain America: The Winter Soldier 1204.3333333333333
****** Edge of Tomorrow 1191.0
The Fault in Our Stars 1186.6
The Grand Budapest Hotel 1173.2
Gone Girl 1155.0
Gravity 1150.5
****** Star Trek Into Darkness 1144.4
The Hunger Games: Catching Fire 1130.4
Man of Steel 1102.7142857142858
Captain Phillips 1102.4
The Wolf of Wall Street 1092.625
****** Now You See Me 1061.5714285714287
****** Olympus Has Fallen 1036.2
****** Avengers: Age of Ultron 1033.6
The Secret Life of Walter Mitty 1030.1666666666667
****** World War Z 1029.2
The Heat 1011.8
Godzilla 986.4
****** Oblivion 959.8333333333334
****** The Maze Runner 932.8
****** Elysium 919.5
The Equalizer 858.8
****** Lucy 847.0
The Bling Ring 808.6

```

###### Demo 2 (Recommendation by Genre)
Given the genre “Action”, the rater ID 65, the number of minimal raters set to 5, and the number of top similar raters set to 10, the console output recommendation movies are (star sign means not recommended):
```
Gone Girl 683.2
Crime, Drama, Mystery
****** Prisoners 623.1666666666666
****** Crime, Drama, Mystery
Non-Stop 503.6
Action, Mystery, Thriller
Oblivion 469.2
Action, Adventure, Mystery
```

###### Demo 3 (Recommendation by Combined Filters: Year and Movie Length)
Given the year 2000, minutes between 80 and 100 inclusive, the rater ID 65, the number of minimal raters set to 5, and the number of top similar raters set to 10,  the console output recommendation movies are (star sign means not recommended):
```
Nightcrawler 2014 117 957.0
Interstellar 2014 169 955.8333333333334
Whiplash 2014 107 919.2857142857143
Gone Girl 2014 149 903.3333333333334
Rush 2013 123 894.8
****** Dallas Buyers Club 2013 117 863.6666666666666
****** Birdman or (The Unexpected Virtue of Ignorance) 2014 119 845.8333333333334
****** The Theory of Everything 2014 123 839.1666666666666
The Judge 2014 141 837.0
****** Fury 2014 134 830.0
The Grand Budapest Hotel 2014 99 828.0
Edge of Tomorrow 2014 113 804.0
Now You See Me 2013 115 791.6
The Maze Runner 2014 113 689.6
The Equalizer 2014 132 583.0
```
### Software Dependency
Fully developed in [BlueJ](https://www.bluej.org/), checkout for more details.

### File Description
* _Movie.java_: Plain Old Java Object(POJO) class for storing the data about one movie.
* _Rating.java_: Plain Old Java Object(POJO) class for storing the data about one rating of an item.
* _Rater.java_: An interface to keep track of one rater and all their ratings.
---
* _MovieDatabase.java_: Store all the movie information.
* _RaterDatabase.java_: Store all the rater information.
---
* _FirstRatings.java_: Process the movie and ratings data and to answer questions about them.
* _SecondRatings.java_: Computing averages on movie ratings.
* _ThirdRatings.java_: Get average ratings by customer id.
* _FourthRatings.java_: Similar to `ThirdRatings.java` but can get similar raters based on collaborate filtering algorithm.
---
* _EfficientRater.java_: Implementation of `Rater.java`.
* _Filter.java_: An interface need to filter based from customer selection.
* _TrueFilter.java_: Used to select every movie from `MovieDatabase.java`.
* _AllFilters.java_: Combines serveral filters.
* _YearAfterFilter.java_: A filter for a specfic year.
* _MinutesFilter.java_: A filter for a specfic year.
* _GenreFilter.java_: A filter for a specfic year.
* _DirectorFilter.java_: A filter for a specfic year.
---
* _MovieRunnerAverage.java_: Recommendation engines runner with average ratings.
* _MovieRunnerWithFilter.java_: Recommendation engines runner with filter.
* _MovieRunnerSimilarRatings.java_: Fully implemented recommendation engines runner.

### License
BSD