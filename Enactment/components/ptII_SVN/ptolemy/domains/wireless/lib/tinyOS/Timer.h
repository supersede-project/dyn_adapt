/* Timer.c - Java Native Interface to the blink app.


Authors: 
Version $Id: Timer.h 31916 2004-03-11 16:14:22Z cxh $
*/

void Timer_StdControl_init();
void Timer_StdControl_start();

void Timer_StdControl_stop();

void Timer_Timer_start(int);

void Timer_Timer_fired();

void Timer_Timer_stop();
