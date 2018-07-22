import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TfIdf {

	private final List<String[]> documents;

	public TfIdf(List<String[]> documents) {
		this.documents = documents;
	}

	public List<String[]> getDocuments() {
		return this.documents;
	}

	public Map<String, MutableInt> tf(String[] document) {
		Map<String, MutableInt> map = new HashMap<String, MutableInt>();
		for (String s : document) {
			MutableInt counter = map.get(s);
			if (counter == null)
				map.put(s, MutableInt.createMutableInt());
			else
				counter.increment();
		}
		return map;
	}

	private Map<String, MutableInt> counter(final List<String> list2) {
		Map<String, MutableInt> map = new HashMap<String, MutableInt>();
		for (String s : list2) {
			MutableInt counter = map.get(s);
			if (counter == null)
				map.put(s, MutableInt.createMutableInt());
			else
				counter.increment();
		}
		return map;
	}

	public Map<String, MutableInt> df() {
		List<String> list2 = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for (String[] s : documents) {
			for (String d : s) {
				set.add(d);
			}
			for (String d : set) {
				list2.add(d);
			}
			set.clear();
		}
		return counter(list2);
	}

	public Map<String, Double> tfidf() {
		Map<String, MutableInt> df_scores = df();
		Map<String, Double> map = new HashMap<String, Double>();
		for (String[] s : documents) {
			Map<String, MutableInt> tf_scores = tf(s);
			for (String d : s) {
				if (map.get(d) == null) {
					double score = tf_scores.get(d).getCounter() / (df_scores.get(d).getCounter() + 0.01);
					map.put(d, score);
				}
			}
		}
		return map;
	}
}
