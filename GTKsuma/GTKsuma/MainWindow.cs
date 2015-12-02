using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}
	
	protected void OnButton1Clicked (object sender, EventArgs e)
	{
		decimal label1 = decimal.Parse (entry1.Text);
		decimal label2 = decimal.Parse (entry2.Text);
		decimal label3 = label1 + label2;

		resultado.Text = label3.ToString();
	}
}
