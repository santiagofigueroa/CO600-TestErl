package testerl;

import com.ericsson.otp.erlang.*;
import java.io.IOException;

public class TestModel
{
    /**
     * 1. CREATES/MANAGES E-UNITS and tests
     * 2. Compiles expressions
     *
     * PROPOSED message LEGEND:
     *      Begin -> 'start'
     *      Compile-expresion -> {'compile', expr}
     *      add-test -> {'add', expr, modul}
     *      new-Eunit -> {'make', modul}
     */
    private boolean ready;
    private OtpNode main;
    private OtpMbox inbox;


    public TestModel()
    {
        ready = false;
        try {
            main = new OtpNode("main");
        }
        catch(IOException e){e.getMessage();}
        inbox = main.createMbox("inbox");
    }

    public boolean loadBEAM()
    {
        OtpMsg response;

        /**
         * TODO: run Erlang node called 'Efactory'
         */
        try{
            inbox.send("Efactory@localHost", new OtpErlangAtom("start"));

            //DELAY HERE!!
            response = inbox.receiveMsg(1000);

            //DECIDER
            if (response.getMsg().toString().equals("ready")){
                ready = true;
            }
            return (response.getMsg().toString().equals("ready"));
        }
        catch(OtpErlangExit oe){oe.getMessage();}
        catch(OtpErlangDecodeException od){od.getMessage();}
        catch(InterruptedException ie){ie.getMessage();}

        //hopefully is unreachable.
        return false;
    }

    /**
     * TODO: implement E-UNIT FACTORY methods
     */
    public void addTest()
    {
        if (ready){
            /**
             * 1. send msg to Efactory asking for modules' E-unit.
             * 2. if ok; send msg with expression.
             * TODO: how to AUTOMATE this????
             * 3. Efactory replies ok if added.
             */
        }
    }
}