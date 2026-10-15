
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Bitacora {
    String folio, tiempo, tipo, observaciones, infantesCurp, responsablesCurp, educadoresCurp;

    public Bitacora() {
    }
    static String todos = "SELECT * FROM bitacora ORDER BY folio DESC";

    public Bitacora(String folio, String tiempo, String tipo, String observaciones, String infantesCurp, String responsablesCurp, String educadoresCurp) {
        this.folio = folio;
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.observaciones = observaciones;
        this.infantesCurp = infantesCurp;
        this.responsablesCurp = responsablesCurp;
        this.educadoresCurp = educadoresCurp;
    }
    
    public int Insertar(Connection con){
        int resultado = 0;
        try {
            String sql = "INSERT INTO responsables VALUE(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            ps.setString(2, tiempo);
            ps.setString(3, tipo);
            ps.setString(4, observaciones);
            ps.setString(5, infantesCurp);
            ps.setString(6, responsablesCurp);
            ps.setString(7, educadoresCurp);
            return ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int borrar(Connection con){
        int resultado = 0;
        try {
            String sql = "DELETE FROM responsables WHERE curp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
    
    public int actualizar(Connection con){
        int resultado = 0;
        try {
            String sql = "UPDATE responsables SET tiempo = ?, tipo = ?, observaciones = ?, infantesCurp = ?, responsablesCurp = ?, educadoresCurp = ?  WHERE folio = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tiempo);
            ps.setString(2, tipo);
            ps.setString(3, observaciones);
            ps.setString(4, infantesCurp);
            ps.setString(5, responsablesCurp);
            ps.setString(6, educadoresCurp);
            ps.setString(7, folio);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }


    
    
}
