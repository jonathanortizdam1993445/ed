using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		//poner los datos en modo tabla
		treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

		//crea un listado
		ListStore liststore = new ListStore (typeof(long),typeof(string));
		treeView.Model = liststore;

		//permitir conexion a la base de datos 
		IDbConnection dbconnection =new MySqlConnection("database=dbprueba; user=root; password=sistema;");
		dbconnection.Open ();

		//las operaciones que corresponda

		//para leer las lineas de la base de datos
		IDbCommand dbcommand = dbconnection.CreateCommand ();
		dbcommand.CommandText = "select * from categoria";	

		IDataReader datareader=dbcommand.ExecuteReader();

		while (datareader.Read())
			//añadir los datos de la base de datos a la lista
			liststore.AppendValues(datareader["id"], datareader["nombre"]);

			//Console.WriteLine("id={0} nombre={1}", datareader["id"], datareader["nombre"]);
			datareader.Close();







		dbconnection.Close ();
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
}
