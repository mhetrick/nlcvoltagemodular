package com.nlc.router;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//[/user-imports]


public class Router extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Router( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Router", ModuleType.ModuleType_Switches, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "6affd9ffefcf47aa9ba832bbb828a39a" );
}

void InitializeControls()
{

	cv1and2 = new VoltageAudioJack( "cv1and2", "CV 1 & 2", this, JackType.JackType_AudioInput );
	AddComponent( cv1and2 );
	cv1and2.SetWantsMouseNotifications( false );
	cv1and2.SetPosition( 6, 192 );
	cv1and2.SetSize( 25, 25 );
	cv1and2.SetSkin( "Jack Round 25px" );

	cv3and4 = new VoltageAudioJack( "cv3and4", "CV 3 & 4", this, JackType.JackType_AudioInput );
	AddComponent( cv3and4 );
	cv3and4.SetWantsMouseNotifications( false );
	cv3and4.SetPosition( 59, 193 );
	cv3and4.SetSize( 25, 25 );
	cv3and4.SetSkin( "Jack Round 25px" );

	in1 = new VoltageAudioJack( "in1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( in1 );
	in1.SetWantsMouseNotifications( false );
	in1.SetPosition( 6, 236 );
	in1.SetSize( 25, 25 );
	in1.SetSkin( "Jack Round 25px" );

	in2 = new VoltageAudioJack( "in2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( in2 );
	in2.SetWantsMouseNotifications( false );
	in2.SetPosition( 32, 236 );
	in2.SetSize( 25, 25 );
	in2.SetSkin( "Jack Round 25px" );

	in3 = new VoltageAudioJack( "in3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( in3 );
	in3.SetWantsMouseNotifications( false );
	in3.SetPosition( 59, 236 );
	in3.SetSize( 25, 25 );
	in3.SetSkin( "Jack Round 25px" );

	in4 = new VoltageAudioJack( "in4", "In 4", this, JackType.JackType_AudioInput );
	AddComponent( in4 );
	in4.SetWantsMouseNotifications( false );
	in4.SetPosition( 86, 236 );
	in4.SetSize( 25, 25 );
	in4.SetSkin( "Jack Round 25px" );

	out1 = new VoltageAudioJack( "out1", "Out 1", this, JackType.JackType_AudioOutput );
	AddComponent( out1 );
	out1.SetWantsMouseNotifications( false );
	out1.SetPosition( 6, 280 );
	out1.SetSize( 25, 25 );
	out1.SetSkin( "Jack Round 25px" );

	out2 = new VoltageAudioJack( "out2", "Out 2", this, JackType.JackType_AudioOutput );
	AddComponent( out2 );
	out2.SetWantsMouseNotifications( false );
	out2.SetPosition( 32, 280 );
	out2.SetSize( 25, 25 );
	out2.SetSkin( "Jack Round 25px" );

	out3 = new VoltageAudioJack( "out3", "Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( out3 );
	out3.SetWantsMouseNotifications( false );
	out3.SetPosition( 59, 280 );
	out3.SetSize( 25, 25 );
	out3.SetSkin( "Jack Round 25px" );

	out4 = new VoltageAudioJack( "out4", "Out 4", this, JackType.JackType_AudioOutput );
	AddComponent( out4 );
	out4.SetWantsMouseNotifications( false );
	out4.SetPosition( 86, 280 );
	out4.SetSize( 25, 25 );
	out4.SetSkin( "Jack Round 25px" );

	outAll = new VoltageAudioJack( "outAll", "Out All", this, JackType.JackType_AudioOutput );
	AddComponent( outAll );
	outAll.SetWantsMouseNotifications( false );
	outAll.SetPosition( 86, 193 );
	outAll.SetSize( 25, 25 );
	outAll.SetSkin( "Jack Round 25px" );

	knob1 = new VoltageKnob( "knob1", "knob1", this, 0.0, 1.0, 0.5 );
	AddComponent( knob1 );
	knob1.SetWantsMouseNotifications( false );
	knob1.SetPosition( 15, 47 );
	knob1.SetSize( 35, 35 );
	knob1.SetSkin( "Knurled Plastic White" );
	knob1.SetRange( 0.0, 1.0, 0.5, false, 0 );
	knob1.SetKnobParams( 215, 145 );
	knob1.DisplayValueInPercent( false );
	knob1.SetKnobAdjustsRing( true );

	knob2 = new VoltageKnob( "knob2", "knob2", this, 0.0, 1.0, 0.5 );
	AddComponent( knob2 );
	knob2.SetWantsMouseNotifications( false );
	knob2.SetPosition( 66, 70 );
	knob2.SetSize( 35, 35 );
	knob2.SetSkin( "Knurled Plastic White" );
	knob2.SetRange( 0.0, 1.0, 0.5, false, 0 );
	knob2.SetKnobParams( 215, 145 );
	knob2.DisplayValueInPercent( false );
	knob2.SetKnobAdjustsRing( true );

	knob3 = new VoltageKnob( "knob3", "knob3", this, 0.0, 1.0, 0.5 );
	AddComponent( knob3 );
	knob3.SetWantsMouseNotifications( false );
	knob3.SetPosition( 15, 95 );
	knob3.SetSize( 35, 35 );
	knob3.SetSkin( "Knurled Plastic White" );
	knob3.SetRange( 0.0, 1.0, 0.5, false, 0 );
	knob3.SetKnobParams( 215, 145 );
	knob3.DisplayValueInPercent( false );
	knob3.SetKnobAdjustsRing( true );

	knob4 = new VoltageKnob( "knob4", "knob4", this, 0.0, 1.0, 0.5 );
	AddComponent( knob4 );
	knob4.SetWantsMouseNotifications( false );
	knob4.SetPosition( 66, 116 );
	knob4.SetSize( 35, 35 );
	knob4.SetSkin( "Knurled Plastic White" );
	knob4.SetRange( 0.0, 1.0, 0.5, false, 0 );
	knob4.SetKnobParams( 215, 145 );
	knob4.DisplayValueInPercent( false );
	knob4.SetKnobAdjustsRing( true );
}



//-------------------------------------------------------------------------------
//  public void Initialize()

//  Initialize will get called shortly after your module's constructor runs. You can use it to
//  do any initialization that the auto-generated code doesn't handle.
//-------------------------------------------------------------------------------
@Override
public void Initialize()
{
	//[user-Initialize]   Add your own initialization code here



	//[/user-Initialize]
}


//-------------------------------------------------------------------------------
//  public void Destroy()

//  Destroy will get called just before your module gets deleted. You can use it to perform any
//  cleanup that's not handled automatically by Java.
//-------------------------------------------------------------------------------
@Override
public void Destroy()
{
	super.Destroy();
	//[user-Destroy]   Add your own module-getting-deleted code here



	//[/user-Destroy]
}


//-------------------------------------------------------------------------------
//  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

//  Notify will get called when various events occur - control values changing, timers firing, etc.
//-------------------------------------------------------------------------------
@Override
public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
{
	//[user-Notify]   Add your own notification handling code between this line and the notify-close comment
	switch( notification )
	{
		case Knob_Changed:   // doubleValue is the new VoltageKnob value
		{
		}
		break;
	
		case Slider_Changed:   // doubleValue is the new slider value
		{
		}
		break;
	
		case Button_Changed:   // doubleValue is the new button/toggle button value
		{
		}
		break;
	
		case Switch_Changed:   // doubleValue is the new switch value
		{
		}
		break;
	
		case Jack_Connected:   // longValue is the new cable ID
		{
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
		}
		break;
	
		case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
		{
		}
		break;
	
		case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
		{
		}
		break;
	
		case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
		{
		}
		break;
	
		case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
		{
		}
		break;
	
		case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
		{
		}
		break;
	
		case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
		{
		}
		break;
	
		case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
		{
		}
		break;
	
		case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
		{
		}
		break;
	
		// Less common notifications:
	
		case Named_Timer:   // object contains a String with the name of the timer that has fired
		{
		}
		break;
	
		case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
		{
		}
		break;
	
		case Canvas_Painted:   // Canvas painting is complete
		{
		}
		break;
	
		case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
		{
		}
		break;
	
		case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
		{
		}
		break;
	
		case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
		{
		}
		break;
	
		case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
		{
		}
		break;
	
		case Label_Changed:        // The text of an editable text control has changed
		{
		}
		break;
	
		case SoundPlayback_Start:   // A sound has begun playback
		{
		}
		break;
	
		case SoundPlayback_End:     // A sound has ended playback
		{
		}
		break;
	
		case Scrollbar_Position:    // longValue is the new scrollbar position
		{
		}
		break;
	
		case PolyVoices_Changed:    // longValue is the new number of poly voices
		{
		}
		break;
	
		case File_Dropped:     // 'object' is a String containing the file path
		{
		}
		break;
	
		case Preset_Loading_Start:   // called when preset loading begins
		{
		}
		break;
	
		case Preset_Loading_Finish:  // called when preset loading finishes
		{
		}
		break;
	
		case Variation_Loading_Start:    // sent when a variation is about to load
		{
		}
		break;
	
		case Variation_Loading_Finish:   // sent when a variation has just finished loading
		{
		}
		break;
	
		case Tempo_Changed:     // doubleValue is the new tempo
		{
		}
		break;
	
		case Randomized:     // called when the module's controls get randomized
		{
		}
		break;
	
		case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
		{
		}
		break;
	
		case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
		{
		}
		break;
	
		case Reset:    // sent when the module has been reset to default settings
		{
		}
		break;
	
		case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
		{
		}
		break;
	
		case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
		{
		}
		break;
	
		case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
		{
		}
		break;
	}



	return false;
	//[/user-Notify]
}


//-------------------------------------------------------------------------------
//  public void ProcessSample()

//  ProcessSample is called once per sample. Usually it's where you read
//  from input jacks, process audio, and write it to your output jacks.
//  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
//  to other threads when possible and avoid calling native functions.
//-------------------------------------------------------------------------------
@Override
public void ProcessSample()
{
	//[user-ProcessSample]   Add your own process-sampling code here



	//[/user-ProcessSample]
}


//-------------------------------------------------------------------------------
//  public String GetTooltipText( VoltageComponent component )

//  Gets called when a tooltip is about to display for a control. Override it if
//  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
//  for instance, you can translate the knob's current value to a log-based string and display it here.
//-------------------------------------------------------------------------------
@Override
public String GetTooltipText( VoltageComponent component )
{
	//[user-GetTooltipText]   Add your own code here



	return super.GetTooltipText( component );
	//[/user-GetTooltipText]
}


//-------------------------------------------------------------------------------
//  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

//  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
//  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
//  in GetTooltipText().
//-------------------------------------------------------------------------------
@Override
public void EditComponentValue( VoltageComponent component, double newValue, String newText )
{
	//[user-EditComponentValue]   Add your own code here



	//[/user-EditComponentValue]
	super.EditComponentValue( component, newValue, newText );
}


//-------------------------------------------------------------------------------
//  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

//  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
//  process them in this function when they get triggered by undo/redo actions.
//-------------------------------------------------------------------------------
@Override
public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
{
	//[user-OnUndoRedo]   Add your own code here



	//[/user-OnUndoRedo]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformation()

//  Gets called when the module's state gets saved, typically when the user saves a preset with
//  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformation()
{
	//[user-GetStateInformation]   Add your own code here



	return null;
	//[/user-GetStateInformation]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformation(byte[] stateInfo)

//  Gets called when this module's state is getting restored, typically when a user opens a preset with
//  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformation(byte[] stateInfo)
{
	//[user-SetStateInformation]   Add your own code here



	//[/user-SetStateInformation]
}


//-------------------------------------------------------------------------------
//  public byte[] GetStateInformationForVariations()

//  Gets called when a user saves a variation with this module in it.
//  Voltage Modular will automatically save the states of knobs, sliders, etc.,
//  but if you have any custom state information you need to save, return it from this function.
//-------------------------------------------------------------------------------
@Override
public byte[] GetStateInformationForVariations()
{
	//[user-GetStateInformationForVariations]   Add your own code here



	return GetStateInformation();
	//[/user-GetStateInformationForVariations]
}


//-------------------------------------------------------------------------------
//  public void SetStateInformationForVariations(byte[] stateInfo)

//  Gets called when a user loads a variation with this module in it.
//  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
//-------------------------------------------------------------------------------
@Override
public void SetStateInformationForVariations(byte[] stateInfo)
{
	//[user-SetStateInformationForVariations]   Add your own code here
	SetStateInformation(stateInfo);



	//[/user-SetStateInformationForVariations]
}


// Auto-generated variables
private VoltageKnob knob4;
private VoltageKnob knob3;
private VoltageKnob knob2;
private VoltageKnob knob1;
private VoltageAudioJack outAll;
private VoltageAudioJack out4;
private VoltageAudioJack out3;
private VoltageAudioJack out2;
private VoltageAudioJack out1;
private VoltageAudioJack in4;
private VoltageAudioJack in3;
private VoltageAudioJack in2;
private VoltageAudioJack in1;
private VoltageAudioJack cv3and4;
private VoltageAudioJack cv1and2;


//[user-code-and-variables]    Add your own variables and functions here
//[/user-code-and-variables]





}

 