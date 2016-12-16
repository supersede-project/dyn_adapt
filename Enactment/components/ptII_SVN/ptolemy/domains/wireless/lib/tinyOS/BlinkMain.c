/* BlinkMain.c - test code for the blink app. It is not exactly the same as the TinyOS
Main component. But it illustrates the similiar structure for our experiments now.


Authors: Yang
Version $Id: BlinkMain.c 31916 2004-03-11 16:14:22Z cxh $
*/

#include "BlinkMain.h"
#include "Blink.h"
#include <stdio.h>

void initialize() {
    Blink_StdControl_init();
    Timer_StdControl_init();
}

void start() {
    Timer_StdControl_start();
    Blink_StdControl_start();
}

void stop() {
    Timer_StdControl_stop();
    Blink_StdControl_stop();
}




