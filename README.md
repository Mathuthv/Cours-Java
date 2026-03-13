# Cours Java — Paris-Dauphine

> Dépôt personnel de cours Java — Université Paris-Dauphine  
> Basé sur les cours d'Olivier Cailloux, LAMSADE

---

## Ressources

| Semaine | Thème | PDF | Fichiers TP |
|---------|-------|-----|-------------|
| 1 | Syntaxe | [Syntax.pdf](semaine-1-syntaxe/Syntax.pdf) | [MyMathClass.java](semaine-1-syntaxe/MyMathClass.java) · [MyBooleanClass.java](semaine-1-syntaxe/MyBooleanClass.java) · [MovingThing.java](semaine-1-syntaxe/MovingThing.java) |
| 2 | Contrats | [Contrats.pdf](semaine-2-contrats/Contrats.pdf) | [Rolling.java](semaine-2-contrats/Rolling.java) · [Capitalize.java](semaine-2-contrats/Capitalize.java) · [Contrats.java](semaine-2-contrats/Contrats.java) |
| 3 | Exécution | [Execution.pdf](semaine-3-execution/Execution.pdf) | — |
| 4 | JUnit | —| [RollingTests.java](semaine-4-JUnit/RollingTests.java) · [CapitalizeTests.java](semaine-4-JUnit/CapitalizeTests.java) · [ContratsTests.java](semaine-4-JUnit/ContratsTests.java) |
| 5 | Notions d'objet | [Notions_d_objet.pdf](semaine-5-objets/Notions_d_objet.pdf) | — |

---

## Fiche de révision — Semaine 1 : Syntaxe Java

### 1. Syntaxe de base

```java
// Commentaire sur une ligne
/* Commentaire sur plusieurs lignes */

int x = 5;   // toute instruction se termine par ;

{            // un bloc regroupe plusieurs instructions
    instruction1;
    instruction2;
}
```

---

### 2. Variables

| Syntaxe | Exemple |
|--------|---------|
| Déclaration | `int a;` |
| Affectation | `a = 3;` |
| Déclaration + affectation | `int a = 3;` |

**Types primitifs** (nom en minuscule) :

| Type | Description | Exemple |
|------|-------------|---------|
| `boolean` | Vrai ou faux | `true`, `false` |
| `int` | Entier 32 bits | `42`, `100_000` |
| `double` | Flottant 64 bits | `3.14d`, `2d` |

**Type objet :**

```java
String s = "Bonjour";   // toujours entre guillemets doubles
```

---

### 3. Portée des variables

Une variable est connue **uniquement dans le bloc où elle est déclarée**.

```java
{
    int a = 2;
    {
        int b = 3;
        // a → connu ✅   b → connu ✅
    }
    // a → connu ✅   b → INCONNU ❌
}
```

> Bonne pratique : déclarer les variables avec la portée la plus étroite possible.

---

### 4. Opérateurs

| Opérateur | Description |
|-----------|-------------|
| `!` | Négation logique |
| `++`, `--` | Incrémentation / décrémentation |
| `+`, `-`, `*`, `/` | Arithmétique (`/` entier ≠ `/` double) |
| `%` | Reste de division entière |
| `+` sur String | Concaténation : `"a" + "b"` → `"ab"` |
| `<`, `>`, `<=`, `>=`, `==`, `!=` | Comparaison → retourne `boolean` |
| `&&` | ET logique (court-circuit) |
| `\|\|` | OU logique (court-circuit) |
| `+=`, `-=` | Opération puis affectation |

```java
// Opérateur ternaire
double result = condition ? valeur_si_vrai : valeur_si_faux;
```

---

### 5. Tableaux

```java
int[] primes = {2, 3, 5, 7, 11};   // initialisation directe
int x = primes[0];                  // accès par index (base 0)

double[] tab = new double[10];      // tableau vide de taille 10
tab[0] = 3d;
```

---

### 6. Tests

