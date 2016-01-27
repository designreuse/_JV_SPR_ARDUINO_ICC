# _JV_SPR_ARDUINO_ICC
Java //Spring //Arduino //Inteligent Climate Control


JSON dönüşümleri için  Google'a ait  Gson kütüphanesi

Spring MVC yapısı

Tomcat

Rxtx

Maven

Html

Jquery

Bootstarp

Css

Gson


3 kez hareket değeri okunur. Hareket varmı yokmu hesaplanır
                if (counter > 3) {

                    if (tmpVal > 1) {
                        motion.setMotionData(1);

                    } else {
                        motion.setMotionData(0);

                    }

                    break;
                }






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







1- start climate
2- stop climate
3- readdata (DHT/PIR)
4-


99 - full auto
98 - perde kapat
97 - perde aç
