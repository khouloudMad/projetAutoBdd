@searchIII
Feature: Chercher utilisateur avec le status
  En tant qu'Admin connecte je veux chercher un ou plusieurs utilisateur enregsitré sur orange HRM

  Background: 
    Given je me connecte sur l'application
    When je saisie le nom "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d acceuil et "Dashboard" s affiche

  @searchUserByStatus
  Scenario Outline: recherche d'un utilisateur enregistré
    When je clique sur le bouton Admin
    And je choisis le status "<status>"
    And je clique sur le bouton search
    Then je vérifie que seulement "<status>" existe  dans le tableau

    Examples: 
      | status   |
      | Enabled  |
      | Disabled |
