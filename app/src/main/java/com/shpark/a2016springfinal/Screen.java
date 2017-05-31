package com.shpark.a2016springfinal;

// you need the following imports in all Java Bridge apps
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;

// import any components you are going to use in your app. In this case, just Button
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.TextBox;


// you can use the following header for all apps
public class Screen extends Form implements HandlesEventDispatching
{
    // declare all your components as instance variables

    private Button calcButton;
    private Label label1;
    private Label label2;
    private Label label3;
    private TextBox start;
    private TextBox end;
    private TextBox tot;

    private int total = 0;

    // $define is where you'll create components, initialize properties and make any calls that
    // you'd put in Screen.Initialize of an App Inventor app(this)
    protected void $define()
    {
        // create the button component
        label1 = new Label(this);
        label1.Text("시작정수");
        start = new TextBox(this);

        label2 = new Label(this);
        label2.Text("끝나는 정수");
        end = new TextBox(this);

        label3 = new Label(this);
        label3.Text("합은");

        tot = new TextBox(this);

        calcButton = new Button(this);  // the parameter defines the parent for the component,
        // in this case, "this" the screen.
        // if you had an arrangement, you'd refer to it instead.
        calcButton.Text( "합 계산" );


        // register all events that you want to respond to. The second parameter is
        // just a name, the third is the event you care about and its component-independent
        // so you, e.g., you need just one "Click" event even if many buttons
        EventDispatcher.registerEventForDelegation( this, "CalcClick", "Click" );
    }
    // dispatchEvent handles all events. You'll use an if-else to identify the component and
    // event and you can either call a method or just respond to the event directly
    // params provides the event parameters (not used here)
    public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params )
    {
        if( component.equals(calcButton) && eventName.equals("Click") )
        {
            CalcClick();
            return true;
        }
        // here is where you'd check for other events of your app...
        return false;
    }
    // this is the event handler that dispatchEvent above calls. We just set the button background
    public void CalcClick()
    {
        int i;
        total = 0;
        
        for ( i= Integer.parseInt(start.Text()); i <= Integer.parseInt(end.Text()); i++) {
        total = total + i;
        }
        tot.Text(Integer.toString(total));
    }

}