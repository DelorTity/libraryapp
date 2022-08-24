# library-app
application de gestion de bibliothèque


Bienvenue à la Bibliothèque Que voulez-vous faire ? 1 - Gestion des auteurs 2 - Gestion des livres 0 - Quitter la bibliothèque

$ _

Les actions suivantes se produisent en fonction du choix de l'utilisateur : Choix 1 (Gestion des auteurs )

On affiche les auteurs dans la console
Les auteurs affichés sont classés par ordre alphabétique du prénom, puis du nom
...

Exemple d'affichage des livres

Liste des auteurs 16 - Napoleon Hill 3 - Pierre-Yves McSween 5 - Thione Niang 9 - Wilfried Djomo

Pour ajouter un nouvel auteur, veuillez saisir : "add" Pour faire une action sur un auteur, veuillez saisir l'action suivit, d'un espace, puis de l'identifiant de l'auteur. Actions possible : Suppression (delete).
Ou saisissez "back" pour retourner au menu principal

Si l'utilisateur saisit back, alors il est redirigé au menu principal. Ajout d'un nouvel auteur

Les informations suivantes sont nécessaires à la création d'un auteur
    Prénom
    Nom
Lors de la création d'un auteur, on vérifie si un auteur existe déjà dans la base de données avec le même nom et le même prénom (ignorer la casse)
    Si oui, afficher un message d'erreur : "L'auteur {Prénom} {Nom} existe déjà." et demander à l'utilisateur de rentrer à nouveau le prénom et le nom de l'auteur.
    Sinon, sauvegarder l'auteur dans la base de donnés et afficher un message de succès.

Simulation de la création d'un auteur

$ add Ajout d'un nouvel auteur Entrez le prénom de l'auteur : Thione Entrez le nom de l'auteur : Niang

Gestion des cas possibles Auteur existe déjà

L'auteur Thione Niang existe déjà. Veuillez reprendre s'il vous plaît.

Entrez le prénom de l'auteur : Thione Entrez le nom de l'auteur : Niang

Auteur est créé avec succès

L'auteur Thione Niang a été rajouté avec succès.

Tapez "ENTER" pour retourner

Après avoir tapé la touche "ENTER", l'application retourne à la liste des auteurs, et vous pouvez voir le nouvel auteur. Suppression d'un auteur

La suppression d'un auteur entraine la suppression de tous les livres de celui-ci.

$ delete 5 L'auteur "Thione Niang" et ses livres ont été supprimés avec succès.
Tapez "ENTER" pour retourner

Après avoir tapé la touche "ENTER", l'application retourne à l'étape précédente (le listage des auteurs). Choix 2 : (Gestion des livres)

On affiche les livres dans la console
Les livres affichés sont classés par ordre alphabétique du titre
...

Exemple d'affichage des livres

Liste des livres 5 - Demain tu gouvernes le monde - Thione Niang 3 - En as-tu vraiment besoin ? - Pierre-Yves McSween 9 - L'effet papillon - Wilfried Djomo 16 - Liberté 45 - Pierre-Yves McSween 8 - Social Entrepreneurship - Thione Niang 21 - Think and grow rich - Napoleon Hill

Pour ajouter un nouveau livre, veuillez saisir : "add" Pour faire une action sur un livre, veuillez saisir l'action suivit, de l'espace, puis de l'identifiant du livre. Actions possible : Affichage (read) et Suppression (delete)
Ou saisissez "back" pour retourner au menu principal

$ _

Si l'utilisateur saisi back, alors il est redirigé au menu principal.

Simulation des actions de l'utilisateur Ajout d'un nouveau livre

Lors de l'ajout d'un livre, la première action à faire est de demander le nom complet de l'auteur, puis d'aller rechercher dans la base de données si l'auteur existe.
    Si oui, continuer la création du livre
    Sinon, dire à l'utilisateur que l'auteur n'existe pas, par conséquent le livre ne peut être créé.
Si l'auteur existe, alors demander les informations du livre, telles que :
    Titre
    Numéro ISBN
    Editeur
    Année de publication

Une fois, ces informations ont été fournies avec succès, sauvegarder le livre et afficher un message de succès, comme lors de la création d'un auteur.

Simulation de la création d'un livre

$ add Ajout d'un nouveau livre Veuillez entrer le nom complet de l'auteur : Wilfied Djomo

L'auteur saisi n'existe pas

L'auteur Wilfied Djomo n'existe pas Veuillez entrer le nom complet de l'auteur : Wilfried Djomo

L'auteur existe

Nouveau livre pour Wilfried Djomo Quel est le titre ? L'Effet papillon Entrez le numéro ISBN : 9789706783819 L'éditeur du livre : EDILIVRE Année de publication : 2022

Livre créé avec succès

Le livre "L'Effet papillon" a été ajouté avec succès.

Tapez "ENTER" pour retourner

Après avoir tapé la touche "ENTER", l'application retourne à la liste des livres, et vous pouvez voir le nouveau livre. Affichage

Exemple : L'utilisateur veut afficher les informations du livre 5

$ read 5 Titre : Demain tu gouvernes le monde Auteur : Thione Niang ISBN : 9781706903819 Editeur : Washitong Publishing Année de publication : 2017
Tapez "ENTER" pour retourner

Après avoir tapé la touche "ENTER", l'application retourne à l'étape précédente (le listage des livres). Suppression

Exemple : L'utilisateur veut supprimer le livre 5

$ delete 5 Le livre "Demain tu gouvernes le monde" a été supprimé avec succès.
Tapez "ENTER" pour retourner

Après avoir tapé la touche "ENTER", l'application retourne à l'étape précédente (le listage des livres). Notes fonctionnelles

Il existe une relation 1-N entre auteur et livre, un auteur peut avoir plusieurs livres. Il est donc important de prendre en compte cette relation lors de la modélisation de la base de données
Valider toutes les saisies de l'utilisateur et afficher les messages d'erreurs lorsque l'utilisateur saisit une valeur non attendue.

Notes techniques

Organiser l'application en couches.
    Couche d'accès aux données : DAO
    Couche service : pour les traitements
    D'autres couches si nécessaire

Les tests unitaires et d'intégration doivent être implémentés

Respecter l'affichage des différents textes : casse, espacement, ponctuation, ...

Base de données : MySQL

Outil de compilation : Maven (avec un Maven Wrapper)

Java 8+

Livrables

Le script de création de la base de données et les tables : Ce script devra être présent dans le code source
Générer les rapports de tests suivants :
    JaCoCo : Couverture de tests minimum 70%
    Surefire
    SpotBug
