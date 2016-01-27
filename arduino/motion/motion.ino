int pirPin = 2; // read motion from pin2

void setup() {

pinMode(pirPin,INPUT); 
Serial.begin(9600);

}

void loop() {
 
  Serial.print("Motion = ");
  Serial.println(digitalRead(pirPin));
  delay(200);
  
}
