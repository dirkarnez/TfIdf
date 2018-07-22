import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		String[] str_1 = { "有", "隻", "狗", "坐", "咗", "響", "梳", "化", "度" };
		String[] str_2 = { "有", "隻", "貓", "坐", "咗", "響", "張", "牀", "度" };
		
		TfIdf ttt = new TfIdf(Arrays.asList(str_1, str_2));
		
		Map<String, Double> map = ttt.tfidf();
		for (Entry<String, Double> entry : map.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
}