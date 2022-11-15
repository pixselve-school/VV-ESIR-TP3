# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. Ce test échoue à cause des erreurs causée par la multiplication des nombres flottants. Pour éviter ce problème, on peut utiliser la méthode `assertEquals` avec un delta de 0.0001.
Ainsi, le test devient `assertEquals(3 * .4, 1.2, 0.0001)`

2. La méthode `assertEquals` compare les valeurs des objets passés en paramètre, tandis que la méthode `assertSame` compare les références des objets passés en paramètre. Par exemple, si on a deux objets `String` de même valeur, mais de références différentes, alors `assertEquals` retournera `true` tandis que `assertSame` retournera `false`.

3. On peut utiliser `fail` pour vérifier que le code ne passe pas par une certaine partie du code. Par exemple, on peut vérifier que le code ne passe pas par une exception en utilisant `fail` dans le `catch` de l'exception.

4. La méthode `assertThrows` permet de vérifier que l'exception est bien lancée, et de récupérer l'exception pour vérifier ses attributs. Cela permet de vérifier que l'exception est bien lancée avec les bons paramètres.