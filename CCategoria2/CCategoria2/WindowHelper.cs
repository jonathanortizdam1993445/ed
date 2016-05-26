using System;
using Gtk;

namespace CCategoria2
{
	public class WindowHelper
	{
		public static bool confirm(Window parent, String message){
		
			MessageDialog messagedialog = new MessageDialog(
			DialogFlags.Modal,
			MessageType.Question,
			ButtonsType.YesNo,
			messagedialog
			);
		};

		ResponseType response =(ResponseType) MessageDialog.Run();

	}
}

