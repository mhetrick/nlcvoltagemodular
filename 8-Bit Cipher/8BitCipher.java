package com.nlc.cipher;


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


public class Cipher extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Cipher( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "8-Bit Cipher", ModuleType.ModuleType_Logic, 4.0 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "3022f1c3de994e31bf75a3d2f3e6a6e3" );
}

void InitializeControls()
{

	clockInput = new VoltageAudioJack( "clockInput", "Clock In", this, JackType.JackType_AudioInput );
	AddComponent( clockInput );
	clockInput.SetWantsMouseNotifications( false );
	clockInput.SetPosition( 19, 297 );
	clockInput.SetSize( 25, 25 );
	clockInput.SetSkin( "Jack Round 25px" );

	data1 = new VoltageAudioJack( "data1", "Data 1", this, JackType.JackType_AudioInput );
	AddComponent( data1 );
	data1.SetWantsMouseNotifications( false );
	data1.SetPosition( 47, 297 );
	data1.SetSize( 25, 25 );
	data1.SetSkin( "Jack Round 25px" );

	data2 = new VoltageAudioJack( "data2", "Data 2", this, JackType.JackType_AudioInput );
	AddComponent( data2 );
	data2.SetWantsMouseNotifications( false );
	data2.SetPosition( 75, 297 );
	data2.SetSize( 25, 25 );
	data2.SetSkin( "Jack Round 25px" );

	strobeJack = new VoltageAudioJack( "strobeJack", "Strobe", this, JackType.JackType_AudioInput );
	AddComponent( strobeJack );
	strobeJack.SetWantsMouseNotifications( false );
	strobeJack.SetPosition( 103, 297 );
	strobeJack.SetSize( 25, 25 );
	strobeJack.SetSkin( "Jack Round 25px" );

	cvOut1 = new VoltageAudioJack( "cvOut1", "CV 1", this, JackType.JackType_AudioOutput );
	AddComponent( cvOut1 );
	cvOut1.SetWantsMouseNotifications( false );
	cvOut1.SetPosition( 160, 297 );
	cvOut1.SetSize( 25, 25 );
	cvOut1.SetSkin( "Jack Round 25px" );

	cvOut2 = new VoltageAudioJack( "cvOut2", "CV 2", this, JackType.JackType_AudioOutput );
	AddComponent( cvOut2 );
	cvOut2.SetWantsMouseNotifications( false );
	cvOut2.SetPosition( 189, 297 );
	cvOut2.SetSize( 25, 25 );
	cvOut2.SetSkin( "Jack Round 25px" );

	cvOut3 = new VoltageAudioJack( "cvOut3", "CV 3", this, JackType.JackType_AudioOutput );
	AddComponent( cvOut3 );
	cvOut3.SetWantsMouseNotifications( false );
	cvOut3.SetPosition( 217, 297 );
	cvOut3.SetSize( 25, 25 );
	cvOut3.SetSkin( "Jack Round 25px" );

	cvOut4 = new VoltageAudioJack( "cvOut4", "CV 4", this, JackType.JackType_AudioOutput );
	AddComponent( cvOut4 );
	cvOut4.SetWantsMouseNotifications( false );
	cvOut4.SetPosition( 245, 297 );
	cvOut4.SetSize( 25, 25 );
	cvOut4.SetSkin( "Jack Round 25px" );

	superSerial = new VoltageAudioJack( "superSerial", "Super Serial", this, JackType.JackType_AudioOutput );
	AddComponent( superSerial );
	superSerial.SetWantsMouseNotifications( false );
	superSerial.SetPosition( 132, 148 );
	superSerial.SetSize( 25, 25 );
	superSerial.SetSkin( "Jack Round 25px" );

	LED1 = new VoltageLED( "LED1", "LED1", this );
	AddComponent( LED1 );
	LED1.SetWantsMouseNotifications( false );
	LED1.SetPosition( 139, 83 );
	LED1.SetSize( 11, 11 );
	LED1.SetSkin( "Silver Backed Red" );

	LED2 = new VoltageLED( "LED2", "LED2", this );
	AddComponent( LED2 );
	LED2.SetWantsMouseNotifications( false );
	LED2.SetPosition( 191, 105 );
	LED2.SetSize( 11, 11 );
	LED2.SetSkin( "Silver Backed Red" );

	LED3 = new VoltageLED( "LED3", "LED3", this );
	AddComponent( LED3 );
	LED3.SetWantsMouseNotifications( false );
	LED3.SetPosition( 212, 155 );
	LED3.SetSize( 11, 11 );
	LED3.SetSkin( "Silver Backed Red" );

	LED4 = new VoltageLED( "LED4", "LED4", this );
	AddComponent( LED4 );
	LED4.SetWantsMouseNotifications( false );
	LED4.SetPosition( 191, 205 );
	LED4.SetSize( 11, 11 );
	LED4.SetSkin( "Silver Backed Red" );

	LED5 = new VoltageLED( "LED5", "LED5", this );
	AddComponent( LED5 );
	LED5.SetWantsMouseNotifications( false );
	LED5.SetPosition( 139, 227 );
	LED5.SetSize( 11, 11 );
	LED5.SetSkin( "Silver Backed Red" );

	LED6 = new VoltageLED( "LED6", "LED6", this );
	AddComponent( LED6 );
	LED6.SetWantsMouseNotifications( false );
	LED6.SetPosition( 89, 205 );
	LED6.SetSize( 11, 11 );
	LED6.SetSkin( "Silver Backed Red" );

	LED7 = new VoltageLED( "LED7", "LED7", this );
	AddComponent( LED7 );
	LED7.SetWantsMouseNotifications( false );
	LED7.SetPosition( 67, 155 );
	LED7.SetSize( 11, 11 );
	LED7.SetSkin( "Silver Backed Red" );

	LED8 = new VoltageLED( "LED8", "LED8", this );
	AddComponent( LED8 );
	LED8.SetWantsMouseNotifications( false );
	LED8.SetPosition( 89, 105 );
	LED8.SetSize( 11, 11 );
	LED8.SetSkin( "Silver Backed Red" );

	LED9 = new VoltageLED( "LED9", "LED9", this );
	AddComponent( LED9 );
	LED9.SetWantsMouseNotifications( false );
	LED9.SetPosition( 179, 155 );
	LED9.SetSize( 11, 11 );
	LED9.SetSkin( "Silver Backed Red" );

	gateOut1 = new VoltageAudioJack( "gateOut1", "Gate 1", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut1 );
	gateOut1.SetWantsMouseNotifications( false );
	gateOut1.SetPosition( 132, 47 );
	gateOut1.SetSize( 25, 25 );
	gateOut1.SetSkin( "Jack Round 25px" );

	gateOut2 = new VoltageAudioJack( "gateOut2", "Gate 2", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut2 );
	gateOut2.SetWantsMouseNotifications( false );
	gateOut2.SetPosition( 203, 76 );
	gateOut2.SetSize( 25, 25 );
	gateOut2.SetSkin( "Jack Round 25px" );

	gateOut3 = new VoltageAudioJack( "gateOut3", "Gate 3", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut3 );
	gateOut3.SetWantsMouseNotifications( false );
	gateOut3.SetPosition( 234, 146 );
	gateOut3.SetSize( 25, 25 );
	gateOut3.SetSkin( "Jack Round 25px" );

	gateOut4 = new VoltageAudioJack( "gateOut4", "Gate 4", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut4 );
	gateOut4.SetWantsMouseNotifications( false );
	gateOut4.SetPosition( 203, 220 );
	gateOut4.SetSize( 25, 25 );
	gateOut4.SetSkin( "Jack Round 25px" );

	gateOut5 = new VoltageAudioJack( "gateOut5", "Gate 5", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut5 );
	gateOut5.SetWantsMouseNotifications( false );
	gateOut5.SetPosition( 132, 250 );
	gateOut5.SetSize( 25, 25 );
	gateOut5.SetSkin( "Jack Round 25px" );

	gateOut6 = new VoltageAudioJack( "gateOut6", "Gate 6", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut6 );
	gateOut6.SetWantsMouseNotifications( false );
	gateOut6.SetPosition( 60, 220 );
	gateOut6.SetSize( 25, 25 );
	gateOut6.SetSkin( "Jack Round 25px" );

	gateOut7 = new VoltageAudioJack( "gateOut7", "Gate 7", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut7 );
	gateOut7.SetWantsMouseNotifications( false );
	gateOut7.SetPosition( 29, 146 );
	gateOut7.SetSize( 25, 25 );
	gateOut7.SetSkin( "Jack Round 25px" );

	gateOut8 = new VoltageAudioJack( "gateOut8", "Gate 8", this, JackType.JackType_AudioOutput );
	AddComponent( gateOut8 );
	gateOut8.SetWantsMouseNotifications( false );
	gateOut8.SetPosition( 60, 76 );
	gateOut8.SetSize( 25, 25 );
	gateOut8.SetSkin( "Jack Round 25px" );
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
	
	for(int i = 0; i<8; i++)
	{
		bits[i] = false;
		bitsOut[i] = false;
	}
	
	bits[0] = true;

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
			if(component == data1) data1Connected = true;
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
			if(component == data1) data1Connected = false;
		}
		break;
	
		case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
		{
			LED1.SetValue(bitsOut[0] ? 1.0 : 0.0);
			LED2.SetValue(bitsOut[1] ? 1.0 : 0.0);
			LED3.SetValue(bitsOut[2] ? 1.0 : 0.0);
			LED4.SetValue(bitsOut[3] ? 1.0 : 0.0);
			LED5.SetValue(bitsOut[4] ? 1.0 : 0.0);
			LED6.SetValue(bitsOut[5] ? 1.0 : 0.0);
			LED7.SetValue(bitsOut[6] ? 1.0 : 0.0);
			LED8.SetValue(bitsOut[7] ? 1.0 : 0.0);
			
			LED9.SetValue(serialBit ? 1.0 : 0.0);
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
		bits[7] = bits[6];
		bits[6] = bits[5];
		bits[5] = bits[4];
		bits[4] = bits[3];
		bits[3] = bits[2];
		bits[2] = bits[1];
		bits[1] = bits[0];

		serialBit = bits[7];
		
		boolean data2Bool = (data2.GetValue() > 1.0);
		
		if(data1Connected)
		{
			bits[0] = data2Bool || (data1.GetValue() > 1.0);
		}
		else
		{
			boolean feedback = bits[7] != bits[0];
			bits[0] = data2Bool || feedback;
		}
		
		if(strobeJack.GetValue() < 1.0)
		{
			for(int i = 0; i < 8; i++)
			{
				bitsOut[i] = bits[i];
			}
		}
		
		cv1Value = 0.0;
		cv2Value = 0.0;
		cv3Value = 0.0;
		cv4Value = 0.0;
		
		if(bitsOut[0])
		{
			cv1Value += 0.243;
			cv2Value += 0.0522;
		}
		if(bitsOut[1])
		{
			cv2Value += 0.5279;
			cv3Value += 0.1132;
		}
		if(bitsOut[2])
		{
			cv3Value += 0.5293;
			cv4Value += 0.1129;
		}
		if(bitsOut[3])
		{
			cv1Value += 0.0522;
			cv4Value += 0.2452;
		}
		if(bitsOut[4])
		{
			cv1Value += 0.5268;
			cv2Value += 0.1129;
		}
		if(bitsOut[5])
		{
			cv2Value += 0.2465;
			cv3Value += 0.0528;
		}
		if(bitsOut[6])
		{
			cv3Value += 0.2475;
			cv4Value += 0.0527;
		}
		if(bitsOut[7])
		{
			cv1Value += 0.1103;
			cv4Value += 0.5129;
		}
		
		cv1Value *= 5.0;
		cv2Value *= 5.0;
		cv3Value *= 5.0;
		cv4Value *= 5.0;
	}

	gateOut1.SetValue(bitsOut[0] ? 5.0 : 0.0);
	gateOut2.SetValue(bitsOut[1] ? 5.0 : 0.0);
	gateOut3.SetValue(bitsOut[2] ? 5.0 : 0.0);
	gateOut4.SetValue(bitsOut[3] ? 5.0 : 0.0);
	gateOut5.SetValue(bitsOut[4] ? 5.0 : 0.0);
	gateOut6.SetValue(bitsOut[5] ? 5.0 : 0.0);
	gateOut7.SetValue(bitsOut[6] ? 5.0 : 0.0);
	gateOut8.SetValue(bitsOut[7] ? 5.0 : 0.0);
	
	superSerial.SetValue(serialBit ? 5.0 : 0.0);
	
	cvOut1.SetValue(cv1Value);
	cvOut2.SetValue(cv2Value);
	cvOut3.SetValue(cv3Value);
	cvOut4.SetValue(cv4Value);
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
private VoltageAudioJack gateOut8;
private VoltageAudioJack gateOut7;
private VoltageAudioJack gateOut6;
private VoltageAudioJack gateOut5;
private VoltageAudioJack gateOut4;
private VoltageAudioJack gateOut3;
private VoltageAudioJack gateOut2;
private VoltageAudioJack gateOut1;
private VoltageLED LED9;
private VoltageLED LED8;
private VoltageLED LED7;
private VoltageLED LED6;
private VoltageLED LED5;
private VoltageLED LED4;
private VoltageLED LED3;
private VoltageLED LED2;
private VoltageLED LED1;
private VoltageAudioJack superSerial;
private VoltageAudioJack cvOut4;
private VoltageAudioJack cvOut3;
private VoltageAudioJack cvOut2;
private VoltageAudioJack cvOut1;
private VoltageAudioJack strobeJack;
private VoltageAudioJack data2;
private VoltageAudioJack data1;
private VoltageAudioJack clockInput;


//[user-code-and-variables]    Add your own variables and functions here

private NLCTrigger clockIn = new NLCTrigger();
private boolean data1Connected = false;
private boolean[] bits = new boolean[8];
private boolean[] bitsOut = new boolean[8];
private boolean serialBit = false;

private double cv1Value = 0.0;
private double cv2Value = 0.0;
private double cv3Value = 0.0;
private double cv4Value = 0.0;
//[/user-code-and-variables]
}

 