import java.util.*;
class cricket{
     public HashMap<Integer,String> countries=new HashMap<Integer,String>();
    
    private int overs,nation1,nation2;
    cricket(){                                //Default Constructor
      
          countries.put(1,"India");
          countries.put(2,"Australia");
          countries.put(3,"South Africa");
          countries.put(4,"New Zealand");
          countries.put(5,"West Indies");
          
      }
    cricket(int overs,int nation1,int nation2){//constructor Overloading
        this.overs=overs;
        this.nation1=nation1;
        this.nation2=nation2;
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
        
        }
}
        