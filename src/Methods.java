import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

public class Methods extends ConnectionDDBB{
    static Scanner sc=new Scanner(System.in);

    //PROCEDURE -> CREAR TABLA E INSERTAR VALUES

    public void create_insert_emfermos_doctores(){
        Connection connection=openConnectionDDBB();
        try {
            Statement st=connection.createStatement();

            ResultSet result=st.executeQuery("{call hospital.procedure_new_insert_table_enfermos_doctores}");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(connection);
        }
    }

    //FUNCTIONS
    //recibe doctor, devuelve cantidad de pacientes
    public void quantity_patient_to_doctor(){
        String doctor_name=AdditionalMethods.ask_for_varchar("apellido del doctor");

        Connection connection=openConnectionDDBB();
        try {
            CallableStatement cs=connection.prepareCall("{call hospital.function_quantity_patients(?)}");
            cs.setString(1,doctor_name);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println("El doctor "+doctor_name+" lleva a "+cs.getInt(1)+" pacientes.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(connection);
        }

    }




}
