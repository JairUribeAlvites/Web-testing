Feature: Agregar Producto

  @SeleccionarProducto @HappyPath
  Scenario Outline: Agregar un producto al carrito de manera existosa
    Given el usuario esta en la pagina de inicio
    When agrega el producto "<producto>" al carrito
    Then se realiza el registro de manera exitosa
    And se muestra una notificación con el mensaje "Product added"

    Examples:
    |producto    |
    |Sony vaio i5|