```java
if (condition) {
    // ...
} else if (autreCondition) {
    // ...
} else {
    // ...
}

// Astuce : plus concis qu'un if/else
openGate = (value == 3);
```

---

### 7. Boucles

```java
// While
while (condition) { ... }

// Do...while (exécuté au moins une fois)
do { ... } while (condition);

// For classique
for (int i = 0; i < 3; ++i) { ... }

// For-each (tableaux / collections)
for (int v : values) { ... }
```

---

### 8. Méthodes

```java
// type_retour nom(type param, ...)
double weightedSum(double a, double b) {
    return a + b;
}

// void = pas de valeur de retour
void afficher(String msg) {
    System.out.println(msg);
}
```

---

### 9. Classes

```java
class MyMathClass {
    static double w1;                        // variable de classe

    static double wSum(double a, double b) { // méthode de classe
        return w1 * a + (1 - w1) * b;
    }
}

// Appel depuis l'extérieur :
MyMathClass.w1 = 0.8d;
double r = MyMathClass.wSum(2d, 4d);
```

#### Encapsulation (private)

```java
class MyMathClass {
    private static double w1;   // inaccessible depuis l'extérieur

    static void setW1(double val) {
        w1 = val >= 0 ? val : Double.NaN;
    }

    static double getW1() {
        return w1;
    }
}
```

> `private` garantit que la variable ne peut être modifiée qu'à travers les setters.

---

### 10. Strings — méthodes utiles

```java
String s1 = "Bonjour";
String s2 = "bonjour";

// Comparaison — NE JAMAIS utiliser == pour les Strings !
s1.equals(s2)                // false  (sensible à la casse)
s1.equalsIgnoreCase(s2)      // true   (insensible à la casse)

// Informations
s1.length()                  // 7
s1.isEmpty()                 // false
s1.contains("jour")          // true
s1.startsWith("Bon")         // true
s1.endsWith("jour")          // true

// Transformation
s1.toLowerCase()             // "bonjour"
s1.toUpperCase()             // "BONJOUR"
s1.trim()                    // supprime les espaces début/fin
s1.replace("jour", "soir")   // "Bonsoir"

// Extraction
s1.charAt(0)                 // 'B'
s1.substring(3)              // "jour"
s1.substring(0, 3)           // "Bon"
s1.indexOf("jour")           // 3

// Conversion
String.valueOf(42)           // "42"   (int → String)
Integer.parseInt("42")       // 42     (String → int)
Double.parseDouble("3.14")   // 3.14   (String → double)

// Formatage
String.format("Bonjour %s, tu as %d ans", "Ana", 20);
// → "Bonjour Ana, tu as 20 ans"
```

> ⚠️ `==` compare les références mémoire, pas le contenu. Toujours utiliser `.equals()`.

---

### 11. Nombres aléatoires

```java
// Nombre aléatoire entre 0.0 (inclus) et 1.0 (exclu)
double r = Math.random();

// Entier aléatoire entre min et max inclus
public static int getRandom(int min, int max) {
    if (max < min) {
        throw new IllegalArgumentException("Le max doit être >= min.");
    }
    int range = (max - min) + 1;
    return (int) ((range * Math.random()) + min);
}

// Exemples :
getRandom(1, 6)    // dé à 6 faces → entre 1 et 6
getRandom(0, 100)  // pourcentage  → entre 0 et 100
```

**Explication de la formule :**
- `Math.random()` → `double` dans `[0.0, 1.0[`
- `range * Math.random()` → `double` dans `[0.0, range[`
- `+ min` → décale vers `[min, max+1[`
- `(int)` → tronque, résultat final dans `[min, max]`

---

### 12. Autres méthodes utiles du JDK

```java
Math.abs(-4)        // valeur absolue → 4
Math.PI             // constante π ≈ 3.14159
Math.pow(2, 10)     // 2^10 → 1024.0
Math.sqrt(9)        // racine carrée → 3.0
Math.min(3, 7)      // → 3
Math.max(3, 7)      // → 7

System.out.println("texte");   // afficher avec retour à la ligne
System.out.print("texte");     // afficher sans retour à la ligne
```

