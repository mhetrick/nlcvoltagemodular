package com.nlc.squidaxon;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
//modified SchmittTrigger with no hysteresis.
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


public class SquidAxon extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public SquidAxon( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Squid Axon", ModuleType.ModuleType_CVProcessors, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "525f6053c37948f78447bd70f0c456ec" );
}

void InitializeControls()
{

	feedbackKnob = new VoltageKnob( "Feedback", "Feedback", this, 0.0, 1.0, 0.0 );
	AddComponent( feedbackKnob );
	feedbackKnob.SetWantsMouseNotifications( false );
	feedbackKnob.SetPosition( 66, 47 );
	feedbackKnob.SetSize( 41, 41 );
	feedbackKnob.SetSkin( "Dial Sky" );
	feedbackKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
	feedbackKnob.SetKnobParams( 215, 145 );
	feedbackKnob.DisplayValueInPercent( true );
	feedbackKnob.SetKnobAdjustsRing( true );

	nlFeedbackKnob = new VoltageKnob( "NLFeedback", "Non-Linear Feedback", this, 0.0, 4.0, 0.0 );
	AddComponent( nlFeedbackKnob );
	nlFeedbackKnob.SetWantsMouseNotifications( false );
	nlFeedbackKnob.SetPosition( 8, 47 );
	nlFeedbackKnob.SetSize( 41, 41 );
	nlFeedbackKnob.SetSkin( "Dial Sky" );
	nlFeedbackKnob.SetRange( 0.0, 4.0, 0.0, false, 0 );
	nlFeedbackKnob.SetKnobParams( 215, 145 );
	nlFeedbackKnob.DisplayValueInPercent( true );
	nlFeedbackKnob.SetKnobAdjustsRing( true );

	out1 = new VoltageAudioJack( "out1", "Out 1", this, JackType.JackType_AudioOutput );
	AddComponent( out1 );
	out1.SetWantsMouseNotifications( false );
	out1.SetPosition( 2, 264 );
	out1.SetSize( 25, 25 );
	out1.SetSkin( "Jack Round Sky Ring" );

	out2 = new VoltageAudioJack( "out2", "Out 2", this, JackType.JackType_AudioOutput );
	AddComponent( out2 );
	out2.SetWantsMouseNotifications( false );
	out2.SetPosition( 31, 264 );
	out2.SetSize( 25, 25 );
	out2.SetSkin( "Jack Round Sky Ring" );

	out3 = new VoltageAudioJack( "out3", "Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( out3 );
	out3.SetWantsMouseNotifications( false );
	out3.SetPosition( 60, 264 );
	out3.SetSize( 25, 25 );
	out3.SetSkin( "Jack Round Sky Ring" );

	out4 = new VoltageAudioJack( "out4", "Out 4", this, JackType.JackType_AudioOutput );
	AddComponent( out4 );
	out4.SetWantsMouseNotifications( false );
	out4.SetPosition( 88, 264 );
	out4.SetSize( 25, 25 );
	out4.SetSkin( "Jack Round Sky Ring" );

	clockInput = new VoltageAudioJack( "clockInput", "Clock In", this, JackType.JackType_AudioInput );
	AddComponent( clockInput );
	clockInput.SetWantsMouseNotifications( false );
	clockInput.SetPosition( 2, 220 );
	clockInput.SetSize( 25, 25 );
	clockInput.SetSkin( "Jack Round Pink Ring" );

	in1 = new VoltageAudioJack( "in1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( in1 );
	in1.SetWantsMouseNotifications( false );
	in1.SetPosition( 31, 220 );
	in1.SetSize( 25, 25 );
	in1.SetSkin( "Jack Round Pink Ring" );

	in2 = new VoltageAudioJack( "in2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( in2 );
	in2.SetWantsMouseNotifications( false );
	in2.SetPosition( 60, 220 );
	in2.SetSize( 25, 25 );
	in2.SetSkin( "Jack Round Pink Ring" );

	in3 = new VoltageAudioJack( "in3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( in3 );
	in3.SetWantsMouseNotifications( false );
	in3.SetPosition( 88, 220 );
	in3.SetSize( 25, 25 );
	in3.SetSkin( "Jack Round Pink Ring" );
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

	for(int i = 0; i<4; i++)
	{
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
			if (component == nlFeedbackKnob)
         {
            nonlinearFeedbackParam = doubleValue;
         }
         else if (component == feedbackKnob)
         {
            linearFeedbackParam = doubleValue;
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
			if(component == in3) stage3Connected = true;
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
			if(component == in3) stage3Connected = false;
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

	if(clockIn.process(clockInput.GetValue()))
	{
	
		if(stage == 0)
		{
			double mixIn = in1.GetValue() + in2.GetValue();
			if (stage3Connected)
			{
				mixIn += in3.GetValue() * linearFeedbackParam;
			}
			else
			{
				mixIn += outs[3] * linearFeedbackParam;
			}

			//add nonlinear feedback
			nonlinearFeedback = outs[3] * nonlinearFeedbackParam;
			nonlinearFeedback = squidDiode(nonlinearFeedback);
			nonlinearFeedback = clamp(nonlinearFeedback, -9.0, 9.0);
			nonlinearFeedback *= -0.7;

			mixIn += nonlinearFeedback;

			outs[0] = clamp(mixIn, -10.0, 10.0);
		}
		else
		{
			outs[stage] = outs[stage - 1];
		}
		
		stage = (stage + 1) % 4;
	}


	out1.SetValue(outs[0]);
	out2.SetValue(outs[0]);
	out3.SetValue(outs[0]);
	out4.SetValue(outs[0]);

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
private VoltageAudioJack in3;
private VoltageAudioJack in2;
private VoltageAudioJack in1;
private VoltageAudioJack clockInput;
private VoltageAudioJack out4;
private VoltageAudioJack out3;
private VoltageAudioJack out2;
private VoltageAudioJack out1;
private VoltageKnob nlFeedbackKnob;
private VoltageKnob feedbackKnob;


//[user-code-and-variables]    Add your own variables and functions here

private int stage = 0;
private double[] outs = new double[4];
private double linearFeedback = 0.0f;
private double nonlinearFeedback = 0.0f;
private double linearFeedbackParam = 0.0f;
private double nonlinearFeedbackParam = 0.0f;
private NLCTrigger clockIn = new NLCTrigger();
private double diodeScalar = 0.0432477f * 28.0f * 10.0f;

boolean stage3Connected = false;

private double squidDiode(double _input)
{
	double sign = _input > 0.0 ? 1.0 : -1.0;

	double diodeIn = Math.abs(_input * 0.1) - 0.667;
	double diodeStage2 = diodeIn + Math.abs(diodeIn);
	double diodeStage3 = diodeStage2 * diodeStage2 * sign;

	return diodeStage3 * diodeScalar;
}

private double clamp(double in, double low, double high)
{
   if(in < low) return low;
   if(in > high) return high;
   return in;
}

//[/user-code-and-variables]
}

 