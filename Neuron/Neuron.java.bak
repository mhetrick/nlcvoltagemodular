package com.nlc.neuron;


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
   public void setInput(float _in)
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


public class Neuron extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Neuron( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Neuron", ModuleType.ModuleType_CVProcessors, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "703556adc88f43ad955609b43ae6ca8e" );
}

void InitializeControls()
{

	sense = new VoltageKnob( "sense", "Sense", this, 0.0, 5.0, 0.0 );
	AddComponent( sense );
	sense.SetWantsMouseNotifications( false );
	sense.SetPosition( 9, 46 );
	sense.SetSize( 41, 41 );
	sense.SetSkin( "Dial Sky" );
	sense.SetRange( 0.0, 5.0, 0.0, false, 0 );
	sense.SetKnobParams( 215, 145 );
	sense.DisplayValueInPercent( true );
	sense.SetKnobAdjustsRing( true );

	response = new VoltageKnob( "response", "Response", this, 0.0, 10.0, 1.0 );
	AddComponent( response );
	response.SetWantsMouseNotifications( false );
	response.SetPosition( 63, 47 );
	response.SetSize( 41, 41 );
	response.SetSkin( "Dial Sky" );
	response.SetRange( 0.0, 10.0, 1.0, false, 0 );
	response.SetKnobParams( 215, 145 );
	response.DisplayValueInPercent( true );
	response.SetKnobAdjustsRing( true );

	neuronOut1 = new VoltageAudioJack( "neuronOut1", "Neuron Out", this, JackType.JackType_AudioOutput );
	AddComponent( neuronOut1 );
	neuronOut1.SetWantsMouseNotifications( false );
	neuronOut1.SetPosition( 45, 178 );
	neuronOut1.SetSize( 25, 25 );
	neuronOut1.SetSkin( "Jack Round Sky Ring" );

	negOut1 = new VoltageAudioJack( "negOut1", "DiffRect Negative Out", this, JackType.JackType_AudioOutput );
	AddComponent( negOut1 );
	negOut1.SetWantsMouseNotifications( false );
	negOut1.SetPosition( 77, 283 );
	negOut1.SetSize( 25, 25 );
	negOut1.SetSkin( "Jack Round Sky Ring" );

	posOut1 = new VoltageAudioJack( "posOut1", "DiffRect Positive Out", this, JackType.JackType_AudioOutput );
	AddComponent( posOut1 );
	posOut1.SetWantsMouseNotifications( false );
	posOut1.SetPosition( 77, 239 );
	posOut1.SetSize( 25, 25 );
	posOut1.SetSkin( "Jack Round Pink Ring" );

	dr1negIn1 = new VoltageAudioJack( "dr1negIn1", "DR Negative Input 1", this, JackType.JackType_AudioInput );
	AddComponent( dr1negIn1 );
	dr1negIn1.SetWantsMouseNotifications( false );
	dr1negIn1.SetPosition( 11, 283 );
	dr1negIn1.SetSize( 25, 25 );
	dr1negIn1.SetSkin( "Jack Round Sky Ring" );

	dr1negIn2 = new VoltageAudioJack( "dr1negIn2", "DR Negative Input 2", this, JackType.JackType_AudioInput );
	AddComponent( dr1negIn2 );
	dr1negIn2.SetWantsMouseNotifications( false );
	dr1negIn2.SetPosition( 45, 283 );
	dr1negIn2.SetSize( 25, 25 );
	dr1negIn2.SetSkin( "Jack Round Sky Ring" );

	dr1posIn1 = new VoltageAudioJack( "dr1posIn1", "DR Positive Input 1", this, JackType.JackType_AudioInput );
	AddComponent( dr1posIn1 );
	dr1posIn1.SetWantsMouseNotifications( false );
	dr1posIn1.SetPosition( 11, 239 );
	dr1posIn1.SetSize( 25, 25 );
	dr1posIn1.SetSkin( "Jack Round Pink Ring" );

	dr1posIn2 = new VoltageAudioJack( "dr1posIn2", "DR Positive Input 2", this, JackType.JackType_AudioInput );
	AddComponent( dr1posIn2 );
	dr1posIn2.SetWantsMouseNotifications( false );
	dr1posIn2.SetPosition( 45, 239 );
	dr1posIn2.SetSize( 25, 25 );
	dr1posIn2.SetSkin( "Jack Round Pink Ring" );

	neuron1In1 = new VoltageAudioJack( "neuron1In1", "Neuron In 1", this, JackType.JackType_AudioInput );
	AddComponent( neuron1In1 );
	neuron1In1.SetWantsMouseNotifications( false );
	neuron1In1.SetPosition( 11, 136 );
	neuron1In1.SetSize( 25, 25 );
	neuron1In1.SetSkin( "Jack Round Pink Ring" );

	neuron1In2 = new VoltageAudioJack( "neuron1In2", "Neuron In 2", this, JackType.JackType_AudioInput );
	AddComponent( neuron1In2 );
	neuron1In2.SetWantsMouseNotifications( false );
	neuron1In2.SetPosition( 45, 136 );
	neuron1In2.SetSize( 25, 25 );
	neuron1In2.SetSkin( "Jack Round Pink Ring" );

	neuron1In3 = new VoltageAudioJack( "neuron1In3", "Neuron In 3", this, JackType.JackType_AudioInput );
	AddComponent( neuron1In3 );
	neuron1In3.SetWantsMouseNotifications( false );
	neuron1In3.SetPosition( 77, 136 );
	neuron1In3.SetSize( 25, 25 );
	neuron1In3.SetSkin( "Jack Round Pink Ring" );
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
	neuron = new NLCNeuron();
	diffRect = new DiffRect();

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
			if(component == sense)
			{
				neuron.setSense(sense.GetValue());
			}
			else if(component == response)
			{
				neuron.setResponse(response.GetValue());
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
	neuron.setInput(neuron1In1.GetValue(), neuron1In2.GetValue(), neuron1In3.GetValue());

	diffRect.setPositiveInput(dr1posIn1.GetValue() + dr1posIn2.GetValue());
	diffRect.setNegativeInput(dr1negIn1.GetValue() + dr1negIn2.GetValue());
	
	neuronOut1.SetValue(neuron.process());
	
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
private VoltageAudioJack neuron1In3;
private VoltageAudioJack neuron1In2;
private VoltageAudioJack neuron1In1;
private VoltageAudioJack dr1posIn2;
private VoltageAudioJack dr1posIn1;
private VoltageAudioJack dr1negIn2;
private VoltageAudioJack dr1negIn1;
private VoltageAudioJack posOut1;
private VoltageAudioJack negOut1;
private VoltageAudioJack neuronOut1;
private VoltageKnob response;
private VoltageKnob sense;


//[user-code-and-variables]    Add your own variables and functions here

	private NLCNeuron neuron;
	private DiffRect diffRect;



//[/user-code-and-variables]
}

 