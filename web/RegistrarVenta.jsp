<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST"> 
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente:</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>                            
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" value="${c.getNom()}" placeholder="Datos Cliente" class="form-control">
                            </div>                                                                                                                
                        </div>
              <!-- Datos del Producto -->
              
                        <div class="form-group">
                            <label>Datos Producto:</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo">  
                                <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                            </div>                            
                            <div class="col-sm-6">
                                <input type="text" name="nombreproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPre()}" class="form-control" placeholder="S/.0.00">                                
                            </div>                            
                            <div class="col-sm-3">
                                <input type="number"  value="1" name="cant" class="form-control">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="stock" value="${producto.getStock()}" placeholder="Stock" class="form-control">
                            </div>                            
                        </div>
                        <div class="form-group">
                            <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                        </div>
                    </div>
                </form>
                </div>                
            </div>   
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto"> 
                            <label>No.Serie:</label>
                                <input type="text" name="N.Serie" class="form-control">
                        </div> 
                        <br>                        
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td>
                                     </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div> 
                    <div class="card-footer">
                        <div>
                            <input type="submit" name="accion" value="Generar Venta" class="btn btn-success">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>








