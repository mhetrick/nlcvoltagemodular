package com.nlc.genie;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here

class DiffRect
{
	public DiffRect()
	{
	
	}
	
	public void process()
   {
      double diff = lastPositiveInput - lastNegativeInput;
      //diff = rack::math::clamp(diff, -10.0, 10.0);
      positiveOutput = diff > 0.0 ? diff : 0.0;
      negativeOutput = diff < 0.0 ? diff : 0.0;
   }
   
   public void setPositiveInput(double _in)
   {
      lastPositiveInput = _in;
   }
   public void setNegativeInput(double _in)
   {
      lastNegativeInput = _in;
   }
   
   public double getPositiveOutput(){return positiveOutput;}
   public double getNegativeOutput(){return negativeOutput;}
	
	private double lastPositiveInput = 0.0;
   private double lastNegativeInput = 0.0;
   private double positiveOutput = 0.0;
   private double negativeOutput = 0.0;
}

class NLCNeuron
{

	public NLCNeuron()
	{
	
	}

	public void setSense(double _sense){sense = _sense;}
   public void setResponse(double _response){response = _response;}
   public void setInput(double _in1, double _in2, double _in3)
   {
   	lastInput = _in1 + _in2 + _in3;
   }
   public void setInput(double _in)
   {
   	lastInput = _in;
   }
   
   public double process()
   {
    	double rectifiedInput = clamp(lastInput + sense, 0.0, 10.0);

      double comparatorOutput = rectifiedInput > 0.0 ? response : response * -1.0;

      return (rectifiedInput - comparatorOutput);
   }
   
   private double sense = 0.0;
   private double response = 1.0;
   private double lastInput = 0.0;
   
   private double clamp(double in, double low, double high)
	{
   	if(in < low) return low;
   	if(in > high) return high;
   	return in;
	}
}
//[/user-imports]


public class Genie extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Genie( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "GENiE", ModuleType.ModuleType_CVProcessors, 3.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "8ffc2a8456d14fdb9e83be8ad85d7b4d" );
}

