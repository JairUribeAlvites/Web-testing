Feature: Logear usuario

  @LogearUsuario @HappyPath
  Scenario Outline: Ingresar de manera existosa a un usuario con credenciales validas
    Given el usuario esta en la pagina de inicio
    When Ingresa con un nombre de usuario "<username>" y contrasenia "<password>"
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | usuarioqwerq | pass123  |


