
@ExceptionHandler(MethoArgumentNotValidException)

public ResponseEntity<ErrorResponse> manejarValidaciones(

    @ExceptionHandler(PokemonNotException.class)
    public ResponseEntity<ErrorResponse> manejarPokemonNoEncontrado(
            PokemonNotFoundException ex,
            HttpServletRequest  request

    ){
        ErrorResponse error= new ErrorResponse(
            localDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            error: "not Found",

        )   

        ErrorResponse error= new ErrorResponse(
            localDateTime.now(),
            HttpStatus.INTERNAL_SERVEL_ERROR.value(),
            error: "INTERNAL SERVEL ERROR",
            mensaje:"ocurrio un error inesperado en el servidor",
            request.getRequestURI());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVEL_ERROR)
    }










)
