<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buscar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h2>Buscar Usuario por ID</h2>
                </div>
                <div class="card-body">
                    <form action="buscarUsuario" method="get">
                        <div class="mb-3">
                            <label for="id" class="form-label">ID de Usuario</label>
                            <input type="number" class="form-control" id="id" name="id" required>
                            <div class="invalid-feedback">Por favor ingrese un ID válido.</div>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Buscar</button>
                    </form>
                    <a href="index.jsp" class="btn btn-secondary w-100 mt-3">Volver</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
