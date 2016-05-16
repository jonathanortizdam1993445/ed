using System;
using System.Data;

namespace CCategoria
{
	public partial class Categoriaview : Gtk.Window
	{
		public Categoriaview () : 
				base(Gtk.WindowType.Toplevel)
		{
			this.Build ();
			saveAction.Activated += delegate {
				Console.WriteLine ("SaveAction:Activated");

				IDbCommand dbcommand =App.Instance.DBconnection.CreateCommand();
				dbcommand.CommandText="insert into categoria (nombre): values {@nombre}";
				String nombre =entry1.Text;

			};

		}
		private void dbcommandparameter(IDbCommand dbcommand, string parameternombre){
		IDbDataParameter dbDataParameter=dbcommand.CreateParameter();
		dbDataParameter.ParameterName ="nombre";
		dbDataParameter.Value=Value;
		dbcommand.ExecuteNonQuery();

		}
	}
}

