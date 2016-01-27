#include <dht.h>

dht DHT;
int val = 0;
int fan = 8;//climate
int pirPin = 2; // read motion from pin2
int ledPin = 9; // led


#define DHT11_PIN 7

void setup()
{
  Serial.begin(9600);
  pinMode(fan, OUTPUT);
  pinMode(ledPin,OUTPUT);
  pinMode(pirPin,INPUT); 
}

void loop(){
}

void serialEvent() // To check if there is any data on the Serial line
{
  while (Serial.available())
  {
    val = Serial.parseInt();
    if(val == 1)   //Switch on the fan, if the received value is 1.
    {
      fanStart();//start climate
    }
    else if(val == 2) //Switch off the fan, if the received value is 2.
    {
      fanStop();//stop climate
    }
    else if(val == 3) //
    {
      ledHigh();//start curtain
    }
    else if(val == 4) //
    {
      ledLow();//stop curtain
    }
    else if(val == 5) // PIR
    {
      getPirData();//READ PIR
    }
    else if(val == 6) // DHT
    {
      getDhtData();//DHT PIR
    }
    else if(val == 99) //Active Mode.
    {
      fullMode();
    }
  }
}

void fullMode(){
  ledHigh();//curtain start
  fanStart();
  
}

void passiveMode(){
  ledLow();//curtain stop
  fanStop();
}

//----------------------------------------------------------
void ledHigh(){
      digitalWrite(ledPin,HIGH); 
  
}

void ledLow(){
      digitalWrite(ledPin,LOW); 
  
}

void fanStart(){
      digitalWrite(fan, HIGH);   
}

void fanStop(){
      digitalWrite(fan, LOW);   
}

void getDhtData(){
  int chk = DHT.read11(DHT11_PIN);
  Serial.print("Temperature = ");
  Serial.println(DHT.temperature);
  Serial.print("Humidity = ");
  Serial.println(DHT.humidity);
}


void getPirData(){
  Serial.print("Motion = ");
  Serial.println(digitalRead(pirPin));
}






