Feature: Pruebas de lectura de usuarios API

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  @smoke
  Scenario: Obtener usuario existente
    Given path 'users', 1
    When method get
    Then status 200
    And match response.id == 1
    And match response.name == '#string'
    And match response.email == '#string'

  Scenario: Listar usuarios
    Given path 'users'
    When method get
    Then status 200
    And match response == '#[10]'
    And match each response contains { id: '#number', name: '#string' }
