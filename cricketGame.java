import java.util.*;
class cricket{
     public HashMap<Integer,String> countries=new HashMap<Integer,String>();
    
    private int overs,nation1,nation2;
    cricket(){
      
          countries.put(1,"India");
          countries.put(2,"Australia");
          countries.put(3,"South Africa");
          countries.put(4,"New Zealand");
          countries.put(5,"West Indies");
          
      }
    cricket(int overs,int nation1,int nation2){
        this.overs=overs;
        this.nation1=nation1;
        this.nation2=nation2;
    }
    public int[] startInings(int k,int flag){
         int a[]=new int[2];
         int run=0,wicket=0;
         int target=k;
     //   System.out.println(overs);
        for(int i=0;i<overs;i++){
            int status[]=startOver(i,wicket);
            System.out.println(" runs this over : "+status[0]);
            run=run+status[0];
            wicket=wicket+status[1];
            System.out.println(" Over : "+i+"||"+" Run/Wicket : "+run+"/"+wicket);
            
            if(flag==1&&k-run>0){
                target=k-run;
                System.out.println("Need "+target+" in "+ (6*(overs-i+1)));
            }else if(flag==1&&k-run<0){
                a[0]=0;
                a[1]=wicket;
                return a;
            }
            if(wicket>9){
              break;  
            }
        }
        a[0]=run;
        a[1]=wicket;
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
            System.out.println(countries.get(nation2)+" won with "+(10-wicket));
        }else{
            System.out.println("Draw");
        }
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
        System.out.println("TARGET : "+(runOfCountry1[0]+1)+" FOR "+battle.countries.get(choosenCountry2));
        
            
        }
}
        