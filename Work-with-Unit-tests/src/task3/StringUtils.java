package task3;

public class StringUtils {

    public static String loose(String str, String remove){
        if(str == null && remove != null){
            return null;
        }
        else if(str == null && remove == null){
            throw new NullPointerException();
        }
        else if(str.equals(" ")){
            return str;
        }
        else{
            String out;
            String st = str.toLowerCase();
            String rem = remove.toLowerCase();
            char[] t = new char[st.length()];
            for(int k = 0; k < st.length(); k++){
                for(int i = 0; i < rem.length(); i++){
                    if(st.charAt(k) == rem.charAt(i)){
                        st = st.replace(st.charAt(k), ' ');
                    }
                }
            }
            out = st.replaceAll(" ", "");
            return out;
        }
    }
}
