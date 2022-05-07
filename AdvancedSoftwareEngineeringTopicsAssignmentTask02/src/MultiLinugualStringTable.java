public class MultiLinugualStringTable {
  private static LanguageSetting cl = LanguageSetting.English;
  private static String [] em = {"Enter your name:", "Welcome", "Have a good time playing Abominodo"};
  private static String [] km = {"'el lIj pong:", "nuqneH", "QaQ poH Abominodo"};
  
  public static String getMessage(int index){
    if(cl == LanguageSetting.English ){
      return em[index];
    } else {
      return km[index];     
    }
    
  }
  
  private enum LanguageSetting {English, Klingon}
}
