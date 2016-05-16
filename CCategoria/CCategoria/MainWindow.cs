using System;
using Gtk;
using System.Data;
using MySql.Data.MySqlClient;
using CCategoria;
public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();


		treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("nombre", new CellRendererText(), "text", 1);

		ListStore liststore = new ListStore(typeof(long), typeof(string));
		treeView.Model = liststore;

		//liststore.AppendValues (33L, "Treinta y tres");

		App.Instance.DbConnection = new MySqlConnection 
			("Database=dbprueba;user=root;password=sistema");
		App.Instance.DbConnection.Open ();

		filListstore (liststore);

		newAction.Activated += delegate {
			CCategoria.CategoriaView categoriaView = new CCategoria.CategoriaView(); 
		};

		deleteAction.Activated += delegate {

			//confirmar 
//			MessageDialog messagedialog =new MessageDialog(
//				this,
//				DialogFlags.Modal,
//				MessageType.Question,
//				ButtonsType.YesNo,
//				"¿QUIERES ELMINAR EL REGISTRO?"
//			);
//			messagedialog.Title=Title;
//			ResponseType response = (ResponseType)messagedialog.Run();
//			messagedialog.Destroy();
//
//			if (response!=ResponseType.Yes)
//				return;

			if (!WindowHelper.Confirm(this,"¿QUIERES ELMINAR EL REGISTRO?"))
				return;

			TreeIter treeIter;
		    treeView.Selection.GetSelected(out treeIter);
			object id = liststore.GetValue(treeIter,0);

			Console.WriteLine ("deleteAction Activated id = {0}" , id);
			IDbCommand deletedbcommand =App.Instance.DbConnection.CreateCommand();


			deletedbcommand.CommandText = "delete from categoria where id=  @id";
			DBHelper.DbCommandAddParameter(deletedbcommand, "id", id);
			deletedbcommand.ExecuteNonQuery();

		};

		treeView.Selection.Changed += delegate {
			Console.WriteLine ("treeView  Selection Changed CountSelectedRows()={0}",
			                   treeView.Selection.CountSelectedRows());
			updateActions();

		};


		refreshAction.Activated += delegate {
			filListstore (liststore);

		};

		updateActions();
		//dbConnection.Close ();

	}

	private void updateActions(){

		deleteAction.Sensitive = treeView.Selection.CountSelectedRows() > 0;

	}

	private void filListstore(ListStore liststore){
		liststore.Clear ();
		IDbCommand dbcommand = App.Instance.DbConnection.CreateCommand ();
		dbcommand.CommandText = "select * from categoria";
		IDataReader dataReader = dbcommand.ExecuteReader ();
		while (dataReader.Read()) {
			//Console.WriteLine ("id={0} nombre={1}", dataReader ["id"], dataReader ["nombre"]);
			liststore.AppendValues (dataReader ["id"], dataReader ["nombre"]);
		}
		dataReader.Close ();
	}
	
	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
	
	protected void OnNewActionActivated (object sender, EventArgs e)
	{

	}
}