---

### 13. Packages

```java
// Déclaration en haut du fichier
package io.github.oliviercailloux.math;

// Import d'une classe d'un autre package
import io.github.oliviercailloux.math.Maths;

// java.lang (String, Math, System...) : pas besoin d'import
```

- Nom complet = `nom.du.package.NomClasse`
- Fichier source : `io/github/.../NomClasse.java`

---

## Fiche de révision — Semaine 2 : Découpe et Contrats

### 1. Pourquoi découper en sous-routines ?

Diviser un problème en sous-problèmes, chacun résolu par une méthode indépendante.

**Avantages :** clarté du code · réutilisation (DRY) · correction de bug en un seul endroit · partage du travail

---

### 2. Interface et API

Une **interface** sépare l'implémentation du monde extérieur. L'**API** (Application Programming Interface) est l'ensemble des sous-routines accessibles par programme.

```
Ton code Java → JDK → Système d'exploitation → Processeur
```

---

### 3. Contrat

Un **contrat** clarifie les responsabilités entre l'appelant et la méthode.

| Terme | Définition |
|-------|------------|
| **Précondition** | Ce que l'appelant doit garantir avant d'appeler |
| **Postcondition** | Ce que la méthode garantit en retour |

```java
/**
 * Retourne un entier aléatoire entre min et max inclus.
 *
 * @param min la borne inférieure
 * @param max la borne supérieure, >= min  ← PRÉCONDITION
 * @return un entier dans [min, max]       ← POSTCONDITION
 */
public static int getRandom(int min, int max) { ... }
```

> Si la précondition n'est pas respectée → **aucune garantie** n'est offerte.

---

### 4. Échec rapide (Fail-Fast)

**Mieux vaut une erreur immédiate qu'une action inattendue.**

**Programmation défensive** — tester les préconditions en entrée :
```java
public static int getRandom(int min, int max) {
    if (max < min) {
        throw new IllegalArgumentException("max doit être >= min");
    }
    // ...
}
```

**Programmation prudente** — vérifier ses propres déductions :
```java
if (result < 0) {
    throw new VerifyException("Erreur logique : result négatif inattendu");
}
```

---

### 5. Exceptions

```java
throw new IllegalArgumentException("Message d'erreur");
```

| Type | Quand l'utiliser |
|------|-----------------|
| `IllegalArgumentException` | Argument invalide fourni par l'appelant |
| `IllegalStateException` | Méthode appelée au mauvais moment |
| `VerifyException` (Guava) | Erreur de logique interne du programmeur |

**Propagation :** si l'exception n'est pas gérée, elle remonte à l'appelant. Si personne ne la gère → arrêt du programme.

---

## Fiche de révision — Semaine 3 : Compiler, Interpréter, Exécuter

### 1. Compiler vs Interpréter

| Action | Définition |
|--------|------------|
| **Compiler** | Transformer un langage en un autre |
| **Interpréter** | Traduire et exécuter les instructions |

Java suit le modèle **compilation puis interprétation** :

```
Code source (.java)
        ↓  javac  (compilation)
    Bytecode (.class)
        ↓  JVM    (interprétation)
    Exécution
```

---

### 2. Compilation

- Le compilateur Java s'appelle **`javac`**, fourni avec le **JDK** (Java Development Kit)
- Chaque classe `Truc` → fichier source `Truc.java` → fichier compilé `Truc.class` (bytecode)
- Les fichiers `.class` sont généralement placés dans un répertoire différent des sources

```bash
# Compiler un fichier
javac "MainCls.java" "RequiredCls.java"
# → produit MainCls.class et RequiredCls.class
```

---

### 3. Interprétation — La JVM

