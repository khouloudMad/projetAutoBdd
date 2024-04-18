@logout
Feature: deconnecter un utilisateur connecte
  En tant qu'Admin connecte je veux me déconnecter

  Background: 
    Given je me connecte sur l'application
    When je saisie le nom "Admin"
    And je saisie le mot de passe "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d acceuil et "Dashboard" s affiche

  @logout
  Scenario: se deconnecter
    When je clique sur "user"
    And je choisis logout
    Then se deconnecter
