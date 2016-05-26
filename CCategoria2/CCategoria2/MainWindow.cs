using CCategoria2;
using System;
using Gtk;
using System.Data;



public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
		treeView.AppendColumn ("id", new CellRendererText (), "text", 0);
		treeView.AppendColumn ("nombre", new CellRendererText (), "text", 1);

		ListStore listStore = new ListStore (typeof(long), typeof(string));
		treeView.Model = listStore;

		fillListStore (listStore);

		deleteAction.Sensitive = false;

		newAction.Activated += delegate {
			new Categoriaview ();
		};

		treeView.Selection.Changed += delegate{
			deleteAction.Sensitive =treeView.Selection.CountSelectedRows() > 0;
		};


		deleteAction.Activated += delegate {
			MessageDialog menssagedialog =new MessageDialog(
				this,
			    DialogFlags.Modal,
				MessageType.Question,
				ButtonsType.YesNo,
				"¿Quieres eliminar el registro?"
		};

		ResponseType response =(ResponseType)

	}

	private void fillListStore (ListStore listStore) {
		IDbCommand dbCommand = App.Instace.DbConnection.CreateCommand ();
		dbCommand.CommandText = "select * from categoria order by id";
		IDataReader dataReader = dbCommand.ExecuteReader ();
		while (dataReader.Read())
			listStore.AppendValues (dataReader ["id"], dataReader ["nombre"]);
		dataReader.Close ();
	}



	protected void OnDeleteEvent (object sender, DeleteEventArgs a)

	{
		Application.Quit ();
		a.RetVal = true;
	}
}
