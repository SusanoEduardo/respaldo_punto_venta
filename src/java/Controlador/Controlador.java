package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    Empleado em= new Empleado();
    EmpleadoDAO edao= new EmpleadoDAO(); // instanciando la clase dao modelo
    Cliente c= new Cliente();
    ClienteDAO cdao= new ClienteDAO();
    Producto p= new Producto();
    ProductoDAO pdao= new ProductoDAO();
    int ide; // para actualizar datos empleado
    int idc; // cliente
    int idp; // productos
    
    Venta v=new Venta(); // INSTANCIOANDO LA CLASE/ENTIDAD VENTA<<<<<<
    List<Venta>lista=new ArrayList<>(); // LA LISTA DE LOS PRODUCTOS
    // declarando variables  para utilizarlos en la venta
      int item;
      int cod;
      String descripcion;
      double precio;
      int cant;
      double subtotal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("Principal")){
               request.getRequestDispatcher("Principal.jsp").forward(request, response);
           }
        if(menu.equals("Empleado")){
                        switch (accion){
                            case "Listar":
                                List lista=edao.listar();
                                request.setAttribute("empleados", lista);
                             break;
                             case "Agregar":
                                 /*
                                    String dni=request.getParameter("txtDni");
                                    String nom=request.getParameter("txtNombres");
                                    String tel=request.getParameter("txtTel");
                                    String est=request.getParameter("txtestado");
                                    String user=request.getParameter("txtUsuario");
                                      em.setDni(dni);
                                      em.setNom(nom);
                                      em.setTel(tel);
                                      em.setEstado(est);
                                      em.setUser(user);
                                        edao.agregar(em);
                                      request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                                      */
                             break;
                             case "Editar":
                                 
                    //Integer.parseInt(String.valueOf(rs.getInt("pacientes.id_paciente")));                                                  
                                ide=Integer.parseInt(request.getParameter("id"));
                                 Empleado e= edao.listarId(ide);
                                 request.setAttribute("empleado", e);System.out.println("EDITAR" + ide);
                                 request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                             System.out.println("EDITAR" + ide);
                            break;
                            
                             case "Actualizar":
                                 /*
                                    String dni1=request.getParameter("txtDni");
                                    String nom1=request.getParameter("txtNombres");
                                    String tel1=request.getParameter("txtTel");
                                    String est1=request.getParameter("txtestado");
                                    String user1=request.getParameter("txtUsuario");
                                      em.setDni(dni1);
                                      em.setNom(nom1);
                                      em.setTel(tel1);
                                      em.setEstado(est1);
                                      em.setUser(user1);
                                      em.setId(ide);
                                        edao.actualizar(em);
                                           System.out.println("actualizaqndo" + ide);
                                 request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                             break;
                             case "Delete":
                                ide=Integer.parseInt(request.getParameter("id"));
                                 edao.delete(ide);
                                 System.out.println("ELIMINANDO" + ide);
                                 request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                             break;
                             */
                      default:
                          throw new AssertionError();
                        }               
                       request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }                      
        if(menu.equals("Clientes")){
               request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if(menu.equals("Producto")){
               request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){
            switch (accion){
              case "BuscarCliente":
                  String dni=request.getParameter("codigocliente");
                    c.setDni(dni);
                    c=cdao.buscar(dni);
                    request.setAttribute("c", c);
                  break;  
                   case "BuscarProducto":
                     int id=Integer.parseInt(request.getParameter("codigoproducto"));
                     p=pdao.listarId(id);
                     request.setAttribute("producto", p);// mandar k se muestre en le formilario
                     //System.out.println("name" + p.getNom() + p.getPre() + p.getStock() );
                  break;  
                  case "Agregar":
                      item = item+1;
                      cod=p.getId();
                      descripcion=request.getParameter("nombreproducto");
                      precio=Double.parseDouble(request.getParameter("precio"));
                      cant=Integer.parseInt(request.getParameter("cant"));
                      subtotal= precio*cant;
                         v.setItem(item);
                         v.setId(cod);
                         v.setDescripcionP(descripcion);
                         v.setPrecio(precio);
                         v.setCantidad(cant);
                         v.setSubtotal(subtotal); 
                      // EL OBJ VENTA ESTA CAPTURANDO LOS DATOS K SE INSERTANDESDE EL FORMULARIO
                          lista.add(v); // TODO EL OBJ K CONTIENE LOS VALORES SE EMPAKETA EN UNA LISTA
                          request.setAttribute("lista", lista);
// enviar los datis al formulario para k se muestren en la tabla se manda al formilarioo
                                  
                  break; 
        default:
        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
          }            
               request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        
      } 
       /*   switch (accion){
              case "Principal":
                  request.getRequestDispatcher("Principal.jsp").forward(request, response);
                  break;
                  case "Producto":
                  request.getRequestDispatcher("Producto.jsp").forward(request, response);
                  break;
                  case "Clientes":
                  request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                  break;
                  case "Empleado":
                  request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                  break;
                  case "NuevaVenta":
                  request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                  break;
              default:
                  throw new AssertionError();
          } */
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
