package main;

import java.util.ArrayList;

interface IEnactor {

    //interface of the Enactor component; returning the enactment code to be injected to the system by the Hook component
    String getEnactmentCode();

}
