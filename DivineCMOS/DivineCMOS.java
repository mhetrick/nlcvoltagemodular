package com.nlc.divinecmos;


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


public class DivineCMOS extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public DivineCMOS( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Divine CMOS", ModuleType.ModuleType_Logic, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "057ba53c2f0b40c08adf0d86ef98d694" );
}

void InitializeControls()
{

	div2Gain = new VoltageKnob( "div2Gain", "/2 Gain", this, 0.0, 5.0, 5.0 );
	AddComponent( div2Gain );
	div2Gain.SetWantsMouseNotifications( false );
	div2Gain.SetPosition( 14, 48 );
	div2Gain.SetSize( 35, 35 );
	div2Gain.SetSkin( "Knurled Plastic White" );
	div2Gain.SetRange( 0.0, 5.0, 5.0, false, 0 );
	div2Gain.SetKnobParams( 215, 145 );
	div2Gain.DisplayValueInPercent( true );
	div2Gain.SetKnobAdjustsRing( true );

	div4Gain = new VoltageKnob( "div4Gain", "/4 Gain", this, 0.0, 5.0, 0.0 );
	AddComponent( div4Gain );
	div4Gain.SetWantsMouseNotifications( false );
	div4Gain.SetPosition( 14, 99 );
	div4Gain.SetSize( 35, 35 );
	div4Gain.SetSkin( "Knurled Plastic White" );
	div4Gain.SetRange( 0.0, 5.0, 0.0, false, 0 );
	div4Gain.SetKnobParams( 215, 145 );
	div4Gain.DisplayValueInPercent( true );
	div4Gain.SetKnobAdjustsRing( true );

	div8Gain = new VoltageKnob( "div8Gain", "/8 Gain", this, 0.0, 5.0, 0.0 );
	AddComponent( div8Gain );
	div8Gain.SetWantsMouseNotifications( false );
	div8Gain.SetPosition( 67, 69 );
	div8Gain.SetSize( 35, 35 );
	div8Gain.SetSkin( "Knurled Plastic White" );
	div8Gain.SetRange( 0.0, 5.0, 0.0, false, 0 );
	div8Gain.SetKnobParams( 215, 145 );
	div8Gain.DisplayValueInPercent( true );
	div8Gain.SetKnobAdjustsRing( true );

	div16Gain = new VoltageKnob( "div16Gain", "/16 Gain", this, 0.0, 5.0, 0.0 );
	AddComponent( div16Gain );
	div16Gain.SetWantsMouseNotifications( false );
	div16Gain.SetPosition( 67, 120 );
	div16Gain.SetSize( 35, 35 );
	div16Gain.SetSkin( "Knurled Plastic White" );
	div16Gain.SetRange( 0.0, 5.0, 0.0, false, 0 );
	div16Gain.SetKnobParams( 215, 145 );
	div16Gain.DisplayValueInPercent( true );
	div16Gain.SetKnobAdjustsRing( true );

	slewKnob = new VoltageKnob( "slewKnob", "Slew", this, 0.0, 1.0, 0.0 );
	AddComponent( slewKnob );
	slewKnob.SetWantsMouseNotifications( false );
	slewKnob.SetPosition( 14, 164 );
	slewKnob.SetSize( 35, 35 );
	slewKnob.SetSkin( "Knurled Plastic White" );
	slewKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
	slewKnob.SetKnobParams( 215, 145 );
	slewKnob.DisplayValueInPercent( true );
	slewKnob.SetKnobAdjustsRing( true );
	slewKnob.SetRangeSkewValue( 0.25, false );

	LED1 = new VoltageLED( "LED1", "LED1", this );
	AddComponent( LED1 );
	LED1.SetWantsMouseNotifications( false );
	LED1.SetPosition( 10, 319 );
	LED1.SetSize( 11, 11 );
	LED1.SetSkin( "Silver Backed Blue" );

	in1 = new VoltageAudioJack( "in1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( in1 );
	in1.SetWantsMouseNotifications( false );
	in1.SetPosition( 3, 221 );
	in1.SetSize( 25, 25 );
	in1.SetSkin( "Jack Round 25px" );

	in2 = new VoltageAudioJack( "in2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( in2 );
	in2.SetWantsMouseNotifications( false );
	in2.SetPosition( 32, 221 );
	in2.SetSize( 25, 25 );
	in2.SetSkin( "Jack Round 25px" );

	slewOut = new VoltageAudioJack( "slewOut", "Slew Out", this, JackType.JackType_AudioOutput );
	AddComponent( slewOut );
	slewOut.SetWantsMouseNotifications( false );
	slewOut.SetPosition( 60, 242 );
	slewOut.SetSize( 25, 25 );
	slewOut.SetSkin( "Jack Round 25px" );

	mainOut = new VoltageAudioJack( "mainOut", "Main Out", this, JackType.JackType_AudioOutput );
	AddComponent( mainOut );
	mainOut.SetWantsMouseNotifications( false );
	mainOut.SetPosition( 88, 242 );
	mainOut.SetSize( 25, 25 );
	mainOut.SetSkin( "Jack Round 25px" );

	div2Out = new VoltageAudioJack( "div2Out", "Div 2", this, JackType.JackType_AudioOutput );
	AddComponent( div2Out );
	div2Out.SetWantsMouseNotifications( false );
	div2Out.SetPosition( 3, 288 );
	div2Out.SetSize( 25, 25 );
	div2Out.SetSkin( "Jack Round 25px" );

	div4Out = new VoltageAudioJack( "div4Out", "Div 4", this, JackType.JackType_AudioOutput );
	AddComponent( div4Out );
	div4Out.SetWantsMouseNotifications( false );
	div4Out.SetPosition( 32, 288 );
	div4Out.SetSize( 25, 25 );
	div4Out.SetSkin( "Jack Round 25px" );

	div8Out = new VoltageAudioJack( "div8Out", "Div 8", this, JackType.JackType_AudioOutput );
	AddComponent( div8Out );
	div8Out.SetWantsMouseNotifications( false );
	div8Out.SetPosition( 60, 288 );
	div8Out.SetSize( 25, 25 );
	div8Out.SetSkin( "Jack Round 25px" );

	div16Out = new VoltageAudioJack( "div16Out", "Div 16", this, JackType.JackType_AudioOutput );
	AddComponent( div16Out );
	div16Out.SetWantsMouseNotifications( false );
	div16Out.SetPosition( 88, 288 );
	div16Out.SetSize( 25, 25 );
	div16Out.SetSkin( "Jack Round 25px" );

	LED2 = new VoltageLED( "LED2", "LED2", this );
	AddComponent( LED2 );
	LED2.SetWantsMouseNotifications( false );
	LED2.SetPosition( 39, 319 );
	LED2.SetSize( 11, 11 );
	LED2.SetSkin( "Silver Backed Blue" );

	LED3 = new VoltageLED( "LED3", "LED3", this );
	AddComponent( LED3 );
	LED3.SetWantsMouseNotifications( false );
	LED3.SetPosition( 67, 319 );
	LED3.SetSize( 11, 11 );
	LED3.SetSkin( "Silver Backed Blue" );

	LED4 = new VoltageLED( "LED4", "LED4", this );
	AddComponent( LED4 );
	LED4.SetWantsMouseNotifications( false );
	LED4.SetPosition( 95, 319 );
	LED4.SetSize( 11, 11 );
	LED4.SetSkin( "Silver Backed Blue" );

	LED5 = new VoltageLED( "LED5", "LED5", this );
	AddComponent( LED5 );
	LED5.SetWantsMouseNotifications( false );
	LED5.SetPosition( 80, 174 );
	LED5.SetSize( 11, 11 );
	LED5.SetSkin( "Silver Backed Blue" );
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
			if(component == div2Gain) div2GainVal.SetValue(doubleValue);
			else if(component == div4Gain) div4GainVal.SetValue(doubleValue);
			else if(component == div8Gain) div8GainVal.SetValue(doubleValue);
			else if(component == div16Gain) div16GainVal.SetValue(doubleValue);
			else if(component == slewKnob)
			{
				double slewTime = doubleValue * 2000.0;
				slewLimiter.SetAttackTime(slewTime);
				slewLimiter.SetReleaseTime(slewTime);
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
			LED1.SetValue(div2Active ? 1.0 : 0.0);
			LED2.SetValue(div4Active ? 1.0 : 0.0);
			LED3.SetValue(div8Active ? 1.0 : 0.0);
			LED4.SetValue(div16Active ? 1.0 : 0.0);
			
			LED5.SetValue(currentOut * 0.2);
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
	if(clockIn1.process(in1.GetValue()))
	{

		if(stepCount1 == 16) stepCount1 = 1;
		else stepCount1++;

		if (stepCount1 % 2 == 0)
		{
			in1div2 = !in1div2;

			if (stepCount1 % 4 == 0)
			{
				in1div4 = ! in1div4;

				if (stepCount1 % 8 == 0)
				{
					 	in1div8 = !in1div8;

						if (stepCount1 % 16 == 0)
						{
							in1div16 = ! in1div16;
						}
				}
			}
		}
	}

	if(clockIn2.process(in2.GetValue()))
	{

		if(stepCount2 == 16) stepCount2 = 1;
		else stepCount2++;

		if (stepCount2 % 2 == 0)
		{
			in2div2 = !in2div2;

			if (stepCount2 % 4 == 0)
			{
				in2div4 = ! in2div4;

				if (stepCount2 % 8 == 0)
				{
					 	in2div8 = !in2div8;

						if (stepCount2 % 16 == 0)
						{
							in2div16 = ! in2div16;
						}
				}
			}
		}
	}
	
	div2Active = (in1div2 != in2div2);
	div4Active = (in1div4 != in2div4);
	div8Active = (in1div8 != in2div8);
	div16Active = (in1div16 != in2div16);
	
	div2Out.SetValue(div2Active ? 5.0 : 0.0);
	div4Out.SetValue(div4Active ? 5.0 : 0.0);
	div8Out.SetValue(div8Active ? 5.0 : 0.0);
	div16Out.SetValue(div16Active ? 5.0 : 0.0);
	
	double div2mix = (div2Active ? div2GainVal.GetSmoothValue() : 0.0);
	double div4mix = (div4Active ? div4GainVal.GetSmoothValue() : 0.0);
	double div8mix = (div8Active ? div8GainVal.GetSmoothValue() : 0.0);
	double div16mix = (div16Active ? div16GainVal.GetSmoothValue() : 0.0);
	
	currentOut = div2mix + div4mix + div8mix + div16mix;
	if(currentOut > 5.0) currentOut = 5.0;
	
	double slewedOut = slewLimiter.ProcessSample(currentOut);
	
	mainOut.SetValue(currentOut);
	slewOut.SetValue(slewedOut);
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
private VoltageLED LED5;
private VoltageLED LED4;
private VoltageLED LED3;
private VoltageLED LED2;
private VoltageAudioJack div16Out;
private VoltageAudioJack div8Out;
private VoltageAudioJack div4Out;
private VoltageAudioJack div2Out;
private VoltageAudioJack mainOut;
private VoltageAudioJack slewOut;
private VoltageAudioJack in2;
private VoltageAudioJack in1;
private VoltageLED LED1;
private VoltageKnob slewKnob;
private VoltageKnob div16Gain;
private VoltageKnob div8Gain;
private VoltageKnob div4Gain;
private VoltageKnob div2Gain;


//[user-code-and-variables]    Add your own variables and functions here

int stepCount1 = 0;
int stepCount2 = 0;
boolean in1div2, in1div4, in1div8, in1div16;
boolean in2div2, in2div4, in2div8, in2div16;
boolean div2Active, div4Active, div8Active, div16Active;
double currentOut = 0.0;

EnvelopeFollower slewLimiter = new EnvelopeFollower(0.0, 0.0, 0.0);

private SmoothValue div2GainVal = new SmoothValue();
private SmoothValue div4GainVal = new SmoothValue();
private SmoothValue div8GainVal = new SmoothValue();
private SmoothValue div16GainVal = new SmoothValue();

private NLCTrigger clockIn1 = new NLCTrigger();
private NLCTrigger clockIn2 = new NLCTrigger();
//[/user-code-and-variables]
}

 