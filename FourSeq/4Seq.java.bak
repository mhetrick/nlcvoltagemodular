package com.nlc.fourseq;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
class NLCTrigger 
{
	boolean state = true;

	void reset() 
	{
		state = true;
	}

	boolean process(double in) {
		if (state) {
			// HIGH to LOW
			if (in < 1.0) 
			{
				state = false;
			}
		}
		else {
			// LOW to HIGH
			if (in >= 1.0) 
			{
				state = true;
				return true;
			}
		}
		return false;
	}

	boolean isHigh() 
	{
		return state;
	}
};


//[/user-imports]


public class FourSeq extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public FourSeq( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "4Seq", ModuleType.ModuleType_Sequencers, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "ad54b8154e0b4b05bf84e6c419350f51" );
}

void InitializeControls()
{

	knob1 = new VoltageKnob( "knob1", "X0/Y3", this, 0.0, 5.0, 0.0 );
	AddComponent( knob1 );
	knob1.SetWantsMouseNotifications( false );
	knob1.SetPosition( 12, 53 );
	knob1.SetSize( 35, 35 );
	knob1.SetSkin( "Knurled Plastic White" );
	knob1.SetRange( 0.0, 5.0, 0.0, false, 0 );
	knob1.SetKnobParams( 215, 145 );
	knob1.DisplayValueInPercent( true );
	knob1.SetKnobAdjustsRing( true );

	knob2 = new VoltageKnob( "knob2", "X1/Y2", this, 0.0, 5.0, 0.0 );
	AddComponent( knob2 );
	knob2.SetWantsMouseNotifications( false );
	knob2.SetPosition( 68, 71 );
	knob2.SetSize( 35, 35 );
	knob2.SetSkin( "Knurled Plastic White" );
	knob2.SetRange( 0.0, 5.0, 0.0, false, 0 );
	knob2.SetKnobParams( 215, 145 );
	knob2.DisplayValueInPercent( true );
	knob2.SetKnobAdjustsRing( true );

	knob3 = new VoltageKnob( "knob3", "X2/Y1", this, 0.0, 5.0, 0.0 );
	AddComponent( knob3 );
	knob3.SetWantsMouseNotifications( false );
	knob3.SetPosition( 13, 101 );
	knob3.SetSize( 35, 35 );
	knob3.SetSkin( "Knurled Plastic White" );
	knob3.SetRange( 0.0, 5.0, 0.0, false, 0 );
	knob3.SetKnobParams( 215, 145 );
	knob3.DisplayValueInPercent( true );
	knob3.SetKnobAdjustsRing( true );

	knob4 = new VoltageKnob( "knob4", "X3/Y0", this, 0.0, 1.0, 0.0 );
	AddComponent( knob4 );
	knob4.SetWantsMouseNotifications( false );
	knob4.SetPosition( 69, 123 );
	knob4.SetSize( 35, 35 );
	knob4.SetSkin( "Knurled Plastic White" );
	knob4.SetRange( 0.0, 1.0, 0.0, false, 0 );
	knob4.SetKnobParams( 215, 145 );
	knob4.DisplayValueInPercent( true );
	knob4.SetKnobAdjustsRing( true );

	clockInput = new VoltageAudioJack( "clockInput", "Clock In", this, JackType.JackType_AudioInput );
	AddComponent( clockInput );
	clockInput.SetWantsMouseNotifications( false );
	clockInput.SetPosition( 3, 204 );
	clockInput.SetSize( 25, 25 );
	clockInput.SetSkin( "Jack Round 25px" );

	directionJack = new VoltageAudioJack( "directionJack", "Up/Down", this, JackType.JackType_AudioInput );
	AddComponent( directionJack );
	directionJack.SetWantsMouseNotifications( false );
	directionJack.SetPosition( 32, 204 );
	directionJack.SetSize( 25, 25 );
	directionJack.SetSkin( "Jack Round 25px" );

	outXJack = new VoltageAudioJack( "outXJack", "Out X", this, JackType.JackType_AudioOutput );
	AddComponent( outXJack );
	outXJack.SetWantsMouseNotifications( false );
	outXJack.SetPosition( 60, 224 );
	outXJack.SetSize( 25, 25 );
	outXJack.SetSkin( "Jack Round 25px" );

	outYJack = new VoltageAudioJack( "outYJack", "Out Y", this, JackType.JackType_AudioOutput );
	AddComponent( outYJack );
	outYJack.SetWantsMouseNotifications( false );
	outYJack.SetPosition( 88, 224 );
	outYJack.SetSize( 25, 25 );
	outYJack.SetSkin( "Jack Round 25px" );

	div2Jack = new VoltageAudioJack( "div2Jack", "Div 2", this, JackType.JackType_AudioOutput );
	AddComponent( div2Jack );
	div2Jack.SetWantsMouseNotifications( false );
	div2Jack.SetPosition( 5, 270 );
	div2Jack.SetSize( 25, 25 );
	div2Jack.SetSkin( "Jack Round 25px" );

	div4Jack = new VoltageAudioJack( "div4Jack", "Div 4", this, JackType.JackType_AudioOutput );
	AddComponent( div4Jack );
	div4Jack.SetWantsMouseNotifications( false );
	div4Jack.SetPosition( 32, 270 );
	div4Jack.SetSize( 25, 25 );
	div4Jack.SetSkin( "Jack Round 25px" );

	div8Jack = new VoltageAudioJack( "div8Jack", "Div 8", this, JackType.JackType_AudioOutput );
	AddComponent( div8Jack );
	div8Jack.SetWantsMouseNotifications( false );
	div8Jack.SetPosition( 60, 270 );
	div8Jack.SetSize( 25, 25 );
	div8Jack.SetSkin( "Jack Round 25px" );

	div16Jack = new VoltageAudioJack( "div16Jack", "Div 16", this, JackType.JackType_AudioOutput );
	AddComponent( div16Jack );
	div16Jack.SetWantsMouseNotifications( false );
	div16Jack.SetPosition( 87, 270 );
	div16Jack.SetSize( 25, 25 );
	div16Jack.SetSkin( "Jack Round 25px" );

	LED1 = new VoltageLED( "LED1", "LED1", this );
	AddComponent( LED1 );
	LED1.SetWantsMouseNotifications( false );
	LED1.SetPosition( 12, 303 );
	LED1.SetSize( 11, 11 );
	LED1.SetSkin( "Silver Backed Red" );

	LED2 = new VoltageLED( "LED2", "LED2", this );
	AddComponent( LED2 );
	LED2.SetWantsMouseNotifications( false );
	LED2.SetPosition( 38, 303 );
	LED2.SetSize( 11, 11 );
	LED2.SetSkin( "Silver Backed Red" );

	LED3 = new VoltageLED( "LED3", "LED3", this );
	AddComponent( LED3 );
	LED3.SetWantsMouseNotifications( false );
	LED3.SetPosition( 67, 303 );
	LED3.SetSize( 11, 11 );
	LED3.SetSkin( "Silver Backed Red" );

	LED4 = new VoltageLED( "LED4", "LED4", this );
	AddComponent( LED4 );
	LED4.SetWantsMouseNotifications( false );
	LED4.SetPosition( 95, 303 );
	LED4.SetSize( 11, 11 );
	LED4.SetSkin( "Silver Backed Red" );
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
	
	StartGuiUpdateTimer();
	
	for (int i = 0; i < 4; i++)
	{
			steps[i] = 0.0f;
			divBools[i] = false;
	}

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
			if(component == knob1) steps[0] = doubleValue;
			else if (component == knob2) steps[1] = doubleValue;
			else if (component == knob3) steps[2] = doubleValue;
			else if (component == knob4) steps[3] = doubleValue;
		
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
			LED1.SetValue(divBools[0] ? 1.0 : 0.0);
			LED2.SetValue(divBools[1] ? 1.0 : 0.0);
			LED3.SetValue(divBools[2] ? 1.0 : 0.0);
			LED4.SetValue(divBools[3] ? 1.0 : 0.0);
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
	if(clockIn.process(clockInput.GetValue()))
	{
		boolean backwards = directionJack.GetValue() > 1.0;
		if(!backwards) xStep = xStep + 1;
		else xStep = xStep - 1;
		
		if(xStep > 3) xStep = 0;
		else if (xStep < 0) xStep = 3;

		if(stepCount == 16) stepCount = 1;
		else stepCount++;

		for(int i = 0; i < 4; i++)
		{
			divBools[i] = !divBools[i];
			if(divBools[i]) break;
		}
	}

	outXJack.SetValue(steps[xStep]);
	outYJack.SetValue(steps[3 - xStep]);
	
	div2Jack.SetValue(divBools[0] ? 5.0 : 0.0);
	div4Jack.SetValue(divBools[1] ? 5.0 : 0.0);
	div8Jack.SetValue(divBools[2] ? 5.0 : 0.0);
	div16Jack.SetValue(divBools[3] ? 5.0 : 0.0);


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
private VoltageLED LED4;
private VoltageLED LED3;
private VoltageLED LED2;
private VoltageLED LED1;
private VoltageAudioJack div16Jack;
private VoltageAudioJack div8Jack;
private VoltageAudioJack div4Jack;
private VoltageAudioJack div2Jack;
private VoltageAudioJack outYJack;
private VoltageAudioJack outXJack;
private VoltageAudioJack directionJack;
private VoltageAudioJack clockInput;
private VoltageKnob knob4;
private VoltageKnob knob3;
private VoltageKnob knob2;
private VoltageKnob knob1;


//[user-code-and-variables]    Add your own variables and functions here


private boolean[] divBools = new boolean[4];
private double[] steps = new double[4];

private int xStep = 0;
private int stepCount = 0;

private NLCTrigger clockIn = new NLCTrigger();


//[/user-code-and-variables]
}

 