- Le bytecode (`.class`) est interprété par la **JVM** (Java Virtual Machine)
- Les fichiers `.class` sont **indépendants de l'OS** (un seul fichier pour tous)
- La JVM, elle, **dépend de l'OS**

```
.class + JVM Linux   → programme exécutable sous Linux
.class + JVM Windows → programme exécutable sous Windows
.class + JVM macOS   → programme exécutable sous macOS
```

> C'est le principe **"Write Once, Run Anywhere"** de Java.

---

### 4. Exécuter — Commande `java`

```bash
# Exécuter une classe (sans package)
java -cp "." "MainClass"

# Le class path (-cp) indique où trouver les fichiers .class
# Par défaut : répertoire courant (.)
# Séparer plusieurs chemins par : (Linux) ou ; (Windows)

java -cp "folder1:folder2" "MainClass"         # Linux
java -cp "folder1;folder2" "MainClass"         # Windows

# Passer des arguments au programme
java -cp "." "MainClass" "argument 1" "argument 2"
```

---

### 5. La méthode `main` — Point d'entrée

La JVM exécute toujours la méthode `main` de la classe donnée en argument.

```java
public class MainClass {
    public static void main(String[] args) {
        // args contient les arguments passés en ligne de commande
        System.out.println("Bonjour " + args[0]);
    }
}
```

> On peut avoir un `main` dans plusieurs classes → plusieurs points d'entrée possibles.

---

### 6. Classes dans des packages

Quand une classe est définie dans un package, il faut utiliser son **nom complet**.

```bash
# Compiler
javac "src/me/myapp/mytheme/MyClass.java"

# Exécuter (nom complet + class path vers le dossier racine des .class)
java -cp "target/" "me.myapp.mytheme.MyClass"
```

| Élément | Sans package | Avec package |
|---------|-------------|--------------|
| Fichier source | `MyClass.java` | `src/me/myapp/mytheme/MyClass.java` |
| Compilation | `javac MyClass.java` | `javac "src/me/myapp/mytheme/MyClass.java"` |
| Exécution | `java MainClass` | `java -cp "target/" "me.myapp.mytheme.MyClass"` |

---

### 7. Distribution d'un programme Java

Trois façons de distribuer un programme Java :

**① JVM système + fichiers `.class` séparément** *(utilisé en cours)*
- L'utilisateur installe le JDK sur son système
- Récupère les `.class` et les exécute avec `java`

**② JVM embarquée** (avec `jlink`)
- La JVM, les `.class` et un lanceur sont packagés dans un installeur
- L'utilisateur installe et clique sur le lanceur

**③ JVM sur un serveur** *(utilisé en projet)*
- La JVM tourne côté serveur
- L'utilisateur communique via le réseau (navigateur, appli...)

---

## Fiche de révision — Semaine 4 : JUnit

### 1. Principe

Au lieu de tester manuellement son programme, on écrit des **tests automatisés** qui vérifient une partie précise du code.

**Avantages :**
- Détecter les régressions lors d'un refactoring
- Savoir exactement quelle partie du code échoue
- Documenter l'usage attendu du code
- Forcer une architecture modulaire et découplée

---

### 2. Structure d'un test JUnit

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SuperComputerTests {   // nom de classe → "Tests" à la fin

    @Test
    void testComplicatedComputationWithParameter0() {
        SuperComputer computer = new SuperComputer();
        int actual = computer.complicatedComputation(0);
        assertEquals(3, actual);   // assertEquals(valeur_attendue, valeur_obtenue)
    }
}
```

> ⚠️ L'ordre des paramètres de `assertEquals` est important : **`(expected, actual)`**.  
> Un mauvais ordre donne des messages d'erreur trompeurs.

---

### 3. Assertions utiles

```java
assertEquals(expected, actual)         // vérifie l'égalité
assertNotEquals(unexpected, actual)    // vérifie la non-égalité

assertTrue(condition)                  // vérifie que condition est vraie
assertFalse(condition)                 // vérifie que condition est fausse

