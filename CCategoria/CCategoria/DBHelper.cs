using System;
using System.Data;

namespace CCategoria
{
	public class DBHelper
	{
		public static void DbCommandAddParameter(IDbCommand dbCommand, string parameterName, object value){
			IDbDataParameter dbDataParameter = dbCommand.CreateParameter();
			dbDataParameter.ParameterName = parameterName;
			dbDataParameter.Value = value;
			dbCommand.Parameters.Add(dbDataParameter);
		}
	}
}

