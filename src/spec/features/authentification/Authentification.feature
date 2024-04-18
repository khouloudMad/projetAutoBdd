@authentification
Feature: Authentification
  En tant qu un utilisateur je veux m authentifier sur l appplication orange HRM

  Background: 
    Given je me connecte sur l application

  @authentificationValide
  Scenario: Authentifcation avec coordonnees valides
    When je saisie le nom "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d acceuil et "Dashboard" s affiche

  @authentificationNonValide
  Scenario Outline: Authentifcation avec coordonnees non valides
    When je saisie le nom "<username>"
    And je saisie le mot de passe "<password>"
    And je clique sur le bouton login
    Then je me redirige vers la page d acceuil et "<resultatAttendu>" s affiche

    Examples: 
      | username | password | resultatAttendu |
      | Admin    | admin    | Dashboard       |
      | addmin   | admin123 | Dashboard       |
      | addmin   | admin    | Dashboard       |
      |          | admin123 | Dashboard       |
      | Admin    |          | Dashboard       |
      |          |          | Dashboard       |
