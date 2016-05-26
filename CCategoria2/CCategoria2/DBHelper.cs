using System;
using System.Data;

namespace CCategoria2
{
	public class DBHelper
	{
		public static void DBcommand(IDbCommand dbcommand, String parametername, object value){
			IDbDataParameter dbdataparameter = dbcommand.CreateParameter ();
			dbdataparameter.ParameterName = parametername;

		}
	}
}

