package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validar extends HttpServlet {
    EmpleadoDAO edao= new EmpleadoDAO(); // instanciando la clase dao modelo
// EL METODO DE LA CLA SE EMPEADODAO ES DE TIPO EMPLEADO X ESO SE INSTANCIA LA CLASE EMPELADPO
    Empleado em= new Empleado(); 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        String accion = request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            em = edao.Validar(user, pass);
            if (em.getUser() !=null)    {
                request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);
            } else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
      */
      
    }

 
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

//  SE VALIDA AL LOGIN 
String accion = request.getParameter("accion");
  if(accion.equalsIgnoreCase("Ingresar")){
       String user=request.getParameter("txtuser");
       String pass=request.getParameter("txtpass");
       
       em=edao.Validar(user, pass); // el metod validar contiene user and pass
           if(em.getUser()!=null){
               request.setAttribute("usuario", em); // se save/contiene el usuario en la varibal  em y se envia ala interfaz de izk para capoturar el usuario logeado
               
               System.out.println("here this" + user + pass);       
               System.out.println("user && nameuser this" + em.getUser() + em.getNom());       
               
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                System.out.println("ENTRO DONDE SEGUN ENTRA EN LA PRINCIPAL del Validar this");       
            }else{
              request.getRequestDispatcher("index.jsp").forward(request, response);
               System.out.println("ENTRO EN EL ELSE de la principal del Validar this");       
           }
  } else{ // si el usuario presiona otro boton yno al de ingresar 
      request.getRequestDispatcher("index.jsp").forward(request, response);
      System.out.println("SALIENDO DEL Validar this");       
   }

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
