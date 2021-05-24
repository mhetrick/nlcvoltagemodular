package com.nlc.splosh;


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


//[/user-imports]


public class Splosh extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

public Splosh( long moduleID, VoltageObjects voltageObjects )
{
	super( moduleID, voltageObjects, "Let's Splosh", ModuleType.ModuleType_CVProcessors, 2.0 );

	InitializeControls();


	canBeBypassed = false;
	SetSkin( "9d107e8ced6e486693d417ae5e7cd4e0" );
}

void InitializeControls()
{

	inputJack1 = new VoltageAudioJack( "in1", "In 1", this, JackType.JackType_AudioInput );
	AddComponent( inputJack1 );
	inputJack1.SetWantsMouseNotifications( false );
	inputJack1.SetPosition( 60, 49 );
	inputJack1.SetSize( 25, 25 );
	inputJack1.SetSkin( "Jack Round Pink Ring" );

	inputJack2 = new VoltageAudioJack( "in2", "In 2", this, JackType.JackType_AudioInput );
	AddComponent( inputJack2 );
	inputJack2.SetWantsMouseNotifications( false );
	inputJack2.SetPosition( 60, 128 );
	inputJack2.SetSize( 25, 25 );
	inputJack2.SetSkin( "Jack Round Mint Ring" );

	inputJack4 = new VoltageAudioJack( "in4", "In 4", this, JackType.JackType_AudioInput );
	AddComponent( inputJack4 );
	inputJack4.SetWantsMouseNotifications( false );
	inputJack4.SetPosition( 60, 286 );
	inputJack4.SetSize( 25, 25 );
	inputJack4.SetSkin( "Jack Round Green Ring" );

	inputJack3 = new VoltageAudioJack( "in3", "In 3", this, JackType.JackType_AudioInput );
	AddComponent( inputJack3 );
	inputJack3.SetWantsMouseNotifications( false );
	inputJack3.SetPosition( 59, 210 );
	inputJack3.SetSize( 25, 25 );
	inputJack3.SetSkin( "Jack Round Yellow Ring" );

	outJackA1 = new VoltageAudioJack( "outA1", "Out A1", this, JackType.JackType_AudioOutput );
	AddComponent( outJackA1 );
	outJackA1.SetWantsMouseNotifications( false );
	outJackA1.SetPosition( 17, 33 );
	outJackA1.SetSize( 25, 25 );
	outJackA1.SetSkin( "Jack Round 25px" );

	outJackA4 = new VoltageAudioJack( "outA4", "Out A4", this, JackType.JackType_AudioOutput );
	AddComponent( outJackA4 );
	outJackA4.SetWantsMouseNotifications( false );
	outJackA4.SetPosition( 102, 64 );
	outJackA4.SetSize( 25, 25 );
	outJackA4.SetSkin( "Jack Round 25px" );

	outJackB1 = new VoltageAudioJack( "outB1", "Out B1", this, JackType.JackType_AudioOutput );
	AddComponent( outJackB1 );
	outJackB1.SetWantsMouseNotifications( false );
	outJackB1.SetPosition( 17, 114 );
	outJackB1.SetSize( 25, 25 );
	outJackB1.SetSkin( "Jack Round 25px" );

	outJackB4 = new VoltageAudioJack( "outB4", "Out B4", this, JackType.JackType_AudioOutput );
	AddComponent( outJackB4 );
	outJackB4.SetWantsMouseNotifications( false );
	outJackB4.SetPosition( 102, 143 );
	outJackB4.SetSize( 25, 25 );
	outJackB4.SetSkin( "Jack Round 25px" );

	outJackC1 = new VoltageAudioJack( "outC1", "Out C1", this, JackType.JackType_AudioOutput );
	AddComponent( outJackC1 );
	outJackC1.SetWantsMouseNotifications( false );
	outJackC1.SetPosition( 17, 191 );
	outJackC1.SetSize( 25, 25 );
	outJackC1.SetSkin( "Jack Round 25px" );

	outJackC4 = new VoltageAudioJack( "outC4", "Out C4", this, JackType.JackType_AudioOutput );
	AddComponent( outJackC4 );
	outJackC4.SetWantsMouseNotifications( false );
	outJackC4.SetPosition( 102, 220 );
	outJackC4.SetSize( 25, 25 );
	outJackC4.SetSkin( "Jack Round 25px" );

	outJackD1 = new VoltageAudioJack( "outD1", "Out D1", this, JackType.JackType_AudioOutput );
	AddComponent( outJackD1 );
	outJackD1.SetWantsMouseNotifications( false );
	outJackD1.SetPosition( 17, 272 );
	outJackD1.SetSize( 25, 25 );
	outJackD1.SetSkin( "Jack Round 25px" );

	outJackD4 = new VoltageAudioJack( "outD4", "Out D4", this, JackType.JackType_AudioOutput );
	AddComponent( outJackD4 );
	outJackD4.SetWantsMouseNotifications( false );
	outJackD4.SetPosition( 102, 301 );
	outJackD4.SetSize( 25, 25 );
	outJackD4.SetSkin( "Jack Round 25px" );

	outJackA2 = new VoltageAudioJack( "outA2", "Out A2", this, JackType.JackType_AudioOutput );
	AddComponent( outJackA2 );
	outJackA2.SetWantsMouseNotifications( false );
	outJackA2.SetPosition( 102, 33 );
	outJackA2.SetSize( 25, 25 );
	outJackA2.SetSkin( "Jack Round 25px" );

	outJackA3 = new VoltageAudioJack( "outA3", "Out A3", this, JackType.JackType_AudioOutput );
	AddComponent( outJackA3 );
	outJackA3.SetWantsMouseNotifications( false );
	outJackA3.SetPosition( 17, 64 );
	outJackA3.SetSize( 25, 25 );
	outJackA3.SetSkin( "Jack Round 25px" );

	outJackB2 = new VoltageAudioJack( "outB2", "Out B2", this, JackType.JackType_AudioOutput );
	AddComponent( outJackB2 );
	outJackB2.SetWantsMouseNotifications( false );
	outJackB2.SetPosition( 102, 114 );
	outJackB2.SetSize( 25, 25 );
	outJackB2.SetSkin( "Jack Round 25px" );

	outJackB3 = new VoltageAudioJack( "outB3", "Out B3", this, JackType.JackType_AudioOutput );
	AddComponent( outJackB3 );
	outJackB3.SetWantsMouseNotifications( false );
	outJackB3.SetPosition( 17, 143 );
	outJackB3.SetSize( 25, 25 );
	outJackB3.SetSkin( "Jack Round 25px" );

	outJackC2 = new VoltageAudioJack( "outC2", "Out C2", this, JackType.JackType_AudioOutput );
	AddComponent( outJackC2 );
	outJackC2.SetWantsMouseNotifications( false );
	outJackC2.SetPosition( 102, 191 );
	outJackC2.SetSize( 25, 25 );
	outJackC2.SetSkin( "Jack Round 25px" );

	outJackC3 = new VoltageAudioJack( "outC3", "Out C3", this, JackType.JackType_AudioOutput );
	AddComponent( outJackC3 );
	outJackC3.SetWantsMouseNotifications( false );
	outJackC3.SetPosition( 17, 221 );
	outJackC3.SetSize( 25, 25 );
	outJackC3.SetSkin( "Jack Round 25px" );

	outJackD2 = new VoltageAudioJack( "outD2", "Out D2", this, JackType.JackType_AudioOutput );
	AddComponent( outJackD2 );
	outJackD2.SetWantsMouseNotifications( false );
	outJackD2.SetPosition( 102, 272 );
	outJackD2.SetSize( 25, 25 );
	outJackD2.SetSkin( "Jack Round 25px" );

	outJackD3 = new VoltageAudioJack( "outD3", "Out D3", this, JackType.JackType_AudioOutput );
	AddComponent( outJackD3 );
	outJackD3.SetWantsMouseNotifications( false );
	outJackD3.SetPosition( 17, 301 );
	outJackD3.SetSize( 25, 25 );
	outJackD3.SetSkin( "Jack Round 25px" );

	ledIn1 = new VoltageLED( "ledIn1", "In 1 Value", this );
	AddComponent( ledIn1 );
	ledIn1.SetWantsMouseNotifications( false );
	ledIn1.SetPosition( 67, 39 );
	ledIn1.SetSize( 11, 11 );
	ledIn1.SetSkin( "Silver Backed Red" );

	ledIn2 = new VoltageLED( "ledIn2", "In 1 Value_1", this );
	AddComponent( ledIn2 );
	ledIn2.SetWantsMouseNotifications( false );
	ledIn2.SetPosition( 67, 117 );
	ledIn2.SetSize( 11, 11 );
	ledIn2.SetSkin( "Silver Backed Blue" );

	ledIn3 = new VoltageLED( "ledIn3", "In 1 Value_2", this );
	AddComponent( ledIn3 );
	ledIn3.SetWantsMouseNotifications( false );
	ledIn3.SetPosition( 67, 198 );
	ledIn3.SetSize( 11, 11 );
	ledIn3.SetSkin( "Silver Backed Orange" );

	ledIn4 = new VoltageLED( "ledIn4", "In 1 Value_3", this );
	AddComponent( ledIn4 );
	ledIn4.SetWantsMouseNotifications( false );
	ledIn4.SetPosition( 67, 274 );
	ledIn4.SetSize( 11, 11 );
	ledIn4.SetSkin( "Silver Backed Green" );

	ledA1 = new VoltageLED( "ledA1", "Value A1", this );
	AddComponent( ledA1 );
	ledA1.SetWantsMouseNotifications( false );
	ledA1.SetPosition( 1, 40 );
	ledA1.SetSize( 11, 11 );
	ledA1.SetSkin( "Silver Backed Red" );

	ledA2 = new VoltageLED( "ledA2", "Value A2", this );
	AddComponent( ledA2 );
	ledA2.SetWantsMouseNotifications( false );
	ledA2.SetPosition( 132, 40 );
	ledA2.SetSize( 11, 11 );
	ledA2.SetSkin( "Silver Backed Red" );

	ledA3 = new VoltageLED( "ledA3", "Value A3", this );
	AddComponent( ledA3 );
	ledA3.SetWantsMouseNotifications( false );
	ledA3.SetPosition( 1, 71 );
	ledA3.SetSize( 11, 11 );
	ledA3.SetSkin( "Silver Backed Red" );

	ledA4 = new VoltageLED( "ledA4", "Value A4", this );
	AddComponent( ledA4 );
	ledA4.SetWantsMouseNotifications( false );
	ledA4.SetPosition( 132, 71 );
	ledA4.SetSize( 11, 11 );
	ledA4.SetSkin( "Silver Backed Red" );

	ledB1 = new VoltageLED( "ledB1", "Value B1", this );
	AddComponent( ledB1 );
	ledB1.SetWantsMouseNotifications( false );
	ledB1.SetPosition( 1, 121 );
	ledB1.SetSize( 11, 11 );
	ledB1.SetSkin( "Silver Backed Blue" );

	ledB2 = new VoltageLED( "ledB2", "Value B2", this );
	AddComponent( ledB2 );
	ledB2.SetWantsMouseNotifications( false );
	ledB2.SetPosition( 132, 121 );
	ledB2.SetSize( 11, 11 );
	ledB2.SetSkin( "Silver Backed Blue" );

	ledB3 = new VoltageLED( "ledB3", "Value B3", this );
	AddComponent( ledB3 );
	ledB3.SetWantsMouseNotifications( false );
	ledB3.SetPosition( 1, 150 );
	ledB3.SetSize( 11, 11 );
	ledB3.SetSkin( "Silver Backed Blue" );

	ledB4 = new VoltageLED( "ledB4", "Value B4", this );
	AddComponent( ledB4 );
	ledB4.SetWantsMouseNotifications( false );
	ledB4.SetPosition( 132, 150 );
	ledB4.SetSize( 11, 11 );
	ledB4.SetSkin( "Silver Backed Blue" );

	ledC1 = new VoltageLED( "ledC1", "Value C1", this );
	AddComponent( ledC1 );
	ledC1.SetWantsMouseNotifications( false );
	ledC1.SetPosition( 1, 198 );
	ledC1.SetSize( 11, 11 );
	ledC1.SetSkin( "Silver Backed Orange" );

	ledC2 = new VoltageLED( "ledC2", "Value C2", this );
	AddComponent( ledC2 );
	ledC2.SetWantsMouseNotifications( false );
	ledC2.SetPosition( 132, 198 );
	ledC2.SetSize( 11, 11 );
	ledC2.SetSkin( "Silver Backed Orange" );

	ledC3 = new VoltageLED( "ledC3", "Value C3", this );
	AddComponent( ledC3 );
	ledC3.SetWantsMouseNotifications( false );
	ledC3.SetPosition( 1, 228 );
	ledC3.SetSize( 11, 11 );
	ledC3.SetSkin( "Silver Backed Orange" );

	ledC4 = new VoltageLED( "ledC4", "Value C4", this );
	AddComponent( ledC4 );
	ledC4.SetWantsMouseNotifications( false );
	ledC4.SetPosition( 132, 228 );
	ledC4.SetSize( 11, 11 );
	ledC4.SetSkin( "Silver Backed Orange" );

	ledD1 = new VoltageLED( "ledD1", "Value D1", this );
	AddComponent( ledD1 );
	ledD1.SetWantsMouseNotifications( false );
	ledD1.SetPosition( 1, 279 );
	ledD1.SetSize( 11, 11 );
	ledD1.SetSkin( "Silver Backed Green" );

	ledD2 = new VoltageLED( "ledD2", "Value D2", this );
	AddComponent( ledD2 );
	ledD2.SetWantsMouseNotifications( false );
	ledD2.SetPosition( 132, 279 );
	ledD2.SetSize( 11, 11 );
	ledD2.SetSkin( "Silver Backed Green" );

	ledD3 = new VoltageLED( "ledD3", "Value D3", this );
	AddComponent( ledD3 );
	ledD3.SetWantsMouseNotifications( false );
	ledD3.SetPosition( 1, 308 );
	ledD3.SetSize( 11, 11 );
	ledD3.SetSkin( "Silver Backed Green" );

	ledD4 = new VoltageLED( "ledD4", "Value D4", this );
	AddComponent( ledD4 );
	ledD4.SetWantsMouseNotifications( false );
	ledD4.SetPosition( 132, 308 );
	ledD4.SetSize( 11, 11 );
	ledD4.SetSkin( "Silver Backed Green" );
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
   
   for(int i = 0; i < 8; i++)
   {
      diffRects[i] = new DiffRect();
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
			ledIn1.SetValue(custard * 0.2);
			ledIn2.SetValue(treacle * 0.2);
			ledIn3.SetValue(natto * 0.2);
			ledIn4.SetValue(batter * 0.2);
			
			ledA1.SetValue(outValues[0] * 0.2);
   		ledA2.SetValue(outValues[1] * -0.2);
   		ledA3.SetValue(outValues[2] * 0.2);
   		ledA4.SetValue(outValues[3] * -0.2);
   
   		ledB1.SetValue(outValues[4] * 0.2);
   		ledB2.SetValue(outValues[5] * -0.2);
   		ledB3.SetValue(outValues[6] * 0.2);
   		ledB4.SetValue(outValues[7] * -0.2);
   
   		ledC1.SetValue(outValues[8] * 0.2);
   		ledC2.SetValue(outValues[9] * -0.2);
   		ledC3.SetValue(outValues[10] * 0.2);
   		ledC4.SetValue(outValues[11] * -0.2);
   
   		ledD1.SetValue(outValues[12] * 0.2);
   		ledD2.SetValue(outValues[13] * -0.2);
   		ledD3.SetValue(outValues[14] * 0.2);
   		ledD4.SetValue(outValues[15] * -0.2);
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
	custard = inputJack1.GetValue();
	treacle = inputJack2.GetValue();
	natto = inputJack3.GetValue();
	batter = inputJack4.GetValue();
	
	
	//CT_NB, CN_TB, CB_TN, CTN_B, CTB_N, CNB_T, TNB_C, CTNB;
   diffRects[0].setPositiveInput(custard + treacle);
   diffRects[0].setNegativeInput(natto + batter);

   diffRects[1].setPositiveInput(custard + natto);
   diffRects[1].setNegativeInput(treacle + batter);

   diffRects[2].setPositiveInput(custard + batter);
   diffRects[2].setNegativeInput(treacle + natto);

   diffRects[3].setPositiveInput(custard + treacle + natto);
   diffRects[3].setNegativeInput(batter);

   diffRects[4].setPositiveInput(custard + treacle + batter);
   diffRects[4].setNegativeInput(natto);

   diffRects[5].setPositiveInput(custard + natto + batter);
   diffRects[5].setNegativeInput(treacle);

   diffRects[6].setPositiveInput(natto + treacle + batter);
   diffRects[6].setNegativeInput(custard);

   diffRects[7].setPositiveInput(custard + natto + treacle + batter);
   diffRects[7].setNegativeInput(0.0f);
	
	for (int i = 0; i < 8; i++)
   {
   	diffRects[i].process();
      outValues[i*2] = diffRects[i].getPositiveOutput();
      outValues[i*2 + 1] = diffRects[i].getNegativeOutput();
   }
   
   outJackA1.SetValue(outValues[0]);
   outJackA2.SetValue(outValues[1]);
   outJackA3.SetValue(outValues[2]);
   outJackA4.SetValue(outValues[3]);
   
   outJackB1.SetValue(outValues[4]);
   outJackB2.SetValue(outValues[5]);
   outJackB3.SetValue(outValues[6]);
   outJackB4.SetValue(outValues[7]);
   
   outJackC1.SetValue(outValues[8]);
   outJackC2.SetValue(outValues[9]);
   outJackC3.SetValue(outValues[10]);
   outJackC4.SetValue(outValues[11]);
   
   outJackD1.SetValue(outValues[12]);
   outJackD2.SetValue(outValues[13]);
   outJackD3.SetValue(outValues[14]);
   outJackD4.SetValue(outValues[15]);
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
private VoltageLED ledD4;
private VoltageLED ledD3;
private VoltageLED ledD2;
private VoltageLED ledD1;
private VoltageLED ledC4;
private VoltageLED ledC3;
private VoltageLED ledC2;
private VoltageLED ledC1;
private VoltageLED ledB4;
private VoltageLED ledB3;
private VoltageLED ledB2;
private VoltageLED ledB1;
private VoltageLED ledA4;
private VoltageLED ledA3;
private VoltageLED ledA2;
private VoltageLED ledA1;
private VoltageLED ledIn4;
private VoltageLED ledIn3;
private VoltageLED ledIn2;
private VoltageLED ledIn1;
private VoltageAudioJack outJackD3;
private VoltageAudioJack outJackD2;
private VoltageAudioJack outJackC3;
private VoltageAudioJack outJackC2;
private VoltageAudioJack outJackB3;
private VoltageAudioJack outJackB2;
private VoltageAudioJack outJackA3;
private VoltageAudioJack outJackA2;
private VoltageAudioJack outJackD4;
private VoltageAudioJack outJackD1;
private VoltageAudioJack outJackC4;
private VoltageAudioJack outJackC1;
private VoltageAudioJack outJackB4;
private VoltageAudioJack outJackB1;
private VoltageAudioJack outJackA4;
private VoltageAudioJack outJackA1;
private VoltageAudioJack inputJack3;
private VoltageAudioJack inputJack4;
private VoltageAudioJack inputJack2;
private VoltageAudioJack inputJack1;


//[user-code-and-variables]    Add your own variables and functions here

private DiffRect[] diffRects = new DiffRect[8];

private double custard, treacle, natto, batter;
private double[] outValues = new double[16];
//[/user-code-and-variables]
}

 