assertNull(object)                     // vérifie que l'objet est null
assertNotNull(object)                  // vérifie que l'objet n'est pas null

// Vérifier qu'une exception est bien lancée
assertThrows(IllegalArgumentException.class, () -> {
    getRandom(6, 1);   // max < min → doit lever une exception
});
```

**Astuce :** utiliser le static import pour plus de lisibilité :
```java
// Au lieu de :
Assertions.assertEquals(3, actual);

// Préférer :
import static org.junit.jupiter.api.Assertions.assertEquals;
assertEquals(3, actual);
```

---

### 4. Bonnes pratiques

- Nommer les classes de test avec le suffixe **`Tests`** (ex: `SuperComputerTests`)
- Placer les classes de test dans le **même package** que la classe testée
- Mettre les tests dans **`src/test/java`** (pas dans `src/main/java`)
- Tester uniquement le code **non trivial** (inutile de tester un simple getter)
- Tester les **cas limites** : valeur nulle, zéro, négatif, infini, `null`...
- Chaque test doit tester **une seule chose** à la fois

---

### 5. Exemple complet — Tester `getRandom`

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RollingTests {

    @Test
    void testGetRandomReturnsBetweenBounds() {
        int result = Rolling.getRandom(1, 6);
        assertTrue(result >= 1 && result <= 6,
            "Le résultat doit être entre 1 et 6");
    }

    @Test
    void testGetRandomWithEqualBounds() {
        int result = Rolling.getRandom(5, 5);
        assertEquals(5, result);   // un seul résultat possible
    }

    @Test
    void testGetRandomThrowsWhenMaxLessThanMin() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rolling.getRandom(6, 1);
        });
    }
}
```

---

## Fiche de révision — Semaine 5 : Notions d'objet en Java

### 1. Les deux rôles d'une classe

En Java, une classe joue **deux rôles distincts** :

| Rôle | Description | Exemple |
|------|-------------|---------|
| **Conteneur statique** | Regroupe des variables et méthodes statiques | `Math.sqrt(Math.PI)` |
| **Moule à objets (type)** | Sert de modèle pour créer des instances | `String`, `Car`, `Scanner` |

> Une même classe peut jouer les deux rôles simultanément.

---

### 2. Rôle 1 — Conteneur statique

Les classes regroupent des variables et sous-routines statiques pour **organiser et nommer** le code.

```java
Math.sqrt(Math.PI);   // méthode sqrt statique dans la classe Math
```

Tout ce qui est `static` appartient à la **classe elle-même**, pas à une instance. C'est ce qu'on a utilisé depuis le début du cours.

---

### 3. Rôle 2 — Moule à objets

Une classe définit un **type** : elle est la spécification, le moule à partir duquel on crée des **objets** (aussi appelés **instances**).

- **Classe** = le plan, le type (ex : `Car`)
- **Objet** = une instance concrète de ce type (ex : *ma voiture bleue*)

La classe `String` est un exemple déjà vu : `"blah"` est un objet de type `String`.

---

### 4. Création d'objets — 4 façons

#### ① Via un constructeur (`new`)

C'est la façon la plus courante.

```java
Random r = new Random();

IllegalArgumentException exc1 = new IllegalArgumentException("Must be positive.");
IllegalArgumentException exc2 = new IllegalArgumentException("Must be negative.");
// exc1 et exc2 sont deux objets distincts, mais du même type
```

> `new NomDeLaClasse(arguments)` alloue de la mémoire et appelle le constructeur.

#### ② Via une méthode fabrique (factory method)

Certaines classes exposent des méthodes statiques qui retournent une instance.

```java
Instant now = Instant.now();        // méthode statique now() de Instant
String ten = String.valueOf(10);    // convertit l'int 10 en String "10"
```

#### ③ Via une variable statique

Certaines classes exposent des constantes qui sont déjà des objets prêts à l'emploi.

