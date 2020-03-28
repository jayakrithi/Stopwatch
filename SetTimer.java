

class SetTimer {
    // Global Variables 
    int hours =0;
    int lefthours =0;
    int minutes =0;
    int seconds =0;
    int sec =0;
    
    
    public SetTimer(int sec){
        sec = 0;
    }

    public int calculate(int sec){
        if(sec>3600){
           chours(sec);
        }
        else if(sec >=60){
            cmin(sec);
        }
        else if(sec<60){
            csec(sec);
           
        }
        String strHours;
        String strMins; 
        String strSecs; 
    
        if(seconds < 10)
            strSecs = "0" + Integer.toString(seconds);
        else
            strSecs = Integer.toString(seconds);
       
        if(minutes < 10)
            strMins = "0" + Integer.toString(minutes);
       else
           strMins = Integer.toString(minutes);
        
        if(hours < 10)
            strHours = "0" + Integer.toString(hours);
          else
              strHours = Integer.toString(hours);
            
            
        String time = strHours + ":" + strMins + ":" + strSecs;
        return seconds;
       
    }


    public void chours(int sec){
        hours = sec /3600;
        lefthours = sec%3600;
        if(lefthours >=60){
            minutes = lefthours /60;
            seconds = lefthours %60;
        }
        else 
        {
            seconds = lefthours;
        }
    }

    public void cmin(int sec){
        hours =0;
            minutes = sec/60;
            seconds = sec %60;
    }

    public void csec(int sec){
        hours =0;
        minutes =0;
        seconds =sec;

    }
}