void InitializeControls()
{

	sense1 = new VoltageKnob( "sense1", "Sense 1", this, 0.0, 5.0, 0.0 );
	AddComponent( sense1 );
	sense1.SetWantsMouseNotifications( false );
	sense1.SetPosition( 70, 78 );
	sense1.SetSize( 27, 27 );
	sense1.SetSkin( "Plastic Blue" );
	sense1.SetRange( 0.0, 5.0, 0.0, false, 0 );
	sense1.SetKnobParams( 215, 145 );
	sense1.DisplayValueInPercent( true );
	sense1.SetKnobAdjustsRing( true );

	sense2 = new VoltageKnob( "sense2", "Sense 2", this, 0.0, 5.0, 0.0 );
	AddComponent( sense2 );
	sense2.SetWantsMouseNotifications( false );
	sense2.SetPosition( 116, 78 );
	sense2.SetSize( 27, 27 );
	sense2.SetSkin( "Plastic Blue" );
	sense2.SetRange( 0.0, 5.0, 0.0, false, 0 );
	sense2.SetKnobParams( 215, 145 );
	sense2.DisplayValueInPercent( true );
	sense2.SetKnobAdjustsRing( true );

	sense3 = new VoltageKnob( "sense3", "Sense 3", this, 0.0, 5.0, 0.0 );
	AddComponent( sense3 );
	sense3.SetWantsMouseNotifications( false );
	sense3.SetPosition( 161, 78 );
	sense3.SetSize( 27, 27 );
	sense3.SetSkin( "Plastic Blue" );
	sense3.SetRange( 0.0, 5.0, 0.0, false, 0 );
	sense3.SetKnobParams( 215, 145 );
	sense3.DisplayValueInPercent( true );
	sense3.SetKnobAdjustsRing( true );

	response1 = new VoltageKnob( "response1", "Response 1", this, 0.0, 10.0, 1.0 );
	AddComponent( response1 );
	response1.SetWantsMouseNotifications( false );
	response1.SetPosition( 70, 121 );
	response1.SetSize( 27, 27 );
	response1.SetSkin( "Plastic Blue" );
	response1.SetRange( 0.0, 10.0, 1.0, false, 0 );
	response1.SetKnobParams( 215, 145 );
	response1.DisplayValueInPercent( true );
	response1.SetKnobAdjustsRing( true );

	inGain1 = new VoltageKnob( "inGain1", "In Gain 1", this, 0.0, 10.0, 1.0 );
	AddComponent( inGain1 );
	inGain1.SetWantsMouseNotifications( false );
	inGain1.SetPosition( 70, 168 );
	inGain1.SetSize( 27, 27 );
	inGain1.SetSkin( "Plastic Blue" );
	inGain1.SetRange( 0.0, 10.0, 1.0, false, 0 );
	inGain1.SetKnobParams( 215, 145 );
	inGain1.DisplayValueInPercent( true );
	inGain1.SetKnobAdjustsRing( true );

	inGain2 = new VoltageKnob( "inGain2", "In Gain 2", this, 0.0, 10.0, 1.0 );
	AddComponent( inGain2 );
	inGain2.SetWantsMouseNotifications( false );
	inGain2.SetPosition( 116, 168 );
	inGain2.SetSize( 27, 27 );
	inGain2.SetSkin( "Plastic Blue" );
	inGain2.SetRange( 0.0, 10.0, 1.0, false, 0 );
	inGain2.SetKnobParams( 215, 145 );
	inGain2.DisplayValueInPercent( true );
	inGain2.SetKnobAdjustsRing( true );

	inGain3 = new VoltageKnob( "inGain3", "In Gain 3", this, 0.0, 10.0, 1.0 );
	AddComponent( inGain3 );
	inGain3.SetWantsMouseNotifications( false );
	inGain3.SetPosition( 161, 168 );
	inGain3.SetSize( 27, 27 );
	inGain3.SetSkin( "Plastic Blue" );
	inGain3.SetRange( 0.0, 10.0, 1.0, false, 0 );
	inGain3.SetKnobParams( 215, 145 );
	inGain3.DisplayValueInPercent( true );
	inGain3.SetKnobAdjustsRing( true );

	response3 = new VoltageKnob( "response3", "Response 3", this, 0.0, 10.0, 1.0 );
	AddComponent( response3 );
	response3.SetWantsMouseNotifications( false );
	response3.SetPosition( 161, 121 );
	response3.SetSize( 27, 27 );
	response3.SetSkin( "Plastic Blue" );
	response3.SetRange( 0.0, 10.0, 1.0, false, 0 );
	response3.SetKnobParams( 215, 145 );
	response3.DisplayValueInPercent( true );
	response3.SetKnobAdjustsRing( true );

	response2 = new VoltageKnob( "response2", "Response 2", this, 0.0, 10.0, 1.0 );
	AddComponent( response2 );
	response2.SetWantsMouseNotifications( false );
	response2.SetPosition( 116, 121 );
	response2.SetSize( 27, 27 );
	response2.SetSkin( "Plastic Blue" );
	response2.SetRange( 0.0, 10.0, 1.0, false, 0 );
	response2.SetKnobParams( 215, 145 );
	response2.DisplayValueInPercent( true );
	response2.SetKnobAdjustsRing( true );

	neuronOut1 = new VoltageAudioJack( "neuronOut1", "Neuron Out 1", this, JackType.JackType_AudioOutput );
	AddComponent( neuronOut1 );
	neuronOut1.SetWantsMouseNotifications( false );
	neuronOut1.SetPosition( 28, 307 );
	neuronOut1.SetSize( 25, 25 );
	neuronOut1.SetSkin( "Jack Round 25px" );

	neuronOut3 = new VoltageAudioJack( "neuronOut3", "Neuron Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( neuronOut3 );
	neuronOut3.SetWantsMouseNotifications( false );
	neuronOut3.SetPosition( 201, 307 );
	neuronOut3.SetSize( 25, 25 );
	neuronOut3.SetSkin( "Jack Round 25px" );

	neuronOut2 = new VoltageAudioJack( "neuronOut2", "Neuron Out 2", this, JackType.JackType_AudioOutput );
	AddComponent( neuronOut2 );
	neuronOut2.SetWantsMouseNotifications( false );
	neuronOut2.SetPosition( 117, 307 );
	neuronOut2.SetSize( 25, 25 );
	neuronOut2.SetSkin( "Jack Round 25px" );

	negOut1 = new VoltageAudioJack( "negOut1", "DiffRect Negative Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( negOut1 );
	negOut1.SetWantsMouseNotifications( false );
	negOut1.SetPosition( 71, 307 );
	negOut1.SetSize( 25, 25 );
	negOut1.SetSkin( "Jack Round 25px" );

	posOut1 = new VoltageAudioJack( "posOut1", "DiffRect Positive Out 1", this, JackType.JackType_AudioOutput );
	AddComponent( posOut1 );
	posOut1.SetWantsMouseNotifications( false );
	posOut1.SetPosition( 160, 307 );
	posOut1.SetSize( 25, 25 );
	posOut1.SetSkin( "Jack Round 25px" );

	neuron1In1 = new VoltageAudioJack( "neuron1In1", "Neuron 1 In 1", this, JackType.JackType_AudioInput );
	AddComponent( neuron1In1 );
	neuron1In1.SetWantsMouseNotifications( false );
	neuron1In1.SetPosition( 28, 217 );
	neuron1In1.SetSize( 25, 25 );
	neuron1In1.SetSkin( "Jack Round 25px" );

	neurons12in1 = new VoltageAudioJack( "neurons12in1", "Neurons 1+2 In 1", this, JackType.JackType_AudioInput );
	AddComponent( neurons12in1 );
	neurons12in1.SetWantsMouseNotifications( false );
	neurons12in1.SetPosition( 71, 217 );
	neurons12in1.SetSize( 25, 25 );
	neurons12in1.SetSkin( "Jack Round 25px" );

	neurons12in2 = new VoltageAudioJack( "neurons12in2", "Neurons 1+2 In 2", this, JackType.JackType_AudioInput );
	AddComponent( neurons12in2 );
	neurons12in2.SetWantsMouseNotifications( false );
	neurons12in2.SetPosition( 71, 265 );
	neurons12in2.SetSize( 25, 25 );
	neurons12in2.SetSkin( "Jack Round 25px" );

	neurons23in1 = new VoltageAudioJack( "neurons23in1", "Neurons 2+3 In 1", this, JackType.JackType_AudioInput );
	AddComponent( neurons23in1 );
	neurons23in1.SetWantsMouseNotifications( false );
	neurons23in1.SetPosition( 160, 217 );
	neurons23in1.SetSize( 25, 25 );
	neurons23in1.SetSkin( "Jack Round 25px" );

	neurons23in2 = new VoltageAudioJack( "neurons23in2", "Neurons 2+3 In 2", this, JackType.JackType_AudioInput );
	AddComponent( neurons23in2 );
	neurons23in2.SetWantsMouseNotifications( false );
	neurons23in2.SetPosition( 160, 265 );
	neurons23in2.SetSize( 25, 25 );
	neurons23in2.SetSkin( "Jack Round 25px" );

	neuron1In2 = new VoltageAudioJack( "neuron1In2", "Neuron 1 In 2", this, JackType.JackType_AudioInput );
	AddComponent( neuron1In2 );
	neuron1In2.SetWantsMouseNotifications( false );
	neuron1In2.SetPosition( 28, 265 );
	neuron1In2.SetSize( 25, 25 );
	neuron1In2.SetSkin( "Jack Round 25px" );

	neuron2In2 = new VoltageAudioJack( "neuron2In2", "Neuron 2 In 2", this, JackType.JackType_AudioInput );
	AddComponent( neuron2In2 );
	neuron2In2.SetWantsMouseNotifications( false );
	neuron2In2.SetPosition( 117, 265 );
	neuron2In2.SetSize( 25, 25 );
	neuron2In2.SetSkin( "Jack Round 25px" );

	neuron2In1 = new VoltageAudioJack( "neuron2In1", "Neuron 2 In 1", this, JackType.JackType_AudioInput );
	AddComponent( neuron2In1 );
	neuron2In1.SetWantsMouseNotifications( false );
	neuron2In1.SetPosition( 117, 217 );
	neuron2In1.SetSize( 25, 25 );
	neuron2In1.SetSkin( "Jack Round 25px" );

	neuron3In1 = new VoltageAudioJack( "neuron3In1", "Neuron 3 In 1", this, JackType.JackType_AudioInput );
	AddComponent( neuron3In1 );
	neuron3In1.SetWantsMouseNotifications( false );
	neuron3In1.SetPosition( 201, 217 );
	neuron3In1.SetSize( 25, 25 );
	neuron3In1.SetSkin( "Jack Round 25px" );

	neuron3In2 = new VoltageAudioJack( "neuron3In2", "Neuron 3 In 2", this, JackType.JackType_AudioInput );
	AddComponent( neuron3In2 );
	neuron3In2.SetWantsMouseNotifications( false );
	neuron3In2.SetPosition( 201, 265 );
	neuron3In2.SetSize( 25, 25 );
	neuron3In2.SetSkin( "Jack Round 25px" );
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
	neuron1 = new NLCNeuron();
	neuron2 = new NLCNeuron();
	neuron3 = new NLCNeuron();
	diffRect = new DiffRect();

	gain1 = new SmoothValue();
	gain2 = new SmoothValue();
	gain3 = new SmoothValue();
	
	connected1 = false;
	connected2 = false;
	connected3 = false;
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
			if(component == sense1)
			{
				neuron1.setSense(doubleValue);
			}
			else if(component == sense2)
			{
				neuron2.setSense(doubleValue);
			}
			else if(component == sense3)
			{
				neuron3.setSense(doubleValue);
			}
			else if(component == response1)
			{
				neuron1.setResponse(doubleValue);
			}
			else if(component == response2)
			{
				neuron2.setResponse(doubleValue);
			}
			else if(component == response3)
			{
				neuron3.setResponse(doubleValue);
			}
			else if(component == inGain1)
			{
				gain1.SetValue(doubleValue);
			}
			else if(component == inGain2)
			{
				gain2.SetValue(doubleValue);
			}
			else if(component == inGain3)
			{
				gain3.SetValue(doubleValue);
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
			if(component == neuron1In1) connected1 = true;
			else if(component == neuron2In1) connected2 = true;
			else if(component == neuron3In1) connected3 = true;
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
			if(component == neuron1In1) connected1 = false;
			else if(component == neuron2In1) connected2 = false;
			else if(component == neuron3In1) connected3 = false;
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
	
	double totalGain1 = gain1.GetSmoothValue();
	double totalGain2 = gain2.GetSmoothValue();
	double totalGain3 = gain3.GetSmoothValue();
	
	double neuron1InputVal = 0.0f;
	if (connected1)
	{
			neuron1InputVal = neuron1In1.GetValue() * totalGain1;
	}
	else
	{
			neuron1InputVal = neuron3Out * totalGain1;
	}

	double neuron2InputVal = 0.0f;
	if (connected2)
	{
			neuron2InputVal = neuron2In1.GetValue() * totalGain2;
	}
	else
	{
			neuron2InputVal = neuron1Out * totalGain2;
	}

	double neuron3InputVal = 0.0f;
	if (connected3)
	{
			neuron3InputVal = neuron3In1.GetValue() * totalGain3;
	}
	else
	{
			neuron3InputVal = neuron2Out * totalGain3;
	}
	
	double neuron1Inputs = neuron1InputVal + neuron1In2.GetValue();
	double neuron2Inputs = neuron2InputVal + neuron2In2.GetValue();
	double neuron3Inputs = neuron3InputVal + neuron3In2.GetValue();
	
	double neuron12Inputs = neurons12in1.GetValue() + neurons12in2.GetValue();
	double neuron23Inputs = neurons23in1.GetValue() + neurons23in2.GetValue();
	
	neuron1.setInput(neuron1Inputs + neuron12Inputs);
	neuron2.setInput(neuron2Inputs + neuron12Inputs + neuron23Inputs);
	neuron3.setInput(neuron3Inputs + neuron23Inputs);

	neuron1Out = neuron1.process();
	neuron2Out = neuron2.process();
	neuron3Out = neuron3.process();

	//bad naming
	neuronOut1.SetValue(neuron1Out);
	neuronOut2.SetValue(neuron2Out);
	neuronOut3.SetValue(neuron3Out);
	
	diffRect.setPositiveInput(neuron1Out + neuron3Out);
	diffRect.setNegativeInput(neuron2Out);
	
	diffRect.process();
	
	posOut1.SetValue(diffRect.getPositiveOutput());
	negOut1.SetValue(diffRect.getNegativeOutput());

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
private VoltageAudioJack neuron3In2;
private VoltageAudioJack neuron3In1;
private VoltageAudioJack neuron2In1;
private VoltageAudioJack neuron2In2;
private VoltageAudioJack neuron1In2;
private VoltageAudioJack neurons23in2;
private VoltageAudioJack neurons23in1;
private VoltageAudioJack neurons12in2;
private VoltageAudioJack neurons12in1;
private VoltageAudioJack neuron1In1;
private VoltageAudioJack posOut1;
private VoltageAudioJack negOut1;
private VoltageAudioJack neuronOut2;
private VoltageAudioJack neuronOut3;
private VoltageAudioJack neuronOut1;
private VoltageKnob response2;
private VoltageKnob response3;
private VoltageKnob inGain3;
private VoltageKnob inGain2;
private VoltageKnob inGain1;
private VoltageKnob response1;
private VoltageKnob sense3;
private VoltageKnob sense2;
private VoltageKnob sense1;


//[user-code-and-variables]    Add your own variables and functions here

	private NLCNeuron neuron1, neuron2, neuron3;
	private DiffRect diffRect;

	private SmoothValue gain1, gain2, gain3;
	
	private boolean connected1, connected2, connected3;
	
	private double neuron1Out, neuron2Out, neuron3Out;

//[/user-code-and-variables]
}

 