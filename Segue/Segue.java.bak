package com.nlc.segue;


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


public class Segue extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Segue( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Segue", ModuleType.ModuleType_Utility, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "cbbad993b1464e6d92a9f33d1b10bef2" );
}

void InitializeControls()
{

	inputLJack = new VoltageAudioJack( "Input", "Input", this, JackType.JackType_AudioInput );
	AddComponent( inputLJack );
	inputLJack.SetWantsMouseNotifications( false );
	inputLJack.SetPosition( 14, 238 );
	inputLJack.SetSize( 25, 25 );
	inputLJack.SetSkin( "Jack Round 25px" );

	inputRJack = new VoltageAudioJack( "Input_1", "Input_1", this, JackType.JackType_AudioInput );
	AddComponent( inputRJack );
	inputRJack.SetWantsMouseNotifications( false );
	inputRJack.SetPosition( 78, 238 );
	inputRJack.SetSize( 25, 25 );
	inputRJack.SetSkin( "Jack Round 25px" );

	outputLJack = new VoltageAudioJack( "Output", "Output", this, JackType.JackType_AudioOutput );
	AddComponent( outputLJack );
	outputLJack.SetWantsMouseNotifications( false );
	outputLJack.SetPosition( 29, 291 );
	outputLJack.SetSize( 25, 25 );
	outputLJack.SetSkin( "Jack Round 25px" );

	outputRJack = new VoltageAudioJack( "Output_1", "Output_1", this, JackType.JackType_AudioOutput );
	AddComponent( outputRJack );
	outputRJack.SetWantsMouseNotifications( false );
	outputRJack.SetPosition( 63, 291 );
	outputRJack.SetSize( 25, 25 );
	outputRJack.SetSkin( "Jack Round 25px" );

	cvInput = new VoltageAudioJack( "Pan CV", "Pan CV", this, JackType.JackType_AudioInput );
	AddComponent( cvInput );
	cvInput.SetWantsMouseNotifications( false );
	cvInput.SetPosition( 46, 212 );
	cvInput.SetSize( 25, 25 );
	cvInput.SetSkin( "Jack Round 25px" );

	amountKnob = new VoltageKnob( "Pan", "Pan", this, 0.0, 1.0, 0.0 );
	AddComponent( amountKnob );
	amountKnob.SetWantsMouseNotifications( false );
	amountKnob.SetPosition( 43, 116 );
	amountKnob.SetSize( 29, 29 );
	amountKnob.SetSkin( "Dial Sky" );
	amountKnob.SetRange( 0.0, 1.0, 0.0, true, 0 );
	amountKnob.SetKnobParams( 215, 145 );
	amountKnob.DisplayValueInPercent( true );
	amountKnob.SetKnobAdjustsRing( true );

	gain1Knob = new VoltageKnob( "gainX", "Gain X", this, 0.0, 1.0, 1.0 );
	AddComponent( gain1Knob );
	gain1Knob.SetWantsMouseNotifications( false );
	gain1Knob.SetPosition( 11, 53 );
	gain1Knob.SetSize( 29, 29 );
	gain1Knob.SetSkin( "Dial Sky" );
	gain1Knob.SetRange( 0.0, 1.0, 1.0, true, 0 );
	gain1Knob.SetKnobParams( 215, 145 );
	gain1Knob.DisplayValueInPercent( true );
	gain1Knob.SetKnobAdjustsRing( true );

	gain2Knob = new VoltageKnob( "gainY", "Gain Y", this, 0.0, 1.0, 1.0 );
	AddComponent( gain2Knob );
	gain2Knob.SetWantsMouseNotifications( false );
	gain2Knob.SetPosition( 76, 54 );
	gain2Knob.SetSize( 29, 29 );
	gain2Knob.SetSkin( "Dial Sky" );
	gain2Knob.SetRange( 0.0, 1.0, 1.0, true, 0 );
	gain2Knob.SetKnobParams( 215, 145 );
	gain2Knob.DisplayValueInPercent( true );
	gain2Knob.SetKnobAdjustsRing( true );

	cvDepth = new VoltageKnob( "Pan CV Depth", "Pan CV Depth", this, -1.0, 1.0, 0.0 );
	AddComponent( cvDepth );
	cvDepth.SetWantsMouseNotifications( false );
	cvDepth.SetPosition( 48, 177 );
	cvDepth.SetSize( 20, 20 );
	cvDepth.SetSkin( "Plastic Black" );
	cvDepth.SetRange( -1.0, 1.0, 0.0, false, 0 );
	cvDepth.SetKnobParams( 215, 145 );
	cvDepth.DisplayValueInPercent( true );
	cvDepth.SetKnobAdjustsRing( true );
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
			if (component == amountKnob)
			{
				// If the Volume knob is turned, set out
				// SmoothValue object to the new volume value.
				amountValue.SetValue(doubleValue);
			}
			else if (component == gain1Knob)
			{
				gain1Value.SetValue(doubleValue);
			}
			else if (component == gain2Knob)
			{
				gain2Value.SetValue(doubleValue);
			}
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
	
		// Less-common notifications:
	
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
	
		case Canvas_MouseMove:   // The mouse has moved over a Canvas object
		{
		}
		break;
	
		case Canvas_LeftButtonDown:   // The user has left-clicked on a Canvas object
		{
		}
		break;
	
		case Canvas_LeftButtonUp:   // The user has released left-click on a Canvas object
		{
		}
		break;
	
		case Canvas_RightButtonDown:   // The user has right-clicked on a Canvas object
		{
		}
		break;
	
		case Canvas_RightButtonUp:   // The user has released left-click on a Canvas object
		{
		}
		break;
	
		case Canvas_MouseLeave:   // The mouse has moved off a Canvas object
		{
		}
		break;
	
		case Control_DragStart:   // A user has started dragging on a control that has been marked as dragable
		{
		}
		break;
	
		case Control_DragOn:   // This control has been dragged over during a drag operation. object contains the dragged object
		{
		}
		break;
	
		case Control_DragOff:   // This control has been dragged over during a drag operation. object contains the dragged object
		{
		}
		break;
	
		case Control_DragEnd:   // A user has ended their drag on a control that has been marked as dragable
		{
		}
		break;
	
		case Label_Changed:   // The text of an editable text control has changed
		{
		}
		break;
	
		case SoundPlayback_Start: // A sound has begun playback
		{
		}
		break;
	
		case SoundPlayback_End:    // A sound has ended playback
		{
		}
		break;
	
		case Scrollbar_Position:    // longValue is the new scrollbar position
		{
		}
		break;
	
		case PolyVoices_Changed:    // longValue is the new number of Poly Voices
		{
		}
		break;
	
		case File_Dropped:        // 'object' is a String containing the file path
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
	double inputL = inputLJack.GetValue() * gain1Value.GetSmoothValue();
	double inputR = inputRJack.GetValue() * gain2Value.GetSmoothValue();

	double panInput = amountValue.GetSmoothValue();
	panInput = panInput + ((cvInput.GetValue() * cvDepth.GetValue()) * 0.2);
	if(panInput < 0.0) panInput = 0.0;
	if(panInput > 1.0) panInput = 1.0;
	
	double pan = panInput;
	double outL, outR;
	
	outL = LERP(pan, inputR, inputL);
	outR = LERP(pan, inputL, inputR);

	outputLJack.SetValue(outL);
	outputRJack.SetValue(outR);
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
private VoltageKnob cvDepth;
private VoltageKnob gain2Knob;
private VoltageKnob gain1Knob;
private VoltageKnob amountKnob;
private VoltageAudioJack cvInput;
private VoltageAudioJack outputRJack;
private VoltageAudioJack outputLJack;
private VoltageAudioJack inputRJack;
private VoltageAudioJack inputLJack;


//[user-code-and-variables]    Add your own variables and functions here

private SmoothValue amountValue = new SmoothValue();
private SmoothValue gain1Value = new SmoothValue();
private SmoothValue gain2Value = new SmoothValue();

private double LERP(double _amountOfA, double _inA, double _inB)
{
  return ((_amountOfA*_inA)+((1.0-_amountOfA)*_inB));
}

//[/user-code-and-variables]
}

 