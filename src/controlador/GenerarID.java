package controlador;

public class GenerarID {
private static final String elementos="0,1,2,3,4,5,6,7,8,9,"
        + "a,b,c,d,e,f,g,h,i,j,"
        + "k,l,m,n,ñ,o,p,q,r,s,"
        + "t,u,v,w,x,y,z,"
        + "A,B,C,D,E,F,G,H,I,J,"
        + "K,L,M,N,Ñ,O,P,Q,R,S,"
        + "T,U,V,W,X,Y,Z,"
        + "$,%,&,#,@";
    public static String  getID(int tam) {
        String[] lst_elementos = elementos.split(",");
        String llave="";
        
        for (int i=0;i<tam ; i++) {
            int n=new java.util.Random().nextInt(lst_elementos.length);
            llave+=lst_elementos[n];
        }
        return llave;
    }
    public static void main(String[] args) {
        
        getID(6);
        
    }
}
