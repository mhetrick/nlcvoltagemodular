package com.nlc.numberwang;


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


public class Numberwang extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Numberwang( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Numberwang", ModuleType.ModuleType_Logic, 3.2 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "45b03a23d1114c9bab04e9049a581423" );
}

void InitializeControls()
{

	inJack1 = new VoltageAudioJack( "inJack1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( inJack1 );
	inJack1.SetWantsMouseNotifications( false );
	inJack1.SetPosition( 36, 58 );
	inJack1.SetSize( 25, 25 );
	inJack1.SetSkin( "Jack Round 25px" );

	inJack2 = new VoltageAudioJack( "inJack2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( inJack2 );
	inJack2.SetWantsMouseNotifications( false );
	inJack2.SetPosition( 66, 58 );
	inJack2.SetSize( 25, 25 );
	inJack2.SetSkin( "Jack Round 25px" );

	inJack3 = new VoltageAudioJack( "inJack3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( inJack3 );
	inJack3.SetWantsMouseNotifications( false );
	inJack3.SetPosition( 96, 58 );
	inJack3.SetSize( 25, 25 );
	inJack3.SetSkin( "Jack Round 25px" );

	inJack4 = new VoltageAudioJack( "inJack4", "In 4", this, JackType.JackType_AudioInput );
	AddComponent( inJack4 );
	inJack4.SetWantsMouseNotifications( false );
	inJack4.SetPosition( 126, 58 );
	inJack4.SetSize( 25, 25 );
	inJack4.SetSkin( "Jack Round 25px" );

	syncIn = new VoltageAudioJack( "syncIn", "Sync In", this, JackType.JackType_AudioInput );
	AddComponent( syncIn );
	syncIn.SetWantsMouseNotifications( false );
	syncIn.SetPosition( 170, 58 );
	syncIn.SetSize( 25, 25 );
	syncIn.SetSkin( "Jack Round 25px" );

	out11 = new VoltageAudioJack( "out11", "Out 1:1", this, JackType.JackType_AudioOutput );
	AddComponent( out11 );
	out11.SetWantsMouseNotifications( false );
	out11.SetPosition( 36, 112 );
	out11.SetSize( 25, 25 );
	out11.SetSkin( "Jack Round 25px" );

	out12 = new VoltageAudioJack( "out12", "Out 1:2", this, JackType.JackType_AudioOutput );
	AddComponent( out12 );
	out12.SetWantsMouseNotifications( false );
	out12.SetPosition( 81, 112 );
	out12.SetSize( 25, 25 );
	out12.SetSkin( "Jack Round 25px" );

	out13 = new VoltageAudioJack( "out13", "Out 1:3", this, JackType.JackType_AudioOutput );
	AddComponent( out13 );
	out13.SetWantsMouseNotifications( false );
	out13.SetPosition( 125, 112 );
	out13.SetSize( 25, 25 );
	out13.SetSkin( "Jack Round 25px" );

	out14 = new VoltageAudioJack( "out14", "Out 1:4", this, JackType.JackType_AudioOutput );
	AddComponent( out14 );
	out14.SetWantsMouseNotifications( false );
	out14.SetPosition( 170, 112 );
	out14.SetSize( 25, 25 );
	out14.SetSkin( "Jack Round 25px" );

	out15 = new VoltageAudioJack( "out15", "Out 1:5", this, JackType.JackType_AudioOutput );
	AddComponent( out15 );
	out15.SetWantsMouseNotifications( false );
	out15.SetPosition( 36, 170 );
	out15.SetSize( 25, 25 );
	out15.SetSkin( "Jack Round 25px" );

	out16 = new VoltageAudioJack( "out16", "Out 1:6", this, JackType.JackType_AudioOutput );
	AddComponent( out16 );
	out16.SetWantsMouseNotifications( false );
	out16.SetPosition( 81, 170 );
	out16.SetSize( 25, 25 );
	out16.SetSkin( "Jack Round 25px" );

	out17 = new VoltageAudioJack( "out17", "Out 1:7", this, JackType.JackType_AudioOutput );
	AddComponent( out17 );
	out17.SetWantsMouseNotifications( false );
	out17.SetPosition( 125, 170 );
	out17.SetSize( 25, 25 );
	out17.SetSkin( "Jack Round 25px" );

	out18 = new VoltageAudioJack( "out18", "Out 1:8", this, JackType.JackType_AudioOutput );
	AddComponent( out18 );
	out18.SetWantsMouseNotifications( false );
	out18.SetPosition( 170, 170 );
	out18.SetSize( 25, 25 );
	out18.SetSkin( "Jack Round 25px" );

	out19 = new VoltageAudioJack( "out19", "Out 1:9", this, JackType.JackType_AudioOutput );
	AddComponent( out19 );
	out19.SetWantsMouseNotifications( false );
	out19.SetPosition( 36, 227 );
	out19.SetSize( 25, 25 );
	out19.SetSkin( "Jack Round 25px" );

	out20 = new VoltageAudioJack( "out20", "Out 1:10", this, JackType.JackType_AudioOutput );
	AddComponent( out20 );
	out20.SetWantsMouseNotifications( false );
	out20.SetPosition( 81, 227 );
	out20.SetSize( 25, 25 );
	out20.SetSkin( "Jack Round 25px" );

	out21 = new VoltageAudioJack( "out21", "Out 1:11", this, JackType.JackType_AudioOutput );
	AddComponent( out21 );
	out21.SetWantsMouseNotifications( false );
	out21.SetPosition( 125, 227 );
	out21.SetSize( 25, 25 );
	out21.SetSkin( "Jack Round 25px" );

	out22 = new VoltageAudioJack( "out22", "Out 1:12", this, JackType.JackType_AudioOutput );
	AddComponent( out22 );
	out22.SetWantsMouseNotifications( false );
	out22.SetPosition( 170, 227 );
	out22.SetSize( 25, 25 );
	out22.SetSkin( "Jack Round 25px" );

	out23 = new VoltageAudioJack( "out23", "Out 1:13", this, JackType.JackType_AudioOutput );
	AddComponent( out23 );
	out23.SetWantsMouseNotifications( false );
	out23.SetPosition( 37, 288 );
	out23.SetSize( 25, 25 );
	out23.SetSkin( "Jack Round 25px" );

	out24 = new VoltageAudioJack( "out24", "Out 1:14", this, JackType.JackType_AudioOutput );
	AddComponent( out24 );
	out24.SetWantsMouseNotifications( false );
	out24.SetPosition( 82, 288 );
	out24.SetSize( 25, 25 );
	out24.SetSkin( "Jack Round 25px" );

	out25 = new VoltageAudioJack( "out25", "Out 1:15", this, JackType.JackType_AudioOutput );
	AddComponent( out25 );
	out25.SetWantsMouseNotifications( false );
	out25.SetPosition( 126, 288 );
	out25.SetSize( 25, 25 );
	out25.SetSkin( "Jack Round 25px" );

	out26 = new VoltageAudioJack( "out26", "Out 1:16", this, JackType.JackType_AudioOutput );
	AddComponent( out26 );
	out26.SetWantsMouseNotifications( false );
	out26.SetPosition( 171, 288 );
	out26.SetSize( 25, 25 );
	out26.SetSkin( "Jack Round 25px" );
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
private VoltageAudioJack out26;
private VoltageAudioJack out25;
private VoltageAudioJack out24;
private VoltageAudioJack out23;
private VoltageAudioJack out22;
private VoltageAudioJack out21;
private VoltageAudioJack out20;
private VoltageAudioJack out19;
private VoltageAudioJack out18;
private VoltageAudioJack out17;
private VoltageAudioJack out16;
private VoltageAudioJack out15;
private VoltageAudioJack out14;
private VoltageAudioJack out13;
private VoltageAudioJack out12;
private VoltageAudioJack out11;
private VoltageAudioJack syncIn;
private VoltageAudioJack inJack4;
private VoltageAudioJack inJack3;
private VoltageAudioJack inJack2;
private VoltageAudioJack inJack1;


//[user-code-and-variables]    Add your own variables and functions here
//[/user-code-and-variables]





}

 