
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author jvergara <jvergara@gocatapult.com>
 */
public class TestJDBCTxn
{

    @Test
    public void test1()
    {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcurl = "jdbc:postgresql://localhost/testdb";
            con = DriverManager.getConnection(jdbcurl, "postgres", "Change1234");
            con.setAutoCommit(false);
            
            String sql = "insert into template"
                + "(id)"
                + "values(?)";
            
            update(con, sql, 10L);
            update(con, sql, 20L);
            update(con, sql, 30L);
            update(con, sql, 30L);
            
            con.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try { con.rollback(); } catch (SQLException ex) {}
        }
        finally  {
            try { con.close(); }catch (Exception e){}
        }
    }
    
    private void update(Connection con, String sql, Object ... args) throws Exception
    {
        PreparedStatement stm = con.prepareStatement(sql);
        for (int i=0; i<args.length; ++i) {
            stm.setObject(i+1, args[i]);
        }
        stm.executeUpdate();
        stm.close();
    }
}
