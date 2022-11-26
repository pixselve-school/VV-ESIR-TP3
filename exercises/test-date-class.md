# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

  public Date(int day, int month, int year) { ...}

  public static boolean isValidDate(int day, int month, int year) { ...}

  public static boolean isLeapYear(int year) { ...}

  public Date nextDate() { ...}

  public Date previousDate

  { ...}

  public int compareTo(Date other) { ...}

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null`

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point.
Also, feel free to add any extra method you may need to the `Date` class.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the
   characteristics and blocks you identified for each method. Specify which characteristics are common to more than one
   method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to
   increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to
   far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage
   and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new
   test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

### 1. Input Space Partitioning

#### isValidDate

Cette méthode prend en paramètre trois entiers qui représentent le jour, le mois et l'année et retourne un booléen qui
indique si la date est valide ou non.

Les caractéristiques de cette méthode sont les suivantes :

| Caractéristique                                              | b1     | b2             |
|--------------------------------------------------------------|--------|----------------|
| Jour en février dans une année bissextile                    | 1-29   | ]-∞;1[∪]29;+∞[ |
| Jour en février dans une année non bissextile                | 1-28   | ]-∞;1[∪]28;+∞[ |
| Jour en avril, juin, septembre et novembre                   | 1-30   | ]-∞;1[∪]30;+∞[ |
| Jour en janvier, mars, mai, juillet, août, octobre, décembre | 1-31   | ]-∞;1[∪]31;+∞[ |
| Mois                                                         | 1-12   | ]-∞;1[∪]12;+∞[ |
| Année                                                        | [1;+∞[ | ]-∞;1[         |

#### isLeapYear

Cette méthode prend en paramètre un entier qui représente l'année et retourne un booléen qui indique si l'année est
bissextile ou non.

Les caractéristiques de cette méthode sont les suivantes :

| Caractéristique  | b1     | b2     |
|------------------|--------|--------|
| Année bissextile | oui    | non    |
| Année            | [1;+∞[ | ]-∞;1[ |

#### nextDate

Cette méthode prend en paramètre une date et retourne une nouvelle date qui correspond à la date du jour suivant.

Les caractéristiques de cette méthode sont les suivantes :

| Caractéristique                                              | b1             | b2     | b3  |
|--------------------------------------------------------------|----------------|--------|-----|
| Jour en février dans une année bissextile                    | ]-∞;1[∪]29;+∞[ | 1-28   | 29  |
| Jour en février dans une année non bissextile                | ]-∞;1[∪]28;+∞[ | 1-27   | 28  |
| Jour en avril, juin, septembre et novembre                   | ]-∞;1[∪]30;+∞[ | 1-29   | 30  |
| Jour en janvier, mars, mai, juillet, août, octobre, décembre | ]-∞;1[∪]31;+∞[ | 1-30   | 31  |
| Mois                                                         | ]-∞;1[∪]12;+∞[ | 1-11   | 12  |
| Année                                                        | ]-∞;1[         | [1;+∞[ |     |

#### previousDate

Cette méthode prend en paramètre une date et retourne une nouvelle date qui correspond à la date du jour précédent.

Les caractéristiques de cette méthode sont les suivantes :

| Caractéristique                                              | b1             | b2   | b3     |
|--------------------------------------------------------------|----------------|------|--------|
| Jour en février dans une année bissextile                    | ]-∞;1[∪]29;+∞[ | 2-29 | 1      |
| Jour en février dans une année non bissextile                | ]-∞;1[∪]28;+∞[ | 2-28 | 1      |
| Jour en avril, juin, septembre et novembre                   | ]-∞;1[∪]30;+∞[ | 2-30 | 1      |
| Jour en janvier, mars, mai, juillet, août, octobre, décembre | ]-∞;1[∪]31;+∞[ | 2-31 | 1      |
| Mois                                                         | ]-∞;1[∪]12;+∞[ | 2-12 | 1      |
| Année                                                        | ]-∞;1[         | 1    | ]1;+∞[ |

#### compareTo

Cette méthode prend en paramètre une date et retourne un entier qui indique si la date est antérieure, égale ou
postérieure à la date passée en paramètre.

Les caractéristiques de cette méthode sont les suivantes :

| Caractéristique                                         | b1         | b2    | b3         |
|---------------------------------------------------------|------------|-------|------------|
| Relation de la date passée en paramètre avec notre date | supérieure | égale | inférieure |
| Date passée en paramètre est null                       | oui        | non   |            |

### 2. Logic Coverage

Avec les tests suivants, on obtient une couverture de 96%.
On peut voir que c'est la fonction `compareTo` que nous n'avons pas assez testé.
On ajoute un cas où l'année est différente et un cas où le mois est différent.
Avec ces deux cas, on obtient une couverture de 100%.

### 4. Mutation Testing

En l'état, on obtient un score de 91% de mutation. Analysons les mutations qui n'ont pas été tuées.

![img_1.png](img_1.png)

Ligne 27 de l'image ci-dessus, on a une mutation qui remplace la première comparaison par un `<=`.
En effet, on ne teste pas le cas où une année est égale à 1. Après avoir ajouté ce cas, le mutant est tué.

![img_2.png](img_2.png)

Même chose ligne 45. La comparaison est remplacée par un `<=`.
On ne teste pas le cas où l'année est égale à 1. Mais on a affaire à un mutant équivalent.
Effectivement, l'année 1 n'est pas bissextile, la fonction renvoie donc `false`, la fonction d'origine et la fonction
mutante renvoient la même valeur.

On ne peut donc pas tuer ce mutant.

Concernant les mutations ligne 7, on va décomposer la condition en plusieurs ifs pour voir ce qui ne fonctionne pas.

Avec ça, on remarque que le cas où l'année est divisible par 4 et 100, mais pas par 400 n'est pas testé.
On ajoute donc ce cas et tous les mutants sont tués.

![img_3.png](img_3.png)

Ligne 70, c'est aussi une comparaison qui est remplacée par un `<=`.
On ne teste pas le cas où le jour est égal à 2 (`previousDay = day - 1`).
Après avoir ajouté ce cas, le mutant est tué.

Pour finir, il ne reste qu'un mutant non tué qui est un mutant équivalent. Cela équivaut à un score de 99%.