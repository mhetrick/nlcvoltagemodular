package com.nlc.divide;


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

class BooleanTrigger {
	boolean state = true;

	void reset() 
	{
		state = true;
	}

	boolean process(boolean _state) 
	{
		boolean triggered = (_state && !state);
		state = _state;
		return triggered;
	}
};

//[/user-imports]


public class DivConquer extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public DivConquer( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Divide and Conquer", ModuleType.ModuleType_Logic, 1.6 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "2d612b3b9685418fa8cad94613ec154f" );
}

void InitializeControls()
{

	inMain = new VoltageAudioJack( "inMain", "In Main", this, JackType.JackType_AudioInput );
	AddComponent( inMain );
	inMain.SetWantsMouseNotifications( false );
	inMain.SetPosition( 13, 216 );
	inMain.SetSize( 25, 25 );
	inMain.SetSkin( "Jack Round 25px" );

	in3 = new VoltageAudioJack( "in3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( in3 );
	in3.SetWantsMouseNotifications( false );
	in3.SetPosition( 13, 64 );
	in3.SetSize( 25, 25 );
	in3.SetSkin( "Jack Round 25px" );

	in5 = new VoltageAudioJack( "in5", "In 5", this, JackType.JackType_AudioInput );
	AddComponent( in5 );
	in5.SetWantsMouseNotifications( false );
	in5.SetPosition( 13, 111 );
	in5.SetSize( 25, 25 );
	in5.SetSkin( "Jack Round 25px" );

	in7 = new VoltageAudioJack( "in7", "In 7", this, JackType.JackType_AudioInput );
	AddComponent( in7 );
	in7.SetWantsMouseNotifications( false );
	in7.SetPosition( 13, 156 );
	in7.SetSize( 25, 25 );
	in7.SetSkin( "Jack Round 25px" );

	out2 = new VoltageAudioJack( "out2", "Out 2", this, JackType.JackType_AudioOutput );
	AddComponent( out2 );
	out2.SetWantsMouseNotifications( false );
	out2.SetPosition( 46, 216 );
	out2.SetSize( 25, 25 );
	out2.SetSkin( "Jack Round 25px" );

	out3 = new VoltageAudioJack( "out3", "Out 3", this, JackType.JackType_AudioOutput );
	AddComponent( out3 );
	out3.SetWantsMouseNotifications( false );
	out3.SetPosition( 78, 64 );
	out3.SetSize( 25, 25 );
	out3.SetSkin( "Jack Round 25px" );

	out4 = new VoltageAudioJack( "out4", "Out 4", this, JackType.JackType_AudioOutput );
	AddComponent( out4 );
	out4.SetWantsMouseNotifications( false );
	out4.SetPosition( 78, 216 );
	out4.SetSize( 25, 25 );
	out4.SetSkin( "Jack Round 25px" );

	out5 = new VoltageAudioJack( "out5", "Out 5", this, JackType.JackType_AudioOutput );
	AddComponent( out5 );
	out5.SetWantsMouseNotifications( false );
	out5.SetPosition( 78, 110 );
	out5.SetSize( 25, 25 );
	out5.SetSkin( "Jack Round 25px" );

	out7 = new VoltageAudioJack( "out7", "Out 7", this, JackType.JackType_AudioOutput );
	AddComponent( out7 );
	out7.SetWantsMouseNotifications( false );
	out7.SetPosition( 78, 156 );
	out7.SetSize( 25, 25 );
	out7.SetSkin( "Jack Round 25px" );

	out8 = new VoltageAudioJack( "out8", "Out 8", this, JackType.JackType_AudioOutput );
	AddComponent( out8 );
	out8.SetWantsMouseNotifications( false );
	out8.SetPosition( 13, 259 );
	out8.SetSize( 25, 25 );
	out8.SetSkin( "Jack Round 25px" );

	out16 = new VoltageAudioJack( "out16", "Out 16", this, JackType.JackType_AudioOutput );
	AddComponent( out16 );
	out16.SetWantsMouseNotifications( false );
	out16.SetPosition( 46, 259 );
	out16.SetSize( 25, 25 );
	out16.SetSkin( "Jack Round 25px" );

	out32 = new VoltageAudioJack( "out32", "Out 32", this, JackType.JackType_AudioOutput );
	AddComponent( out32 );
	out32.SetWantsMouseNotifications( false );
	out32.SetPosition( 79, 259 );
	out32.SetSize( 25, 25 );
	out32.SetSkin( "Jack Round 25px" );

	out64 = new VoltageAudioJack( "out64", "Out 64", this, JackType.JackType_AudioOutput );
	AddComponent( out64 );
	out64.SetWantsMouseNotifications( false );
	out64.SetPosition( 14, 301 );
	out64.SetSize( 25, 25 );
	out64.SetSkin( "Jack Round 25px" );

	out128 = new VoltageAudioJack( "out128", "Out 128", this, JackType.JackType_AudioOutput );
	AddComponent( out128 );
	out128.SetWantsMouseNotifications( false );
	out128.SetPosition( 46, 301 );
	out128.SetSize( 25, 25 );
	out128.SetSkin( "Jack Round 25px" );

	out256 = new VoltageAudioJack( "out256", "Out 256", this, JackType.JackType_AudioOutput );
	AddComponent( out256 );
	out256.SetWantsMouseNotifications( false );
	out256.SetPosition( 79, 300 );
	out256.SetSize( 25, 25 );
	out256.SetSkin( "Jack Round 25px" );

	out3Div2 = new VoltageAudioJack( "out3Div2", "Out 3 Div 2", this, JackType.JackType_AudioOutput );
	AddComponent( out3Div2 );
	out3Div2.SetWantsMouseNotifications( false );
	out3Div2.SetPosition( 46, 65 );
	out3Div2.SetSize( 25, 25 );
	out3Div2.SetSkin( "Jack Round 25px" );

	out5Div2 = new VoltageAudioJack( "out5Div2", "Out 5 Div 2", this, JackType.JackType_AudioOutput );
	AddComponent( out5Div2 );
	out5Div2.SetWantsMouseNotifications( false );
	out5Div2.SetPosition( 46, 111 );
	out5Div2.SetSize( 25, 25 );
	out5Div2.SetSkin( "Jack Round 25px" );

	out7Div2 = new VoltageAudioJack( "out7Div2", "Out 7 Div 2", this, JackType.JackType_AudioOutput );
	AddComponent( out7Div2 );
	out7Div2.SetWantsMouseNotifications( false );
	out7Div2.SetPosition( 46, 156 );
	out7Div2.SetSize( 25, 25 );
	out7Div2.SetSkin( "Jack Round 25px" );

	led2 = new VoltageLED( "led2", "LED 2", this );
	AddComponent( led2 );
	led2.SetWantsMouseNotifications( false );
	led2.SetPosition( 71, 213 );
	led2.SetSize( 8, 8 );
	led2.SetSkin( "Silver Backed Blue" );

	led3 = new VoltageLED( "led3", "LED 3", this );
	AddComponent( led3 );
	led3.SetWantsMouseNotifications( false );
	led3.SetPosition( 71, 84 );
	led3.SetSize( 8, 8 );
	led3.SetSkin( "Silver Backed Blue" );

	led4 = new VoltageLED( "led4", "LED 4", this );
	AddComponent( led4 );
	led4.SetWantsMouseNotifications( false );
	led4.SetPosition( 71, 236 );
	led4.SetSize( 8, 8 );
	led4.SetSkin( "Silver Backed Blue" );

	led5 = new VoltageLED( "led5", "LED 5", this );
	AddComponent( led5 );
	led5.SetWantsMouseNotifications( false );
	led5.SetPosition( 71, 130 );
	led5.SetSize( 8, 8 );
	led5.SetSkin( "Silver Backed Blue" );

	led7 = new VoltageLED( "led7", "LED 7", this );
	AddComponent( led7 );
	led7.SetWantsMouseNotifications( false );
	led7.SetPosition( 71, 176 );
	led7.SetSize( 8, 8 );
	led7.SetSkin( "Silver Backed Blue" );

	led8 = new VoltageLED( "led8", "LED 8", this );
	AddComponent( led8 );
	led8.SetWantsMouseNotifications( false );
	led8.SetPosition( 38, 277 );
	led8.SetSize( 8, 8 );
	led8.SetSkin( "Silver Backed Blue" );

	led16 = new VoltageLED( "led16", "LED 16", this );
	AddComponent( led16 );
	led16.SetWantsMouseNotifications( false );
	led16.SetPosition( 71, 255 );
	led16.SetSize( 8, 8 );
	led16.SetSkin( "Silver Backed Blue" );

	led32 = new VoltageLED( "led32", "LED 32", this );
	AddComponent( led32 );
	led32.SetWantsMouseNotifications( false );
	led32.SetPosition( 71, 278 );
	led32.SetSize( 8, 8 );
	led32.SetSkin( "Silver Backed Blue" );

	led64 = new VoltageLED( "led64", "LED 64", this );
	AddComponent( led64 );
	led64.SetWantsMouseNotifications( false );
	led64.SetPosition( 38, 320 );
	led64.SetSize( 8, 8 );
	led64.SetSkin( "Silver Backed Blue" );

	led128 = new VoltageLED( "led128", "LED 128", this );
	AddComponent( led128 );
	led128.SetWantsMouseNotifications( false );
	led128.SetPosition( 71, 298 );
	led128.SetSize( 8, 8 );
	led128.SetSkin( "Silver Backed Blue" );

	led256 = new VoltageLED( "led256", "LED 256", this );
	AddComponent( led256 );
	led256.SetWantsMouseNotifications( false );
	led256.SetPosition( 71, 320 );
	led256.SetSize( 8, 8 );
	led256.SetSkin( "Silver Backed Blue" );

	led3Div2 = new VoltageLED( "led3Div2", "LED 3 Div 2", this );
	AddComponent( led3Div2 );
	led3Div2.SetWantsMouseNotifications( false );
	led3Div2.SetPosition( 71, 62 );
	led3Div2.SetSize( 8, 8 );
	led3Div2.SetSkin( "Silver Backed Blue" );

	led5Div2 = new VoltageLED( "led5Div2", "LED 5 Div 2", this );
	AddComponent( led5Div2 );
	led5Div2.SetWantsMouseNotifications( false );
	led5Div2.SetPosition( 71, 108 );
	led5Div2.SetSize( 8, 8 );
	led5Div2.SetSkin( "Silver Backed Blue" );

	led7Div2 = new VoltageLED( "led7Div2", "LED 7 Div 2", this );
	AddComponent( led7Div2 );
	led7Div2.SetWantsMouseNotifications( false );
	led7Div2.SetPosition( 71, 154 );
	led7Div2.SetSize( 8, 8 );
	led7Div2.SetSkin( "Silver Backed Blue" );
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
			if(component == in3) in3Connected = true;
			else if(component == in5) in5Connected = true;
			else if(component == in7) in7Connected = true;
		}
		break;
	
		case Jack_Disconnected:   // All cables have been disconnected from this jack
		{
			if(component == in3) in3Connected = false;
			else if(component == in5) in5Connected = false;
			else if(component == in7) in7Connected = false;
		}
		break;
	
		case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
		{
			led2.SetValue(div2 ? 1.0 : 0.0);
			led4.SetValue(div4 ? 1.0 : 0.0);
			led8.SetValue(div8 ? 1.0 : 0.0);
			led16.SetValue(div16 ? 1.0 : 0.0);
			led32.SetValue(div32 ? 1.0 : 0.0);
			led64.SetValue(div64 ? 1.0 : 0.0);
			led128.SetValue(div128 ? 1.0 : 0.0);
			led256.SetValue(div256 ? 1.0 : 0.0);
			
			led3.SetValue(div3 ? 1.0 : 0.0);
			led3Div2.SetValue(div3div2 ? 1.0 : 0.0);
			
			led5.SetValue(div5 ? 1.0 : 0.0);
			led5Div2.SetValue(div5div2 ? 1.0 : 0.0);
			
			led7.SetValue(div7 ? 1.0 : 0.0);
			led7Div2.SetValue(div7div2 ? 1.0 : 0.0);
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

	double mainClock = inMain.GetValue();
	double clock3 = in3Connected ? in3.GetValue() : mainClock;
	double clock5 = in5Connected ? in5.GetValue() : mainClock;
	double clock7 = in7Connected ? in7.GetValue() : mainClock;

	if(clockIn1.process(mainClock))
        {
            div2 = !div2;
            if(!div2)
            {
                div4 = !div4;
                if(!div4)
                {
                    div8 = !div8;
                    if(!div8)
                    {
                        div16 = !div16;
                        if(!div16)
                        {
                            div32 = !div32;
                            if(!div32)
                            {
                                div64 = !div64;
                                if(!div64)
                                {
                                    div128 = !div128;
                                    if(!div128)
                                    {
                                        div256 = !div256;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
	
	processClock3Row(clock3);
	processClock5Row(clock5);
	processClock7Row(clock7);
	
	double gateOutValue = 5.0;
	out2.SetValue(div2 ? gateOutValue : 0.0);
	out4.SetValue(div4 ? gateOutValue : 0.0);
	out8.SetValue(div8 ? gateOutValue : 0.0);
	out16.SetValue(div16 ? gateOutValue : 0.0);
	out32.SetValue(div32 ? gateOutValue : 0.0);
	out64.SetValue(div64 ? gateOutValue : 0.0);
	out128.SetValue(div128 ? gateOutValue : 0.0);
	out256.SetValue(div256 ? gateOutValue : 0.0);
	
	out3.SetValue(div3 ? gateOutValue : 0.0);
	out3Div2.SetValue(!div3div2 ? gateOutValue : 0.0);
	
	out5.SetValue(div5 ? gateOutValue : 0.0);
	out5Div2.SetValue(div5div2 ? gateOutValue : 0.0);
	
	out7.SetValue(div7 ? gateOutValue : 0.0);
	out7Div2.SetValue(!div7div2 ? gateOutValue : 0.0);

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
private VoltageLED led7Div2;
private VoltageLED led5Div2;
private VoltageLED led3Div2;
private VoltageLED led256;
private VoltageLED led128;
private VoltageLED led64;
private VoltageLED led32;
private VoltageLED led16;
private VoltageLED led8;
private VoltageLED led7;
private VoltageLED led5;
private VoltageLED led4;
private VoltageLED led3;
private VoltageLED led2;
private VoltageAudioJack out7Div2;
private VoltageAudioJack out5Div2;
private VoltageAudioJack out3Div2;
private VoltageAudioJack out256;
private VoltageAudioJack out128;
private VoltageAudioJack out64;
private VoltageAudioJack out32;
private VoltageAudioJack out16;
private VoltageAudioJack out8;
private VoltageAudioJack out7;
private VoltageAudioJack out5;
private VoltageAudioJack out4;
private VoltageAudioJack out3;
private VoltageAudioJack out2;
private VoltageAudioJack in7;
private VoltageAudioJack in5;
private VoltageAudioJack in3;
private VoltageAudioJack inMain;


//[user-code-and-variables]    Add your own variables and functions here

private void processClock3Row(double clock3)
{
	boolean clock3xor = (clock3 > 1.0) != div3;
	
	//if xor is true, trigger div3div2 flipflop
	if(flipflop3div2.process(clock3xor))
	{
		div3div2 = !div3div2;
	}

	//div3div2's output is high when div3div2's flipflop
	//is low
	
	//when div3div2's flipflop goes high, trigger
	//div3's flipflop
	if(flipflop3.process(div3div2))
	{
		div3 = !div3;
	}
}

private void processClock5Row(double clock5)
{
	boolean clock5xor = (clock5 > 1.0) != div5;
	
	if(flipflop5helper.process(clock5xor))
	{
		div5helper = !div5helper;
	}
	
	boolean helperxor = div5helper != div5;
	
	if(flipflop5div2.process(helperxor))
	{
		div5div2 = !div5div2;
	}
	
	if(flipflop5.process(div5div2))
	{
		div5 = !div5;
	}
}

private void processClock7Row(double clock7)
{
	boolean clock7xor = (clock7 > 1.0) != div7;
	
	if(flipflop7helper.process(clock7xor))
	{
		div7helper = !div7helper;
	}
	
	if(flipflop7div2.process(div7helper))
	{
		div7div2 = !div7div2;
	}
	
	if(flipflop7.process(div7div2))
	{
		div7 = !div7;
	}
	
}

int stepCount1, stepCount3, stepCount5, stepCount7;

boolean div2, div4, div8, div16, div32, div64, div128, div256;
boolean div3, div3div2;
boolean div5, div5div2, div5helper;
boolean div7, div7div2, div7helper;

boolean in3Connected, in5Connected, in7Connected;

private NLCTrigger clockIn1 = new NLCTrigger();

private BooleanTrigger flipflop3div2 = new BooleanTrigger();
private BooleanTrigger flipflop3 = new BooleanTrigger();

private BooleanTrigger flipflop5div2 = new BooleanTrigger();
private BooleanTrigger flipflop5helper = new BooleanTrigger();
private BooleanTrigger flipflop5 = new BooleanTrigger();

private BooleanTrigger flipflop7div2 = new BooleanTrigger();
private BooleanTrigger flipflop7helper = new BooleanTrigger();
private BooleanTrigger flipflop7 = new BooleanTrigger();


//[/user-code-and-variables]
}

 