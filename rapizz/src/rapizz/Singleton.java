package rapizz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
		private Connection cnx;
		private static Singleton instance;

		private Singleton() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("PB Chargement Driver MySQL");
			}
			
			try {
				cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/rapizz?user=user&password=user&serverTimezone=UTC");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("PB Connexion � la BD");
			}
		}
		
		public static Singleton getInstance() {
			if(instance == null) {
				instance = new Singleton();
			}
			return instance;
		}
		
		public Connection getConnection() {
			return cnx;
		}
}
