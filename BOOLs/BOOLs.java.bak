package com.nlc.bools;


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


public class BOOLs extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public BOOLs( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "BOOLs", ModuleType.ModuleType_Logic, 1.2 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "6b6b819046a743b181ab6c5a30c9191c" );
}

void InitializeControls()
{

	slewKnob = new VoltageKnob( "slewKnob", "Slew", this, 0.0, 1.0, 0.0 );
	AddComponent( slewKnob );
	slewKnob.SetWantsMouseNotifications( false );
	slewKnob.SetPosition( 22, 38 );
	slewKnob.SetSize( 41, 41 );
	slewKnob.SetSkin( "Dial Sky" );
	slewKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
	slewKnob.SetKnobParams( 215, 145 );
	slewKnob.DisplayValueInPercent( true );
	slewKnob.SetKnobAdjustsRing( true );
	slewKnob.SetRangeSkewValue( 0.25, false );

	slewOutJack = new VoltageAudioJack( "slewOutJack", "Slewed Out", this, JackType.JackType_AudioOutput );
	AddComponent( slewOutJack );
	slewOutJack.SetWantsMouseNotifications( false );
	slewOutJack.SetPosition( 12, 300 );
	slewOutJack.SetSize( 25, 25 );
	slewOutJack.SetSkin( "Jack Round Pink Ring" );

	steppedOutJack = new VoltageAudioJack( "steppedOutJack", "Stepped Out", this, JackType.JackType_AudioOutput );
	AddComponent( steppedOutJack );
	steppedOutJack.SetWantsMouseNotifications( false );
	steppedOutJack.SetPosition( 48, 300 );
	steppedOutJack.SetSize( 25, 25 );
	steppedOutJack.SetSkin( "Jack Round Pink Ring" );

	outJack1 = new VoltageAudioJack( "outJack1", "Out 1", this, JackType.JackType_AudioOutput );
	AddComponent( outJack1 );
	outJack1.SetWantsMouseNotifications( false );
	outJack1.SetPosition( 48, 148 );
	outJack1.SetSize( 25, 25 );
	outJack1.SetSkin( "Jack Round Pink Ring" );

	outJack2 = new VoltageAudioJack( "outJack2", "Out 2", this, JackType.JackType_AudioOutput );
	AddComponent( outJack2 );
	outJack2.SetWantsMouseNotifications( false );
	outJack2.SetPosition( 48, 184 );
	outJack2.SetSize( 25, 25 );
	outJack2.SetSkin( "Jack Round Pink Ring" );

	outJack3 = new VoltageAudioJack( "outJack3", "Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( outJack3 );
	outJack3.SetWantsMouseNotifications( false );
	outJack3.SetPosition( 48, 220 );
	outJack3.SetSize( 25, 25 );
	outJack3.SetSkin( "Jack Round Pink Ring" );

	outJack4 = new VoltageAudioJack( "outJack4", "Out 4", this, JackType.JackType_AudioOutput );
	AddComponent( outJack4 );
	outJack4.SetWantsMouseNotifications( false );
	outJack4.SetPosition( 48, 256 );
	outJack4.SetSize( 25, 25 );
	outJack4.SetSkin( "Jack Round Pink Ring" );

	inJack1 = new VoltageAudioJack( "inJack1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( inJack1 );
	inJack1.SetWantsMouseNotifications( false );
	inJack1.SetPosition( 15, 148 );
	inJack1.SetSize( 25, 25 );
	inJack1.SetSkin( "Jack Round Sky Ring" );

	sampleIn = new VoltageAudioJack( "sampleIn", "Sample In", this, JackType.JackType_AudioInput );
	AddComponent( sampleIn );
	sampleIn.SetWantsMouseNotifications( false );
	sampleIn.SetPosition( 30, 103 );
	sampleIn.SetSize( 25, 25 );
	sampleIn.SetSkin( "Jack Round Sky Ring" );

	inJack2 = new VoltageAudioJack( "inJack2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( inJack2 );
	inJack2.SetWantsMouseNotifications( false );
	inJack2.SetPosition( 15, 184 );
	inJack2.SetSize( 25, 25 );
	inJack2.SetSkin( "Jack Round Sky Ring" );

	inJack3 = new VoltageAudioJack( "inJack3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( inJack3 );
	inJack3.SetWantsMouseNotifications( false );
	inJack3.SetPosition( 15, 220 );
	inJack3.SetSize( 25, 25 );
	inJack3.SetSkin( "Jack Round Sky Ring" );

	inJack4 = new VoltageAudioJack( "inJack4", "In 4", this, JackType.JackType_AudioInput );
	AddComponent( inJack4 );
	inJack4.SetWantsMouseNotifications( false );
	inJack4.SetPosition( 15, 256 );
	inJack4.SetSize( 25, 25 );
	inJack4.SetSkin( "Jack Round Sky Ring" );

	LED1 = new VoltageLED( "LED1", "LED1", this );
	AddComponent( LED1 );
	LED1.SetWantsMouseNotifications( false );
	LED1.SetPosition( 75, 144 );
	LED1.SetSize( 11, 11 );
	LED1.SetSkin( "Silver Backed Blue" );

	LED2 = new VoltageLED( "LED2", "LED2", this );
	AddComponent( LED2 );
	LED2.SetWantsMouseNotifications( false );
	LED2.SetPosition( 75, 179 );
	LED2.SetSize( 11, 11 );
	LED2.SetSkin( "Silver Backed Blue" );

	LED3 = new VoltageLED( "LED3", "LED3", this );
	AddComponent( LED3 );
	LED3.SetWantsMouseNotifications( false );
	LED3.SetPosition( 75, 216 );
	LED3.SetSize( 11, 11 );
	LED3.SetSkin( "Silver Backed Blue" );

	LED4 = new VoltageLED( "LED4", "LED4", this );
	AddComponent( LED4 );
	LED4.SetWantsMouseNotifications( false );
	LED4.SetPosition( 75, 251 );
	LED4.SetSize( 11, 11 );
	LED4.SetSkin( "Silver Backed Blue" );

	logicSwitch = new VoltageSwitch( "logicSwitch", "Logic Mode", this, 0 );
	AddComponent( logicSwitch );
	logicSwitch.SetWantsMouseNotifications( false );
	logicSwitch.SetPosition( 12, 17 );
	logicSwitch.SetSize( 62, 14 );
	logicSwitch.SetSkin( "5-State Slide Horizontal" );
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

	for(int i = 0; i<4; i++)
	{
		ins[i] = false;
		outBools[i] = false;
		outs[i] = 0.0;
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
			if(component == slewKnob)
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
			if(component == logicSwitch) logicMode = (int)(doubleValue);
		}
		break;
	
		case Jack_Connected:   // longValue is the new cable ID
		{
			if(component == sampleIn) clocked = true;
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
			if(component == sampleIn) clocked = false;
		}
		break;
	
		case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
		{
			LED1.SetValue(outBools[0] ? 1.0 : 0.0);
			LED2.SetValue(outBools[1] ? 1.0 : 0.0);
			LED3.SetValue(outBools[2] ? 1.0 : 0.0);
			LED4.SetValue(outBools[3] ? 1.0 : 0.0);
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
if(clocked)
{
	if (clockIn.process(sampleIn.GetValue()))
	{
		fullBOOLsProcess();
	}
}
else fullBOOLsProcess();

steppedOutJack.SetValue(stepValue);
slewOutJack.SetValue(slewLimiter.ProcessSample(stepValue));

outJack1.SetValue(outs[0]);
outJack2.SetValue(outs[1]);
outJack3.SetValue(outs[2]);
outJack4.SetValue(outs[3]);

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

	if(component == logicSwitch) return modes[logicMode];

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
private VoltageSwitch logicSwitch;
private VoltageLED LED4;
private VoltageLED LED3;
private VoltageLED LED2;
private VoltageLED LED1;
private VoltageAudioJack inJack4;
private VoltageAudioJack inJack3;
private VoltageAudioJack inJack2;
private VoltageAudioJack sampleIn;
private VoltageAudioJack inJack1;
private VoltageAudioJack outJack4;
private VoltageAudioJack outJack3;
private VoltageAudioJack outJack2;
private VoltageAudioJack outJack1;
private VoltageAudioJack steppedOutJack;
private VoltageAudioJack slewOutJack;
private VoltageKnob slewKnob;


//[user-code-and-variables]    Add your own variables and functions here

private double slewValue = 0.0;

private boolean[] ins = new boolean[4];
private boolean[] outBools = new boolean[4];
private double[] outs = new double[4];

private double stepValue = 0.0;
private double lastSlew = -1.0;

private double gateScale = 5.0;
private double gateUnscale = 1.0/gateScale;
private double stepScale = 3.0;
private double step1val = 0.0364 * stepScale;
private double step2val = 0.0729 * stepScale;
private double step3val = 0.1458 * stepScale;
private double step4val = 0.2915 * stepScale;

private NLCTrigger clockIn = new NLCTrigger();

private EnvelopeFollower slewLimiter = new EnvelopeFollower(0.0, 0.0, 0.0);

private boolean clocked = false;

private int logicMode = 0;

private String[] modes = {"OR", "AND", "XOR", "NOR",
"XNOR"};

private void acquireInputs()
{
	ins[0] = inJack1.GetValue() > 1.0;
	ins[1] = inJack2.GetValue() > 1.0;
	ins[2] = inJack3.GetValue() > 1.0;
	ins[3] = inJack4.GetValue() > 1.0;
}

private boolean logicFunction(boolean in1, boolean in2)
{
	switch(logicMode)
	{
		case 0:
			return in1 || in2;
			
		case 1:
			return in1 && in2;
			
		case 2:
			return in1 != in2;
			
		case 3:
			return !(in1 || in2);
			
		case 4:
			return in1 == in2;
			
		default:
			return in1 || in2;
	}
	
}

private void applyLogic()
{
	outBools[0] = logicFunction(ins[0], ins[1]);
	outBools[1] = logicFunction(ins[1], ins[2]);
	outBools[2] = logicFunction(ins[2], ins[3]);
	outBools[3] = logicFunction(ins[3], ins[0]);
}

private void setOutputValues()
{
	for (int i = 0; i < 4; i++)
	{
		outs[i] = outBools[i] ? gateScale : 0.0;
	}

	stepValue = 0.0f;
	stepValue += (outs[0] * step1val);
	stepValue += (outs[1] * step2val);
	stepValue += (outs[2] * step3val);
	stepValue += (outs[3] * step4val);
}

private void fullBOOLsProcess()
{
	acquireInputs();
	applyLogic();
	setOutputValues();
}
//[/user-code-and-variables]
}

 