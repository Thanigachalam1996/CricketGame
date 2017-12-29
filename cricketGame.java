import java.util.*;
class cricket{
    public HashMap<Integer,String> countries=new HashMap<Integer,String>();
    static String numAsString[]={"<--FOUR-->","<--SIX-->"};
    private int overs,nation1,nation2;
    cricket(){
      
          countries.put(1,"India");
          countries.put(2,"Australia");
          countries.put(3,"South Africa");
          countries.put(4,"New Zealand");
          countries.put(5,"West Indies");
        // System.out.println(countries.get(1));
          
      }
    cricket(int overs,int nation1,int nation2){
          
          countries.put(1,"India");
          countries.put(2,"Australia");
          countries.put(3,"South Africa");
          countries.put(4,"New Zealand");
          countries.put(5,"West Indies");
          this.overs=overs;
          this.nation1=nation1;
          this.nation2=nation2;
    }
    public int[] startInings(int k,int flag){
         int a[]=new int[2];
         int run=0,wicket=0;
         int target=k;
     //   System.out.println(overs);
        for(int i=1;i<overs+1;i++){
            int status[]=startOver(i,wicket,target,flag);
            System.out.println("_________________________________________________________________");
            System.out.println(" runs this over : "+status[0]);
            run=run+status[0];
            wicket=status[1];
            System.out.println(" Over : "+i+"||"+" Run/Wicket : "+run+"/"+wicket);
            System.out.println("_________________________________________________________________");
            if(wicket>9){
                a[0]=run+status[0];a[1]=10;
                return a;
            }
            if(flag==1&&k-run>0&&i+1!=overs+1){
                target=k-run;
                System.out.println("Need "+target+" in "+ (6*(overs-i))+" Balls ");
            }else if(flag==1&&k-run<0){
                a[0]=run;
                a[1]=wicket;
                return a;
            }
           
        }
        a[0]=run;
        a[1]=wicket;
        return a;
       
    }
    public static int[] startOver(int i,int wicket,int target,int flag){
            int runThisOver=0;
            Random r1=new Random();
            int notConsidered=0;
            int status=0;
            int cons=0;
            Boolean freeHit=false;
            for(int j=1;j<7;j++){
                if(flag==1&&target-runThisOver<=0){
                    int a[]={runThisOver,wicket};
                    return a;
                }
                System.out.print(i+"."+j+" : ");
                boolean checkForNoBall=isThisNoBall(r1);
                if(freeHit){
                    System.out.print("<FREE HIT>:");
                }
                if(checkForNoBall){
                    j--;
                    
                }
                int[] isItOut=isThatOut(r1,checkForNoBall,freeHit);
                if(isItOut[0]==-1) { 
                     status=runForABall(r1);
                     System.out.print(status);
                     if(status%6==0&&status!=0){
                         System.out.print(numAsString[1]);
                     }else if(status%4==0&&status!=0){
                         System.out.print(numAsString[0]);
                     }
                    System.out.println();
                }else{
                  //  runThisOver=runThisOver+isItOut[0];
                    //wicket=wicket++;
                    status=isItOut[0];
                    wicket++;
                    if(wicket>9){
                     int a[]={runThisOver,wicket};
                     return a;
                    }
                }
                    //continue;
                
                if(checkForNoBall){
                    freeHit=true;
                    
                }else{
                    freeHit=false;
                }
                runThisOver=runThisOver+status;
               }
               
                //System.out.println("Runs this  Over : "+runThisOver);
                int a[]={runThisOver,wicket};
                return a;
    }
    
   
    
    
    
                
                
                
            
    public void showCountries(){
        System.out.println("Choose Two countries to start the match");
        Set s=countries.entrySet();
        Iterator i=s.iterator();
        while(i.hasNext()){
            Map.Entry country=(Map.Entry)i.next();
            System.out.println(country.getKey()+" "+country.getValue());
        }
        
    }
    public void showResult(int country1,int country2,int wicket){
        if(country1>country2){
            System.out.println(countries.get(nation1)+" won By "+(country1-country2)+" runs");
        }else if(country1<country2){
            System.out.println(countries.get(nation2)+" won by "+(10-wicket)+" wickets");
        }else{
            System.out.println("Draw");
        }
    }
    public void showCountryNumber(int choice){
        System.out.println(countries.get(choice));
    }
       
}
class Match{
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        cricket cri=new cricket();
        cri.showCountries();
        int choosenCountry1;
        int choosenCountry2;
        while(true){
            choosenCountry1=s.nextInt();
            choosenCountry2=s.nextInt();
        if(choosenCountry1!=choosenCountry2&&choosenCountry1<6&&choosenCountry2<6){
            System.out.print("Enter Number of Overs");
            break;
        }else if(choosenCountry1>=6||choosenCountry2>=6){
            System.out.println("Enter Valid Input");
        }else{
            System.out.println("Select Different Countries");
        }
        }
        int numOfOvers=s.nextInt();
        System.out.print(" : "+numOfOvers);
        System.out.println();
        cricket battle=new cricket(numOfOvers,choosenCountry1,choosenCountry2);
        int[] runOfCountry1=battle.startInings(0,0);
        System.out.println("END OF FIRST INNINGS");
        System.out.println(battle.countries.get(choosenCountry1)+" : "+runOfCountry1[0]+"/"+runOfCountry1[1]);
        System.out.println("TARGET : "+(runOfCountry1[0]+1)+" FOR "+(battle.countries.get(choosenCountry2)).toUpperCase());
        
        int[] runOfCountry2=battle.startInings(runOfCountry1[0],1);
        battle.showResult(runOfCountry1[0],runOfCountry2[0],runOfCountry2[1]);
            
        }
}
        