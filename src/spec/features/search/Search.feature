@search
Feature: Chercher utilisateur
  En tant qu'Admin connecte je veux chercher un utilisateur enregsitré sur orange HRM

  Background: 
    Given je me connecte sur l'application
    When je saisie le nom "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d acceuil et "Dashboard" s affiche
    When je clique sur le bouton Admin

  @searchUser
  Scenario Outline: recherche d'un utilisateur enregistré
    And je saisie le username "<username>"
    And je clique sur le bouton search
    Then je vérifie que "<username>" existe dans le tableau

    Examples: 
      | username |
      |          |
      | Admin    |
      | Ad       |