```java
DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
```

#### ④ Syntaxe littérale (réservée aux Strings)

Les Strings ont une syntaxe spéciale en Java grâce aux guillemets doubles.

```java
String s = "Coucou";   // pas besoin de new String("Coucou")
```

> ⚠️ Derrière les guillemets, Java crée bien un objet `String`.

---

### 5. Méthodes d'instance vs méthodes statiques

Les **méthodes non statiques** (d'instance) ont un comportement qui **dépend de l'objet sur lequel elles sont appelées**.

```java
String s1 = "a";
String s2 = "Coucou";

s1.toUpperCase()   // → "A"
s2.toUpperCase()   // → "COUCOU"

exc1.getMessage()  // → "Must be positive."
exc2.getMessage()  // → "Must be negative."
```

Même méthode (`toUpperCase`, `getMessage`), résultats différents → l'objet porte son propre **état**.

| | Méthode statique | Méthode d'instance |
|--|--|--|
| Mot-clé | `static` | *(absent)* |
| Appel | `NomClasse.méthode()` | `objet.méthode()` |
| Dépend de l'instance ? | ❌ Non | ✅ Oui |

---

### 6. Égalité d'objets — Pièges à éviter

```java
String s1 = "hello";
String s2 = "hello";

s1 == s2        // ❌ compare les RÉFÉRENCES mémoire (peut être false !)
s1.equals(s2)   // ✅ compare le CONTENU sémantique → true
```

> **Règle absolue** : toujours utiliser `.equals()` pour comparer des objets, jamais `==`.  
> `==` ne teste que si les deux variables pointent vers le **même objet en mémoire**.

---

### 7. Le Scanner — lire l'entrée utilisateur

`Scanner` est une classe du JDK qui permet de lire des données depuis l'entrée standard (clavier).

```java
import java.util.Scanner;

Scanner stdin = new Scanner(System.in);   // crée un Scanner lié au clavier
String userName = stdin.nextLine();        // lit une ligne entière
int age = stdin.nextInt();                 // lit un entier
double val = stdin.nextDouble();           // lit un double
```

> `System.in` est le flux d'entrée standard (le clavier). `Scanner` l'enveloppe pour faciliter la lecture.

**Attention :** après `nextInt()` ou `nextDouble()`, faire un `stdin.nextLine()` vide pour consommer le `\n` résiduel avant de lire une nouvelle ligne.

```java
int n = stdin.nextInt();
stdin.nextLine();           // ← vider le buffer
String ligne = stdin.nextLine();
```

---

### 8. Résumé visuel — Classe vs Objet

```
┌─────────────────────────────────────────────────┐
│                  Classe  String                 │
│                                                 │
│  définit : length(), toUpperCase(), equals()... │
│  (le moule, le plan, le type)                   │
└────────────────────┬────────────────────────────┘
                     │ new / littéral / factory
          ┌──────────┴──────────┐
          ▼                     ▼
   Objet : "hello"       Objet : "WORLD"
   (instance 1)          (instance 2)
   s1.length() → 5       s2.length() → 5
   s1.toUpperCase()      s2.toLowerCase()
      → "HELLO"             → "world"
```

---

### 9. Points clés à retenir (semaine 5)

- Une **classe** a deux rôles : conteneur statique ET moule à objets.
- Un **objet** est une **instance** de classe, créé via `new`, une factory, une constante statique ou un littéral.
- Les **méthodes d'instance** opèrent sur un objet spécifique et peuvent retourner des résultats différents selon cet objet.
- Pour comparer deux objets, **toujours utiliser `.equals()`**, jamais `==`.
- `Scanner` permet de lire l'entrée utilisateur ; c'est lui-même un objet instancié avec `new Scanner(System.in)`.
- `String` est un type objet avec une syntaxe littérale spéciale (`"texte"`).

---

*Cours basé sur les slides de Olivier Cailloux — LAMSADE, Université Paris-Dauphine*
