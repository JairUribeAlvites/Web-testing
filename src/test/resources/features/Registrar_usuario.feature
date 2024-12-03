Feature: Registrar un Usuario

  @RegistrarUsuario2 @HappyPath
  Scenario Outline: Registrar de manera existosa a un usuario con credenciales validas
    Given el usuario esta en la pagina de inicio
    When se registra con un nombre de usuario "<username>" y contrasenia "<password>"
    Then se realiza el registro de manera exitosa

    Examples:
      | username    | password |
      | usuarioqwerq | pass123  |

